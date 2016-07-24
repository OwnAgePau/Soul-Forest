package com.Mod_Ores.Blocks.Containers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

import com.Mod_Ores.Blocks.Recipes.IceWorkbenchCraftingRecipes;
import com.Mod_Ores.Blocks.Slots.SlotIceCrafting;
import com.Mod_Ores.Init.SoulBlocks;

public class ContainerIceWorkbench extends Container{
    
	/** The crafting matrix inventory (4x4). */
    public InventoryCrafting craftMatrix = new InventoryCrafting(this, 4, 4);
    public IInventory craftResult = new InventoryCraftResult();
    private World worldObj;
    private int posX;
    private int posY;
    private int posZ;

    public ContainerIceWorkbench(InventoryPlayer par1InventoryPlayer, World world, int x, int y, int z){
        this.worldObj = world;
        this.posX = x;
        this.posY = y;
        this.posZ = z;
        this.addSlotToContainer(new SlotIceCrafting(par1InventoryPlayer.player, this.craftMatrix, this.craftResult, 0, 124, 35));
        int l;
        int i1;

        for (l = 0; l < 4; ++l){
            for (i1 = 0; i1 < 4; ++i1){
            	// Slot (inventory, index, x, y)
                this.addSlotToContainer(new Slot(this.craftMatrix, i1 + l * 4, 8 + i1 * 18, 8 + l * 18));
            }
        }

        for (l = 0; l < 3; ++l){
            for (i1 = 0; i1 < 9; ++i1){
                this.addSlotToContainer(new Slot(par1InventoryPlayer, i1 + l * 9 + 9, 8 + i1 * 18, 84 + l * 18));
            }
        }

        for (l = 0; l < 9; ++l){
            this.addSlotToContainer(new Slot(par1InventoryPlayer, l, 8 + l * 18, 142));
        }

        this.onCraftMatrixChanged(this.craftMatrix);
    }

    /**
     * Callback for when the crafting matrix is changed.
     */
    public void onCraftMatrixChanged(IInventory par1IInventory){
        this.craftResult.setInventorySlotContents(0, IceWorkbenchCraftingRecipes.getInstance().findMatchingRecipe(this.craftMatrix, this.worldObj));
    }

    /**
     * Callback for when the crafting gui is closed.
     */
    public void onContainerClosed(EntityPlayer par1EntityPlayer){
        for (int i = 0; i < 16; ++i){
            ItemStack itemstack = this.craftMatrix.removeStackFromSlot(i);
            if (itemstack != null){
                par1EntityPlayer.dropPlayerItemWithRandomChoice(itemstack, false);
            }
        }
    }

    public boolean canInteractWith(EntityPlayer par1EntityPlayer){
    	return this.worldObj.getBlockState(new BlockPos(this.posX, this.posY, this.posZ)).getBlock() != SoulBlocks.IceWorkbench.get() ? false : par1EntityPlayer.getDistanceSq((double)this.posX + 0.5D, (double)this.posY + 0.5D, (double)this.posZ + 0.5D) <= 64.0D;
    }

    /**
     * Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
     */
    public ItemStack transferStackInSlot(EntityPlayer p_82846_1_, int p_82846_2_){
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(p_82846_2_);

        if (slot != null && slot.getHasStack()){
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (p_82846_2_ == 0){
                if (!this.mergeItemStack(itemstack1, 17, 46, true)){
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (p_82846_2_ >= 10 && p_82846_2_ < 37){
                if (!this.mergeItemStack(itemstack1, 37, 46, false)){
                    return null;
                }
            }
            else if (p_82846_2_ >= 37 && p_82846_2_ < 46){
                if (!this.mergeItemStack(itemstack1, 17, 37, false)){
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 17, 46, false)){
                return null;
            }

            if (itemstack1.stackSize == 0){
                slot.putStack((ItemStack)null);
            }
            else{
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize){
                return null;
            }

            slot.onPickupFromSlot(p_82846_1_, itemstack1);
        }

        return itemstack;
    }

    public boolean canMergeSlot(ItemStack stack, Slot p_94530_2_){
        return p_94530_2_.inventory != this.craftResult && super.canMergeSlot(stack, p_94530_2_);
    }
}