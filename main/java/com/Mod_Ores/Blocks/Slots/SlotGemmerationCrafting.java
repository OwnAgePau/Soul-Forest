package com.Mod_Ores.Blocks.Slots;

import com.Mod_Ores.soul_forest;
import com.Mod_Ores.Init.SoulItems;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerDestroyItemEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemSmeltedEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class SlotGemmerationCrafting extends Slot{
    /** The craft matrix inventory linked to this result slot. */
    private final IInventory craftMatrix;

    /** The player that is using the GUI where this slot resides. */
    private EntityPlayer thePlayer;

    /**
     * The number of items that have been crafted so far. Gets passed to ItemStack.onCrafting before being reset.
     */
    private int amountCrafted;

    public SlotGemmerationCrafting(EntityPlayer par1EntityPlayer, IInventory par2IInventory, IInventory par3IInventory, int par4, int par5, int par6){
	super(par3IInventory, par4, par5, par6);
	this.thePlayer = par1EntityPlayer;
	this.craftMatrix = par2IInventory;
    }

    /**
     * Check if the stack is a valid item for this slot. Always true beside for the armor slots.
     */
    public boolean isItemValid(ItemStack par1ItemStack){
	return false;
    }

    /**
     * Decrease the size of the stack in slot (first int arg) by the amount of the second int arg. Returns the new
     * stack.
     */
    public ItemStack decrStackSize(int par1){
	if (this.getHasStack()){
	    this.amountCrafted += Math.min(par1, this.getStack().stackSize);
	}

	return super.decrStackSize(par1);
    }

    /**
     * the itemStack passed in is the output - ie, iron ingots, and pickaxes, not ore and wood. Typically increases an
     * internal count then calls onCrafting(item).
     */
    protected void onCrafting(ItemStack par1ItemStack, int par2){
	this.amountCrafted += par2;
	this.onCrafting(par1ItemStack);
    }

    /**
     * the itemStack passed in is the output - ie, iron ingots, and pickaxes, not ore and wood.
     */
    protected void onCrafting(ItemStack par1ItemStack){
	par1ItemStack.onCrafting(this.thePlayer.worldObj, this.thePlayer, this.amountCrafted);
	this.amountCrafted = 0;
    }
    
    private int getDamage(){
	// Calculate amount of damage given to the stone.
	int damage = 0;
	ItemStack input = null;
	ItemStack repairStack = null;
	if(this.craftMatrix.getStackInSlot(0) != null && this.craftMatrix.getStackInSlot(1) != null){
	    input = this.craftMatrix.getStackInSlot(0);
	    if(input.getItem() == SoulItems.JetAmuletStone.get()){
		repairStack = this.craftMatrix.getStackInSlot(1);
	    }
	    else{
		input = this.craftMatrix.getStackInSlot(1);
		repairStack = this.craftMatrix.getStackInSlot(0);
	    }
	} 
	if(input != null && repairStack != null){
	    Item repair = repairStack.getItem();
	    for(String toolClass : repair.getToolClasses(repairStack)){
		int lvl = repair.getHarvestLevel(repairStack, toolClass);
		damage = lvl * (input.getMaxDamage() / 10);
		System.out.println(repairStack.getDisplayName() + ", Tool : "  + toolClass + " : " + lvl + " -> " + damage);
	    }
	}
	return damage;
    }

    public void onPickupFromSlot(EntityPlayer par1EntityPlayer, ItemStack par2ItemStack){
	int damage = this.getDamage();
	ItemCraftedEvent itemCrafted = new ItemCraftedEvent(thePlayer, par2ItemStack, craftMatrix);
	soul_forest.craftHandler.onCrafting(itemCrafted);

	this.onCrafting(par2ItemStack);

	for (int i = 0; i < this.craftMatrix.getSizeInventory(); ++i){
	    ItemStack itemstack1 = this.craftMatrix.getStackInSlot(i);            
	    if (itemstack1 != null){
		this.craftMatrix.decrStackSize(i, 1);

		
		if (itemstack1.isItemStackDamageable() && itemstack1.getItemDamage() + damage >= itemstack1.getMaxDamage()){
		    MinecraftForge.EVENT_BUS.post(new PlayerDestroyItemEvent(thePlayer, itemstack1));
		    itemstack1 = null;
		}

		if(itemstack1 != null){
		    if (!itemstack1.getItem().doesContainerItemLeaveCraftingGrid(itemstack1)){
			if (this.craftMatrix.getStackInSlot(i) == null){
			    this.craftMatrix.setInventorySlotContents(i, itemstack1);
			    if(itemstack1.getItem() == SoulItems.JetAmuletStone.get()){
				itemstack1.setItemDamage(itemstack1.getItemDamage() + damage);
			    }
			}
			else{
			    this.thePlayer.dropPlayerItemWithRandomChoice(itemstack1, false);
			}
		    }	

		    if (itemstack1.getItem().hasContainerItem()){
			ItemStack itemstack2 = itemstack1.getItem().getContainerItem(itemstack1);

			if (itemstack2.isItemStackDamageable() && itemstack2.getItemDamage() > itemstack2.getMaxDamage()){
			    MinecraftForge.EVENT_BUS.post(new PlayerDestroyItemEvent(thePlayer, itemstack2));
			    itemstack2 = null;
			}

			if (itemstack2 != null && (!itemstack1.getItem().doesContainerItemLeaveCraftingGrid(itemstack1) || !this.thePlayer.inventory.addItemStackToInventory(itemstack2))){
			    if (this.craftMatrix.getStackInSlot(i) == null){
				this.craftMatrix.setInventorySlotContents(i, itemstack2);
			    }
			    else{
				this.thePlayer.dropPlayerItemWithRandomChoice(itemstack2, false);
			    }
			}
		    }
		}
	    }
	}
    }
}
