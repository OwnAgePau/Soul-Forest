package com.Mod_Ores.BiomeGen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCocoa;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.BlockVine;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.Mod_Ores.Blocks.BlockSoulSapling;
import com.Mod_Ores.Init.SoulBlocks;

public class WorldGenGrapeTree extends WorldGenAbstractTree {
	
    /** The minimum height of a generated tree. */
    private final int minTreeHeight;
    /** True if this tree should grow Vines. */
    private final boolean vinesGrow;
    /** The metadata value of the wood to use in tree generation. */
    private final IBlockState metaWood;
    /** The metadata value of the leaves to use in tree generation. */
    private final IBlockState metaLeaves;
    private static final String __OBFID = "CL_00000438";
    
    private Block[] vineBlocks;

    public WorldGenGrapeTree(boolean notify){
    	this(notify, 5, SoulBlocks.SoulLog.get().getDefaultState(), SoulBlocks.GrapesLeaves.get().getDefaultState(), true);
    	this.vineBlocks = new Block[]{SoulBlocks.Baneberry.get(), SoulBlocks.Blackberry.get(), 
        		SoulBlocks.Blueberry.get(), SoulBlocks.Raspberry.get(), SoulBlocks.Razzberry.get(), 
        		SoulBlocks.Cranberry.get(), SoulBlocks.Strawberry.get()};
    }

