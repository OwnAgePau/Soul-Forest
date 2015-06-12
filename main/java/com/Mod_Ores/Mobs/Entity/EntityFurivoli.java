package com.Mod_Ores.Mobs.Entity;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.Mod_Ores.Init.SoulItems;
import com.Mod_Ores.Init.Config.SoulConfigCreatures;
import com.Mod_Ores.Items.Entity.EntitySmallSoulFireball;

public class EntityFurivoli extends EntityMob implements IRangedAttackMob{
    // Entity, MovementSpeed, i think range, time between attacks
    private EntityAIArrowAttack aiArrowAttack = new EntityAIArrowAttack(this, 1.0D, 10, 10, 960.0F);
    private EntityAIAttackOnCollide aiAttackOnCollide = new EntityAIAttackOnCollide(this, EntityPlayer.class, 0.31F, false);
    private int field_70846_g;

    private double moveSpeed;

    public EntityFurivoli(World par1World){
	super(par1World);
	// this.texture = "/mob/furivoli.png";
	this.moveSpeed = 2;
	this.isImmuneToFire = true;
	this.setCustomNameTag(this.getCommandSenderName());
	this.tasks.addTask(5, new EntityAIWander(this, 0.0D));
	this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 16.0F));
	this.tasks.addTask(6, new EntityAILookIdle(this));
	this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
	this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 100, true));
	//this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 30, true));
    }

    @Override
    public String getCommandSenderName() {
	return "Furivoli";
    }

    protected void entityInit(){
	super.entityInit();
	this.dataWatcher.addObject(16, new Byte((byte)0));
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
	this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(SoulConfigCreatures.furivoliHealth);
	this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(SoulConfigCreatures.furivoliKnockback);
	this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(SoulConfigCreatures.furivoliDamage);
	this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.0D);
    }

    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound(){
	return "mob.blaze.breathe";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound(){
	return "mob.blaze.hit";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound(){
	return "mob.blaze.death";
    }

    /**
     * Returns the amount of damage a mob should deal.
     */
    public int getAttackStrength(Entity par1Entity){
	return 6;
    }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    @Override
    public void onLivingUpdate(){
	this.tasks.addTask(4, this.aiArrowAttack);

	if (this.rand.nextInt(40) == 0){
	    this.worldObj.playSoundEffect(this.posX + 0.5D, this.posY + 0.5D, this.posZ + 0.5D, "fire.fire", 1.0F + this.rand.nextFloat(), this.rand.nextFloat() * 0.7F + 0.3F);
	}

	/*if (this.rand.nextInt(10) == 0)
        {
	        for (int i = 0; i < 1; ++i)
	        {
	            this.worldObj.spawnParticle("largesmoke", this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, 0.0D, 0.0D, 0.0D);
	        }
        }*/

	super.onLivingUpdate();
    }

    /**
     * Returns the item ID for the item the mob drops on death.
     */
    @Override
    protected Item getDropItem(){
	return SoulItems.BurnedShard.get();
    }

    /**
     * Attack the specified entity using a ranged attack.
     */
    @Override
    public void attackEntityWithRangedAttack(EntityLivingBase p_82196_1_, float p_82196_2_){
	double d0 = p_82196_1_.posX - this.posX;
	double d1 = p_82196_1_.boundingBox.minY + (double)(p_82196_1_.height / 2.0F) - (this.posY + (double)(this.height / 2.0F));
	double d2 = p_82196_1_.posZ - this.posZ;
	float f1 = MathHelper.sqrt_float(p_82196_2_) * 0.5F;
	/* EntityArrow entityarrow = new EntityArrow(this.worldObj, this, p_82196_1_, 1.6F, (float)(14 - this.worldObj.difficultySetting.getDifficultyId() * 4));
        int i = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, this.getHeldItem());
        int j = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, this.getHeldItem());
        entityarrow.setDamage((double)(p_82196_2_ * 2.0F) + this.rand.nextGaussian() * 0.25D + (double)((float)this.worldObj.difficultySetting.getDifficultyId() * 0.11F));

        if (i > 0)
        {
            entityarrow.setDamage(entityarrow.getDamage() + (double)i * 0.5D + 0.5D);
        }

        if (j > 0)
        {
            entityarrow.setKnockbackStrength(j);
        }*/

	//if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, this.getHeldItem()) > 0 || this.getSkeletonType() == 1)
	//{
	//    entityarrow.setFire(100);
	//}
	this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1009, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
	for (int i2 = 0; i2 < 1; ++i2)
	{
	    EntitySmallSoulFireball entitysmallfireball = new EntitySmallSoulFireball(this.worldObj, this, d0 + this.rand.nextGaussian() * (double)f1, d1, d2 + this.rand.nextGaussian() * (double)f1);
	    entitysmallfireball.posY = this.posY + (double)(this.height / 2.0F) + 0.5D;
	    this.worldObj.spawnEntityInWorld(entitysmallfireball);
	}
	//this.playSound("random.bow", 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
	// this.worldObj.spawnEntityInWorld(entityarrow);
    }
}
