package com.Mod_Ores.Blocks.Special;

import javax.swing.Icon;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.Mod_Ores.soul_forest;
import com.Mod_Ores.Init.SoulBlocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockGemmingTable extends Block{
    @SideOnly(Side.CLIENT)
    private IIcon workbenchIconTop;
    @SideOnly(Side.CLIENT)
    private IIcon workbenchIconFront;

    public BlockGemmingTable(String Unlname){
	super(Material.anvil);
	this.setCreativeTab(soul_forest.tabSoulBlocks);
	GameRegistry.registerBlock(this, Unlname);
	setBlockName(Unlname);
    }

    @SideOnly(Side.CLIENT)

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    @Override
    public IIcon getIcon(int par1, int par2){
	return par1 == 1 ? this.workbenchIconTop : (par1 == 0 ? this.workbenchIconTop : (par1 != 2 && par1 != 4 ? this.blockIcon : this.workbenchIconFront));
    }

    @SideOnly(Side.CLIENT)

    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    @Override
    public void registerBlockIcons(IIconRegister par1IconRegister){
	this.blockIcon = par1IconRegister.registerIcon("soulforest:Gemming_side");
	this.workbenchIconTop = par1IconRegister.registerIcon("soulforest:Gemming_top");
	this.workbenchIconFront = par1IconRegister.registerIcon("soulforest:Gemming_side");
    }

    /**
     * Called upon block activation (right click on the block.)
     */
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9){
	Block i = world.getBlock(x, y, z);
	if (i != SoulBlocks.GemmingTable.get() || player.isSneaking()) {
	    return false;
	}

	player.openGui(soul_forest.instance, 4, world, x, y, z);
	return true;
    }
}
