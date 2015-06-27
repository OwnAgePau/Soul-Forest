package com.Mod_Ores.Blocks.Containers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.Mod_Ores.Blocks.Recipes.GemmerationCraftingRecipes;
import com.Mod_Ores.Blocks.Slots.SlotGemmerationCrafting;
import com.Mod_Ores.Init.SoulBlocks;
import com.Mod_Ores.Init.SoulItems;

public class ContainerGemmeration extends Container{
    /** The crafting matrix inventory (2x1). */
    public InventoryCrafting craftMatrix = new InventoryCrafting(this, 2, 1);
    public IInventory craftResult = new InventoryCraftResult();
    private World worldObj;
    private int posX;
    private int posY;
    private int posZ;

    public ContainerGemmeration(InventoryPlayer par1InventoryPlayer, World world, int x, int y, int z){
	this.worldObj = world;
	this.posX = x;
	this.posY = y;
	this.posZ = z;
	this.addSlotToContainer(new SlotGemmerationCrafting(par1InventoryPlayer.player, this.craftMatrix, this.craftResult, 0, 116, 35));
	int l;
	int i1;


	//for (i1 = 0; i1 < 2; ++i1){
	this.addSlotToContainer(new Slot(this.craftMatrix, 0, 56, 17));
	this.addSlotToContainer(new Slot(this.craftMatrix, 1, 56, 53));
	//}

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
	ItemStack result = GemmerationCraftingRecipes.getInstance().findMatchingRecipe(this.craftMatrix, this.worldObj);
	if(result != null){
	    ItemStack input = null;
	    ItemStack input2 = null;
	    if(this.getSlot(0).getStack() != null){
		input = this.getSlot(0).getStack();
	    } 
	    if(this.getSlot(1).getStack() != null){
		input2 = this.getSlot(1).getStack();
	    }
	    if(input != null && input2 != null){
		if(input.getItem() != SoulItems.JetAmuletStone.get()){
		    result.setItemDamage(input.getItemDamage() - (input.getMaxDamage() / 5)); // Get Amount of Repair at once
		}
		else{
		    result.setItemDamage(input2.getItemDamage() - (input2.getMaxDamage() / 5));
		}
	    }
	}
	this.craftResult.setInventorySlotContents(0, result);
    }

    /**
     * Callback for when the crafting gui is closed.
     */
    public void onContainerClosed(EntityPlayer par1EntityPlayer){
	for (int i = 0; i < 2; ++i){
	    ItemStack itemstack = this.craftMatrix.getStackInSlotOnClosing(i);
	    if (itemstack != null){
		par1EntityPlayer.dropPlayerItemWithRandomChoice(itemstack, false);
	    }
	}
    }

    public boolean canInteractWith(EntityPlayer par1EntityPlayer){
	return this.worldObj.getBlock(this.posX, this.posY, this.posZ) != SoulBlocks.GemmerationTable.get() ? false : par1EntityPlayer.getDistanceSq((double)this.posX + 0.5D, (double)this.posY + 0.5D, (double)this.posZ + 0.5D) <= 64.0D;
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
		if (!this.mergeItemStack(itemstack1, 17,  this.inventorySlots.size(), true)){
		    return null;
		}

		slot.onSlotChange(itemstack1, itemstack);
	    }
	    else if (p_82846_2_ >= 10 && p_82846_2_ < 37){
		if (!this.mergeItemStack(itemstack1, 37,  this.inventorySlots.size(), false)){
		    return null;
		}
	    }
	    else if (p_82846_2_ >= 37 && p_82846_2_ <  this.inventorySlots.size()){
		if (!this.mergeItemStack(itemstack1, 17, 37, false)){
		    return null;
		}
	    }
	    else if (!this.mergeItemStack(itemstack1, 17,  this.inventorySlots.size(), false)){
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

    public boolean func_94530_a(ItemStack par1ItemStack, Slot par2Slot){
	return par2Slot.inventory != this.craftResult && super.func_94530_a(par1ItemStack, par2Slot);
    }
}
