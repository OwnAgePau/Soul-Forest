package com.Mod_Ores;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class SoulForestMaterials extends Material{

    public SoulForestMaterials(MapColor par1MapColor) {
	super(par1MapColor);
	this.setReplaceable();
	this.setNoPushMobility();
    }

    /**
     * Returns if blocks of these materials are liquids.
     */
    public boolean isLiquid(){
	return true;
    }

    /**
     * Returns if this material is considered solid or not
     */
    public boolean blocksMovement(){
	return false;
    }

    public boolean isSolid(){
	return false;
    }

    public static final Material soulWater = (new SoulForestMaterials(MapColor.waterColor)).setNoPushMobility();
}
