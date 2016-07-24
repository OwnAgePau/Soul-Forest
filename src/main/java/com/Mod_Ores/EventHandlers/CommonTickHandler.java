package com.Mod_Ores.EventHandlers;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

import com.Mod_Ores.Init.InitMaterials;
import com.Mod_Ores.Init.SoulItems;

public class CommonTickHandler{
    private static Minecraft minecraft = Minecraft.getMinecraft();
    private static World theWorld;
    private static EntityPlayer player = minecraft.thePlayer;
    private static int absorption = 22;
    private boolean hasAbsorption;

    public CommonTickHandler(Minecraft mc){
		this.minecraft = mc;
		theWorld = minecraft.theWorld;
    }

    @SubscribeEvent
    public void onPlayerTick(PlayerTickEvent event){		
		this.player = event.player;
	
		if(this.checkPlayerIsWearingSetArmorType(InitMaterials.Bronze_Armor)){
		    // Player is wearing full bronze set
		    player.addPotionEffect(new PotionEffect(Potion.regeneration.getId(), 3, 1));
		    Random random = new Random();				
		    if(random.nextInt(10) == 0){					
		    	
				float f1 = (float)MathHelper.floor_double(player.getCollisionBoundingBox().minY);
				double f2 = (random.nextFloat() * 2.0F - 1.0F) * player.width;
				double f3 = (random.nextFloat() * 2.0F - 1.0F) * player.width;
				player.worldObj.spawnParticle(EnumParticleTypes.WATER_BUBBLE, MathHelper.floor_double(player.posX) + 
						(double)f2, (double)(f1 + 1.5F), MathHelper.floor_double(player.posZ) + (double)f3, 
						player.motionX, player.motionY, player.motionZ, new int[0]);
		    }
		}
		else if(this.checkPlayerIsWearingSetArmorType(InitMaterials.Slime_Armor)){
		    // Player is wearing full slime set
		    player.addPotionEffect(new PotionEffect(Potion.jump.getId(), 5, 4));
		    player.fallDistance = 0.0F;
		}
		else if(this.checkPlayerIsWearingSetArmorType(InitMaterials.Silver_Armor)){
		    // Player is wearing full silver set
		    player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 5, 4));
		}
		else if(this.checkPlayerIsWearingSetArmorType(InitMaterials.Fyrised_Armor)){
		    // Player is wearing full fyrised set
		    player.addPotionEffect(new PotionEffect(Potion.fireResistance.getId(), 5, 4));
		    if(player.isInWater()){
				if(player.getHeldItem() != null){
				    if(!player.getHeldItem().getItem().equals(SoulItems.FrostShard.get())){
				    	player.attackEntityFrom(DamageSource.drown, 1.0F);
				    }
				}
				else{
					player.attackEntityFrom(DamageSource.drown, 1.0F);
				}
		    }
		}
    }

    private boolean checkPlayerIsWearingSetArmorType(ArmorMaterial mat){
		for(int index = 0; index < 4; index++){
		    if(player.getCurrentArmor(index) != null){
				ItemArmor armor = (ItemArmor)player.getCurrentArmor(index).getItem();
				if(!armor.getArmorMaterial().equals(mat)){
				    return false;
				}
		    }
		    else{
		    	return false;
		    }
		}
		return true;
    }
}