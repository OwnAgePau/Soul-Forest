package com.Mod_Ores.Blocks.Special;

import java.util.IdentityHashMap;
import java.util.Random;
import java.util.Map.Entry;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFire;
import net.minecraft.block.BlockTNT;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.Mod_Ores.soul_forest;
import com.Mod_Ores.Dimension.SoulForest.TeleportBlockSoulForest;
import com.Mod_Ores.Init.SoulBlocks;
import com.google.common.collect.Maps;

public class SoulFire extends BlockFire{
    private int[] chanceToEncourageFire = new int[256];
    private int[] abilityToCatchFire = new int[256];
    //@SideOnly(Side.CLIENT)
    //private IIcon[] iconArray;
    
    public final String textureName;
	
	public String getName(){
    	return this.textureName;
    }

    public SoulFire(String Unlname){
        super();
        this.setTickRandomly(true);
        this.setUnlocalizedName(soul_forest.MODID + "_" + Unlname);
        this.textureName = Unlname;
		GameRegistry.registerBlock(this, Unlname);
    }

    public void initializeBlock(){
        Blocks.fire.setFireInfo(Blocks.planks, 5, 20);
        Blocks.fire.setFireInfo(Blocks.double_wooden_slab, 5, 20);
        Blocks.fire.setFireInfo(Blocks.wooden_slab, 5, 20);
        Blocks.fire.setFireInfo(Blocks.oak_fence_gate, 5, 20);
        Blocks.fire.setFireInfo(Blocks.spruce_fence_gate, 5, 20);
        Blocks.fire.setFireInfo(Blocks.birch_fence_gate, 5, 20);
        Blocks.fire.setFireInfo(Blocks.jungle_fence_gate, 5, 20);
        Blocks.fire.setFireInfo(Blocks.dark_oak_fence_gate, 5, 20);
        Blocks.fire.setFireInfo(Blocks.acacia_fence_gate, 5, 20);
        Blocks.fire.setFireInfo(Blocks.oak_fence, 5, 20);
        Blocks.fire.setFireInfo(Blocks.spruce_fence, 5, 20);
        Blocks.fire.setFireInfo(Blocks.birch_fence, 5, 20);
        Blocks.fire.setFireInfo(Blocks.jungle_fence, 5, 20);
        Blocks.fire.setFireInfo(Blocks.dark_oak_fence, 5, 20);
        Blocks.fire.setFireInfo(Blocks.acacia_fence, 5, 20);
        Blocks.fire.setFireInfo(Blocks.oak_stairs, 5, 20);
        Blocks.fire.setFireInfo(Blocks.birch_stairs, 5, 20);
        Blocks.fire.setFireInfo(Blocks.spruce_stairs, 5, 20);
        Blocks.fire.setFireInfo(Blocks.jungle_stairs, 5, 20);
        Blocks.fire.setFireInfo(Blocks.log, 5, 5);
        Blocks.fire.setFireInfo(Blocks.log2, 5, 5);
        Blocks.fire.setFireInfo(Blocks.leaves, 30, 60);
        Blocks.fire.setFireInfo(Blocks.leaves2, 30, 60);
        Blocks.fire.setFireInfo(Blocks.bookshelf, 30, 20);
        Blocks.fire.setFireInfo(Blocks.tnt, 15, 100);
        Blocks.fire.setFireInfo(Blocks.tallgrass, 60, 100);
        Blocks.fire.setFireInfo(Blocks.double_plant, 60, 100);
        Blocks.fire.setFireInfo(Blocks.yellow_flower, 60, 100);
        Blocks.fire.setFireInfo(Blocks.red_flower, 60, 100);
        Blocks.fire.setFireInfo(Blocks.deadbush, 60, 100);
        Blocks.fire.setFireInfo(Blocks.wool, 30, 60);
        Blocks.fire.setFireInfo(Blocks.vine, 15, 100);
        Blocks.fire.setFireInfo(Blocks.coal_block, 5, 5);
        Blocks.fire.setFireInfo(Blocks.hay_block, 60, 20);
        Blocks.fire.setFireInfo(Blocks.carpet, 60, 20);
    }

    private void setBurnRate(Block par1, int par2, int par3){
    	this.setFireInfo(par1, par2, par3);
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4){
        return null;
    }

    public boolean isOpaqueCube(){
        return false;
    }

    public boolean renderAsNormalBlock(){
        return false;
    }

    public int getRenderType(){
        return 3;
    }

    public int quantityDropped(Random par1Random){
        return 0;
    }

