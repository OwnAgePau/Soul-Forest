package com.Mod_Ores.Blocks.TileEntities;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IChatComponent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.Mod_Ores.Blocks.Recipes.GemcutterRecipes;
import com.Mod_Ores.Blocks.Special.BlockGemcutterBench;
import com.Mod_Ores.Init.SoulItems;

public class TileEntityGemcutter extends TileEntity implements ISidedInventory{
    
	private ItemStack[] gemcutterItemStacks = new ItemStack[4];

    private static final int[] slots_top = new int[] {0};
    private static final int[] slots_bottom = new int[] {2, 1};
    private static final int[] slots_sides = new int[] {1};

    private String guiName;

    public int currentGemItemBurnTime = 0;
    public int gemcutterBurnTime = 0;
    public int gemcutterCookTime = 0;

    @Override
    public String getName() {
    	return "Gemcutter";
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
    	return "Gemcutter";
    }

    public boolean isInvNameLocalized(){
    	return false;
    }

    public int getInventoryStackLimit(){
    	return 64;
    }

    public int getSizeInventory(){
    	return this.gemcutterItemStacks.length;
    }

    @Override
    public ItemStack getStackInSlot(int slot){
    	return this.gemcutterItemStacks[slot];
    }

    @Override
    public ItemStack decrStackSize(int slot, int ammount){
		if (this.gemcutterItemStacks[slot] != null){
		    ItemStack itemstack;
	
		    if (this.gemcutterItemStacks[slot].stackSize <= ammount){
				itemstack = this.gemcutterItemStacks[slot];
				this.gemcutterItemStacks[slot] = null;
				return itemstack;
		    }
		    else{
				itemstack = this.gemcutterItemStacks[slot].splitStack(ammount);
		
				if (this.gemcutterItemStacks[slot].stackSize == 0){
				    this.gemcutterItemStacks[slot] = null;
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
		if (this.gemcutterItemStacks[slot] != null){
		    ItemStack itemstack = this.gemcutterItemStacks[slot];
		    this.gemcutterItemStacks[slot] = null;
		    return itemstack;
		}
		else{
		    return null;
		}
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack itemStack){
		this.gemcutterItemStacks[slot] = itemStack;
		if (itemStack != null && itemStack.stackSize > this.getInventoryStackLimit()){
		    itemStack.stackSize = this.getInventoryStackLimit();
		}
    }

    @Override
    public void readFromNBT(NBTTagCompound par1NBTTagCompound){
		super.readFromNBT(par1NBTTagCompound);
		NBTTagList nbttaglist = par1NBTTagCompound.getTagList("Items", 10);
		this.gemcutterItemStacks = new ItemStack[this.getSizeInventory()];
	
		for (int i = 0; i < nbttaglist.tagCount(); ++i){
		    NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
		    byte slot = nbttagcompound1.getByte("Slot");
	
		    if (slot >= 0 && slot < this.gemcutterItemStacks.length){
		    	this.gemcutterItemStacks[slot] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
		    }
		}
	
		this.gemcutterBurnTime = par1NBTTagCompound.getShort("BurnTime");
		this.gemcutterCookTime = par1NBTTagCompound.getShort("CookTime");
		this.currentGemItemBurnTime = getItemBurnTime(this.gemcutterItemStacks[1]);
    }

    @Override
    public void writeToNBT(NBTTagCompound par1NBTTagCompound){
		super.writeToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setShort("BurnTime", (short)this.gemcutterBurnTime);
		par1NBTTagCompound.setShort("CookTime", (short)this.gemcutterCookTime);
		NBTTagList nbttaglist = new NBTTagList();
	
		for (int currentindex = 0; currentindex < this.gemcutterItemStacks.length; ++currentindex){
		    if (this.gemcutterItemStacks[currentindex] != null){
				NBTTagCompound nbttagcompound = new NBTTagCompound();
				nbttagcompound.setByte("Slot", (byte)currentindex);
				this.gemcutterItemStacks[currentindex].writeToNBT(nbttagcompound);
				nbttaglist.appendTag(nbttagcompound);
		    }
		}
	
		par1NBTTagCompound.setTag("Items", nbttaglist);
    }

    @SideOnly(Side.CLIENT)

    public int getCutProgressScaled(int par1){
    	return this.gemcutterCookTime * par1 / 200;
    }

    @SideOnly(Side.CLIENT)

    public int getPolishTimeRemainingScaled(int par1){
		if (this.currentGemItemBurnTime == 0){
		    this.currentGemItemBurnTime = 200;
		}
	
		return this.gemcutterBurnTime * par1 / this.currentGemItemBurnTime;
    }

    public boolean isCutting(){
    	return this.gemcutterBurnTime > 0;
    }

    public void update(){
		boolean flag = this.gemcutterBurnTime > 0;
		boolean flag1 = false;
	
		if (this.gemcutterBurnTime > 0){
		    --this.gemcutterBurnTime;
		}
	
		if (!this.worldObj.isRemote){
		    if (this.gemcutterBurnTime == 0){
				if(this.canCut()){
				    this.currentGemItemBurnTime = this.gemcutterBurnTime = getItemBurnTime(this.gemcutterItemStacks[1]);
		
				    if (this.gemcutterBurnTime > 0){
						flag1 = true;
			
						if (this.gemcutterItemStacks[1] != null){
						    --this.gemcutterItemStacks[1].stackSize;
			
						    if (this.gemcutterItemStacks[1].stackSize == 0){
						    	this.gemcutterItemStacks[1] = this.gemcutterItemStacks[1].getItem().getContainerItem(gemcutterItemStacks[1]);
						    }
						}
				    }
				}              
		    }
	
		    if (this.isCutting() && this.canCut()){
				++this.gemcutterCookTime;
		
				if (this.gemcutterCookTime == 200){
				    this.gemcutterCookTime = 0;
				    this.cutItem();
				    flag1 = true;
				}
		    }
		    else{
		    	this.gemcutterCookTime = 0;
		    }
	
		    if (flag != this.gemcutterBurnTime > 0){
		    	flag1 = true;                
		    }
	
		    // if(flag1){
			//this.onInventoryChanged();
			BlockGemcutterBench.setState(this.gemcutterBurnTime > 0, this.worldObj, this.getPos());
			//}
		}
    }

    private boolean canCut(){
		if (this.gemcutterItemStacks[0] == null){
		    return false;
		}      
		else if (this.gemcutterItemStacks[2] == null){
		    return false;
		}
		else{
		    ItemStack itemstack = GemcutterRecipes.smelting().getGemcutterSmeltingResult(this.gemcutterItemStacks[0], this.gemcutterItemStacks[2]);
	
		    if (itemstack == null) return false;
		    //if(this.gemcutterItemStacks[0].stackSize < GemcutterRecipes.smelting().getSlot1ReduceAmount(this.gemcutterItemStacks[0]).stackSize) return false;
		    //if(this.gemcutterItemStacks[1].stackSize < GemcutterRecipes.smelting().getSlot2ReduceAmount(this.gemcutterItemStacks[1]).stackSize) return false;
		    if (this.gemcutterItemStacks[3] == null) return true;
		    if (!this.gemcutterItemStacks[3].isItemEqual(itemstack)) return false;
		    int result = gemcutterItemStacks[3].stackSize + itemstack.stackSize;
		    return (result <= getInventoryStackLimit() && result <= itemstack.getMaxStackSize());
		}
    }

    public void cutItem(){
		if (this.canCut()){
		    ItemStack itemstack = GemcutterRecipes.smelting().getGemcutterSmeltingResult(this.gemcutterItemStacks[0], this.gemcutterItemStacks[2]);
	
		    if (this.gemcutterItemStacks[3] == null){
		    	this.gemcutterItemStacks[3] = itemstack.copy();
		    }
		    else if (this.gemcutterItemStacks[3].isItemEqual(itemstack)){
		    	gemcutterItemStacks[3].stackSize += itemstack.stackSize;
		    }
	
		    --this.gemcutterItemStacks[0].stackSize;
		    --this.gemcutterItemStacks[2].stackSize;
		    /*if(GemcutterRecipes.gemcutterSmeltingList1.containsValue(this.gemcutterItemStacks[0]) || GemcutterRecipes.gemcutterSmeltingList1.containsValue(this.gemcutterItemStacks[1]))
	            {
	            	if(GemcutterRecipes.gemcutterSmeltingList2.containsValue(this.gemcutterItemStacks[0]) || GemcutterRecipes.gemcutterSmeltingList2.containsValue(this.gemcutterItemStacks[1]))
	            	{
	                    this.gemcutterItemStacks[0].stackSize -= GemcutterRecipes.smelting().getSlot1ReduceAmount(this.gemcutterItemStacks[0]).stackSize;
	                    this.gemcutterItemStacks[1].stackSize -= GemcutterRecipes.smelting().getSlot2ReduceAmount(this.gemcutterItemStacks[1]).stackSize;
	            	}
	
	            	this.gemcutterItemStacks[0] = null;
	            }
	            else
	            {
	            	this.gemcutterItemStacks[0] = null;
	            }*/
	
		    if (this.gemcutterItemStacks[0].stackSize <= 0){
		    	this.gemcutterItemStacks[0] = null;
		    }
	
		    if (this.gemcutterItemStacks[2].stackSize <= 0){
		    	this.gemcutterItemStacks[2] = null;
		    }
		}
    }

    public static int getItemBurnTime(ItemStack itemStack){
		if (itemStack == null){
		    return 0;
		}
		else{
		    Item i = itemStack.getItem();
		    Item item = itemStack.getItem();
	
		    if (itemStack.getItem() instanceof ItemBlock && i != null){
		    	Block block = Block.getBlockFromItem(i);
		    }
	
		    if (i == SoulItems.Polisher.get()) return 1600;
		    if (i == SoulItems.UraniumLiquid.get()) return 4800;
		    return GameRegistry.getFuelValue(itemStack);
		}
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
		switch (id){
            case 0:
                return this.gemcutterBurnTime;
            case 1:
                return this.currentGemItemBurnTime;
            case 2:
                return this.gemcutterCookTime;
            default:
                return 0;
        }
	}

	@Override
	public void setField(int id, int value) {
		switch (id){
            case 0:
                this.gemcutterBurnTime = value;
                break;
            case 1:
                this.currentGemItemBurnTime = value;
                break;
            case 2:
                this.gemcutterCookTime = value;
                break;
        }
	}

	@Override
	public int getFieldCount() {
		return 3;
	}

	@Override
	public void clear() {		
		 for (int i = 0; i < this.gemcutterItemStacks.length; ++i){
			 this.gemcutterItemStacks[i] = null;
	     }
	}

	@Override
	public IChatComponent getDisplayName() {
		return null;
	}
}