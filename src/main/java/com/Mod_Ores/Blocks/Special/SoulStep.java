package com.Mod_Ores.Blocks.Special;

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
import com.Mod_Ores.Init.SoulBlocks;

public class SoulStep extends SoulHalfslab{
    
	/** The list of the types of step blocks. */
    public static final String[] blockStepTypes = new String[] {"ice", "bauxite", "porphyry", "slate", "titanium"};
    @SideOnly(Side.CLIENT)
    //private IIcon theIcon;

	/**
	 * Soul Step Block Constructor
	 * @param id this is the Block ID
	 * @param Unlname This is the Unlocalized Name
	 * @param InGname This is the Name that you will see In game
	 * @param Hardness sets the hardness of the block
	 * @param Resistance sets the resistance of the block
	 * @param LightValue sets the blocks light value
	 * @param isDoubleSlab sets whether this block is a double slab or not
	 */
	 public SoulStep(String Unlname, float Hardness, float Resistance, Boolean LightValue){ //id - item ID, UName - Unlocalized Name, IGName - IngameName
		  super(Unlname); //This super will load item ID and UName
		  setCreativeTab(soul_forest.tabSoulBlocks); //Set Tab in ModBase.class and plase it here (with many items its VERY code-shortening), this will load unlocalized name
		  //setUnlocalizedName(Unlname);
		  setHardness(Hardness); // Default 3.0F
		  setResistance(Resistance); // Default 2F
		  if(LightValue == true){
			  setLightLevel(1F); // Default 1F
		  }
		  
		  setStepSound(Block.soundTypeMetal);
		  GameRegistry.registerBlock(this, Unlname);
		  //LanguageRegistry.addName(this, InGname);
    }

    //@SideOnly(Side.CLIENT)

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    /*public IIcon getIcon(int par1, int par2)
    {
        int k = par2 & 7;

        if (this.isDoubleSlab && (par2 & 8) != 0)
        {
            par1 = 1;
        }

        return k == 0 ? (par1 != 1 && par1 != 0 ? this.theIcon : this.blockIcon) : (k == 1 ? SoulBlocks.IceBrick.get().getBlockTextureFromSide(par1) : (k == 2 ? SoulBlocks.BauxiteBrick.get().getBlockTextureFromSide(par1) : (k == 3 ? SoulBlocks.PorphyryBrick.get().getBlockTextureFromSide(par1) : (k == 4 ? SoulBlocks.SlateBrick.get().getBlockTextureFromSide(par1) : this.blockIcon))));
    }*/

    @SideOnly(Side.CLIENT)

    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    /*@Override
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("soulforest:soulhalfslab_top");
        this.theIcon = par1IconRegister.registerIcon("soulforest:soulhalfslab");
    }*/

    /**
     * Returns the ID of the items to drop on destruction.
     */
    /*public int idDropped(int par1, Random par2Random, int par3)
    {
        return SoulBlocks.SoulHalfSlab.get().blockID;
    }*/

    /**
     * Returns an item stack containing a single instance of the current block type. 'i' is the block's subtype/damage
     * and is ignored for blocks which do not support subtypes. Blocks which cannot be harvested should return null.
     */
    protected ItemStack createStackedBlock(int par1){
        return new ItemStack(SoulBlocks.SoulHalfSlab.get(), 2, par1 & 7);
    }

    /**
     * Returns the slab block name with step type.
     */
    public String getFullSlabName(int par1){
        if (par1 < 0 || par1 >= blockStepTypes.length){
            par1 = 0;
        }	
        return blockStepTypes[par1] + " brick";
    }

    @SideOnly(Side.CLIENT)

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    public void getSubBlocks(Block par1, CreativeTabs par2CreativeTabs, List par3List){
        if (par1 != SoulBlocks.SoulDoubleSlab.get()){
            for (int j = 0; j <= 7; ++j){
                if (j != 2){
                    par3List.add(new ItemStack(par1, 1, j));
                }
            }
        }
    }
}