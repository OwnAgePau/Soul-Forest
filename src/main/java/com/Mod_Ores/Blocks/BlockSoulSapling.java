package com.Mod_Ores.Blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.TerrainGen;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.Mod_Ores.IMetaBlockName;
import com.Mod_Ores.ItemBlockMeta;
import com.Mod_Ores.soul_forest;
import com.Mod_Ores.BiomeGen.WorldGenGrapeTree;
import com.Mod_Ores.Init.SoulBlocks;

public class BlockSoulSapling extends Block{
    
    //public static final PropertyEnum<BlockSoulSapling.EnumType> TYPE = PropertyEnum.<BlockSoulSapling.EnumType>create("type", BlockSoulSapling.EnumType.class);
    public static final PropertyInteger STAGE = PropertyInteger.create("stage", 0, 1);

	//@SideOnly(Side.CLIENT)
    //private IIcon[] saplingIcon;
    
    private Block topBlock;
    private Block bottomBlock;
    
    private WorldGenerator theGenerator;
    
	public final String textureName;
	
	public String getName(){
		return this.textureName;
	}

    public BlockSoulSapling(String unlName, Block topBlock, Block bottomBlock, WorldGenerator theGenerator){
		super(Material.plants);
		float f = 0.4F;
		this.setStepSound(soundTypeGrass);
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
		this.setCreativeTab(soul_forest.tabSoulBerries);
		this.topBlock = topBlock;
		this.bottomBlock = bottomBlock;
		this.theGenerator = theGenerator;
		this.textureName = unlName;
		this.setUnlocalizedName(soul_forest.MODID + "_" + unlName);
		GameRegistry.registerBlock(this, unlName);
		//this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, EnumType.SOUL)); // TODO this might be different for every variant
    }
    
    @Override
    public int getRenderType() {
    	  return 3;
    }

    /*@Override
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List list) {
    	for(int i = 0; i < BlockSoulSapling.EnumType.values().length; i++){
    		list.add(new ItemStack(itemIn, 1, i));
    	}
    }*/
    
    @SideOnly(Side.CLIENT)
    @Override
    public EnumWorldBlockLayer getBlockLayer(){
        return EnumWorldBlockLayer.CUTOUT;
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state){
        return null;
    }

    @Override
    public boolean isOpaqueCube(){
        return false;
    }

    @Override
    public boolean isFullCube(){
        return false;
    }

	/**
     * Gets passed in the blockID of the block below and supposed to return true if its allowed to grow on the type of
     * blockID passed in. Args: blockID
     */
    protected boolean canThisPlantGrowOnThisBlockID(Block par1){
    	return par1 == this.topBlock || par1 == this.bottomBlock;
    }

    /*@Override
    public boolean canPlaceBlockAt(World par1World, BlockPos pos){
		Block block =par1World.getBlockState(pos.down()).getBlock();
		if(block != null){
		    if(block.canSustainPlant(par1World, pos.down(), EnumFacing.UP, this))
			return true;   
		}
		else{
		    return false;
		}

		return block.canSustainPlant(par1World, pos.down(), EnumFacing.UP, this);
    }

    public void onNeighborBlockChange(World par1World, BlockPos pos, IBlockState state){
    	this.checkBlockCoordValid(par1World, pos, state);
    }

    protected final void checkBlockCoordValid(World par1World, BlockPos pos, IBlockState state){
		if (!this.canBlockStay(par1World, pos, state)){
		    //this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
		    par1World.setBlockToAir(pos);
		}
    }

    @Override
    public boolean canBlockStay(World par1World, BlockPos pos, IBlockState state){
    	return this.canPlaceBlockAt(par1World, pos);
    }*/

