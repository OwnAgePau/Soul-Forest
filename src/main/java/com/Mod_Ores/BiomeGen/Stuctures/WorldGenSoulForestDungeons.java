package com.Mod_Ores.BiomeGen.Stuctures;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.BlockPos;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.DungeonHooks;

import com.Mod_Ores.Init.SoulBlocks;

public class WorldGenSoulForestDungeons extends WorldGenerator{
    
	@Override
    public boolean generate(World world, Random par2Random, BlockPos pos){
        byte b0 = 3;
        int l = par2Random.nextInt(2) + 2;
        int i1 = par2Random.nextInt(2) + 2;
        int j1 = 0;
        int k1;
        int l1;
        int i2;

        for (k1 = pos.getX() - l - 1; k1 <= pos.getX() + l + 1; ++k1){
            for (l1 = pos.getY() - 1; l1 <= pos.getY() + b0 + 1; ++l1){
                for (i2 = pos.getZ() - i1 - 1; i2 <= pos.getZ() + i1 + 1; ++i2){
                    Material material = world.getBlockState(new BlockPos(k1, l1, i2)).getBlock().getMaterial();

                    if (l1 == pos.getY() - 1 && !material.isSolid()){
                        return false;
                    }

                    if (l1 == pos.getY() + b0 + 1 && !material.isSolid()){
                        return false;
                    }

                    if ((k1 == pos.getX() - l - 1 || k1 == pos.getX() + l + 1 || i2 == pos.getZ() - i1 - 1 || i2 == pos.getZ() + i1 + 1) && l1 == pos.getY() && world.isAirBlock(new BlockPos(k1, l1, i2)) && world.isAirBlock(new BlockPos(k1, l1 + 1, i2))){
                        ++j1;
                    }
                }
            }
        }

        if (j1 >= 1 && j1 <= 5){
            for (k1 = pos.getX() - l - 1; k1 <= pos.getX() + l + 1; ++k1){
                for (l1 = pos.getY() + b0; l1 >= pos.getY() - 1; --l1){
                    for (i2 = pos.getZ() - i1 - 1; i2 <= pos.getZ() + i1 + 1; ++i2){
                        if (k1 != pos.getX() - l - 1 && l1 != pos.getY() - 1 && i2 != pos.getZ() - i1 - 1 && k1 != pos.getX() + l + 1 && l1 != pos.getY() + b0 + 1 && i2 != pos.getZ() + i1 + 1){
                            world.setBlockToAir(new BlockPos(k1, l1, i2));
                        }
                        else if (l1 >= 0 && !world.getBlockState(new BlockPos(k1, l1 - 1, i2)).getBlock().getMaterial().isSolid()){
                            world.setBlockToAir(new BlockPos(k1, l1, i2));
                        }
                        else if (world.getBlockState(new BlockPos(k1, l1, i2)).getBlock().getMaterial().isSolid()){
                            if (l1 == pos.getY() - 1 && par2Random.nextInt(4) != 0){
                                world.setBlockState(new BlockPos(k1, l1, i2), SoulBlocks.BauxiteMossy.get().getDefaultState(), 0);
                            }
                            else{
                                world.setBlockState(new BlockPos(k1, l1, i2), SoulBlocks.Bauxite.get().getDefaultState(), 0);
                            }
                        }
                    }
                }
            }

            k1 = 0;

            while (k1 < 2){
                l1 = 0;

                while (true){
                    if (l1 < 3){
                        label210:{
                            i2 = pos.getX() + par2Random.nextInt(l * 2 + 1) - l;
                            int j2 = pos.getZ() + par2Random.nextInt(i1 * 2 + 1) - i1;

                            if (world.isAirBlock(new BlockPos(i2, pos.getY(), j2))){
                                int k2 = 0;

                                if (world.getBlockState(new BlockPos(i2 - 1, pos.getY(), j2)).getBlock().getMaterial().isSolid()){
                                    ++k2;
                                }

                                if (world.getBlockState(new BlockPos(i2 + 1, pos.getY(), j2)).getBlock().getMaterial().isSolid()){
                                    ++k2;
                                }

                                if (world.getBlockState(new BlockPos(i2, pos.getY(), j2 - 1)).getBlock().getMaterial().isSolid()){
                                    ++k2;
                                }

                                if (world.getBlockState(new BlockPos(i2, pos.getY(), j2 + 1)).getBlock().getMaterial().isSolid()){
                                    ++k2;
                                }

                                if (k2 == 1){
                                    world.setBlockState(new BlockPos(i2, pos.getY(), j2), Blocks.chest.getDefaultState(), 0);
                                    TileEntityChest tileentitychest = (TileEntityChest)world.getTileEntity(new BlockPos(i2, pos.getY(), j2));

                                    if (tileentitychest != null){
                                        ChestGenHooks info = ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST);
                                        WeightedRandomChestContent.generateChestContents(par2Random, info.getItems(par2Random), tileentitychest, info.getCount(par2Random));
                                    }

                                    break label210;
                                }
                            }

                            ++l1;
                            continue;
                        }
                    }

                    ++k1;
                    break;
                }
            }

            world.setBlockState(pos, Blocks.mob_spawner.getDefaultState(), 0);
            TileEntity tileentitymobspawner = world.getTileEntity(pos);

            if (tileentitymobspawner instanceof TileEntityMobSpawner){
            	 ((TileEntityMobSpawner)tileentitymobspawner).getSpawnerBaseLogic().setEntityName(this.pickMobSpawner(par2Random));
            }
            else{
                System.err.println("Failed to fetch mob spawner entity at (" + pos.getX() + ", " + pos.getY() + ", " + pos.getZ() + ")");
            }

            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Picks potentially a random item to add to a dungeon chest.
     */
    private ItemStack pickCheckLootItem(Random par1Random){
        return ChestGenHooks.getOneItem(ChestGenHooks.DUNGEON_CHEST, par1Random);
    }

    /**
     * Randomly decides which spawner to use in a dungeon
     */
    private String pickMobSpawner(Random par1Random){
        return DungeonHooks.getRandomDungeonMob(par1Random);
    }
}