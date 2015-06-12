package com.Mod_Ores.Blocks.Special;

import com.Mod_Ores.soul_forest;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.creativetab.CreativeTabs;

public class BlockSoulStairs extends BlockStairs {

	public BlockSoulStairs(Block p_i45428_1_, int p_i45428_2_, String unlName, CreativeTabs tab) {
		super(p_i45428_1_, p_i45428_2_);
		GameRegistry.registerBlock(this, unlName);
		super.setBlockName(unlName);
		super.setCreativeTab(tab);
	}
}
