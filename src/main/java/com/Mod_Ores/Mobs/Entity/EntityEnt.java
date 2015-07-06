package com.Mod_Ores.Mobs.Entity;

import java.util.Calendar;
import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.Mod_Ores.Init.SoulItems;
import com.Mod_Ores.Init.Config.SoulConfigCreatures;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityEnt extends EntityMob{
    /**
     * Ticker used to determine the time remaining for this zombie to convert into a villager when cured.
     */
    private int conversionTime = 0;
    public int health = SoulConfigCreatures.yetiHealth;

    private double moveSpeed;

    public EntityEnt(World par1World){
	super(par1World);
	this.moveSpeed = SoulConfigCreatures.yetiMovement;
	this.setCustomNameTag(this.getCommandSenderName());
	this.getNavigator().setBreakDoors(true);
	this.tasks.addTask(0, new EntityAISwimming(this));
	this.tasks.addTask(1, new EntityAIBreakDoor(this));
	this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, this.moveSpeed, false));
	this.tasks.addTask(3, new EntityAIAttackOnCollide(this, EntityVillager.class, this.moveSpeed, true));
	this.tasks.addTask(4, new EntityAIMoveTowardsRestriction(this, this.moveSpeed));
	this.tasks.addTask(5, new EntityAIMoveThroughVillage(this, this.moveSpeed, false));
	this.tasks.addTask(6, new EntityAIWander(this, this.moveSpeed));
	this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
	this.tasks.addTask(7, new EntityAILookIdle(this));
	this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
	this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 16, true));
	this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityVillager.class, 16, false));
    }

    @Override
    protected void applyEntityAttributes() {
	super.applyEntityAttributes();
	// Max Health - default 20.0D - min 0.0D - max Double.MAX_VALUE
	this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(SoulConfigCreatures.yetiHealth);
	// Attack Damage - default 2.0D - min 0.0D - max Doubt.MAX_VALUE
	this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(SoulConfigCreatures.yetiDamage);

    }

    @Override
    public String getCommandSenderName() {
	return "Yeti";
    }

    /**
     * This method returns a value to be applied directly to entity speed, this factor is less than 1 when a slowdown
     * potion effect is applied, more than 1 when a haste potion effect is applied and 2 for fleeing entities.
     */
    public float getSpeedModifier(){
	return 0;
    }

    @SideOnly(Side.CLIENT)

    /**
     * Returns the texture's file path as a String.
     */
    public String getTexture(){
	return "/mob/SoulYeti.png";
    }

    /**
     * Returns the current armor value as determined by a call to InventoryPlayer.getTotalArmorValue
     */
    public int getTotalArmorValue(){
	int i = super.getTotalArmorValue() + 3;
	if (i > 20){
	    i = 20;
	}
	return i;
    }

    /**
     * Returns true if the newer Entity AI code should be run
     */
    protected boolean isAIEnabled(){
	return true;
    }

    @Override
    public void onLivingUpdate(){
	if (this.worldObj.isDaytime() && !this.worldObj.isRemote && !this.isChild()){
	    float f = this.getBrightness(1.0F);

	    ItemStack itemstack = this.getEquipmentInSlot(4);

	    if (itemstack != null){
		if (itemstack.isItemStackDamageable()){
		    itemstack.setItemDamage(itemstack.getItemDamageForDisplay() + this.rand.nextInt(2));

		    if (itemstack.getItemDamageForDisplay() >= itemstack.getMaxDamage()){
			this.renderBrokenItemStack(itemstack);
			this.setCurrentItemOrArmor(4, (ItemStack)null);
		    }
		}
	    }
	}
	super.onLivingUpdate();
    }

    @Override
    public IEntityLivingData onSpawnWithEgg(IEntityLivingData par1EntityLivingData){
	par1EntityLivingData = super.onSpawnWithEgg(par1EntityLivingData);
	float f = this.worldObj.func_147462_b(this.posX, this.posY, this.posZ);
	this.setCanPickUpLoot(this.rand.nextFloat() < 0.55F * f);

	this.addRandomArmor();
	this.enchantEquipment();
	Calendar calendar = this.worldObj.getCurrentDate();

	if (calendar.get(2) + 1 == 10 && calendar.get(5) == 31 && this.rand.nextFloat() < 0.25F){
	    this.setCurrentItemOrArmor(4, new ItemStack(this.rand.nextFloat() < 0.1F ? Blocks.lit_pumpkin : Blocks.pumpkin));
	    this.equipmentDropChances[4] = 0.0F;
	}

	return par1EntityLivingData;
    }

    @Override
    public void onKillEntity(EntityLivingBase par1EntityLivingBase){
	super.onKillEntity(par1EntityLivingBase);
	this.dropRareDrop(2);
    }

    @Override
    public boolean attackEntityAsMob(Entity par1Entity){
	boolean flag = super.attackEntityAsMob(par1Entity);
	int difficultySetting = this.worldObj.difficultySetting.getDifficultyId();

	if (flag && this.getHeldItem() == null && this.isBurning() && this.rand.nextFloat() < difficultySetting * 0.3F){
	    par1Entity.setFire(2 * difficultySetting);
	}

	return flag;
    }

    /**
     * Returns the amount of damage a mob should deal.
     */
    public int getAttackStrength(Entity par1Entity){
	ItemStack itemstack = this.getHeldItem();
	//float f = (float)(this.getMaxHealth() - this.getHealth()) / (float)this.getMaxHealth();
	//int i = 3 + MathHelper.floor_float(f * 6.0F);

	if (itemstack != null)
	{
	    //int i += itemstack.getDamageVsEntity(this);
	}

	return 12;
	//return i;
    }

    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound(){
	return "mob.zombie.say";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound(){
	return "mob.zombie.hurt";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound(){
	return "mob.zombie.death";
    }

    /**
     * Plays step sound at given x, y, z for the entity
     */
    protected void playStepSound(int par1, int par2, int par3, int par4){
	this.playSound("mob.zombie.step", 0.15F, 1.0F);
    }

    @Override
    protected Item getDropItem() {
	return SoulItems.FrozenRod.get();
    }
    
    @Override
    protected void dropFewItems(boolean par1, int par2){
	Random r = new Random();
	this.dropItem(SoulItems.FrostShard.get(), r.nextInt(3) + 1);
	this.dropItem(SoulItems.Soul.get(), r.nextInt(5) + 1);
    }

    protected void dropRareDrop(int par1){
	super.dropRareDrop(par1);
	switch (this.rand.nextInt(2)){
	case 0:
	    this.dropItem(SoulItems.ChromiteSword.get(), 1);
	    break;
	case 1:
	    this.dropItem(SoulItems.BaneberryCake.get(), 1);
	}
    }

    /**
     * Makes entity wear random armor based on difficulty
     */
    protected void addRandomArmor(){
	super.addRandomArmor();
	switch (this.rand.nextInt(5)){
	case 0:
	    break;
	case 1:
	    break;
	case 2:
	    setCurrentItemOrArmor(0, new ItemStack(SoulItems.ChromiteSword.get()));
	    break;
	case 3:       		
	    setCurrentItemOrArmor(1, new ItemStack(SoulItems.BronzeBoots.get()));
	    setCurrentItemOrArmor(2, new ItemStack(SoulItems.BronzeLeggings.get()));
	    setCurrentItemOrArmor(3, new ItemStack(SoulItems.BronzeChestplate.get()));
	    setCurrentItemOrArmor(4, new ItemStack(SoulItems.BronzeHelmet.get()));
	    break;
	}
    }

    @Override
    public void setCurrentItemOrArmor(int par1, ItemStack par2ItemStack){
	super.setCurrentItemOrArmor(par1, par2ItemStack);
    }
}
