package com.Mod_Ores.Blocks.Special;

import com.Mod_Ores.soul_forest;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockSoulStairs extends BlockStairs {
	
	public final String textureName;
	
	public String getName(){
		return this.textureName;
	}

    public BlockSoulStairs(Block p_i45428_1_, int p_i45428_2_, String unlName, CreativeTabs tab) {
		super(p_i45428_1_.getDefaultState());
		GameRegistry.registerBlock(this, unlName);
		this.setUnlocalizedName(soul_forest.MODID + "_" + unlName);
		this.textureName = unlName;
		super.setCreativeTab(tab);
    }
}