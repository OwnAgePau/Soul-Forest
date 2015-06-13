package com.Mod_Ores.Mobs.Entity;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAICreeperSwell;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.Mod_Ores.Init.InitAchievements;
import com.Mod_Ores.Init.SoulItems;
import com.Mod_Ores.Init.Config.SoulConfigCreatures;
import com.Mod_Ores.Items.Entity.EntityBigFrostShard;
import com.Mod_Ores.Items.Entity.EntitySmallSoulFireball;
import com.Mod_Ores.Mobs.AI.EntityAIPlaceWall;
import com.Mod_Ores.Mobs.AI.EntityAITeleport;

public class EntityIceQueen extends EntityMob implements IBossDisplayData, IRangedAttackMob{
   
    private EntityAIArrowAttack aiArrowAttack = new EntityAIArrowAttack(this, 1.0D, 10, 10, 960.0F);
    private int timeUntillWall;
    private int minTimWallPlacement;

    private int timeUntillSummon;
    private int minTimeSummon;
    
    private int summonedCreatures;

    public EntityIceQueen(World par1World){
	super(par1World);
	this.minTimWallPlacement = 235;
	this.timeUntillWall = this.minTimWallPlacement;
	this.minTimeSummon = 642;
	this.timeUntillSummon = this.minTimeSummon;
	this.setHealth(this.getMaxHealth());
	this.setCustomNameTag(this.getCommandSenderName());
	this.tasks.addTask(0, new EntityAITeleport(this, EntityPlayer.class));
	this.tasks.addTask(1, new EntityAIAttackOnCollide(this, 0.50F, false));
	this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityPlayer.class, 30.0F));
	this.tasks.addTask(3, new EntityAIPlaceWall(this, EntityPlayer.class, false, 3, 3));
	this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 50, true));
	//this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 20, true));
	//this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
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

    public void setTimeUntillPlaceWall(int time){
	this.timeUntillWall = time;
    }

    public int getTimeUntillPlaceWall(){
	return this.timeUntillWall;
    }

    public int getMinTimePlaceWall(){
	return this.minTimWallPlacement;
    }

    // Set max health and attack damage
    @Override
    protected void applyEntityAttributes(){
	super.applyEntityAttributes();
	this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0);
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
    protected void dropFewItems(boolean isRecentHit, int enchantmentLootingModifier){
	this.dropItem(SoulItems.FrostShard.get(), 10 + this.rand.nextInt(31));
	this.dropItem(SoulItems.FrozenRod.get(), 3 + this.rand.nextInt(7));
	for(int rareDropTimes = 0; rareDropTimes < 4; rareDropTimes++){
	    switch (this.rand.nextInt(9)){
	    case 0:
		this.dropItem(SoulItems.OnyxUncut.get(), 1);
		break;
	    case 1:
		this.dropItem(Items.nether_star, 1);
		break;
	    case 2:
		this.dropItem(Items.glowstone_dust, 10 + this.rand.nextInt(11));
		break;
	    case 3:
		this.dropItem(SoulItems.BlackdiamondUncut.get(), 1);
		break;
	    case 4:
		this.dropItem(SoulItems.TitaniumUncut.get(), 1);
		break;
	    case 5:
		this.dropItem(SoulItems.AquamarineWaraxe.get(), 1);
		break;
	    case 6:
		this.dropItem(SoulItems.ScarletiteUncut.get(), 2 + this.rand.nextInt(4));
		break;
	    case 7:
		this.dropItem(SoulItems.FrostFragment.get(), 8 + this.rand.nextInt(13));
		break;
	    case 8:
		this.dropItem(SoulItems.FrostWand.get(), 1);
		break;
	    }
	}
    }

    @Override
    public void onUpdate(){
	//System.out.println("Time to wait: " + this.timeUntillWall);
	if(this.timeUntillSummon > 0){
	    this.timeUntillSummon -= this.rand.nextInt(5);
	}
	else{
	    this.summonCreature(2);	    
	}
	if(this.timeUntillWall > 0){
	    this.timeUntillWall -= this.rand.nextInt(5);
	}
	else{
	    this.timeUntillWall = 0;
	}
	super.onUpdate();
    }
    
    @Override
    public void onLivingUpdate(){
	this.tasks.removeTask(this.aiArrowAttack);
	this.tasks.addTask(4, this.aiArrowAttack);
	super.onLivingUpdate();
    }

    private EntityCreature getRandomSummonedCreature(int random){
	EntityCreature entity = new EntityIceQueenIllusion(this.worldObj);
	switch(random)
	{
	case 0:
	    entity = new EntityIceQueenIllusion(this.worldObj);
	    break;
	case 1:
	    entity = new EntityIceQueenIllusion(this.worldObj);
	    break;
	case 2:
	    entity = new EntitySnowCreeper(this.worldObj);
	    break;
	case 3:
	    entity = new EntityIceFairy(this.worldObj);
	    break;
	}
	return entity;
    }

    private void summonCreature(int amount){
	int random = this.rand.nextInt(4);
	if(!this.worldObj.isRemote && this.summonedCreatures < 6){
	    for(int i = 0; i < amount; i++){
		EntityCreature entity = this.getRandomSummonedCreature(random);
		entity.copyLocationAndAnglesFrom(this);
		double d0 = entity.posX + (this.rand.nextDouble() - 0.5D) * 6.0D; // was 64.0D
		double d1 = entity.posY + (double)(this.rand.nextInt(64) - 32);
		double d2 = entity.posZ + (this.rand.nextDouble() - 0.5D) * 6.0D; // was 64.0D
		this.teleportTo(entity, d0, d1, d2);
		entity.onSpawnWithEgg((IEntityLivingData)null);
		this.worldObj.spawnEntityInWorld(entity);
		this.summonedCreatures++;
	    }
	    this.timeUntillSummon = this.minTimeSummon;
	}
    }

    @Override
    public void attackEntityWithRangedAttack(EntityLivingBase p_82196_1_, float p_82196_2_) {
	double d0 = p_82196_1_.posX - this.posX;
	double d1 = p_82196_1_.boundingBox.minY + (double)(p_82196_1_.height / 2.0F) - (this.posY + (double)(this.height / 2.0F));
	double d2 = p_82196_1_.posZ - this.posZ;
	float f1 = MathHelper.sqrt_float(p_82196_2_) * 0.5F;
	this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1009, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
	System.out.println("Trying to attack");
	for (int i2 = 0; i2 < 1; ++i2){
	    EntityBigFrostShard bigFrostShard = new EntityBigFrostShard(this.worldObj, this, d0 + this.rand.nextGaussian() * (double)f1, d1, d2 + this.rand.nextGaussian() * (double)f1);
	    System.out.println("SUMMON : " + bigFrostShard);
	    bigFrostShard.posY = this.posY + (double)(this.height / 2.0F) + 0.5D;
	    this.worldObj.spawnEntityInWorld(bigFrostShard);
	}
    }
    
    /**
     * Teleport the ice queen
     */
    protected boolean teleportTo(EntityCreature entity, double x, double y, double z){
	/*EnderTeleportEvent event = new EnderTeleportEvent(this.theEntity, p_70825_1_, p_70825_3_, p_70825_5_, 0);
        if (MinecraftForge.EVENT_BUS.post(event)){
            return false;
        }*/
	double d3 = entity.posX;
	double d4 = entity.posY;
	double d5 = entity.posZ;
	entity.posX = x;
	entity.posY = y;
	entity.posZ = z;
	boolean flag = false;
	int i = MathHelper.floor_double(entity.posX);
	int j = MathHelper.floor_double(entity.posY);
	int k = MathHelper.floor_double(entity.posZ);

	if (this.worldObj.blockExists(i, j, k)){
	    boolean flag1 = false;

	    while (!flag1 && j > 0){
		Block block = entity.worldObj.getBlock(i, j - 1, k);

		if (block.getMaterial().blocksMovement()){
		    flag1 = true;
		}
		else{
		    --entity.posY;
		    --j;
		}
	    }

	    if (flag1){
		entity.setPosition(entity.posX, entity.posY, entity.posZ);

		if (entity.worldObj.getCollidingBoundingBoxes(entity, entity.boundingBox).isEmpty() && !entity.worldObj.isAnyLiquid(entity.boundingBox)){
		    flag = true;
		}
	    }
	}

	if (!flag){
	    entity.setPosition(d3, d4, d5);
	    return false;
	}
	else{
	    short short1 = 128;

	    for (int l = 0; l < short1; ++l){
		double d6 = (double)l / ((double)short1 - 1.0D);
		float f = (this.rand.nextFloat() - 0.5F) * 0.2F;
		float f1 = (this.rand.nextFloat() - 0.5F) * 0.2F;
		float f2 = (this.rand.nextFloat() - 0.5F) * 0.2F;
		double d7 = d3 + (entity.posX - d3) * d6 + (this.rand.nextDouble() - 0.5D) * (double)entity.width * 2.0D;
		double d8 = d4 + (entity.posY - d4) * d6 + this.rand.nextDouble() * (double)entity.height;
		double d9 = d5 + (entity.posZ - d5) * d6 + (this.rand.nextDouble() - 0.5D) * (double)entity.width * 2.0D;
		entity.worldObj.spawnParticle("portal", d7, d8, d9, (double)f, (double)f1, (double)f2);
	    }

	    entity.worldObj.playSoundEffect(d3, d4, d5, "mob.endermen.portal", 1.0F, 1.0F);
	    entity.playSound("mob.endermen.portal", 1.0F, 1.0F);
	    return true;
	}
    }
}