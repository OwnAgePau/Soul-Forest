package com.Mod_Ores.Blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

public class BlockSoulWithMetaData extends ItemBlockWithMetadata {
    
    public BlockSoulWithMetaData(Block block) {
        super(block, block);
    }
    
    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return this.getUnlocalizedName() + "_" + stack.getItemDamage();
    }
}