    /**
     * Ticks the block if it's been scheduled
     */
    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand){
		super.updateTick(worldIn, pos, state, rand);
		this.markOrGrowMarked(worldIn, pos, state, rand);
    }

    /*@SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int par1, int par2){
		par2 &= 3;
		return this.saplingIcon[par2];
    }*/

    public void markOrGrowMarked(World par1World, BlockPos pos, IBlockState state, Random rand){
    	if (((Integer)state.getValue(STAGE)).intValue() == 0) {
    		par1World.setBlockState(pos, state.cycleProperty(STAGE), 4);
        }
        else
        {
            this.generateTree(par1World, pos, state, rand);
        }
    }

    /**
     * Attempts to grow a sapling into a tree
     */
    public void generateTree(World par1World, BlockPos pos, IBlockState state, Random par5Random){
		if (!net.minecraftforge.event.terraingen.TerrainGen.saplingGrowTree(par1World, par5Random, pos)){
		    return;
		}
		//int l = par1World.getBlockMetadata(par2, par3, par4) & 7;
		//Object object = par5Random.nextInt(10) == 0 ? new WorldGenBigTree(true) : new WorldGenTrees(true);
		int i1 = 0;
		int j1 = 0;
		boolean flag = false;
		//Object object = new WorldGenGrapeTree(true);
		Object object = this.theGenerator;
		
		if (flag){
		    par1World.setBlockState(new BlockPos(pos.getX() + i1, pos.getY(), pos.getZ() + j1), Block.getBlockFromName("air").getDefaultState(), 4);
		    par1World.setBlockState(new BlockPos(pos.getX() + i1 + 1, pos.getY(), pos.getZ() + j1), Block.getBlockFromName("air").getDefaultState(), 4);
		    par1World.setBlockState(new BlockPos(pos.getX() + i1, pos.getY(), pos.getZ() + j1 + 1), Block.getBlockFromName("air").getDefaultState(), 4);
		    par1World.setBlockState(new BlockPos(pos.getX() + i1 + 1, pos.getY(), pos.getZ() + j1 + 1), Block.getBlockFromName("air").getDefaultState(), 4);
		}
		else{
		    par1World.setBlockState(pos, Block.getBlockFromName("air").getDefaultState(), 4);
		}
	
		if (!((WorldGenerator)object).generate(par1World, par5Random, new BlockPos(pos.getX() + i1, pos.getY(), pos.getZ() + j1))){
		    if (flag){
				par1World.setBlockState(new BlockPos(pos.getX() + i1, pos.getY(), pos.getZ() + j1), this.getDefaultState(), 4);
				par1World.setBlockState(new BlockPos(pos.getX() + i1 + 1, pos.getY(), pos.getZ() + j1), this.getDefaultState(), 4);
				par1World.setBlockState(new BlockPos(pos.getX() + i1, pos.getY(), pos.getZ() + j1 + 1), this.getDefaultState(), 4);
				par1World.setBlockState(new BlockPos(pos.getX() + i1 + 1, pos.getY(), pos.getZ() + j1 + 1), this.getDefaultState(), 4);
		    }
		    else{
		    	par1World.setBlockState(pos, this.getDefaultState(), 4);
		    }
		}
    }
    
    /*@Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { TYPE });
    }
    
    @Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty(TYPE, EnumType.values()[meta]);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        EnumType type = (EnumType) state.getValue(TYPE);
        return type.getID();
    }
    
    @Override
    public int damageDropped(IBlockState state) {
        return getMetaFromState(state);
    }*/

    @SideOnly(Side.CLIENT)

	/*@Override
	public EnumFlowerColor getBlockType() {
		// TODO Auto-generated method stub
		return null;
	}*/
    
	 /*public static enum EnumType implements IStringSerializable{
		 	SOUL(0, "Sapling_soul"),
		    HARDWOOD(1, "Sapling_hardwood"),
		 	FROZEN(2, "Sapling_frozen");

		    private int ID;
		    private String name;
		    
		    private EnumType(int ID, String name) {
		        this.ID = ID;
		        this.name = name;
		    }
		    
		    @Override
		    public String getName() {
		        return this.name;
		    }

		    public int getID() {
		        return this.ID;
		    }
		    
		    @Override
		    public String toString() {
		        return getName();
		    }
	 }*/

	/*@Override
	public String getSpecialName(ItemStack stack) {
		return EnumType.values()[stack.getItemDamage()].getName();
	}
	
	public static String[] getEnumTypes(){
		String[] values = new String[BlockSoulSapling.EnumType.values().length];
		for(int i = 0; i < BlockSoulSapling.EnumType.values().length; i++){
			values[i] = BlockSoulSapling.EnumType.values()[i].toString();
		}
		return values;
	}*/
	
	@Override
	public ItemStack getPickBlock(MovingObjectPosition target, World world, BlockPos pos) {
	    return new ItemStack(Item.getItemFromBlock(this), 1, this.getMetaFromState(world.getBlockState(pos)));
	}
}