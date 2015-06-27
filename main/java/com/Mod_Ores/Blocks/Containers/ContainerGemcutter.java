package com.Mod_Ores.Blocks.Containers;

import com.Mod_Ores.Blocks.Recipes.GemcutterRecipes;
import com.Mod_Ores.Blocks.Slots.SlotGemcutter;
import com.Mod_Ores.Blocks.TileEntities.TileEntityGemcutter;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

public class ContainerGemcutter extends Container
{
    private TileEntityGemcutter gemcutter;
    private int lastGemCookTime = 0;
    private int lastGemBurnTime = 0;
    private int lastGemItemBurnTime = 0;

    public ContainerGemcutter(InventoryPlayer par1InventoryPlayer, TileEntityGemcutter par2TileEntityGemcutter)
    {
        this.gemcutter = par2TileEntityGemcutter;
        this.addSlotToContainer(new Slot(par2TileEntityGemcutter, 0, 56, 17)); // 0
        this.addSlotToContainer(new Slot(par2TileEntityGemcutter, 1, 65, 53)); // 2
        this.addSlotToContainer(new Slot(par2TileEntityGemcutter, 2, 46, 53)); // 1
        this.addSlotToContainer(new SlotGemcutter(par1InventoryPlayer.player, par2TileEntityGemcutter, 3, 116, 35)); // 3
        //this.addSlotToContainer(new SlotGemcutter(par1InventoryPlayer.player, par2TileEntityGemcutter, 2, 116, 35));

        for (int invRow = 0; invRow < 3; ++invRow)
        {
            for (int invCol = 0; invCol < 9; ++invCol)
            {
                this.addSlotToContainer(new Slot(par1InventoryPlayer, invCol + invRow * 9 + 9, 8 + invCol * 18, 84 + invRow * 18));
            }
        }

        for (int actionBar = 0; actionBar < 9; ++actionBar)
        {
            this.addSlotToContainer(new Slot(par1InventoryPlayer, actionBar, 8 + actionBar * 18, 142));
        }
    }

    @Override
    public void addCraftingToCrafters(ICrafting par1ICrafting)
    {
        super.addCraftingToCrafters(par1ICrafting);
        par1ICrafting.sendProgressBarUpdate(this, 0, this.gemcutter.gemcutterCookTime);
        par1ICrafting.sendProgressBarUpdate(this, 1, this.gemcutter.gemcutterBurnTime);
        par1ICrafting.sendProgressBarUpdate(this, 2, this.gemcutter.currentGemItemBurnTime);
    }

    @Override
    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();

        for (int i = 0; i < this.crafters.size(); ++i)
        {
            ICrafting icrafting = (ICrafting)this.crafters.get(i);

            if (this.lastGemCookTime != this.gemcutter.gemcutterCookTime)
            {
                icrafting.sendProgressBarUpdate(this, 0, this.gemcutter.gemcutterCookTime);
            }

            if (this.lastGemBurnTime != this.gemcutter.gemcutterBurnTime)
            {
                icrafting.sendProgressBarUpdate(this, 1, this.gemcutter.gemcutterBurnTime);
            }

            if (this.lastGemItemBurnTime != this.gemcutter.currentGemItemBurnTime)
            {
                icrafting.sendProgressBarUpdate(this, 2	, this.gemcutter.currentGemItemBurnTime);
            }
        }

        this.lastGemCookTime = this.gemcutter.gemcutterCookTime;
        this.lastGemBurnTime = this.gemcutter.gemcutterBurnTime;
        this.lastGemItemBurnTime = this.gemcutter.currentGemItemBurnTime;
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int par1, int par2)
    {
        if (par1 == 0)
        {
            this.gemcutter.gemcutterCookTime = par2;
        }

        if (par1 == 1)
        {
            this.gemcutter.gemcutterBurnTime = par2;
        }

        if (par1 == 2)
        {
            this.gemcutter.currentGemItemBurnTime = par2;
        }
    }
    
    @Override
    public boolean canInteractWith(EntityPlayer par1EntityPlayer)
    {
        return this.gemcutter.isUseableByPlayer(par1EntityPlayer);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(par2);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            
            if (par2 == 2)
            {
                if (!this.mergeItemStack(itemstack1, 3, 39, true))
                {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (par2 != 1 && par2 != 0)
            {
                if (GemcutterRecipes.smelting().getGemcutterSmeltingResult(itemstack1, itemstack1) != null)
                {
                    if (!this.mergeItemStack(itemstack1, 0, 1, false))
                    {
                        return null;
                    }
                }
                else if (TileEntityGemcutter.isItemFuel(itemstack1))
                {
                    if (!this.mergeItemStack(itemstack1, 1, 2, false))
                    {
                        return null;
                    }
                }
                else if (par2 >= 3 && par2 < 30)
                {
                    if (!this.mergeItemStack(itemstack1, 30, 39, false))
                    {
                        return null;
                    }
                }
                else if (par2 >= 30 && par2 < 39 && !this.mergeItemStack(itemstack1, 3, 30, false))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 3, 39, false))
            {
                return null;
            }

            if (itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize)
            {
                return null;
            }

            slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
        }
     	
        return itemstack;
    }
}
