package com.Mod_Ores.Blocks;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.Icon;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.Mod_Ores.soul_forest;
import com.Mod_Ores.Init.SoulBlocks;
import com.Mod_Ores.Init.SoulItems;

public class BlockVineplant extends Block implements IPlantable{
	
	public static final PropertyEnum<BlockVineplant.EnumType> TYPE = PropertyEnum.<BlockVineplant.EnumType>create("type", BlockVineplant.EnumType.class);
    
	private static Icon iconTop;
    private static Icon iconBottom;
    
	public final String textureName;
	
	public String getName(){
		return this.textureName;
	}

    public BlockVineplant(String Unlname){
		super(Material.plants);
		float f = 0.375F;
		this.setStepSound(soundTypeGrass);
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 1.0F, 0.5F + f);
		this.setTickRandomly(true);
		setCreativeTab(soul_forest.tabSoulBerries);
		this.setUnlocalizedName(soul_forest.MODID + "_" + Unlname);
		this.textureName = Unlname;
		GameRegistry.registerBlock(this, Unlname);
    }

    /**
     * Ticks the block if it's been scheduled
     */
    @Override
    public void updateTick(World par1World, BlockPos pos, IBlockState state, Random par5Random){
		if (par1World.isAirBlock(pos.up())){
		    int l;
	
		    for (l = 1; par1World.getBlockState(pos.down()).getBlock() == SoulBlocks.Vineplant.get(); ++l){
		    	;
		    }
	
		    if (l == 0 || l == 1){
		    	par1World.setBlockState(pos.up(), SoulBlocks.Vineplant.get().getDefaultState());
		    }
		    if (l == 2){
		    	par1World.setBlockState(pos.up(), SoulBlocks.VineplantTop.get().getDefaultState());
		    }
		}
    }

    /**
     * Checks to see if its valid to put this block at the specified coordinates. Args: world, x, y, z
     */
    @Override
    public boolean canPlaceBlockAt(World par1World, BlockPos pos){
		Block block = par1World.getBlockState(pos.down()).getBlock();
		if(block.isAir(par1World, pos.down())){
		    return false;
		}
		return block == SoulBlocks.BogGrass.get() || block == SoulBlocks.BogDirt.get() || block == SoulBlocks.Vineplant.get();
    }

    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor blockID
     */
    @Override
    public void onNeighborBlockChange(World par1World, BlockPos pos, IBlockState state, Block neighbourBlock){
    	this.checkBlockCoordValid(par1World, pos, state);
    }

    /**
     * Checks if current block pos is valid, if not, breaks the block as dropable item. Used for reed and cactus.
     */
    protected final void checkBlockCoordValid(World par1World, BlockPos pos, IBlockState state){
		if (!this.canBlockStay(par1World, pos, state)){
		    //this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
		    par1World.setBlockToAir(pos);
		}
    }

    /**
     * Can this block stay at this position.  Similar to canPlaceBlockAt except gets checked often with plants.
     */
    public boolean canBlockStay(World par1World, BlockPos pos, IBlockState state){
    	return this.canPlaceBlockAt(par1World, pos);
    }

    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4){
    	return null;
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    /*public int idDropped(int par1, Random par2Random, int par3)
    {
        return SoulItems.ItemVineplant.get();
    }*/

    /**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    public boolean isOpaqueCube(){
    	return false;
    }

    @Override
    public boolean isFullCube(){
    	return true;
    }

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock(){
    	return false;
    }

    /**
     * The type of render function that is called for this block
     */
    public int getRenderType(){
    	return 1;
    }

    @SideOnly(Side.CLIENT)
    
    public static enum EnumType implements IStringSerializable{
        DEAD_BUSH(0, "dead_bush"),
        GRASS(1, "tall_grass"),
        FERN(2, "fern");

        private static final BlockVineplant.EnumType[] META_LOOKUP = new BlockVineplant.EnumType[values().length];
        private final int meta;
        private final String name;

        private EnumType(int meta, String name){
            this.meta = meta;
            this.name = name;
        }

        public int getMeta(){
            return this.meta;
        }

        public String toString(){
            return this.name;
        }

        public static BlockVineplant.EnumType byMetadata(int meta){
            if (meta < 0 || meta >= META_LOOKUP.length){
                meta = 0;
            }

            return META_LOOKUP[meta];
        }

        public String getName(){
            return this.name;
        }

        static{
            for (BlockVineplant.EnumType blocktallgrass$enumtype : values()){
                META_LOOKUP[blocktallgrass$enumtype.getMeta()] = blocktallgrass$enumtype;
            }
        }
    }

    /**
     * only called by clickMiddleMouseButton , and passed to inventory.setCurrentItem (along with isCreative)
     */
    @Override
    public ArrayList<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune){
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
		ret.add(new ItemStack(SoulItems.ItemVineplant.get(), 1, ((BlockVineplant.EnumType)world.getBlockState(pos).getValue(TYPE)).getMeta()));
		return ret;
    }

    @Override
    public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
    	return EnumPlantType.Cave;
    }


    @Override
    public IBlockState getPlant(IBlockAccess world, BlockPos pos) {
    	return this.getDefaultState();
    }
}