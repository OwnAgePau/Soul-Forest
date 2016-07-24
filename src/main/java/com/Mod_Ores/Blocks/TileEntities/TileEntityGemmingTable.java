package com.Mod_Ores.Blocks.TileEntities;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IChatComponent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.Mod_Ores.Blocks.Recipes.GemcutterRecipes;
import com.Mod_Ores.Init.SoulItems;

public class TileEntityGemmingTable extends TileEntity implements ISidedInventory{
    
	private ItemStack[] gemmingItemStacks = new ItemStack[3];

    private static final int[] slots_top = new int[] {0};
    private static final int[] slots_bottom = new int[] {1};
    private static final int[] slots_sides = new int[] {1};

    private String guiName;

    @Override
    public String getName() {
    	return "Gemming Table";
    }

    @Override
    public boolean hasCustomName() {
    	return true;
    }

	@Override
	public void openInventory(EntityPlayer player) {}

	@Override
	public void closeInventory(EntityPlayer player) {}

    public void setGuiDisplayName(String par1Str){
    	this.guiName = par1Str;
    }

    public String getInvName(){
    	return "Gemming Table";
    }

    public boolean isInvNameLocalized(){
    	return false;
    }

    public int getInventoryStackLimit(){
    	return 9;
    }

    public int getSizeInventory(){
    	return this.gemmingItemStacks.length;
    }

    @Override
    public ItemStack getStackInSlot(int slot){
    	return this.gemmingItemStacks[slot];
    }

    @Override
    public ItemStack decrStackSize(int slot, int ammount){
		if (this.gemmingItemStacks[slot] != null){
		    ItemStack itemstack;
	
		    if (this.gemmingItemStacks[slot].stackSize <= ammount){
				itemstack = this.gemmingItemStacks[slot];
				this.gemmingItemStacks[slot] = null;
				return itemstack;
			}
			else{
				itemstack = this.gemmingItemStacks[slot].splitStack(ammount);
		
				if (this.gemmingItemStacks[slot].stackSize == 0){
				    this.gemmingItemStacks[slot] = null;
				}
		
				return itemstack;
		    }
		}
		else{
		    return null;
		}
    }

    @Override
    public ItemStack removeStackFromSlot(int slot){
		if (this.gemmingItemStacks[slot] != null){
		    ItemStack itemstack = this.gemmingItemStacks[slot];
		    this.gemmingItemStacks[slot] = null;
		    return itemstack;
		}
		else{
		    return null;
		}
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack itemStack){
		this.gemmingItemStacks[slot] = itemStack;
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
		this.gemmingItemStacks = new ItemStack[this.getSizeInventory()];
	
		for (int i = 0; i < nbttaglist.tagCount(); ++i){
		    NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
		    byte slot = nbttagcompound1.getByte("Slot");
	
		    if (slot >= 0 && slot < this.gemmingItemStacks.length){
		    	this.gemmingItemStacks[slot] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
		    }
		}
    }

    @Override
    public void writeToNBT(NBTTagCompound par1NBTTagCompound){
		super.writeToNBT(par1NBTTagCompound);
		NBTTagList nbttaglist = new NBTTagList();
	
		for (int currentindex = 0; currentindex < this.gemmingItemStacks.length; ++currentindex){
		    if (this.gemmingItemStacks[currentindex] != null){
				NBTTagCompound nbttagcompound = new NBTTagCompound();
				nbttagcompound.setByte("Slot", (byte)currentindex);
				this.gemmingItemStacks[currentindex].writeToNBT(nbttagcompound);
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

    public void update(){
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
		if (this.gemmingItemStacks[0] == null){       	
		    return false;
		}  
	
		if(this.gemmingItemStacks[1] == null){
		    return false;
		}
		else{
		    //this.gelAmmountExtracted = this.gemmingItemStacks[1].getItemDamage();
		    if(!this.gemmingItemStacks[1].isItemDamaged()){
		    	return false;
		    }
		    else{
		    	return true;
		    }
		    
		}
    }

    public void extract(){ // Deze methode zorgt voor het resultaat wat er uit komt
		if (this.canExtract()){            
		    this.gemmingItemStacks[1].damageItem(-1, Minecraft.getMinecraft().thePlayer);
		    --this.gemmingItemStacks[0].stackSize;
	
		    if(!this.gemmingItemStacks[1].isItemDamaged() && this.gemmingItemStacks[1].getItem().equals(SoulItems.GelPot.get())){
				--this.gemmingItemStacks[1].stackSize;
				this.gemmingItemStacks[1] = new ItemStack(SoulItems.GelPotFilled.get(), 1);
		    }
	
		    if (this.gemmingItemStacks[0].stackSize <= 0){
		    	this.gemmingItemStacks[0] = null;
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
    	return this.worldObj.getTileEntity(this.getPos()) != this ? false : par1EntityPlayer.getDistanceSq((double)this.getPos().getX() + 0.5D, (double)this.getPos().getY() + 0.5D, (double)this.getPos().getZ() + 0.5D) <= 64.0D;
    }

    public void openChest() {}

    public void closeChest() {}

    @Override
    public int[] getSlotsForFace(EnumFacing side){
    	return side == EnumFacing.DOWN ? slots_bottom : (side == EnumFacing.UP ? slots_top : slots_sides);
    }

    @Override
    public boolean canInsertItem(int par1, ItemStack par2ItemStack, EnumFacing side){
    	return this.isItemValidForSlot(par1, par2ItemStack);
    }

    public boolean canExtractItem(int par1, ItemStack par2ItemStack, EnumFacing side){
    	return side != EnumFacing.DOWN || par1 != 1 || par2ItemStack.equals(Item.getItemById(325));
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
    
    @Override
	public int getField(int id) {
    	return 0;
	}

	@Override
	public void setField(int id, int value) {}

	@Override
	public int getFieldCount() {
		return 3;
	}

	@Override
	public void clear() {		
		 for (int i = 0; i < this.gemmingItemStacks.length; ++i){
			 this.gemmingItemStacks[i] = null;
	     }
	}

	@Override
	public IChatComponent getDisplayName() {
		return null;
	}
}