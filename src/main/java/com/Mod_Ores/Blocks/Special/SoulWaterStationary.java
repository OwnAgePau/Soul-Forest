package com.Mod_Ores.Blocks.Special;

import com.Mod_Ores.Init.SoulBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDynamicLiquid;
import net.minecraft.block.BlockStaticLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SoulWaterStationary extends BlockStaticLiquid{
    
	//private IIcon[] theIcon;

	public SoulWaterStationary(String Unlname){
        super(Material.water);
        this.setTickRandomly(true);
        this.blockHardness = 100F;
        this.setLightLevel(0);
        this.disableStats();
		GameRegistry.registerBlock(this, Unlname);
    }

    @Override
    public int getRenderType(){
    	return 4;
    }
    
	/*@Override
	public int stillLiquidId() 
	{
		return this.blockID + 1;
	}

	@Override
	public boolean isMetaSensitive() 
	{
		return false;
	}

	@Override
	public int stillLiquidMeta() 
	{
		return 0;
	}*/
	
	/*@Override
	public void registerBlockIcons(IIconRegister iconReg){
		this.theIcon = new IIcon[] {iconReg.registerIcon("soulforest:Soul_Water"), iconReg.registerIcon("soulforest:Soul_Water_Flow")};
	}
	
    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int p_149691_1_, int p_149691_2_){
        return this.theIcon[0];
    }*/
    
    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor Block
     */
    @Override
    public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock){
        super.onNeighborBlockChange(worldIn, pos, state, neighborBlock);
        if (worldIn.getBlockState(pos).getBlock() == this){
            this.updateLiquid(worldIn, pos, state);
        }
    }

    /**
     * Changes the block ID to that of an updating fluid.
     */
    private void updateLiquid(World worldIn, BlockPos pos, IBlockState state){
        BlockDynamicLiquid blockdynamicliquid = getFlowingBlock(this.blockMaterial);
        worldIn.setBlockState(pos, blockdynamicliquid.getDefaultState().withProperty(LEVEL, state.getValue(LEVEL)), 2);
        worldIn.scheduleUpdate(pos, blockdynamicliquid, this.tickRate(worldIn));
    }
}