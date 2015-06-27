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

public class TileEntityGemmerationTable extends TileEntity implements ISidedInventory
{
    private ItemStack[] gemmerationItemStacks = new ItemStack[3];

    private static final int[] slots_top = new int[] {0};
    private static final int[] slots_bottom = new int[] {1};
    private static final int[] slots_sides = new int[] {1};

    private String guiName;

    @Override
    public String getInventoryName() {
	return "Gemmeration Table";
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
	return "Gemmeration Table";
    }

    public boolean isInvNameLocalized(){
	return false;
    }

    public int getInventoryStackLimit(){
	return 9;
    }

    public int getSizeInventory(){
	return this.gemmerationItemStacks.length;
    }

    @Override
    public ItemStack getStackInSlot(int slot){
	return this.gemmerationItemStacks[slot];
    }

    @Override
    public ItemStack decrStackSize(int slot, int ammount){
	if (this.gemmerationItemStacks[slot] != null){
	    ItemStack itemstack;

	    if (this.gemmerationItemStacks[slot].stackSize <= ammount){
		itemstack = this.gemmerationItemStacks[slot];
		this.gemmerationItemStacks[slot] = null;
		return itemstack;
	    }
	    else{
		itemstack = this.gemmerationItemStacks[slot].splitStack(ammount);

		if (this.gemmerationItemStacks[slot].stackSize == 0){
		    this.gemmerationItemStacks[slot] = null;
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
	if (this.gemmerationItemStacks[slot] != null){
	    ItemStack itemstack = this.gemmerationItemStacks[slot];
	    this.gemmerationItemStacks[slot] = null;
	    return itemstack;
	}
	else{
	    return null;
	}
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack itemStack){
	this.gemmerationItemStacks[slot] = itemStack;
	int stackLimit = 1;
	if(slot == 1){
	    if (itemStack != null && itemStack.stackSize > stackLimit){
		itemStack.stackSize = stackLimit;
	    }
	}
	else{
	    if (itemStack != null && itemStack.stackSize > this.getInventoryStackLimit()){
		itemStack.stackSize = this.getInventoryStackLimit();
	    }
	}
    }

    @Override
    public void readFromNBT(NBTTagCompound par1NBTTagCompound){
	super.readFromNBT(par1NBTTagCompound);
	NBTTagList nbttaglist = par1NBTTagCompound.getTagList("Items", 10);
	this.gemmerationItemStacks = new ItemStack[this.getSizeInventory()];

	for (int i = 0; i < nbttaglist.tagCount(); ++i){
	    NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
	    byte slot = nbttagcompound1.getByte("Slot");

	    if (slot >= 0 && slot < this.gemmerationItemStacks.length){
		this.gemmerationItemStacks[slot] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
	    }
	}
    }

    @Override
    public void writeToNBT(NBTTagCompound par1NBTTagCompound){
	super.writeToNBT(par1NBTTagCompound);
	NBTTagList nbttaglist = new NBTTagList();

	for (int currentindex = 0; currentindex < this.gemmerationItemStacks.length; ++currentindex){
	    if (this.gemmerationItemStacks[currentindex] != null){
		NBTTagCompound nbttagcompound = new NBTTagCompound();
		nbttagcompound.setByte("Slot", (byte)currentindex);
		this.gemmerationItemStacks[currentindex].writeToNBT(nbttagcompound);
		nbttaglist.appendTag(nbttagcompound);
	    }
	}

	par1NBTTagCompound.setTag("Items", nbttaglist);
    }

    @SideOnly(Side.CLIENT)

    /*public int getExtractProgressScaled(int par1){
	return this.gelextractorCookTime * par1 / 75;
    }


    public int getGelExtracted(){
	return this.gelAmmountExtracted;
    }

    @SideOnly(Side.CLIENT)
    public int getExtractTimeRemainingScaled(int par1){
	if (this.currentItemBurnTime == 0){
	    this.currentItemBurnTime = 100;
	}

	//return this.gelextractorBurnTime * par1 / this.currentItemBurnTime;
	return this.gelextractorCookTime * par1 / this.currentItemBurnTime;
    }*/

    public boolean isExtracting(){
	return true;
    }

    @Override
    public void updateEntity(){
	//boolean flag = this.gelextractorBurnTime > 0;
	boolean flag1 = false;

	if (!this.worldObj.isRemote){
	    if (this.isExtracting() && this.canExtract()){
		/*++this.gelextractorCookTime;
		if (this.gelextractorCookTime >= 75){
		    this.gelextractorCookTime = 0;*/
		this.extract();
		flag1 = true;
		//}
	    }

	    /*if (flag != this.gelextractorBurnTime > 0){
		flag1 = true;    // Furnace is aan het branden            
	    }*/

	    if(flag1){
		//this.onInventoryChanged(); // Hier zou ik aan uit kunnen regelen
		//BlockGelExtractor.updateGemcutterBlockState(this.gelextractorBurnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
	    }
	}
    }

    public boolean canExtract(){
	if (this.gemmerationItemStacks[0] == null){       	
	    return false;
	}  

	if(this.gemmerationItemStacks[1] == null){
	    return false;
	}
	else{
	    //this.gelAmmountExtracted = this.gemmerationItemStacks[1].getItemDamage();
	    if(!this.gemmerationItemStacks[1].isItemDamaged()){
		return false;
	    }
	    else{
		return true;
	    }

	}
    }

    public void extract(){ // Deze methode zorgt voor het resultaat wat er uit komt
	if (this.canExtract()){            
	    this.gemmerationItemStacks[1].damageItem(-1, Minecraft.getMinecraft().thePlayer);
	    --this.gemmerationItemStacks[0].stackSize;

	    if(!this.gemmerationItemStacks[1].isItemDamaged() && this.gemmerationItemStacks[1].getItem().equals(SoulItems.GelPot.get())){
		--this.gemmerationItemStacks[1].stackSize;
		this.gemmerationItemStacks[1] = new ItemStack(SoulItems.GelPotFilled.get(), 1);
	    }

	    if (this.gemmerationItemStacks[0].stackSize <= 0){
		this.gemmerationItemStacks[0] = null;
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
