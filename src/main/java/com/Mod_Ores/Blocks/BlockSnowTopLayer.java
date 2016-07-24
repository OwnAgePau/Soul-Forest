package com.Mod_Ores.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.fml.common.registry.GameRegistry;

import org.w3c.dom.Entity;

import com.Mod_Ores.soul_forest;

public class BlockSnowTopLayer extends Block{
    protected boolean isInWeb;
    public float fallDistance;
    
	public final String textureName;
	
	public String getName(){
		return this.textureName;
	}

    public BlockSnowTopLayer(String Unlname){
		super(Material.snow);
		GameRegistry.registerBlock(this, Unlname);
		this.setUnlocalizedName(soul_forest.MODID + "_" + Unlname);
		this.textureName = Unlname;
    }

    /*@Override
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return SoulConfigBlocks.thickSnowID;
    }*/
    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4){
    	return null;
    }
    /**
     * Triggered whenever an entity collides with this block (enters into the block). Args: world, x, y, z, entity
     */
    public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity){
    	((BlockSnowTopLayer) par5Entity).setInWeb();
    }
    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock(){
    	return true;
    }

    /**
     * Sets the Entity inside a web block.
     */
    public void setInWeb(){
		this.isInWeb = true;
		this.fallDistance = 0.9F;
    }

    @Override
    public boolean canSustainPlant(IBlockAccess world, BlockPos pos, EnumFacing direction, IPlantable plant){
    	return false;
    }
}