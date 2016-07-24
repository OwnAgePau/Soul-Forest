package com.Mod_Ores.Mobs.Entity;

import java.util.Random;

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
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;

import com.Mod_Ores.Init.SoulItems;
import com.Mod_Ores.Init.Config.SoulConfigCreatures;

public class EntitySnowCreeper extends EntityCreeper{
    /**
     * Time when this creeper was last in an active state (Messed up code here, probably causes creeper animation to go
     * weird)
     */
    private int lastActiveTime;

    /**
     * The amount of time since the creeper was close enough to the player to ignite
     */
    private int timeSinceIgnited;
    private int fuseTime = 1;

    /** Explosion radius for this creeper. */
    private int explosionRadius = 30;

    public EntitySnowCreeper(World par1World){
		super(par1World);
		this.fuseTime = 1;
		this.explosionRadius = 50;
		this.setCustomNameTag(this.getCommandSenderName());
		//this.texture = "/mob/SnowCreeper.png";
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAICreeperSwell(this));
		this.tasks.addTask(3, new EntityAIAvoidEntity(this, EntityOcelot.class, 6.0F, 0.25F, 0.3F));
		this.tasks.addTask(4, new EntityAIAttackOnCollide(this, 0.50F, false));
		this.tasks.addTask(5, new EntityAIWander(this, 0.2F));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
		this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, false));
    }

    public String getCommandSenderName() {
    	return "Exclos";
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
		// Max Health - default 20.0D - min 0.0D - max Double.MAX_VALUE
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(SoulConfigCreatures.exclosHealth);
		// Attack Damage - default 2.0D - min 0.0D - max Doubt.MAX_VALUE
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(SoulConfigCreatures.exclosDamage);
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
    protected void dropFewItems(boolean par1, int par2){
		Random r = new Random();
		this.dropItem(SoulItems.FrostShard.get(), r.nextInt(3) + 1);
		this.dropItem(SoulItems.Soul.get(), r.nextInt(2) + 1);
    }

    @Override
    public void onKillEntity(EntityLivingBase par1EntityLivingBase){
		super.onKillEntity(par1EntityLivingBase);
		this.dropRareDrop(2);
    }

    protected void dropRareDrop(int par1){
		switch (this.rand.nextInt(2)){
		case 0:
		    this.dropItem(SoulItems.FrozenRod.get(), 3);
		    break;
		case 1:
		    this.dropItem(SoulItems.FrostShard.get(), 2);
		    break;
		}
    }
}