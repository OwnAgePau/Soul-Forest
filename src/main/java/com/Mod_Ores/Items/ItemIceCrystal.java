package com.Mod_Ores.Items;

import java.util.List;

import org.lwjgl.input.Keyboard;

import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.Mod_Ores.SoulForestKeyHandler;
import com.Mod_Ores.soul_forest;
import com.Mod_Ores.Init.SoulBlocks;
import com.Mod_Ores.Mobs.Entity.EntityIceQueen;
import com.Mod_Ores.Mobs.Entity.EntityKingKotek;

public class ItemIceCrystal extends Item{	
	
    private boolean hasSpawn = false;

    public final String textureName;
    
    public String getName(){
    	return this.textureName;
    }
    
    /**
     * Item Constructor
     * @param Unlname This is the Unlocalized Name
     */
    public ItemIceCrystal(String Unlname){
		super();
		this.setCreativeTab(soul_forest.tabSoulOther);
		this.setUnlocalizedName(soul_forest.MODID + "_" + Unlname);
		this.textureName = Unlname;
		GameRegistry.registerItem(this, Unlname);
		this.maxStackSize = 1;
		this.setMaxDamage(1);
		hasSpawn = false;
    }

    @Override
    public EnumRarity getRarity(ItemStack par1ItemStack){
    	return EnumRarity.EPIC;
    }

    @Override
    public boolean hasEffect(ItemStack par1ItemStack) {
	return true;
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, 
    		float hitX, float hitY, float hitZ) {		
		if(!worldIn.isRemote){
		    boolean spawned = false;
		    if(this.checkAreaForAltar(worldIn, pos)){
				EntityIceQueen entityKingKotek = new EntityIceQueen(worldIn);
				entityKingKotek.copyLocationAndAnglesFrom(playerIn);
				entityKingKotek.onInitialSpawn(worldIn.getDifficultyForLocation(pos), (IEntityLivingData)null);
				spawned = worldIn.spawnEntityInWorld(entityKingKotek);
				playerIn.addChatMessage(new ChatComponentText("\u00A73You have summoned The Ice Queen!"));
				stack.damageItem(2, playerIn);
		    }
		    else{
		    	playerIn.addChatMessage(new ChatComponentText("\u00A74The structure is incomplete!"));
		    }
		    return spawned;
		}
		else{		
		    return false;
		}
    }

    private boolean checkAreaForAltar(World par3World, BlockPos pos){
		int width = 5;
		int pillarHeight = 3;
		if(par3World.getBlockState(pos).getBlock() != SoulBlocks.AquamarineBlock.get()){
		    return false;
		}
		for(int x = 0; x < width; x++){
		    for(int z = 0; z < width; z++){
				if(x != 2 && z != 2){
				    if(par3World.getBlockState(new BlockPos(pos.getX() + x - 2, pos.getY(), pos.getZ() + z - 2)).getBlock() != SoulBlocks.IceBrick.get()){
				    	return false;
				    }
				}
		    }
		}
		for(int y = 1; y < pillarHeight; y++){
		    if(par3World.getBlockState(new BlockPos(pos.getX() - 2, pos.getY() + y, pos.getZ() - 2)).getBlock() != SoulBlocks.IceBrick.get()){
		    	return false;
		    }
		    if(par3World.getBlockState(new BlockPos(pos.getX() + 2, pos.getY() + y, pos.getZ() - 2)).getBlock() != SoulBlocks.IceBrick.get()){
		    	return false;
		    }
		    if(par3World.getBlockState(new BlockPos(pos.getX() - 2, pos.getY() + y, pos.getZ() + 2)).getBlock() != SoulBlocks.IceBrick.get()){
		    	return false;
		    }
		    if(par3World.getBlockState(new BlockPos(pos.getX() + 2, pos.getY() + y, pos.getZ() + 2)).getBlock() != SoulBlocks.IceBrick.get()){
		    	return false;
		    }
		}
		if(par3World.getBlockState(new BlockPos(pos.getX() - 2, pos.getY() + pillarHeight, pos.getZ() - 2)).getBlock() != SoulBlocks.AmazoniteBlock.get()){
		    return false;
		}
		if(par3World.getBlockState(new BlockPos(pos.getX() - 2, pos.getY() + pillarHeight, pos.getZ() + 2)).getBlock() != SoulBlocks.AmazoniteBlock.get()){
		    return false;
		}
		if(par3World.getBlockState(new BlockPos(pos.getX() + 2, pos.getY() + pillarHeight, pos.getZ() - 2)).getBlock() != SoulBlocks.AmazoniteBlock.get()){
		    return false;
		}
		if(par3World.getBlockState(new BlockPos(pos.getX() + 2, pos.getY() + pillarHeight, pos.getZ() + 2)).getBlock() != SoulBlocks.AmazoniteBlock.get()){
		    return false;
		}
		return true;
    }

    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		int uses = this.getMaxDamage();
		par3List.add("\u00A73Max Uses : " + uses);
		if(SoulForestKeyHandler.isKeyPressed){
		    par3List.add("Be sure to build an altar for your queen, ");
		    par3List.add("so she might have mercy on your soul!");
		}
		else{
		    par3List.add("Press " + Keyboard.getKeyName(SoulForestKeyHandler.keyValues[SoulForestKeyHandler.CUSTOM_INV]) + " to show more details.");
		}
    }
}