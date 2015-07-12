package com.Mod_Ores.Blocks.Special;

import net.minecraft.world.World;

import com.Mod_Ores.soul_forest;
import com.Mod_Ores.Dimension.FrozenHearth.TeleportBlockFrozenHearth;
import com.Mod_Ores.Dimension.SoulForest.TeleportBlockSoulForest;
import com.Mod_Ores.Init.SoulBlocks;
import com.Mod_Ores.Init.Config.SoulConfig;

public class SoulFireFrozenHearth extends SoulFire{

    public SoulFireFrozenHearth(String Unlname) {
	super(Unlname);
    }
    
    @Override
    public void onBlockAdded(World par1World, int par2, int par3, int par4){
	System.out.println("Current world ID : " + par1World.provider.dimensionId);
	System.out.println(((TeleportBlockFrozenHearth)SoulBlocks.TeleporterFrozenHearth.get()).tryToCreatePortal(par1World, par2, par3, par4));
        if (par1World.provider.dimensionId == SoulConfig.SoulForestID && par1World.getBlock(par2, par3 - 1, par4) != SoulBlocks.TurquoiseBlock.get()){
            if(((TeleportBlockFrozenHearth)SoulBlocks.TeleporterFrozenHearth.get()).tryToCreatePortal(par1World, par2, par3, par4)){
                if (!par1World.doesBlockHaveSolidTopSurface(par1World, par2, par3 - 1, par4) && !this.canNeighborBurn(par1World, par2, par3, par4)){
                    par1World.setBlockToAir(par2, par3, par4);
                }
                else{
                    par1World.scheduleBlockUpdate(par2, par3, par4, this, this.tickRate(par1World) + par1World.rand.nextInt(10));
                }
            }
        }
    }
}