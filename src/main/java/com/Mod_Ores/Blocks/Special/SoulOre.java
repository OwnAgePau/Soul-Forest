package com.Mod_Ores.Blocks.Special;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

import com.Mod_Ores.soul_forest;
import com.Mod_Ores.Init.InitAchievements;
import com.Mod_Ores.Init.SoulBlocks;
import com.Mod_Ores.Particles.RenderParticles;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class SoulOre extends Block{
    private int dropQuantity;
    private Item dropItem;

    /**
     * Decoration Block Constructor
     * @param id this is the Block ID
     * @param dropItem this is the id of the block/item that will be dropped when this block is destroyed
     * @param dropQuantity is the quantity of the block/item that is being dropped
     * @param Unlname This is the Unlocalized Name
     * @param InGname This is the Name that you will see In game
     * @param Hardness sets the hardness of the block
     * @param Resistance sets the resistance of the block
     * @param LightValue sets the blocks light value
     */
    public SoulOre(int par3dropQuantity, int harvestLevel, String Unlname, float Hardness, float Resistance, Boolean LightValue){
	super(Material.rock);
	setCreativeTab(soul_forest.tabSoulBlocks);
	setHardness(Hardness);
	setResistance(Resistance);		  
	setStepSound(Block.soundTypeStone);

	if(LightValue == true){
	    setLightLevel(1F); // Default 1F
	}

	this.dropQuantity = par3dropQuantity;
	GameRegistry.registerBlock(this, Unlname);
	setBlockName(Unlname);
	this.dropItem = Item.getItemFromBlock(this);
	this.setHarvestLevel("pickaxe", harvestLevel);
    }

    public SoulOre(Item item, int par3dropQuantity, int harvestLevel, String Unlname, float Hardness, float Resistance, Boolean LightValue){
	super(Material.rock);
	setCreativeTab(soul_forest.tabSoulBlocks);
	setHardness(Hardness);
	setResistance(Resistance);	  
	setStepSound(Block.soundTypeStone);
	this.dropItem = item;

	if(LightValue == true){
	    setLightLevel(1F);
	}

	this.dropQuantity = par3dropQuantity;
	GameRegistry.registerBlock(this, Unlname);
	setBlockName(Unlname);
	this.setHarvestLevel("pickaxe", harvestLevel);
    }

    @Override
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_){
	return this.dropItem;
    }

    @Override
    public int quantityDropped(Random par1Random) {
	return this.dropQuantity;
    }

    @Override
    public void onBlockHarvested(World par1World, int par2, int par3, int par4, int par5, EntityPlayer par6EntityPlayer) {
	if(this == SoulBlocks.Uraniumore.get() || this == SoulBlocks.Steelore.get() || this == SoulBlocks.Cobaltore.get()){
	    super.onBlockHarvested(par1World, par2, par3, par4, par5, par6EntityPlayer);
	    par6EntityPlayer.addStat(InitAchievements.getRareOverworldOre, 1);
	}		
	else if(this == SoulBlocks.Tinore.get() || this == SoulBlocks.Copperore.get()){
	    super.onBlockHarvested(par1World, par2, par3, par4, par5, par6EntityPlayer);
	    par6EntityPlayer.addStat(InitAchievements.mineTinCopper, 1);
	}
	else{
	    super.onBlockHarvested(par1World, par2, par3, par4, par5, par6EntityPlayer);
	    par6EntityPlayer.addStat(InitAchievements.firstUncutfound, 1);
	}
    }

    @Override
    public void randomDisplayTick(World world, int x, int y, int z, Random random) {
	if(this == SoulBlocks.Amazoniteore.get()){
	    if(random.nextInt(3) == 0){
		RenderParticles.spawnParticle("amazonite", x + random.nextDouble(), y + 1.1, z + random.nextDouble(), 5.0D, 1.0D, 1.0D);
		RenderParticles.spawnParticle("amazonite", x + 1.1, y + random.nextDouble(), z + random.nextDouble(), 5.0D, 1.0D, 1.0D);
		RenderParticles.spawnParticle("amazonite", x - 0.1, y + random.nextDouble(), z + random.nextDouble(), 5.0D, 1.0D, 1.0D);
		RenderParticles.spawnParticle("amazonite", x + random.nextDouble(), y + random.nextDouble(), z + 1.1, 5.0D, 1.0D, 1.0D);
		RenderParticles.spawnParticle("amazonite", x + random.nextDouble(), y + random.nextDouble(), z - 0.1, 5.0D, 1.0D, 1.0D);	
	    }
	}
	else if(this == SoulBlocks.Cobaltore.get()){
	    if(random.nextInt(3) == 0){
		RenderParticles.spawnParticle("cobalt", x + random.nextDouble(), y + 1.1, z + random.nextDouble(), 5.0D, 1.0D, 1.0D);
		RenderParticles.spawnParticle("cobalt", x + 1.1, y + random.nextDouble(), z + random.nextDouble(), 5.0D, 1.0D, 1.0D);
		RenderParticles.spawnParticle("cobalt", x - 0.1, y + random.nextDouble(), z + random.nextDouble(), 5.0D, 1.0D, 1.0D);
		RenderParticles.spawnParticle("cobalt", x + random.nextDouble(), y + random.nextDouble(), z + 1.1, 5.0D, 1.0D, 1.0D);
		RenderParticles.spawnParticle("cobalt", x + random.nextDouble(), y + random.nextDouble(), z - 0.1, 5.0D, 1.0D, 1.0D);	
	    }
	}
    }

    @Override
    public boolean canSustainPlant(IBlockAccess world, int x, int y, int z, ForgeDirection direction, IPlantable plant) {
	return false;
    }
}
