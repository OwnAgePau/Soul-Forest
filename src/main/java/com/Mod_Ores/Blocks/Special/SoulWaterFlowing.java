package com.Mod_Ores.Blocks.Special;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SoulWaterFlowing extends BlockFluidClassic{

    //private static IIcon[] theIcon;

    public SoulWaterFlowing(Fluid fluid, String Unlname){
		super(fluid, Material.water);
		this.setTickRandomly(true);
		this.blockHardness = 100F;
		this.disableStats();
		this.setLightLevel(0);
		float f = 0.0F;
		float f1 = 0.0F;
		this.setBlockBounds(0.0F + f1, 0.0F + f, 0.0F + f1, 1.0F + f1, 1.0F + f, 1.0F + f1);
		FluidRegistry.registerFluid(fluid);
		GameRegistry.registerBlock(this, "soulforest" + "_" + fluid.getUnlocalizedName().substring(5));
		fluid.setUnlocalizedName(fluid.getUnlocalizedName());
		this.setCreativeTab(CreativeTabs.tabMisc);
    }

    /*@Override
    public void registerBlockIcons(IIconRegister iconReg){
    	this.theIcon = new IIcon[] {iconReg.registerIcon("soulforest:Soul_Water"), iconReg.registerIcon("soulforest:Soul_Water_Flow")};
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int p_149691_1_, int p_149691_2_){
		return this.theIcon[0];
    }*/

    @Override
    public boolean canDisplace(IBlockAccess world, BlockPos pos) {
		if (world.getBlockState(pos).getBlock().getMaterial().isLiquid()) return false;
			return super.canDisplace(world, pos);
    }

    @Override
    public boolean displaceIfPossible(World world, BlockPos pos) {
		if (world.getBlockState(pos).getBlock().getMaterial().isLiquid()) return false;
			return super.displaceIfPossible(world, pos);
    }
}