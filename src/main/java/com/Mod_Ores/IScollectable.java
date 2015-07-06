package com.Mod_Ores;

import java.util.ArrayList;

import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 *
 * This allows for mods to create there own shear-like items
 * and have them interact with Blocks/Entities without extra work.
 * Also, if your block/entity supports the Shears, this allows you
 * to support mod-shears as well.
 *
 */
public interface IScollectable{
    /**
     * Checks if the object is currently collectable
     * Example: Sheep return false when they have no wool
     *
     * @param item The itemstack that is being used, Possible to be null
     * @param world The current world
     * @param x The X Position
     * @param y The Y Position
     * @param z The Z Position
     * @return If this is collectable, and onSheared should be called.
     */
    public boolean isCollectable(ItemStack item, World world, int x, int y, int z);

    /**
     * Performs the shear function on this object.
     * This is called for both client, and server.
     * The object should perform all actions related to being collected,
     * except for dropping of the items.
     *
     * Returns a list of items that resulted from the collecting process.
     *
     * For entities, they should trust there internal location information
     * over the values passed into this function.
     *
     * @param item The itemstack that is being used, Possible to be null
     * @param world The current world
     * @param x The X Position
     * @param y The Y Position
     * @param z The Z Position
     * @param fortune The fortune level of the shears being used
     * @return A ArrayList containing all items from this collecting. Possible to be null.
     */
    public ArrayList<ItemStack> onCollected(ItemStack item, World world, int x, int y, int z, int fortune);
}
