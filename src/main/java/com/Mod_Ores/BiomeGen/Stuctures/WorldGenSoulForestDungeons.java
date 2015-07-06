package com.Mod_Ores.BiomeGen.Stuctures;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.DungeonHooks;

import com.Mod_Ores.Init.SoulBlocks;

public class WorldGenSoulForestDungeons extends WorldGenerator
{
    public boolean generate(World par1World, Random par2Random, int x, int y, int z)
    {
        byte b0 = 3;
        int l = par2Random.nextInt(2) + 2;
        int i1 = par2Random.nextInt(2) + 2;
        int j1 = 0;
        int k1;
        int l1;
        int i2;

        for (k1 = x - l - 1; k1 <= x + l + 1; ++k1)
        {
            for (l1 = y - 1; l1 <= y + b0 + 1; ++l1)
            {
                for (i2 = z - i1 - 1; i2 <= z + i1 + 1; ++i2)
                {
                    Material material = par1World.getBlock(k1, l1, i2).getMaterial();

                    if (l1 == y - 1 && !material.isSolid())
                    {
                        return false;
                    }

                    if (l1 == y + b0 + 1 && !material.isSolid())
                    {
                        return false;
                    }

                    if ((k1 == x - l - 1 || k1 == x + l + 1 || i2 == z - i1 - 1 || i2 == z + i1 + 1) && l1 == y && par1World.isAirBlock(k1, l1, i2) && par1World.isAirBlock(k1, l1 + 1, i2))
                    {
                        ++j1;
                    }
                }
            }
        }

        if (j1 >= 1 && j1 <= 5)
        {
            for (k1 = x - l - 1; k1 <= x + l + 1; ++k1)
            {
                for (l1 = y + b0; l1 >= y - 1; --l1)
                {
                    for (i2 = z - i1 - 1; i2 <= z + i1 + 1; ++i2)
                    {
                        if (k1 != x - l - 1 && l1 != y - 1 && i2 != z - i1 - 1 && k1 != x + l + 1 && l1 != y + b0 + 1 && i2 != z + i1 + 1)
                        {
                            par1World.setBlockToAir(k1, l1, i2);
                        }
                        else if (l1 >= 0 && !par1World.getBlock(k1, l1 - 1, i2).getMaterial().isSolid())
                        {
                            par1World.setBlockToAir(k1, l1, i2);
                        }
                        else if (par1World.getBlock(k1, l1, i2).getMaterial().isSolid())
                        {
                            if (l1 == y - 1 && par2Random.nextInt(4) != 0)
                            {
                                par1World.setBlock(k1, l1, i2, SoulBlocks.BauxiteMossy.get(), 0, 2);
                            }
                            else
                            {
                                par1World.setBlock(k1, l1, i2, SoulBlocks.Bauxite.get(), 0, 2);
                            }
                        }
                    }
                }
            }

            k1 = 0;

            while (k1 < 2)
            {
                l1 = 0;

                while (true)
                {
                    if (l1 < 3)
                    {
                        label210:
                        {
                            i2 = x + par2Random.nextInt(l * 2 + 1) - l;
                            int j2 = z + par2Random.nextInt(i1 * 2 + 1) - i1;

                            if (par1World.isAirBlock(i2, y, j2))
                            {
                                int k2 = 0;

                                if (par1World.getBlock(i2 - 1, y, j2).getMaterial().isSolid())
                                {
                                    ++k2;
                                }

                                if (par1World.getBlock(i2 + 1, y, j2).getMaterial().isSolid())
                                {
                                    ++k2;
                                }

                                if (par1World.getBlock(i2, y, j2 - 1).getMaterial().isSolid())
                                {
                                    ++k2;
                                }

                                if (par1World.getBlock(i2, y, j2 + 1).getMaterial().isSolid())
                                {
                                    ++k2;
                                }

                                if (k2 == 1)
                                {
                                    par1World.setBlock(i2, y, j2, Block.getBlockFromName("chest"), 0, 2);
                                    TileEntityChest tileentitychest = (TileEntityChest)par1World.getTileEntity(i2, y, j2);

                                    if (tileentitychest != null)
                                    {
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

            par1World.setBlock(x, y, z, Block.getBlockFromName("mob_spawner"), 0, 2);
            TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)par1World.getTileEntity(x, y, z);

            if (tileentitymobspawner != null)
            {
            	tileentitymobspawner.func_145881_a().setEntityName(this.pickMobSpawner(par2Random));
            }
            else
            {
                System.err.println("Failed to fetch mob spawner entity at (" + x + ", " + y + ", " + z + ")");
            }

            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Picks potentially a random item to add to a dungeon chest.
     */
    private ItemStack pickCheckLootItem(Random par1Random)
    {
        return ChestGenHooks.getOneItem(ChestGenHooks.DUNGEON_CHEST, par1Random);
    }

    /**
     * Randomly decides which spawner to use in a dungeon
     */
    private String pickMobSpawner(Random par1Random)
    {
        return DungeonHooks.getRandomDungeonMob(par1Random);
    }
}

