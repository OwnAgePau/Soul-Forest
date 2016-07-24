package com.Mod_Ores.Blocks.Special;

import javax.swing.Icon;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.Mod_Ores.soul_forest;
import com.Mod_Ores.Init.SoulBlocks;

public class BlockGemmerationTable extends Block{
    
	/*@SideOnly(Side.CLIENT)
    private IIcon workbenchIconTop;
    @SideOnly(Side.CLIENT)
    private IIcon workbenchIconFront;*/
	
    public final String textureName;
	
	public String getName(){
    	return this.textureName;
    }

    public BlockGemmerationTable(String Unlname){
		super(Material.anvil);
		this.setCreativeTab(soul_forest.tabSoulBlocks);
		this.setUnlocalizedName(soul_forest.MODID + "_" + Unlname);
		this.textureName = Unlname;
		GameRegistry.registerBlock(this, Unlname);
    }

    /*@SideOnly(Side.CLIENT)

    @Override
    public IIcon getIcon(int par1, int par2){
    	return par1 == 1 ? this.workbenchIconTop : (par1 == 0 ? this.workbenchIconTop : (par1 != 2 && par1 != 4 ? this.blockIcon : this.workbenchIconFront));
    }

    @SideOnly(Side.CLIENT)

    @Override
    public void registerBlockIcons(IIconRegister par1IconRegister){
		this.blockIcon = par1IconRegister.registerIcon("soulforest:Gemmeration_side");
		this.workbenchIconTop = par1IconRegister.registerIcon("soulforest:Gemmeration_top");
		this.workbenchIconFront = par1IconRegister.registerIcon("soulforest:Gemmeration_side");
    }*/

    /**
     * Called upon block activation (right click on the block.)
     */
    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ){
		Block i = worldIn.getBlockState(pos).getBlock();
		if (i != SoulBlocks.GemmerationTable.get() || playerIn.isSneaking()) {
		    return false;
		}
	
		playerIn.openGui(soul_forest.instance, 3, worldIn, pos.getX(), pos.getY(), pos.getZ());
		return true;
    }
}
