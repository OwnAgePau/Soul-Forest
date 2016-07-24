package com.Mod_Ores.Blocks;

import com.Mod_Ores.soul_forest;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockSoulPlant extends Block implements IPlantable{
	
	public final String textureName;
	
	public String getName(){
		return this.textureName;
	}
    
    public BlockSoulPlant(String Unlname){
		super(Material.plants);
		this.setTickRandomly(true);
		float f = 0.2F;
		this.setStepSound(soundTypeGrass);
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 3.0F, 0.5F + f);
		this.setCreativeTab(soul_forest.tabSoulBerries);
		this.setUnlocalizedName(soul_forest.MODID + "_" + Unlname);
		this.textureName = Unlname;
		GameRegistry.registerBlock(this, Unlname);
	}

    @Override
    public boolean canPlaceBlockAt(World par1World, BlockPos pos){
		Block block = par1World.getBlockState(pos.down()).getBlock();
		if(block != null){
		    if(block.canSustainPlant(par1World, pos.down(), EnumFacing.UP, this))
			return true;   
		}
		else{
		    return false;
		}
	
		return block.canSustainPlant(par1World, pos.down(), EnumFacing.UP, this);
    }

    @Override
    public boolean canBeReplacedByLeaves(IBlockAccess world, BlockPos pos){
    	return true;
    }

    /*public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5){
    	this.checkBlockCoordValid(par1World, par2, par3, par4);
    }

    protected final void checkBlockCoordValid(World par1World, BlockPos pos){
		if (!this.canBlockStay(par1World, pos)){
		    this.dropBlockAsItem(par1World, pos, par1World.getBlockMetadata(par2, par3, par4), 0);
		    par1World.setBlockToAir(pos);
		}
    }*/

    /**
     * Can this block stay at this position.  Similar to canPlaceBlockAt except gets checked often with plants.
     */
    @Override
    public boolean canReplace(World worldIn, BlockPos pos, EnumFacing side, ItemStack stack){
        return this.canPlaceBlockOnSide(worldIn, pos, side);
    }
    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4){
    	return null;
    }

    /**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    public boolean isOpaqueCube(){
    	return false;
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

    @Override
    public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
    	return EnumPlantType.Cave;
    }


    @Override
    public IBlockState getPlant(IBlockAccess world, BlockPos pos) {
    	return this.getDefaultState();
    }


    /*@Override
    public int getPlantMetadata(IBlockAccess world, int x, int y, int z) {
    	return world.getBlockMetadata(x, y, z);
    }*/
}