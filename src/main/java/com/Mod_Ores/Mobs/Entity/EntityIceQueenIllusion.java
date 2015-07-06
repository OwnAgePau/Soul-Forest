package com.Mod_Ores.Mobs.Entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAICreeperSwell;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import com.Mod_Ores.Init.SoulItems;
import com.Mod_Ores.Init.Config.SoulConfigCreatures;
import com.Mod_Ores.Mobs.AI.EntityAIPlaceWall;
import com.Mod_Ores.Mobs.AI.EntityAITeleport;

public class EntityIceQueenIllusion extends EntityMob{
    
    public EntityIceQueenIllusion(World par1World){
	super(par1World);
	this.setCustomNameTag(this.getCommandSenderName());
	this.tasks.addTask(0, new EntityAITeleport(this, EntityPlayer.class));
	this.tasks.addTask(2, new EntityAIWander(this, 0.2F));
	this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
    }

    @Override
    public String getCommandSenderName() {
	return "Ice Queen";
    }

    /**
     * Gets how bright this entity is.
     */
    public float getBrightness(float par1){
	return 4.0F;
    }

    /**
     * Returns true if the newer Entity AI code should be run
     */
    public boolean isAIEnabled(){
	return true;
    }

    // Set max health and attack damage
    @Override
    protected void applyEntityAttributes(){
	super.applyEntityAttributes();
	this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(SoulConfigCreatures.iceQueenHealth);
	this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(SoulConfigCreatures.iceQueenDamage);
    }

    public boolean attackEntityAsMob(Entity par1Entity){
	return true;
    }

    /**
     * Returns the item ID for the item the mob drops on death.
     */
    @Override
    protected Item getDropItem(){
	return SoulItems.FrostShard.get();
    }

    @Override
    public void onKillEntity(EntityLivingBase par1EntityLivingBase){
	super.onKillEntity(par1EntityLivingBase);
	this.dropRareDrop(2);
    }

    @Override
    protected void dropRareDrop(int par1){
	switch (this.rand.nextInt(2))
	{
	case 0:
	    this.dropItem(SoulItems.FrozenRod.get(), 3);
	    break;
	case 1:
	    this.dropItem(SoulItems.FrostShard.get(), 2);
	    break;
	}
    } 
    
    @Override
    public boolean attackEntityFrom(DamageSource source, float damage) {
        if (this.isEntityInvulnerable()){
            return false;
        }
        else if (super.attackEntityFrom(source, damage)){
            Entity entity = source.getEntity();
            if(entity instanceof EntityPlayer){
        	EntityPlayer player = (EntityPlayer)entity;
        	player.attackEntityFrom(DamageSource.causeMobDamage(this), (float)this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getBaseValue() / 1.2F);
        	player.addPotionEffect(new PotionEffect(Potion.blindness.getId(), 100, 2));
        	this.setDead();
        	return true;
            }
        }
        return false;
    }
}
