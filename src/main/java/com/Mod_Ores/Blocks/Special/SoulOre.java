package com.Mod_Ores.Blocks.Special;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.Mod_Ores.soul_forest;
import com.Mod_Ores.Init.InitAchievements;
import com.Mod_Ores.Init.SoulBlocks;
import com.Mod_Ores.Particles.RenderParticles;

public class SoulOre extends Block{
    private int dropQuantity;
    private Item dropItem;
    
    private final String textureName;

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
    public SoulOre(int par3dropQuantity, int harvestLevel, String name, float Hardness, float Resistance, Boolean LightValue){
		super(Material.rock);
		setCreativeTab(soul_forest.tabSoulBlocks);
		setHardness(Hardness);
		setResistance(Resistance);		  
		setStepSound(Block.soundTypeStone);
		this.setUnlocalizedName(soul_forest.MODID + "_" + name);
		this.textureName = name;
	
		if(LightValue == true){
		    setLightLevel(1F); // Default 1F
		}
	
		this.dropQuantity = par3dropQuantity;
		GameRegistry.registerBlock(this, name);
		this.dropItem = Item.getItemFromBlock(this);
		this.setHarvestLevel("pickaxe", harvestLevel);
    }

    public SoulOre(Item item, int par3dropQuantity, int harvestLevel, String unlName, float Hardness, float Resistance, Boolean LightValue){
		this(par3dropQuantity, harvestLevel, unlName, Hardness, Resistance, LightValue);
		this.dropItem = item;
    }
    
    public String getName(){
    	return this.textureName;
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune){
    	return this.dropItem;
    }

    @Override
    public int quantityDropped(Random par1Random) {
    	return this.dropQuantity;
    }

    @Override
    public void onBlockHarvested(World par1World, BlockPos pos, IBlockState state, EntityPlayer par6EntityPlayer) {
		if(this == SoulBlocks.Uraniumore.get() || this == SoulBlocks.Steelore.get() || this == SoulBlocks.Cobaltore.get()){
		    super.onBlockHarvested(par1World, pos, state, par6EntityPlayer);
		    par6EntityPlayer.addStat(InitAchievements.getRareOverworldOre, 1);
		}		
		else if(this == SoulBlocks.Tinore.get() || this == SoulBlocks.Copperore.get()){
		    super.onBlockHarvested(par1World, pos, state, par6EntityPlayer);
		    par6EntityPlayer.addStat(InitAchievements.mineTinCopper, 1);
		}
		else if(!(this == SoulBlocks.Silverore.get())){
		    super.onBlockHarvested(par1World, pos, state, par6EntityPlayer);
		    par6EntityPlayer.addStat(InitAchievements.firstUncutfound, 1);
		}
    }

    @Override
    public void randomDisplayTick(World worldIn, BlockPos pos, IBlockState state, Random random) {
		if(this == SoulBlocks.Amazoniteore.get()){
		    if(random.nextInt(3) == 0){
				RenderParticles.spawnParticle("amazonite", pos.getX() + random.nextDouble(), pos.getY() + 1.1, pos.getZ() + random.nextDouble(), 5.0D, 1.0D, 1.0D);
				RenderParticles.spawnParticle("amazonite", pos.getX() + 1.1, pos.getY() + random.nextDouble(), pos.getZ() + random.nextDouble(), 5.0D, 1.0D, 1.0D);
				RenderParticles.spawnParticle("amazonite", pos.getX() - 0.1, pos.getY() + random.nextDouble(), pos.getZ() + random.nextDouble(), 5.0D, 1.0D, 1.0D);
				RenderParticles.spawnParticle("amazonite", pos.getX() + random.nextDouble(), pos.getY() + random.nextDouble(), pos.getZ() + 1.1, 5.0D, 1.0D, 1.0D);
				RenderParticles.spawnParticle("amazonite", pos.getX() + random.nextDouble(), pos.getY() + random.nextDouble(), pos.getZ() - 0.1, 5.0D, 1.0D, 1.0D);	
		    }
		}
		else if(this == SoulBlocks.Cobaltore.get()){
		    if(random.nextInt(3) == 0){
				RenderParticles.spawnParticle("cobalt", pos.getX() + random.nextDouble(), pos.getY() + 1.1, pos.getZ() + random.nextDouble(), 5.0D, 1.0D, 1.0D);
				RenderParticles.spawnParticle("cobalt", pos.getX() + 1.1, pos.getY() + random.nextDouble(), pos.getZ() + random.nextDouble(), 5.0D, 1.0D, 1.0D);
				RenderParticles.spawnParticle("cobalt", pos.getX() - 0.1, pos.getY() + random.nextDouble(), pos.getZ() + random.nextDouble(), 5.0D, 1.0D, 1.0D);
				RenderParticles.spawnParticle("cobalt", pos.getX() + random.nextDouble(), pos.getY() + random.nextDouble(), pos.getZ() + 1.1, 5.0D, 1.0D, 1.0D);
				RenderParticles.spawnParticle("cobalt", pos.getX() + random.nextDouble(), pos.getY() + random.nextDouble(), pos.getZ() - 0.1, 5.0D, 1.0D, 1.0D);	
		    }
		}
    }

    @Override
    public boolean canSustainPlant(IBlockAccess world, BlockPos pos, EnumFacing direction, IPlantable plantable) {
    	return false;
    }
}