    public WorldGenGrapeTree(boolean notify, int height, IBlockState woodState, IBlockState leavesState, boolean vinesGrow){
		super(notify);
		this.minTreeHeight = height;
		this.metaWood = woodState;
		this.metaLeaves = leavesState;
		this.vinesGrow = vinesGrow;
    }
    
    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position){
	    int i = rand.nextInt(3) + this.minTreeHeight;
	    boolean flag = true;
	
	    if (position.getY() >= 1 && position.getY() + i + 1 <= 256){
	        for (int j = position.getY(); j <= position.getY() + 1 + i; ++j){
	            int k = 1;
	
	            if (j == position.getY()){
	                k = 0;
	            }
	
	            if (j >= position.getY() + 1 + i - 2){
	                k = 2;
	            }
	
	            BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
	
	            for (int l = position.getX() - k; l <= position.getX() + k && flag; ++l){
	                for (int i1 = position.getZ() - k; i1 <= position.getZ() + k && flag; ++i1){
	                    if (j >= 0 && j < 256){
	                        if (!this.isReplaceable(worldIn,blockpos$mutableblockpos.set(l, j, i1))){
	                            flag = false;
	                        }
	                    }
	                    else{
	                        flag = false;
	                    }
	                }
	            }
	        }
	
	        if (!flag){
	            return false;
	        }
	        else{
	            BlockPos down = position.down();
	            Block block1 = worldIn.getBlockState(down).getBlock();
	            boolean isSoil = block1.canSustainPlant(worldIn, down, net.minecraft.util.EnumFacing.UP, (net.minecraft.block.BlockSapling)Blocks.sapling);
	
	            if (isSoil && position.getY() < 256 - i - 1){
	                block1.onPlantGrow(worldIn, down, position);
	                int k2 = 3;
	                int l2 = 0;
	
	                for (int i3 = position.getY() - k2 + i; i3 <= position.getY() + i; ++i3){
	                    int i4 = i3 - (position.getY() + i);
	                    int j1 = l2 + 1 - i4 / 2;
	
	                    for (int k1 = position.getX() - j1; k1 <= position.getX() + j1; ++k1){
	                        int l1 = k1 - position.getX();
	
	                        for (int i2 = position.getZ() - j1; i2 <= position.getZ() + j1; ++i2){
	                            int j2 = i2 - position.getZ();
	
	                            if (Math.abs(l1) != j1 || Math.abs(j2) != j1 || rand.nextInt(2) != 0 && i4 != 0){
	                                BlockPos blockpos = new BlockPos(k1, i3, i2);
	                                Block block = worldIn.getBlockState(blockpos).getBlock();
	
	                                if (block.isAir(worldIn, blockpos) || block.isLeaves(worldIn, blockpos) || block.getMaterial() == Material.vine){
	                                    this.setBlockAndNotifyAdequately(worldIn, blockpos, this.metaLeaves);
	                                }
	                            }
	                        }
	                    }
	                }
	
	                for (int j3 = 0; j3 < i; ++j3){
	                    BlockPos upN = position.up(j3);
	                    Block block2 = worldIn.getBlockState(upN).getBlock();
	
	                    if (block2.isAir(worldIn, upN) || block2.isLeaves(worldIn, upN) || block2.getMaterial() == Material.vine){
	                        this.setBlockAndNotifyAdequately(worldIn, position.up(j3), this.metaWood);
	
	                        if (this.vinesGrow && j3 > 0){
	                            if (rand.nextInt(3) > 0 && worldIn.isAirBlock(position.add(-1, j3, 0))){
	                                this.growVines(worldIn, position.add(-1, j3, 0), BlockVine.EAST);
	                            }
	
	                            if (rand.nextInt(3) > 0 && worldIn.isAirBlock(position.add(1, j3, 0))){
	                                this.growVines(worldIn, position.add(1, j3, 0), BlockVine.WEST);
	                            }
	
	                            if (rand.nextInt(3) > 0 && worldIn.isAirBlock(position.add(0, j3, -1))){
	                                this.growVines(worldIn, position.add(0, j3, -1), BlockVine.SOUTH);
	                            }
	
	                            if (rand.nextInt(3) > 0 && worldIn.isAirBlock(position.add(0, j3, 1))){
	                                this.growVines(worldIn, position.add(0, j3, 1), BlockVine.NORTH);
	                            }
	                        }
	                    }
	                }
	
	                if (this.vinesGrow){
	                    for (int k3 = position.getY() - 3 + i; k3 <= position.getY() + i; ++k3){
	                        int j4 = k3 - (position.getY() + i);
	                        int k4 = 2 - j4 / 2;
	                        BlockPos.MutableBlockPos blockpos$mutableblockpos1 = new BlockPos.MutableBlockPos();
	
	                        for (int l4 = position.getX() - k4; l4 <= position.getX() + k4; ++l4){
	                            for (int i5 = position.getZ() - k4; i5 <= position.getZ() + k4; ++i5){
	                                blockpos$mutableblockpos1.set(l4, k3, i5);
	
	                                if (worldIn.getBlockState(blockpos$mutableblockpos1).getBlock().isLeaves(worldIn,blockpos$mutableblockpos1)){
	                                    BlockPos blockpos2 = blockpos$mutableblockpos1.west();
	                                    BlockPos blockpos3 = blockpos$mutableblockpos1.east();
	                                    BlockPos blockpos4 = blockpos$mutableblockpos1.north();
	                                    BlockPos blockpos1 = blockpos$mutableblockpos1.south();
	
	                                    if (rand.nextInt(4) == 0 && worldIn.getBlockState(blockpos2).getBlock().isAir(worldIn,blockpos2)){
	                                        this.func_181650_b(worldIn, blockpos2, BlockVine.EAST);
	                                    }
	
	                                    if (rand.nextInt(4) == 0 && worldIn.getBlockState(blockpos3).getBlock().isAir(worldIn,blockpos3)){
	                                        this.func_181650_b(worldIn, blockpos3, BlockVine.WEST);
	                                    }
	
	                                    if (rand.nextInt(4) == 0 && worldIn.getBlockState(blockpos4).getBlock().isAir(worldIn,blockpos4)){
	                                        this.func_181650_b(worldIn, blockpos4, BlockVine.SOUTH);
	                                    }
	
	                                    if (rand.nextInt(4) == 0 && worldIn.getBlockState(blockpos1).getBlock().isAir(worldIn,blockpos1)){
	                                        this.func_181650_b(worldIn, blockpos1, BlockVine.NORTH);
	                                    }
	                                }
	                            }
	                        }
	                    }
	
	                    /*if (rand.nextInt(5) == 0 && i > 5){
	                        for (int l3 = 0; l3 < 2; ++l3){
	                            for (EnumFacing enumfacing : EnumFacing.Plane.HORIZONTAL){
	                                if (rand.nextInt(4 - l3) == 0){
	                                    EnumFacing enumfacing1 = enumfacing.getOpposite();
	                                    this.func_181652_a(worldIn, rand.nextInt(3), position.add(enumfacing1.getFrontOffsetX(), i - 5 + l3, enumfacing1.getFrontOffsetZ()), enumfacing);
	                                }
	                            }
	                        }
	                    }*/
	                }
	
	                return true;
	            }
	            else{
	                return false;
	            }
	        }
	    }
	    else{
	        return false;
	    }
	}
	
	private void growVines(World world, BlockPos pos, PropertyBool property){
		Block vineBlock = this.pickRandomVineBlock(world);
	    this.setBlockAndNotifyAdequately(world, pos, vineBlock.getDefaultState().withProperty(property, Boolean.valueOf(true)));
	}
	
	private void func_181650_b(World world, BlockPos pos, PropertyBool property){
	    this.growVines(world, pos, property);
	    int i = 4;
	
	    for (pos = pos.down(); world.getBlockState(pos).getBlock().isAir(world,pos) && i > 0; --i){
	        this.growVines(world, pos, property);
	        pos = pos.down();
	    }
	}

	/*
	 * Returns a random vine block out of the options given
	 */
	private Block pickRandomVineBlock(World world){
		int blockNr = world.rand.nextInt(this.vineBlocks.length);
		return this.vineBlocks[blockNr];
	}
}