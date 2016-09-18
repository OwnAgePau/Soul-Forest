package com.Mod_Ores.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
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

    /**
     * Allows you to walk through this block
     */
    @Override
    public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state){
        return null;
    }

    @Override
    public boolean isBlockSolid(IBlockAccess worldIn, BlockPos pos, EnumFacing side){
        return false;
    }
    
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn){
    	((BlockSnowTopLayer) entityIn).setInWeb();
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