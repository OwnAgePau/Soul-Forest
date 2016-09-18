/*package com.Mod_Ores.Blocks.Special;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.Mod_Ores.soul_forest;
import com.Mod_Ores.Blocks.Special.Slab.SoulHalfslab;
import com.Mod_Ores.Init.SoulBlocks;

public class SoulStep extends SoulHalfslab{
    

    public static final String[] blockStepTypes = new String[] {"ice", "bauxite", "porphyry", "slate", "titanium"};


	 public SoulStep(String Unlname, float Hardness, float Resistance, Boolean LightValue){ //id - item ID, UName - Unlocalized Name, IGName - IngameName
		  super(Unlname); //This super will load item ID and UName
		  setCreativeTab(soul_forest.tabSoulBlocks); //Set Tab in ModBase.class and plase it here (with many items its VERY code-shortening), this will load unlocalized name
		  this.useNeighborBrightness = !this.isDouble();
		  setHardness(Hardness); // Default 3.0F
		  setResistance(Resistance); // Default 2F
		  if(LightValue == true){
			  setLightLevel(1F); // Default 1F
		  }
		  
		  setStepSound(Block.soundTypeMetal);
		  GameRegistry.registerBlock(this, Unlname);
    }

    protected ItemStack createStackedBlock(int par1){
        return new ItemStack(SoulBlocks.SoulHalfSlab.get(), 2, par1 & 7);
    }


    public String getFullSlabName(int par1){
        if (par1 < 0 || par1 >= blockStepTypes.length){
            par1 = 0;
        }	
        return blockStepTypes[par1] + " brick";
    }

    @SideOnly(Side.CLIENT)


    public void getSubBlocks(Block par1, CreativeTabs par2CreativeTabs, List par3List){
        if (par1 != SoulBlocks.SoulDoubleSlab.get()){
            for (int j = 0; j <= 7; ++j){
                if (j != 2){
                    par3List.add(new ItemStack(par1, 1, j));
                }
            }
        }
    }
}*/