package com.Mod_Ores.Blocks.Special;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.Mod_Ores.soul_forest;

public class SoulWood extends Block{  
	
	public final String textureName;
	
	public String getName(){
		return this.textureName;
	}
	
    /**
     * SoulWood Block Constructor
     * @param id this is the Block ID
     * @param Unlname This is the Unlocalized Name
     * @param InGname This is the Name that you will see In game
     * @param Hardness sets the hardness of the block
     * @param Resistance sets the resistance of the block
     * @param LightValue sets the blocks light value
     */
    public SoulWood(String Unlname, float Hardness, float Resistance){ //id - item ID, UName - Unlocalized Name, IGName - IngameName
		super(Material.wood); //This super will load item ID and UName
		setCreativeTab(soul_forest.tabSoulBlocks);
		setHardness(Hardness); // Default 3.0F
		setResistance(Resistance); // Default 2F		  
		setStepSound(Block.soundTypeWood);
		this.setUnlocalizedName(soul_forest.MODID + "_" + Unlname);
		this.textureName = Unlname;
		GameRegistry.registerBlock(this, Unlname);
    }

    @Override
    public int quantityDropped(Random par1Random) {
    	return 1;
    }

    @Override
    public boolean canSustainPlant(IBlockAccess world, BlockPos pos, EnumFacing direction, IPlantable plant) {
    	return false;
    }
}