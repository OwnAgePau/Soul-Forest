package com.Mod_Ores.EventHandlers;

import java.util.List;
import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.Explosion;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.world.ExplosionEvent;

import com.Mod_Ores.soul_forest;
import com.Mod_Ores.Init.InitAchievements;
import com.Mod_Ores.Init.SoulItems;
import com.Mod_Ores.Mobs.Entity.EntityIceQueen;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ForgeHookEventHelper {

    @SubscribeEvent
    public void entityAttacked(LivingAttackEvent event){
	boolean itemIsSword;

	if(!(event.entityLiving instanceof EntityPlayer)){
	    EntityLiving attackedEnt = (EntityLiving) event.entityLiving;
	    DamageSource attackSource = event.source;
	    Entity player = event.source.getEntity();

	    if(player instanceof EntityPlayer){
		if(((EntityPlayer)player).getHeldItem() != null){
		    ItemStack item = ((EntityPlayer)player).getHeldItem();
		    //System.out.println(item.getDisplayName());
		    if(item.getItem() instanceof ItemSword){
			itemIsSword =  true;
		    }
		    if(item.equals(Item.itemRegistry.getObject("diamond_sword")) || item.equals(Item.itemRegistry.getObject("gold_sword")) || item.equals(Item.itemRegistry.getObject("iron_sword")) || item.equals(Item.itemRegistry.getObject("stone_sword")) || item.equals(Item.itemRegistry.getObject("wood_sword"))){
			itemIsSword = true;
		    }
		    else if(item.equals(SoulItems.AquamarineSword.get()) || item.equals(SoulItems.BronzeSword.get()) || item.equals(SoulItems.ChromiteSword.get()) || item.equals(SoulItems.CobaltSword.get()) || item.equals(SoulItems.MithrilSword.get()) || item.equals(SoulItems.SilverSword.get()) || item.equals(SoulItems.SteelSword.get()) || item.equals(SoulItems.TanzaniteSword.get())){
			itemIsSword = true;
		    }
		    else{
			itemIsSword = false;
		    }

		    if(itemIsSword){
			NBTTagList enchTag = item.getEnchantmentTagList();					
			if (enchTag != null){
			    for (int j = 0; j < enchTag.tagCount(); ++j){
				short id = ((NBTTagCompound)enchTag.getCompoundTagAt(j)).getShort("id");
				short lvl = ((NBTTagCompound)enchTag.getCompoundTagAt(j)).getShort("lvl");
				int effectid = soul_forest.enchantmentFrost.effectId;
				if (id == effectid){
				    if(attackedEnt != null){
					attackedEnt.addPotionEffect(new PotionEffect(Potion.moveSlowdown.getId(), 30, lvl));

					int x = MathHelper.floor_double(attackedEnt.posX);
					int z = MathHelper.floor_double(attackedEnt.posZ);
					for (x = 0; x < 4; ++x){
					    z = MathHelper.floor_double(attackedEnt.posX + (double)((float)(x % 2 * 2 - 1) * 0.25F));
					    int k = MathHelper.floor_double(attackedEnt.posY);
					    int l = MathHelper.floor_double(attackedEnt.posZ + (double)((float)(x / 2 % 2 * 2 - 1) * 0.25F));
					    attackedEnt.worldObj.setBlock(z, k, l, Blocks.snow);
					}
				    }
				}
			    }
			}
		    }

		    if(item.equals(SoulItems.AquamarineSword.get()))
		    {
			System.out.println(attackedEnt.getCommandSenderName());
			System.out.println(attackSource.getDamageType());
			Random random = new Random();	
			Vec3 vec3 = Vec3.createVectorHelper(((double)random.nextFloat() - 0.5D) * 0.1D, Math.random() * 0.1D + 0.1D, 0.0D);
			vec3.rotateAroundX(-player.rotationPitch * (float)Math.PI / 180.0F);
			vec3.rotateAroundY(-player.rotationYaw * (float)Math.PI / 180.0F);
			Vec3 vec31 = Vec3.createVectorHelper(((double)random.nextFloat() - 0.5D) * 0.3D, (double)(-random.nextFloat()) * 0.6D - 0.3D, 0.6D);
			vec31.rotateAroundX(-player.rotationPitch * (float)Math.PI / 180.0F);
			vec31.rotateAroundY(-player.rotationYaw * (float)Math.PI / 180.0F);
			vec31 = vec31.addVector(player.posX, player.posY + (double)player.getEyeHeight(), player.posZ);

			player.worldObj.spawnParticle("bubble", vec31.xCoord, vec31.yCoord, vec31.zCoord, vec3.xCoord, vec3.yCoord + 0.05D, vec3.zCoord);

			//float f1 = (float)MathHelper.floor_double(player.boundingBox.minY);


			//double f2 = (random.nextFloat() * 2.0F - 1.0F) * player.width;
			//double f3 = (random.nextFloat() * 2.0F - 1.0F) * player.width;
			//player.worldObj.spawnParticle("bubble", MathHelper.floor_double(player.posX) + (double)f2, (double)(f1 + 1.5F), MathHelper.floor_double(player.posZ) + (double)f3, player.motionX, player.motionY, player.motionZ);
			//attackedEnt.worldObj.spawnParticle("bubble", d0, d1, d2, f0, 0.0D, f1);
			//attackedEnt.worldObj.spawnParticle("splash", d0, d1, d2, f0, 0.0D, f1);
			//attackedEnt.worldObj.spawnParticle("splash", d0, d1, d2, f0, 0.0D, f1);
			System.out.println("[Soul Forest] Blub");
		    }
		}
	    }
	}
    }

    @SubscribeEvent
    public void onEntityUpdate(LivingUpdateEvent event) {
	//entityLiving in fact refers to EntityLivingBase so to understand everything about this part go to EntityLivingBase instead
	if(!event.entityLiving.worldObj.isRemote){
	    if (event.entityLiving.isPotionActive(soul_forest.lavaImmunity)) {
		if (event.entityLiving.worldObj.rand.nextInt(500) == 0) {
		    EntityZombie entityzombie = new EntityZombie(event.entityLiving.worldObj);
		    entityzombie.copyLocationAndAnglesFrom(event.entityLiving);
		    entityzombie.onSpawnWithEgg((IEntityLivingData)null);

		    event.entityLiving.worldObj.spawnEntityInWorld(entityzombie);
		}
	    }
	}
    }

    @SubscribeEvent
    public void onExplosionStart(ExplosionEvent.Detonate event){
	Explosion explosion = event.explosion;
	if(explosion.exploder instanceof EntityIceQueen){
	    EntityIceQueen queen = (EntityIceQueen)explosion.exploder;
	    List<Entity> entitiesHit = event.getAffectedEntities();
	    for(Entity entity : entitiesHit){
		if(entity instanceof EntityPlayer){
		    EntityPlayer player = (EntityPlayer)entity;
		    player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.getId(), 300, 2));
		    player.attackEntityFrom(DamageSource.setExplosionSource(explosion), (float)queen.getEntityAttribute(SharedMonsterAttributes.attackDamage).getBaseValue() / 2);
		}
	    }
	}
    }

    @SubscribeEvent
    public void onEntityDeath(LivingDeathEvent event){
	if(!event.entityLiving.worldObj.isRemote){
	    EntityPlayer player = null;
	    DamageSource source = event.source;
	    if(source.getEntity() instanceof EntityPlayerMP){
		player = (EntityPlayer)source.getEntity();
	    }
	    if(player != null){
		EntityLivingBase entity = event.entityLiving;
		if(entity instanceof EntityIceQueen){
		    player.addStat(InitAchievements.iceQueen, 1);
		}
	    }
	}
    }
}
