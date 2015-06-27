package com.Mod_Ores.Blocks.TileEntities;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

import com.Mod_Ores.Blocks.Recipes.GemcutterRecipes;
import com.Mod_Ores.Init.SoulItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TileEntityGembleTable extends TileEntity implements ISidedInventory{
    private ItemStack[] gembleItemStacks = new ItemStack[3];

    private static final int[] slots_top = new int[] {0};
    private static final int[] slots_bottom = new int[] {1};
    private static final int[] slots_sides = new int[] {1};

    private String guiName;
    
    public int currentItemBurnTime = 0;
    public int gelextractorBurnTime = 0;
    public int gelextractorCookTime = 0; 

    @Override
    public String getInventoryName() {
	return "Gemble Table";
    }

    @Override
    public boolean hasCustomInventoryName() {
	return true;
    }

    @Override
    public void openInventory() {}

    @Override
    public void closeInventory() {}

    public void setGuiDisplayName(String par1Str){
	this.guiName = par1Str;
    }

    public String getInvName(){
	return "Gemble Table";
    }

    public boolean isInvNameLocalized(){
	return false;
    }

    public int getInventoryStackLimit(){
	return 64;
    }

    public int getSizeInventory(){
	return this.gembleItemStacks.length;
    }

    @Override
    public ItemStack getStackInSlot(int slot){
	return this.gembleItemStacks[slot];
    }

    @Override
    public ItemStack decrStackSize(int slot, int ammount){
	if (this.gembleItemStacks[slot] != null){
	    ItemStack itemstack;

	    if (this.gembleItemStacks[slot].stackSize <= ammount){
		itemstack = this.gembleItemStacks[slot];
		this.gembleItemStacks[slot] = null;
		return itemstack;
	    }
	    else{
		itemstack = this.gembleItemStacks[slot].splitStack(ammount);

		if (this.gembleItemStacks[slot].stackSize == 0){
		    this.gembleItemStacks[slot] = null;
		}

		return itemstack;
	    }
	}
	else{
	    return null;
	}
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int slot){
	if (this.gembleItemStacks[slot] != null){
	    ItemStack itemstack = this.gembleItemStacks[slot];
	    this.gembleItemStacks[slot] = null;
	    return itemstack;
	}
	else{
	    return null;
	}
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack itemStack){
	this.gembleItemStacks[slot] = itemStack;
	if (itemStack != null && itemStack.stackSize > this.getInventoryStackLimit()){
	    itemStack.stackSize = this.getInventoryStackLimit();
	}
    }
    
    @SideOnly(Side.CLIENT)

    @Override
    public void readFromNBT(NBTTagCompound par1NBTTagCompound){
	super.readFromNBT(par1NBTTagCompound);
	NBTTagList nbttaglist = par1NBTTagCompound.getTagList("Items", 10);
	this.gembleItemStacks = new ItemStack[this.getSizeInventory()];

	for (int i = 0; i < nbttaglist.tagCount(); ++i){
	    NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
	    byte slot = nbttagcompound1.getByte("Slot");

	    if (slot >= 0 && slot < this.gembleItemStacks.length){
		this.gembleItemStacks[slot] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
	    }
	}
    }

    @Override
    public void writeToNBT(NBTTagCompound par1NBTTagCompound){
	super.writeToNBT(par1NBTTagCompound);
	NBTTagList nbttaglist = new NBTTagList();

	for (int currentindex = 0; currentindex < this.gembleItemStacks.length; ++currentindex){
	    if (this.gembleItemStacks[currentindex] != null){
		NBTTagCompound nbttagcompound = new NBTTagCompound();
		nbttagcompound.setByte("Slot", (byte)currentindex);
		this.gembleItemStacks[currentindex].writeToNBT(nbttagcompound);
		nbttaglist.appendTag(nbttagcompound);
	    }
	}

	par1NBTTagCompound.setTag("Items", nbttaglist);
    }

    @SideOnly(Side.CLIENT)
    public boolean isExtracting(){
	return true;
    }

    @Override
    public void updateEntity(){
	boolean flag1 = false;

	if (!this.worldObj.isRemote){
	    if (this.isExtracting() && this.canExtract()){
		flag1 = true;
	    }
	    if(flag1){
		//this.onInventoryChanged(); // Hier zou ik aan uit kunnen regelen
		//BlockGelExtractor.updateGemcutterBlockState(this.gelextractorBurnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
	    }
	}
    }

    public boolean canExtract(){
	if (this.gembleItemStacks[0] == null){       	
	    return false;
	}  
	else if(this.gembleItemStacks[1] == null){
	    return false;
	}
	else{
	    ItemStack itemstack = GemcutterRecipes.smelting().getGemcutterSmeltingResult(this.gembleItemStacks[0], this.gembleItemStacks[1]);
	    System.out.println(this.gembleItemStacks[2]);
	    if (itemstack == null) return false;
	    if (this.gembleItemStacks[2] == null) return true;
	    if (!this.gembleItemStacks[2].isItemEqual(itemstack)) return false;
	    int result = gembleItemStacks[2].stackSize + itemstack.stackSize;
	    return (result <= getInventoryStackLimit() && result <= itemstack.getMaxStackSize());
	}
    }

    public void extract(){
	if (this.canExtract()){  
	    ItemStack result = GemcutterRecipes.smelting().getGemcutterSmeltingResult(this.gembleItemStacks[0], this.gembleItemStacks[1]);
	    System.out.println(result.getUnlocalizedName());
	    
	    if (this.gembleItemStacks[2] == null){
		this.gembleItemStacks[2] = result.copy();
	    }
	    else if (this.gembleItemStacks[2].isItemEqual(result)){
		gembleItemStacks[2].stackSize += result.stackSize;
	    }
	    
	    --this.gembleItemStacks[0].stackSize;
	    --this.gembleItemStacks[1].stackSize;
	    
	    if (this.gembleItemStacks[0].stackSize <= 0){
		this.gembleItemStacks[0] = null;
	    }

	    if (this.gembleItemStacks[1].stackSize <= 0){
		this.gembleItemStacks[1] = null;
	    }
	}
    }

    public static int getItemBurnTime(ItemStack itemStack){
	return 4800;
    }

    public static boolean isItemFuel(ItemStack par0ItemStack){
	return getItemBurnTime(par0ItemStack) > 0;
    }

    public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer){
	return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : par1EntityPlayer.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
    }

    public void openChest() {}

    public void closeChest() {}

    public int[] getAccessibleSlotsFromSide(int par1){
	return par1 == 0 ? slots_bottom : (par1 == 1 ? slots_top : slots_sides);
    }

    public boolean canInsertItem(int par1, ItemStack par2ItemStack, int par3){
	return this.isItemValidForSlot(par1, par2ItemStack);
    }

    public boolean canExtractItem(int par1, ItemStack par2ItemStack, int par3){
	return par3 != 0 || par1 != 1 || par2ItemStack == new ItemStack(Item.getItemById(325));
    }

    @Override
    public boolean isItemValidForSlot(int i, ItemStack itemstack) {
	if(i == 3){
	    return false;
	}
	else{
	    return true;
	}
    }
}
