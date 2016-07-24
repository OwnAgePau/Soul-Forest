package com.Mod_Ores.Dimension.SoulForest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockPattern;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.LongHashMap;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

import com.Mod_Ores.Init.SoulBlocks;

public class TeleporterSoulForest extends Teleporter{
    private final WorldServer worldServerInstance;

    /** A private Random() function in Teleporter */
    private final Random random;

    /** Stores successful portal placement locations for rapid lookup. */
    private final LongHashMap destinationCoordinateCache = new LongHashMap();

    /**
     * A list of valid keys for the destinationCoordainteCache. These are based on the X & Z of the players initial
     * location.
     */
    private final List destinationCoordinateKeys = new ArrayList();

    public TeleporterSoulForest(WorldServer par1WorldServer){
    	super(par1WorldServer);
        this.worldServerInstance = par1WorldServer;
        this.random = new Random(par1WorldServer.getSeed());
    }

    /**
     * Place an entity in a nearby portal, creating one if necessary.
     */
    public void placeInPortal(Entity par1Entity, float rotationYaw){
        if (this.worldServerInstance.provider.getDimensionId() != 1){
            if (!this.placeInExistingPortal(par1Entity, rotationYaw)){
                this.makePortal(par1Entity);
                this.placeInExistingPortal(par1Entity, rotationYaw);
            }
        }
        else{
            int i = MathHelper.floor_double(par1Entity.posX);
            int j = MathHelper.floor_double(par1Entity.posY) - 1;
            int k = MathHelper.floor_double(par1Entity.posZ);
            byte b0 = 1;
            byte b1 = 0;

            for (int l = -2; l <= 2; ++l){
                for (int i1 = -2; i1 <= 2; ++i1){
                    for (int j1 = -1; j1 < 3; ++j1){
                        int k1 = i + i1 * b0 + l * b1;
                        int l1 = j + j1;
                        int i2 = k + i1 * b1 - l * b0;
                        boolean flag = j1 < 0;
                        this.worldServerInstance.setBlockState(new BlockPos(k1, l1, i2),  flag ? SoulBlocks.SilverBlock.get().getDefaultState() : Blocks.air.getDefaultState());
                    }
                }
            }

            par1Entity.setLocationAndAngles((double)i, (double)j, (double)k, par1Entity.rotationYaw, 0.0F);
            par1Entity.motionX = par1Entity.motionY = par1Entity.motionZ = 0.0D;
        }
    }
    
