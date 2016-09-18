package com.Mod_Ores.Blocks.Special.Slab;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.item.ItemSlab;

public class ItemSoulSlab extends ItemSlab {
	
	public ItemSoulSlab(final Block block, final SoulHalfSlab slab, final SoulDoubleSlab doubleSlab, final Boolean stacked) {
		super(block, slab, doubleSlab);
	}
}
