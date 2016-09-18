package com.Mod_Ores.Blocks.Special;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.Mod_Ores.soul_forest;
import com.Mod_Ores.Dimension.FrozenHearth.TeleportBlockFrozenHearth;
import com.Mod_Ores.Dimension.SoulForest.TeleportBlockSoulForest;
import com.Mod_Ores.Init.SoulBlocks;
import com.Mod_Ores.Init.Config.SoulConfig;

public class SoulFireFrozenHearth extends SoulFire {
	
    public final String textureName;
	
	public String getName(){
    	return this.textureName;
    }

    public SoulFireFrozenHearth(String Unlname) {
    	super(Unlname);
    	this.setUnlocalizedName(soul_forest.MODID + "_" + Unlname);
    	this.textureName = Unlname;
    }
    
    @Override
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state){
	System.out.println("Current world ID : " + worldIn.provider.getDimensionId());
	System.out.println(((TeleportBlockFrozenHearth)SoulBlocks.TeleporterFrozenHearth.get()).tryToCreatePortal(worldIn, pos.getX(), pos.getY(), pos.getZ()));
        if (worldIn.provider.getDimensionId() == SoulConfig.SoulForestID && worldIn.getBlockState(pos.down()).getBlock() != SoulBlocks.TurquoiseBlock.get()){
            if(((TeleportBlockFrozenHearth)SoulBlocks.TeleporterFrozenHearth.get()).tryToCreatePortal(worldIn, pos.getX(), pos.getY(), pos.getZ())){
                if (!worldIn.doesBlockHaveSolidTopSurface(worldIn, pos.down()) && !this.canNeighborCatchFire(worldIn, pos)){
                	worldIn.setBlockToAir(pos);
                }
                else{
                	worldIn.scheduleBlockUpdate(pos, this.getDefaultState().getBlock(), this.tickRate(worldIn) + worldIn.rand.nextInt(10), 1);
                }
            }
        }
    }
}