    public boolean placeInExistingPortal(Entity entityIn, float rotationYaw){
        int i = 128;
        double d0 = -1.0D;
        int j = MathHelper.floor_double(entityIn.posX);
        int k = MathHelper.floor_double(entityIn.posZ);
        boolean flag = true;
        BlockPos blockpos = BlockPos.ORIGIN;
        long l = ChunkCoordIntPair.chunkXZ2Int(j, k);

        if (this.destinationCoordinateCache.containsItem(l)){
            Teleporter.PortalPosition teleporter$portalposition = (Teleporter.PortalPosition)this.destinationCoordinateCache.getValueByKey(l);
            d0 = 0.0D;
            blockpos = teleporter$portalposition;
            teleporter$portalposition.lastUpdateTime = this.worldServerInstance.getTotalWorldTime();
            flag = false;
        }
        else{
            BlockPos blockpos3 = new BlockPos(entityIn);

            for (int i1 = -128; i1 <= 128; ++i1){
                BlockPos blockpos2;

                for (int j1 = -128; j1 <= 128; ++j1){
                    for (BlockPos blockpos1 = blockpos3.add(i1, this.worldServerInstance.getActualHeight() - 1 - blockpos3.getY(), j1); blockpos1.getY() >= 0; blockpos1 = blockpos2){
                        blockpos2 = blockpos1.down();

                        if (this.worldServerInstance.getBlockState(blockpos1).getBlock() == SoulBlocks.SilverBlock.get()){
                            while (this.worldServerInstance.getBlockState(blockpos2 = blockpos1.down()).getBlock() == SoulBlocks.SilverBlock.get()){
                                blockpos1 = blockpos2;
                            }

                            double d1 = blockpos1.distanceSq(blockpos3);

                            if (d0 < 0.0D || d1 < d0){
                                d0 = d1;
                                blockpos = blockpos1;
                            }
                        }
                    }
                }
            }
        }

        if (d0 >= 0.0D){
            if (flag){
                this.destinationCoordinateCache.add(l, new Teleporter.PortalPosition(blockpos, this.worldServerInstance.getTotalWorldTime()));
                this.destinationCoordinateKeys.add(Long.valueOf(l));
            }

            double d5 = (double)blockpos.getX() + 0.5D;
            double d6 = (double)blockpos.getY() + 0.5D;
            double d7 = (double)blockpos.getZ() + 0.5D;
            TeleportBlockSoulForest block = (TeleportBlockSoulForest)SoulBlocks.Teleporter.get();
            BlockPattern.PatternHelper blockpattern$patternhelper = block.func_181089_f(this.worldServerInstance, blockpos);
            boolean flag1 = blockpattern$patternhelper.getFinger().rotateY().getAxisDirection() == EnumFacing.AxisDirection.NEGATIVE;
            double d2 = blockpattern$patternhelper.getFinger().getAxis() == EnumFacing.Axis.X ? (double)blockpattern$patternhelper.func_181117_a().getZ() : (double)blockpattern$patternhelper.func_181117_a().getX();
            d6 = (double)(blockpattern$patternhelper.func_181117_a().getY() + 1) - entityIn.func_181014_aG().yCoord * (double)blockpattern$patternhelper.func_181119_e();

            if (flag1){
                ++d2;
            }

            if (blockpattern$patternhelper.getFinger().getAxis() == EnumFacing.Axis.X){
                d7 = d2 + (1.0D - entityIn.func_181014_aG().xCoord) * (double)blockpattern$patternhelper.func_181118_d() * (double)blockpattern$patternhelper.getFinger().rotateY().getAxisDirection().getOffset();
            }
            else{
                d5 = d2 + (1.0D - entityIn.func_181014_aG().xCoord) * (double)blockpattern$patternhelper.func_181118_d() * (double)blockpattern$patternhelper.getFinger().rotateY().getAxisDirection().getOffset();
            }

            float f = 0.0F;
            float f1 = 0.0F;
            float f2 = 0.0F;
            float f3 = 0.0F;

            if (blockpattern$patternhelper.getFinger().getOpposite() == entityIn.func_181012_aH()){
                f = 1.0F;
                f1 = 1.0F;
            }
            else if (blockpattern$patternhelper.getFinger().getOpposite() == entityIn.func_181012_aH().getOpposite()){
                f = -1.0F;
                f1 = -1.0F;
            }
            else if (blockpattern$patternhelper.getFinger().getOpposite() == entityIn.func_181012_aH().rotateY()){
                f2 = 1.0F;
                f3 = -1.0F;
            }
            else{
                f2 = -1.0F;
                f3 = 1.0F;
            }

            double d3 = entityIn.motionX;
            double d4 = entityIn.motionZ;
            entityIn.motionX = d3 * (double)f + d4 * (double)f3;
            entityIn.motionZ = d3 * (double)f2 + d4 * (double)f1;
            entityIn.rotationYaw = rotationYaw - (float)(entityIn.func_181012_aH().getOpposite().getHorizontalIndex() * 90) + (float)(blockpattern$patternhelper.getFinger().getHorizontalIndex() * 90);
            entityIn.setLocationAndAngles(d5, d6, d7, entityIn.rotationYaw, entityIn.rotationPitch);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean makePortal(Entity par1Entity){
        byte b0 = 16;
        double d0 = -1.0D;
        int i = MathHelper.floor_double(par1Entity.posX);
        int j = MathHelper.floor_double(par1Entity.posY);
        int k = MathHelper.floor_double(par1Entity.posZ);
        int l = i;
        int i1 = j;
        int j1 = k;
        int k1 = 0;
        int l1 = this.random.nextInt(4);
        int i2;
        double d1;
        double d2;
        int j2;
        int k2;
        int l2;
        int i3;
        int j3;
        int k3;
        int l3;
        int i4;
        int j4;
        int k4;
        double d3;
        double d4;

        for (i2 = i - b0; i2 <= i + b0; ++i2){
            d1 = (double)i2 + 0.5D - par1Entity.posX;

            for (j2 = k - b0; j2 <= k + b0; ++j2){
                d2 = (double)j2 + 0.5D - par1Entity.posZ;
                label274:

                for (k2 = this.worldServerInstance.getActualHeight() - 1; k2 >= 0; --k2){
                    if (this.worldServerInstance.isAirBlock(new BlockPos(i2, k2, j2))){
                        while (k2 > 0 && this.worldServerInstance.isAirBlock(new BlockPos(i2, k2 - 1, j2))){
                            --k2;
                        }

                        for (i3 = l1; i3 < l1 + 4; ++i3){
                            l2 = i3 % 2;
                            k3 = 1 - l2;

                            if (i3 % 4 >= 2){
                                l2 = -l2;
                                k3 = -k3;
                            }

                            for (j3 = 0; j3 < 3; ++j3){
                                for (i4 = 0; i4 < 4; ++i4){
                                    for (l3 = -1; l3 < 4; ++l3){
                                        k4 = i2 + (i4 - 1) * l2 + j3 * k3;
                                        j4 = k2 + l3;
                                        int l4 = j2 + (i4 - 1) * k3 - j3 * l2;

                                        if (l3 < 0 && !this.worldServerInstance.getBlockState(new BlockPos(k4, j4, l4)).getBlock().getMaterial().isSolid() || l3 >= 0 && !this.worldServerInstance.isAirBlock(new BlockPos(k4, j4, l4))){
                                            continue label274;
                                        }
                                    }
                                }
                            }

                            d4 = (double)k2 + 0.5D - par1Entity.posY;
                            d3 = d1 * d1 + d4 * d4 + d2 * d2;

                            if (d0 < 0.0D || d3 < d0){
                                d0 = d3;
                                l = i2;
                                i1 = k2;
                                j1 = j2;
                                k1 = i3 % 4;
                            }
                        }
                    }
                }
            }
        }

        if (d0 < 0.0D){
            for (i2 = i - b0; i2 <= i + b0; ++i2){
                d1 = (double)i2 + 0.5D - par1Entity.posX;

                for (j2 = k - b0; j2 <= k + b0; ++j2){
                    d2 = (double)j2 + 0.5D - par1Entity.posZ;
                    label222:

                    for (k2 = this.worldServerInstance.getActualHeight() - 1; k2 >= 0; --k2){
                        if (this.worldServerInstance.isAirBlock(new BlockPos(i2, k2, j2))){
                            while (k2 > 0 && this.worldServerInstance.isAirBlock(new BlockPos(i2, k2 - 1, j2))){
                                --k2;
                            }

                            for (i3 = l1; i3 < l1 + 2; ++i3){
                                l2 = i3 % 2;
                                k3 = 1 - l2;

                                for (j3 = 0; j3 < 4; ++j3){
                                    for (i4 = -1; i4 < 4; ++i4){
                                        l3 = i2 + (j3 - 1) * l2;
                                        k4 = k2 + i4;
                                        j4 = j2 + (j3 - 1) * k3;

                                        if (i4 < 0 && !this.worldServerInstance.getBlockState(new BlockPos(l3, k4, j4)).getBlock().getMaterial().isSolid() || i4 >= 0 && !this.worldServerInstance.isAirBlock(new BlockPos(l3, k4, j4))){
                                            continue label222;
                                        }
                                    }
                                }

                                d4 = (double)k2 + 0.5D - par1Entity.posY;
                                d3 = d1 * d1 + d4 * d4 + d2 * d2;

                                if (d0 < 0.0D || d3 < d0){
                                    d0 = d3;
                                    l = i2;
                                    i1 = k2;
                                    j1 = j2;
                                    k1 = i3 % 2;
                                }
                            }
                        }
                    }
                }
            }
        }

        int i5 = l;
        int j5 = i1;
        j2 = j1;
        int k5 = k1 % 2;
        int l5 = 1 - k5;

        if (k1 % 4 >= 2){
            k5 = -k5;
            l5 = -l5;
        }

        boolean flag;

        if (d0 < 0.0D){
            if (i1 < 70){
                i1 = 70;
            }

            if (i1 > this.worldServerInstance.getActualHeight() - 10){
                i1 = this.worldServerInstance.getActualHeight() - 10;
            }

            j5 = i1;

            for (k2 = -1; k2 <= 1; ++k2){
                for (i3 = 1; i3 < 3; ++i3){
                    for (l2 = -1; l2 < 3; ++l2){
                        k3 = i5 + (i3 - 1) * k5 + k2 * l5;
                        j3 = j5 + l2;
                        i4 = j2 + (i3 - 1) * l5 - k2 * k5;
                        flag = l2 < 0;
                        this.worldServerInstance.setBlockState(new BlockPos(k3, j3, i4), SoulBlocks.SilverBlock.get().getDefaultState());
                    }
                }
            }
        }

        for (k2 = 0; k2 < 4; ++k2){
            for (i3 = 0; i3 < 4; ++i3){
                for (l2 = -1; l2 < 4; ++l2){
                    k3 = i5 + (i3 - 1) * k5;
                    j3 = j5 + l2;
                    i4 = j2 + (i3 - 1) * l5;
                    flag = i3 == 0 || i3 == 3 || l2 == -1 || l2 == 3;
                    this.worldServerInstance.setBlockState(new BlockPos(k3, j3, i4), flag ? SoulBlocks.SilverBlock.get().getDefaultState() : SoulBlocks.Teleporter.get().getDefaultState()); // 0, 2
                }
            }

            for (i3 = 0; i3 < 4; ++i3){
                for (l2 = -1; l2 < 4; ++l2){
                    k3 = i5 + (i3 - 1) * k5;
                    j3 = j5 + l2;
                    i4 = j2 + (i3 - 1) * l5;
                    this.worldServerInstance.notifyNeighborsOfStateChange(new BlockPos(k3, j3, i4), this.worldServerInstance.getBlockState(new BlockPos(k3, j3, i4)).getBlock());
                }
            }
        }

        return true;
    }

    /**
     * called periodically to remove out-of-date portal locations from the cache list. Argument par1 is a
     * WorldServer.getTotalWorldTime() value.
     */
    public void removeStalePortalLocations(long par1){
        if (par1 % 100L == 0L){
            Iterator iterator = this.destinationCoordinateKeys.iterator();
            long j = par1 - 600L;

            while (iterator.hasNext()){
                Long olong = (Long)iterator.next();
                PortalPosition portalposition = (PortalPosition)this.destinationCoordinateCache.getValueByKey(olong.longValue());

                if (portalposition == null || portalposition.lastUpdateTime < j){
                    iterator.remove();
                    this.destinationCoordinateCache.remove(olong.longValue());
                }
            }
        }
    }
}