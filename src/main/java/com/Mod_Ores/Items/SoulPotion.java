package com.Mod_Ores.Items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemPotion;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;

public class SoulPotion extends Potion{

    public SoulPotion(ResourceLocation location, boolean isBadEffect, int liquidColor) {
		super(location, isBadEffect, liquidColor);
		this.setIconIndex(0, 0);
    }

    @Override
    protected Potion setIconIndex(int p_76399_1_, int p_76399_2_) {
    	return super.setIconIndex(p_76399_1_, p_76399_2_);
    }

    @Override
    protected Potion setEffectiveness(double p_76404_1_) {
    	return super.setEffectiveness(p_76404_1_);
    }
}