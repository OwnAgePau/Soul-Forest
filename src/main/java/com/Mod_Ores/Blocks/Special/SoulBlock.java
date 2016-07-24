package com.Mod_Ores.Blocks.Special;

import java.util.Random;

import com.Mod_Ores.soul_forest;
import com.Mod_Ores.Init.SoulBlocks;
import com.google.common.cache.LoadingCache;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPortal;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockWorldState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockPattern;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SoulBlock extends Block{
    
    public final String textureName;
    
    public String getName(){
    	return this.textureName;
    }
    
    /**
     * Decoration Block Constructor
     * @param id this is the Block ID
     * @param name This is the Unlocalized Name
     * @param Hardness sets the hardness of the block
     * @param Resistance sets the resistance of the block
     * @param LightValue sets the blocks light value
     * @param Material
     */
    public SoulBlock(String name, float Hardness, float Resistance, Boolean LightValue, Material mat){
		super(mat);
		this.setCreativeTab(soul_forest.tabSoulBlocks);
		this.setHardness(Hardness);
		this.setResistance(Resistance);
		this.textureName = name;
		this.setUnlocalizedName(soul_forest.MODID + "_" + name);
		if(LightValue == true){
		    setLightLevel(1F);
		}
		setStepSound(Block.soundTypeMetal);
		GameRegistry.registerBlock(this, name);		
    }

    @Override
    public boolean canSustainPlant(IBlockAccess world, BlockPos pos, EnumFacing direction, net.minecraftforge.common.IPlantable plantable) {
    	return false;
    }

    @Override
    public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock) {
		super.onNeighborBlockChange(worldIn, pos, state, neighborBlock);
		/*if("SnowBottomLayer".equals(this.unlocalizedName)){
		    Block blockChanged = par1World.getBlock(par2x, par3y, par4z);
		    if(par1World.isAirBlock(par2x, par3y + 1, par4z)){
			System.out.println("IS AIR");
			Block block = par1World.getBlock(par2x, par3y, par4z);
			System.out.println("The Block Before : " + block.getLocalizedName());
			par1World.setBlockToAir(par2x, par3y, par4z);
			par1World.setBlock(par2x, par3y - 1, par4z, SoulBlocks.SoulSnowTop.get());
			Block block1 = par1World.getBlock(par2x, par3y, par4z);
			System.out.println("The Block After : " + block1.getLocalizedName());
		    }
		}*/
    }
}