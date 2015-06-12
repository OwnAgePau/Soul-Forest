package com.Mod_Ores.EventHandlers;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

import com.Mod_Ores.Init.SoulItems;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;
import cpw.mods.fml.relauncher.Side;

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
	
	// TO DO : Rewrite
	
	if(player.getCurrentArmor(0) != null && 
		player.getCurrentArmor(1) != null && 
		player.getCurrentArmor(2) != null && 
		player.getCurrentArmor(3) != null){
	    if (player.getCurrentArmor(0).getItem().equals(SoulItems.SlimeBoots.get()) && 
		    player.getCurrentArmor(1).getItem().equals(SoulItems.SlimeLeggings.get()) && 
		    player.getCurrentArmor(2).getItem().equals(SoulItems.SlimeChestplate.get()) && 
		    player.getCurrentArmor(3).getItem().equals(SoulItems.SlimeHelmet.get())){
		player.addPotionEffect(new PotionEffect(Potion.jump.getId(), 5, 4));
		//player.addPotionEffect(new PotionEffect(soul_forest.lavaImmunity.getId(), 5, 4));
		player.fallDistance = 0.0F;
	    }
	    else if (player.getCurrentArmor(0).getItem().equals(SoulItems.SilverBoots.get()) && 
		    player.getCurrentArmor(1).getItem().equals(SoulItems.SilverLeggings.get()) && 
		    player.getCurrentArmor(2).getItem().equals(SoulItems.SilverChestplate.get()) && 
		    player.getCurrentArmor(3).getItem().equals(SoulItems.SilverHelmet.get())){
		player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 5, 4));
		if (player.motionY > 0.0D){
		    //player.motionY += 0.166999999105930325D; //Change this value to how high you want the player to jump
		    //player.speedInAir = 0.0334999996F; //Change this value to set the speed while in air
		}
		this.hasAbsorption = false;
	    }
	    else if (player.getCurrentArmor(0).getItem().equals(SoulItems.MithrilBoots.get()) && 
		    player.getCurrentArmor(1).getItem().equals(SoulItems.MithrilLeggings.get()) && 
		    player.getCurrentArmor(2).getItem().equals(SoulItems.MithrilChestplate.get()) && 
		    player.getCurrentArmor(3).getItem().equals(SoulItems.MithrilHelmet.get())){		
		player.addPotionEffect(new PotionEffect(Potion.fireResistance.getId(), 5, 4));
		if(this.hasAbsorption){
		    //player.addPotionEffect(new PotionEffect(absorption, 5, 2));
		}

		this.hasAbsorption = true;
		if(player.getHeldItem() != null){
		    if(player.isInWater() && !player.getHeldItem().getItem().equals(SoulItems.FrostShard.get())){
			//player.addPotionEffect(new PotionEffect(Potion.harm.getId(), 3, 0));
			player.attackEntityFrom(DamageSource.drown, 1.0F);
		    }
		}
		else{
		    if(player.isInWater()){
			//player.addPotionEffect(new PotionEffect(Potion.harm.getId(), 3, 0));
			player.attackEntityFrom(DamageSource.drown, 1.0F);
		    }
		}
	    }
	    else if (player.getCurrentArmor(0).getItem().equals(SoulItems.BronzeBoots.get()) && 
		    player.getCurrentArmor(1).getItem().equals(SoulItems.BronzeLeggings.get()) && 
		    player.getCurrentArmor(2).getItem().equals(SoulItems.BronzeChestplate.get()) && 
		    player.getCurrentArmor(3).getItem().equals(SoulItems.BronzeHelmet.get())){		
		player.addPotionEffect(new PotionEffect(Potion.regeneration.getId(), 3, 1));
		if(this.hasAbsorption){
		    //player.addPotionEffect(new PotionEffect(absorption, 5, 1));
		}
		this.hasAbsorption = true;

		Random random = new Random();				
		if(random.nextInt(10) == 0){					
		    float f1 = (float)MathHelper.floor_double(player.boundingBox.minY);

		    double f2 = (random.nextFloat() * 2.0F - 1.0F) * player.width;
		    double f3 = (random.nextFloat() * 2.0F - 1.0F) * player.width;
		    player.worldObj.spawnParticle("bubble", MathHelper.floor_double(player.posX) + (double)f2, (double)(f1 + 1.5F), MathHelper.floor_double(player.posZ) + (double)f3, player.motionX, player.motionY, player.motionZ);
		    //this.mc.effectRenderer.addEffect(new EntityCrit2FX(this.mc.theWorld, player));
		}
	    }
	    else{
		this.hasAbsorption = false;
	    }
	}
	else{
	    this.hasAbsorption = false;
	}
    }
}