    public int tickRate(World par1World){
        return 30;
    }

    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand){
        if (worldIn.getGameRules().getBoolean("doFireTick")){
            if (!this.canPlaceBlockAt(worldIn, pos)){
            	worldIn.setBlockToAir(pos);
            }
            
            Block base = worldIn.getBlockState(pos.down()).getBlock();
            boolean flag = (base != null && base.isFireSource(worldIn, pos.down(), EnumFacing.UP));

            if (!flag && worldIn.isRaining() && this.canDie(worldIn, pos)){
            	worldIn.setBlockToAir(pos);
            }
            else{
            	int i = ((Integer)state.getValue(AGE)).intValue();

                if (i < 15){
                	state = state.withProperty(AGE, Integer.valueOf(i + rand.nextInt(3) / 2));
                	worldIn.setBlockState(pos, state, 4);
                }

                worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn) + rand.nextInt(10));
                if (!flag){
                    if (!this.canNeighborCatchFire(worldIn, pos)){
                        if (!World.doesBlockHaveSolidTopSurface(worldIn, pos.down()) || i > 3){
                            worldIn.setBlockToAir(pos);
                        }

                        return;
                    }

                    if (!this.canCatchFire(worldIn, pos.down(), EnumFacing.UP) && i == 15 && rand.nextInt(4) == 0){
                        worldIn.setBlockToAir(pos);
                        return;
                    }
                }

                boolean flag1 = worldIn.isBlockinHighHumidity(pos);
                int j = 0;

                if (flag1){
                    j = -50;
                }

                this.tryCatchFire(worldIn, pos.east(), 300 + j, rand, i, EnumFacing.WEST);
                this.tryCatchFire(worldIn, pos.west(), 300 + j, rand, i, EnumFacing.EAST);
                this.tryCatchFire(worldIn, pos.down(), 250 + j, rand, i, EnumFacing.UP);
                this.tryCatchFire(worldIn, pos.up(), 250 + j, rand, i, EnumFacing.DOWN);
                this.tryCatchFire(worldIn, pos.north(), 300 + j, rand, i, EnumFacing.SOUTH);
                this.tryCatchFire(worldIn, pos.south(), 300 + j, rand, i, EnumFacing.NORTH);

                for (int k = -1; k <= 1; ++k){
                    for (int l = -1; l <= 1; ++l){
                        for (int i1 = -1; i1 <= 4; ++i1){
                            if (k != 0 || i1 != 0 || l != 0){
                                int j1 = 100;

                                if (i1 > 1){
                                    j1 += (i1 - 1) * 100;
                                }

                                BlockPos blockpos = pos.add(k, i1, l);
                                int k1 = this.getNeighborEncouragement(worldIn, blockpos);

                                if (k1 > 0){
                                    int l1 = (k1 + 40 + worldIn.getDifficulty().getDifficultyId() * 7) / (i + 30);

                                    if (flag1){
                                        l1 /= 2;
                                    }

                                    if (l1 > 0 && rand.nextInt(j1) <= l1 && (!worldIn.isRaining() || !this.canDie(worldIn, blockpos))){
                                        int i2 = i + rand.nextInt(5) / 4;

                                        if (i2 > 15){
                                            i2 = 15;
                                        }

                                        worldIn.setBlockState(blockpos, state.withProperty(AGE, Integer.valueOf(i2)), 3);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    protected boolean canNeighborCatchFire(World worldIn, BlockPos pos){
        for (EnumFacing enumfacing : EnumFacing.values()){
            if (this.canCatchFire(worldIn, pos.offset(enumfacing), enumfacing.getOpposite())){
                return true;
            }
        }

        return false;
    }

    public boolean func_82506_l(){
        return false;
    }

    @Deprecated // Use tryCatchFire with face below
    private void catchOnFire(World worldIn, BlockPos pos, int chance, Random random, int age){
        this.tryCatchFire(worldIn, pos, chance, random, age, EnumFacing.UP);
    }
    
    private void tryCatchFire(World worldIn, BlockPos pos, int chance, Random random, int age, EnumFacing face){
        int i = worldIn.getBlockState(pos).getBlock().getFlammability(worldIn, pos, face);

        if (random.nextInt(chance) < i){
            IBlockState iblockstate = worldIn.getBlockState(pos);

            if (random.nextInt(age + 10) < 5 && !worldIn.canLightningStrike(pos)){
                int j = age + random.nextInt(5) / 4;

                if (j > 15){
                    j = 15;
                }

                worldIn.setBlockState(pos, this.getDefaultState().withProperty(AGE, Integer.valueOf(j)), 3);
            }
            else{
                worldIn.setBlockToAir(pos);
            }

            if (iblockstate.getBlock() == Blocks.tnt){
                Blocks.tnt.onBlockDestroyedByPlayer(worldIn, pos, iblockstate.withProperty(BlockTNT.EXPLODE, Boolean.valueOf(true)));
            }
        }
    }

    private int getNeighborEncouragement(World worldIn, BlockPos pos){
        if (!worldIn.isAirBlock(pos)){
            return 0;
        }
        else{
            int i = 0;

            for (EnumFacing enumfacing : EnumFacing.values()){
                i = Math.max(worldIn.getBlockState(pos.offset(enumfacing)).getBlock().getFlammability(worldIn, pos.offset(enumfacing), enumfacing.getOpposite()), i);
            }

            return i;
        }
    }

    public boolean isCollidable(){
        return false;
    }

    @Deprecated // Use canCatchFire with face sensitive version below
    public boolean canCatchFire(IBlockAccess worldIn, BlockPos pos){
        return canCatchFire(worldIn, pos, EnumFacing.UP);
    }

    public boolean canPlaceBlockAt(World worldIn, BlockPos pos){
        return World.doesBlockHaveSolidTopSurface(worldIn, pos.down()) || this.canNeighborCatchFire(worldIn, pos);
    }

    /**
     * Called when a neighboring block changes.
     */
    public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock){
        if (!World.doesBlockHaveSolidTopSurface(worldIn, pos.down()) && !this.canNeighborCatchFire(worldIn, pos)){
            worldIn.setBlockToAir(pos);
        }
    }

    /**
     * The Portal to the dimension
     */
    @Override
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state){
    	if ((worldIn.provider.getDimensionId() > 0 || worldIn.getBlockState(pos.down()).getBlock() != SoulBlocks.SilverBlock.get() || ((TeleportBlockSoulForest)SoulBlocks.Teleporter.get()).tryToCreatePortal(worldIn, pos.getX(), pos.getY(), pos.getZ()))){
            if (!worldIn.doesBlockHaveSolidTopSurface(worldIn, pos.down()) && !this.canNeighborCatchFire(worldIn, pos)){
            	worldIn.setBlockToAir(pos);
            }
            else{
            	worldIn.scheduleBlockUpdate(pos, this.getDefaultState().getBlock(), this.tickRate(worldIn) + worldIn.rand.nextInt(10), 1);
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World worldIn, BlockPos pos, IBlockState state, Random rand){
        if (rand.nextInt(24) == 0){
            worldIn.playSound((double)((float)pos.getX() + 0.5F), (double)((float)pos.getY() + 0.5F), (double)((float)pos.getZ() + 0.5F), "fire.fire", 1.0F + rand.nextFloat(), rand.nextFloat() * 0.7F + 0.3F, false);
        }

        if (!World.doesBlockHaveSolidTopSurface(worldIn, pos.down()) && !Blocks.fire.canCatchFire(worldIn, pos.down(), EnumFacing.UP)){
            if (Blocks.fire.canCatchFire(worldIn, pos.west(), EnumFacing.EAST)){
                for (int j = 0; j < 2; ++j){
                    double d3 = (double)pos.getX() + rand.nextDouble() * 0.10000000149011612D;
                    double d8 = (double)pos.getY() + rand.nextDouble();
                    double d13 = (double)pos.getZ() + rand.nextDouble();
                    worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, d3, d8, d13, 0.0D, 0.0D, 0.0D, new int[0]);
                }
            }

            if (Blocks.fire.canCatchFire(worldIn, pos.east(), EnumFacing.WEST)){
                for (int k = 0; k < 2; ++k){
                    double d4 = (double)(pos.getX() + 1) - rand.nextDouble() * 0.10000000149011612D;
                    double d9 = (double)pos.getY() + rand.nextDouble();
                    double d14 = (double)pos.getZ() + rand.nextDouble();
                    worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, d4, d9, d14, 0.0D, 0.0D, 0.0D, new int[0]);
                }
            }

            if (Blocks.fire.canCatchFire(worldIn, pos.north(), EnumFacing.SOUTH)){
                for (int l = 0; l < 2; ++l){
                    double d5 = (double)pos.getX() + rand.nextDouble();
                    double d10 = (double)pos.getY() + rand.nextDouble();
                    double d15 = (double)pos.getZ() + rand.nextDouble() * 0.10000000149011612D;
                    worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, d5, d10, d15, 0.0D, 0.0D, 0.0D, new int[0]);
                }
            }

            if (Blocks.fire.canCatchFire(worldIn, pos.south(), EnumFacing.NORTH)){
                for (int i1 = 0; i1 < 2; ++i1){
                    double d6 = (double)pos.getX() + rand.nextDouble();
                    double d11 = (double)pos.getY() + rand.nextDouble();
                    double d16 = (double)(pos.getZ() + 1) - rand.nextDouble() * 0.10000000149011612D;
                    worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, d6, d11, d16, 0.0D, 0.0D, 0.0D, new int[0]);
                }
            }

            if (Blocks.fire.canCatchFire(worldIn, pos.up(), EnumFacing.DOWN)){
                for (int j1 = 0; j1 < 2; ++j1){
                    double d7 = (double)pos.getX() + rand.nextDouble();
                    double d12 = (double)(pos.getY() + 1) - rand.nextDouble() * 0.10000000149011612D;
                    double d17 = (double)pos.getZ() + rand.nextDouble();
                    worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, d7, d12, d17, 0.0D, 0.0D, 0.0D, new int[0]);
                }
            }
        }
        else{
            for (int i = 0; i < 3; ++i){
                double d0 = (double)pos.getX() + rand.nextDouble();
                double d1 = (double)pos.getY() + rand.nextDouble() * 0.5D + 0.5D;
                double d2 = (double)pos.getZ() + rand.nextDouble();
                worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, d0, d1, d2, 0.0D, 0.0D, 0.0D, new int[0]);
            }
        }
    }

    //@SideOnly(Side.CLIENT)

    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    /*@Override
    public void registerBlockIcons(IIconRegister par1IconRegister){
        this.iconArray = new IIcon[] {par1IconRegister.registerIcon("soulforest:Soul_Fire"), par1IconRegister.registerIcon("soulforest:Soul_Fire")};
    }*/

    /*@Override
    @SideOnly(Side.CLIENT)
    public IIcon getFireIcon(int par1)
    {
    	return this.iconArray[par1];
    }*/

    @SideOnly(Side.CLIENT)

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    /*@Override
    public IIcon getIcon(int par1, int par2){
        return this.iconArray[0];
    }*/
    
    private static class FireInfo{
        private int encouragement = 0;
        private int flammibility = 0;
    }
    private IdentityHashMap<Block, FireInfo> blockInfo = Maps.newIdentityHashMap();
    
    public void setFireInfo(Block block, int encouragement, int flammibility){
        if (block == Blocks.air) throw new IllegalArgumentException("Tried to set air on fire... This is bad.");
        int id = Block.getIdFromBlock(block);
        this.chanceToEncourageFire[id] = encouragement;
        this.abilityToCatchFire[id] = flammibility;

        FireInfo info = getInfo(block, true);
        info.encouragement = encouragement;
        info.flammibility = flammibility;
    }
    
    private FireInfo getInfo(Block block, boolean garentee){
        FireInfo ret = blockInfo.get(block);
        if (ret == null && garentee){
            ret = new FireInfo();
            blockInfo.put(block, ret);
        }
        return ret;
    }
    
    public void rebuildFireInfo(){
        for (int x = 0; x < 4096; x++) {
            abilityToCatchFire[x] = 0;
            chanceToEncourageFire[x] = 0;
        }

        for (Entry<Block, FireInfo> e : blockInfo.entrySet()){
            int id = Block.getIdFromBlock(e.getKey());
            if (id >= 0 && id < 4096){
                chanceToEncourageFire[id] = e.getValue().encouragement;
                abilityToCatchFire[id] = e.getValue().flammibility;
            }
        }
    }
    
    /**
     * Side sensitive version that calls the block function.
     * 
     * @param world The current world
     * @param x X Position
     * @param y Y Position
     * @param z Z Position
     * @param face The side the fire is coming from
     * @return True if the face can catch fire.
     */
    public boolean canCatchFire(IBlockAccess world, BlockPos pos, EnumFacing face){
        return world.getBlockState(pos).getBlock().isFlammable(world, pos, face);
    }
    
    public int getFlammability(Block block){
        int id = Block.getIdFromBlock(block);
        return id >= 0 && id < 4096 ? abilityToCatchFire[id] : 0;
    }

    public int getEncouragement(Block block){
        int id = Block.getIdFromBlock(block);
        return id >= 0 && id < 4096 ? chanceToEncourageFire[id] : 0;
    }
}