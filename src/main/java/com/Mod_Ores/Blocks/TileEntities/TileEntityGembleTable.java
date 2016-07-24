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
    public String getName() {
    	return "Gemble Table";
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
    public ItemStack removeStackFromSlot(int slot){
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

    public void update(){
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
    	return this.worldObj.getTileEntity(this.getPos()) != this ? false : par1EntityPlayer.getDistanceSq((double)this.getPos().getX() + 0.5D, (double)this.getPos().getY() + 0.5D, (double)this.getPos().getZ() + 0.5D) <= 64.0D;
    }

    public void openChest() {}

    public void closeChest() {}

    @Override
    public int[] getSlotsForFace(EnumFacing side){
    	return side == EnumFacing.DOWN ? slots_bottom : (side == EnumFacing.UP ? slots_top : slots_sides);
    }

    @Override
    public boolean canInsertItem(int index, ItemStack par2ItemStack, EnumFacing direction){
    	return this.isItemValidForSlot(index, par2ItemStack);
    }

    @Override
    public boolean canExtractItem(int index, ItemStack par2ItemStack, EnumFacing direction){
    	return direction != EnumFacing.DOWN || index != 1 || par2ItemStack == new ItemStack(Item.getItemById(325));
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
		switch (id)
        {
            case 0:
                return this.gelextractorBurnTime;
            case 1:
                return this.currentItemBurnTime;
            case 2:
                return this.gelextractorCookTime;
            default:
                return 0;
        }
	}

	@Override
	public void setField(int id, int value) {
		switch (id)
        {
            case 0:
                this.gelextractorBurnTime = value;
                break;
            case 1:
                this.currentItemBurnTime = value;
                break;
            case 2:
                this.gelextractorCookTime = value;
                break;
        }
	}

	@Override
	public int getFieldCount() {
		return 3;
	}

	@Override
	public void clear() {		
		 for (int i = 0; i < this.gembleItemStacks.length; ++i){
			 this.gembleItemStacks[i] = null;
	     }
	}

	@Override
	public IChatComponent getDisplayName() {
		return null;
	}
}
