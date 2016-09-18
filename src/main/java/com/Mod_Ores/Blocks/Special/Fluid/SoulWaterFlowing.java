package com.Mod_Ores.Blocks.Special.Fluid;

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

    public static String name;
    
    public SoulWaterFlowing(Fluid fluid, String Unlname){
		super(fluid, Material.water);
		this.name = Unlname;
		this.setTickRandomly(true);
		this.blockHardness = 100F;
		this.disableStats();
		this.setLightLevel(0);
		float f = 0.0F;
		float f1 = 0.0F;
		this.setBlockBounds(0.0F + f1, 0.0F + f, 0.0F + f1, 1.0F + f1, 1.0F + f, 1.0F + f1);
		FluidRegistry.registerFluid(fluid);
		GameRegistry.registerBlock(this, "soulforest" + ":" + fluid.getUnlocalizedName().substring(6));
		fluid.setUnlocalizedName(fluid.getUnlocalizedName());
		this.setCreativeTab(CreativeTabs.tabMisc);
    }
    
    @Override
    protected void flowIntoBlock(World world, BlockPos pos, int meta){
        if (meta < 0) return;
        if (displaceIfPossible(world, pos)){
           world.setBlockState(pos, this.getBlockState().getBaseState().withProperty(LEVEL, meta), 3);
        }
    }
}