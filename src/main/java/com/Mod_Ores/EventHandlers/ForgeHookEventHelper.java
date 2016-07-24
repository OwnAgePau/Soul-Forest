package com.Mod_Ores.EventHandlers;

import java.util.List;
import java.util.Random;
import java.util.Set;

import net.minecraft.block.state.IBlockState;
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
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.world.Explosion;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.world.ExplosionEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import com.Mod_Ores.soul_forest;
import com.Mod_Ores.Init.InitAchievements;
import com.Mod_Ores.Init.SoulItems;
import com.Mod_Ores.Mobs.Entity.EntityIceQueen;

public class ForgeHookEventHelper {

    @SubscribeEvent
    public void entityAttacked(LivingAttackEvent event){
		if(event.entityLiving.worldObj.isRemote){
		    boolean itemIsSword;
		    if(!(event.entityLiving instanceof EntityPlayer)){
				EntityLiving attackedEnt = (EntityLiving) event.entityLiving;
				DamageSource attackSource = event.source;
				Entity player = event.source.getEntity();
		
				if(player instanceof EntityPlayer){
				    EntityPlayer thePlayer = (EntityPlayer)player;
				    ItemStack item = null;
				    if(thePlayer.getHeldItem() != null){
						item = thePlayer.getHeldItem();
						if(item.getItem() instanceof ItemSword){
						    itemIsSword =  true;
						}
						Item.itemRegistry.getObject(new ResourceLocation("diamond_sword"));
						if(item.equals(Item.itemRegistry.getObject(new ResourceLocation("diamond_sword"))) || item.equals(Item.itemRegistry.getObject(new ResourceLocation("diamond_sword"))) || item.equals(Item.itemRegistry.getObject(new ResourceLocation("diamond_sword"))) || item.equals(Item.itemRegistry.getObject(new ResourceLocation("diamond_sword"))) || item.equals(Item.itemRegistry.getObject(new ResourceLocation("diamond_sword")))){
						    itemIsSword = true;
						}
						else if(item.equals(SoulItems.AquamarineSword.get()) || item.equals(SoulItems.BronzeSword.get()) || item.equals(SoulItems.ChromiteSword.get()) || item.equals(SoulItems.CobaltSword.get()) || item.equals(SoulItems.FyrisedSword.get()) || item.equals(SoulItems.SilverSword.get()) || item.equals(SoulItems.SteelSword.get()) || item.equals(SoulItems.TanzaniteSword.get())){
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
												attackedEnt.worldObj.setBlockState(new BlockPos(z, k, l), Blocks.snow.getDefaultState());
										    }
										}
								    }
								}
						    }
						}
						if(item.getItem().equals(SoulItems.AquamarineSword.get())){
						    Random rand = new Random();	
						    for (int i = 0; i < 8; ++i){
								float f = rand.nextFloat() - rand.nextFloat();
								float f1 = rand.nextFloat() - rand.nextFloat() + 2f;
								float f2 = rand.nextFloat() - rand.nextFloat();
								attackedEnt.worldObj.spawnParticle(EnumParticleTypes.WATER_BUBBLE, attackedEnt.posX + (double)f, attackedEnt.posY + (double)f1, attackedEnt.posZ + (double)f2, attackedEnt.motionX, attackedEnt.motionY, attackedEnt.motionZ, new int[0]);
						    }
						    //attackedEnt.worldObj.spawnParticle("bubble", vec31.xCoord, vec31.yCoord, vec31.zCoord, vec3.xCoord, vec3.yCoord + 0.05D, vec3.zCoord);
						}
				    }
				}
		    }
		}
    }

    @SubscribeEvent
    public void entityHurt(LivingHurtEvent event){
		if(!event.entity.worldObj.isRemote){
		    Entity attacker = event.source.getEntity();
		    if(attacker instanceof EntityPlayer){
				EntityPlayer player = (EntityPlayer)attacker;
				// Increase the damage done by the player by 50% against other mobs
				if(this.checkPlayerHasAmulet(player, SoulItems.BlackdiamondAmuletRing.get())){
				    float bonusDamage = event.ammount / 2;
				    event.ammount += bonusDamage;
				}
			}
			if(!(attacker instanceof EntityPlayer)){
				Entity attacked = event.entityLiving;
				if(attacked instanceof EntityPlayer){
				    EntityPlayer player = (EntityPlayer)attacked;
				    // Decrease the damage done to the player by other mobs with 33,333%;
				    if(this.checkPlayerHasAmulet(player, SoulItems.OlivineAmuletRing.get()) || this.checkPlayerHasAmulet(player, SoulItems.TurquoiseAmuletRing.get())){
						float protectedDamage = event.ammount / 3F;
						event.ammount -= protectedDamage;
				    }
				}
		    }
		}
    }

    // Check the player's hotbar for an amulet, could also be used to check for any other item
    private boolean checkPlayerHasAmulet(EntityPlayer player, Item amulet){
		ItemStack[] inventoryPlayer = player.inventory.mainInventory;
		for(int i = 0; i < inventoryPlayer.length;i++){
		    ItemStack stack = inventoryPlayer[i];
		    if(stack != null){
				if(stack.stackSize > 0){
				    Item item = stack.getItem();
				    // Check if the amulet is in your hotbar
				    if(item.equals(amulet) && i < 9){
						item.setDamage(stack, item.getDamage(stack) + 1);
						return true;
				    }
				}
		    }
		}
		return true;
    }

    @SubscribeEvent
    public void onEntityUpdate(LivingUpdateEvent event) {
		// Potion effect that spawns zombies, custom potion test
		if(!event.entityLiving.worldObj.isRemote){
		    if (event.entityLiving.isPotionActive(soul_forest.lavaImmunity)) {
				if (event.entityLiving.worldObj.rand.nextInt(500) == 0) {
				    EntityZombie entityzombie = new EntityZombie(event.entityLiving.worldObj);
				    entityzombie.copyLocationAndAnglesFrom(event.entityLiving);
				    //entityzombie.onSpawnWithEgg((IEntityLivingData)null);
				    // TODO not sure if works
				    entityzombie.onInitialSpawn(event.entityLiving.worldObj.getDifficultyForLocation(new BlockPos(entityzombie)), (IEntityLivingData)null);
				    event.entityLiving.worldObj.spawnEntityInWorld(entityzombie);
				}
		    }
		}
    }

    @SubscribeEvent
    public void onExplosionStart(ExplosionEvent.Detonate event){
		// Make the explosions by the Ice Queen slow the player.
		Explosion explosion = event.explosion;
		if(explosion.getExplosivePlacedBy() instanceof EntityIceQueen){
		    EntityIceQueen queen = (EntityIceQueen)explosion.getExplosivePlacedBy();
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
		// Check if the player killed the ice queen, and give the player the achievement.
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
