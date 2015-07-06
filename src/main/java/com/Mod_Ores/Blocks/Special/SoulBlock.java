package com.Mod_Ores.Blocks.Special;

import java.util.Random;

import com.Mod_Ores.soul_forest;
import com.Mod_Ores.Init.SoulBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class SoulBlock extends Block{

    private String unlocalizedName;
    /**
     * Decoration Block Constructor
     * @param id this is the Block ID
     * @param unlName This is the Unlocalized Name
     * @param Hardness sets the hardness of the block
     * @param Resistance sets the resistance of the block
     * @param LightValue sets the blocks light value
     * @param Material
     */
    public SoulBlock(String unlName, float Hardness, float Resistance, Boolean LightValue, Material mat){
	super(mat);
	this.unlocalizedName = unlName;
	setCreativeTab(soul_forest.tabSoulBlocks);
	setHardness(Hardness);
	setResistance(Resistance);

	if(LightValue == true){
	    setLightLevel(1F);
	}

	setStepSound(Block.soundTypeMetal);
	GameRegistry.registerBlock(this, unlName);
	setBlockName(unlName);
    }

    @Override
    public boolean canSustainPlant(IBlockAccess world, int x, int y, int z, ForgeDirection direction, IPlantable plant) {
	return false;
    }

    @Override
    public void onNeighborBlockChange(World par1World, int par2x, int par3y, int par4z, Block par5block) {
	super.onNeighborBlockChange(par1World, par2x, par3y, par4z, par5block);
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