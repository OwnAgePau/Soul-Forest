package com.Mod_Ores.Mobs.Entity;

import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.ai.attributes.RangedAttribute;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeModContainer;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.entity.living.ZombieEvent.SummonAidEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;

import com.Mod_Ores.Init.SoulItems;
import com.Mod_Ores.Init.Config.SoulConfigCreatures;

public class EntityGroundhog extends EntityZombie{
    protected static final IAttribute groundhogReinforce = (new RangedAttribute((IAttribute)null, "groundhog.spawnReinforcements", 0.3D, 0.2D, 0.5D)).setDescription("Spawn Reinforcements Chance");
    private static final UUID field_110189_bq = UUID.fromString("49455A49-7EC5-45BA-B886-3B90B23A1718");
    private static final AttributeModifier attackingSpeedBoost = (new AttributeModifier(field_110189_bq, "Attacking speed boost", 0.30D, 0));
    private static final UUID field_110187_bq = UUID.fromString("B9766B59-9566-4402-BC1F-2EE2A276D836");
    private static final AttributeModifier babySpeedBoost = new AttributeModifier(field_110187_bq, "Baby speed boost", 0.40D, 1);

    /** Above zero if this PigZombie is Angry. */
    private int angerLevel;

    /** A random delay until this PigZombie next makes a sound. */
    private int randomSoundDelay;
    private Entity attackTarget;
    private int moveSpeed = 5;

    public EntityGroundhog(World par1World){
		super(par1World);
		this.isImmuneToFire = true;
		this.setCustomNameTag(this.getCommandSenderName());
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(6, new EntityAIWander(this, this.moveSpeed));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityKotek.class, false));
    }

    @Override
    public EnumCreatureAttribute getCreatureAttribute(){
    	return EnumCreatureAttribute.UNDEFINED;
    }

    public String getCommandSenderName() {
    	return "Groundhog";
    }

    @Override
    protected void applyEntityAttributes(){
		super.applyEntityAttributes();       
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(SoulConfigCreatures.groundhogHealth);
		this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(SoulConfigCreatures.groundhogKnockback);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(SoulConfigCreatures.groundhogMovement);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(SoulConfigCreatures.groundhogDamage);	
		this.getAttributeMap().registerAttribute(this.groundhogReinforce).setBaseValue(this.rand.nextDouble() * 0.2D);
    }

    /**
     * Returns true if the newer Entity AI code should be run
     */
    protected boolean isAIEnabled(){
    	return false;
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate(){
		if (this.attackTarget != this.getAttackTarget() && !this.worldObj.isRemote){
		    IAttributeInstance attributeinstance = this.getEntityAttribute(SharedMonsterAttributes.attackDamage);
		    //attributeinstance.applyModifier(attackingSpeedBoost);
	
		    if (this.getAttackTarget() != null){
			//attributeinstance.applyModifier(attackingSpeedBoost);
		    }
		}
	
		this.attackTarget = this.getAttackTarget();
	
		if (this.randomSoundDelay > 0 && --this.randomSoundDelay == 0){
		    this.playSound("mob.zombiepig.zpigangry", this.getSoundVolume() * 1.0F, ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F) * 1.8F);
		}
	
		super.onUpdate();
    }

    @Override
    public boolean attackEntityFrom(DamageSource dmgSource, float damageAmount){
		if (!super.attackEntityFrom(dmgSource, damageAmount)){
		    return false;
		}
		else{
		    EntityLivingBase entitylivingbase = this.getAttackTarget();
		    if (entitylivingbase == null && this.getAttackTarget() instanceof EntityLivingBase){
		    	entitylivingbase = (EntityLivingBase)this.getAttackTarget();
		    }
		    if (entitylivingbase == null && dmgSource.getEntity() instanceof EntityLivingBase){
		    	entitylivingbase = (EntityLivingBase)dmgSource.getEntity();
		    }
		    int i = MathHelper.floor_double(this.posX);
		    int j = MathHelper.floor_double(this.posY);
		    int k = MathHelper.floor_double(this.posZ);
		   
		    // Calculate whether or not to summon Aid
		    SummonAidEvent summonAid = ForgeEventFactory.fireZombieSummonAid(this, worldObj, i, j, k, entitylivingbase, this.getEntityAttribute(groundhogReinforce).getAttributeValue());
		    if (summonAid.getResult() == Result.DENY){
		    	return true;
		    }
		    else if (summonAid.getResult() == Result.ALLOW || entitylivingbase != null && this.worldObj.getDifficulty() == EnumDifficulty.HARD && (double)this.rand.nextFloat() < this.getEntityAttribute(groundhogReinforce).getAttributeValue()){
		    	EntityGroundhog entityGroundhog;
			if (summonAid.customSummonedAid != null && summonAid.getResult() == Result.ALLOW){
			    entityGroundhog = (EntityGroundhog) summonAid.customSummonedAid;
			}
			else{
			    entityGroundhog = new EntityGroundhog(this.worldObj);
			}
	
			for (int l = 0; l < 50; ++l){
			    int i1 = i + MathHelper.getRandomIntegerInRange(this.rand, 7, 40) * MathHelper.getRandomIntegerInRange(this.rand, -1, 1);
			    int j1 = j + MathHelper.getRandomIntegerInRange(this.rand, 7, 40) * MathHelper.getRandomIntegerInRange(this.rand, -1, 1);
			    int k1 = k + MathHelper.getRandomIntegerInRange(this.rand, 7, 40) * MathHelper.getRandomIntegerInRange(this.rand, -1, 1);
	
			    if (World.doesBlockHaveSolidTopSurface(this.worldObj, new BlockPos(i1, j1 - 1, k1)) && this.worldObj.getBlockLightOpacity(new BlockPos(i1, j1, k1)) < 10){
			    	entityGroundhog.setPosition((double)i1, (double)j1, (double)k1);
					if (this.worldObj.checkNoEntityCollision(entityGroundhog.getCollisionBoundingBox()) && this.worldObj.getCollidingBoundingBoxes(entityGroundhog, entityGroundhog.getCollisionBoundingBox()).isEmpty() && !this.worldObj.isAnyLiquid(entityGroundhog.getCollisionBoundingBox())){
					    this.worldObj.spawnEntityInWorld(entityGroundhog);
					    if (entitylivingbase != null) entityGroundhog.setAttackTarget(entitylivingbase);
						    entityGroundhog.onInitialSpawn(this.worldObj.getDifficultyForLocation(new BlockPos(entitylivingbase)), (IEntityLivingData)null);
						    this.getEntityAttribute(groundhogReinforce).applyModifier(new AttributeModifier("Groundhog reinforcement caller charge", -0.05000000074505806D, 0));
						    entityGroundhog.getEntityAttribute(groundhogReinforce).applyModifier(new AttributeModifier("Groundhog reinforcement callee charge", -0.05000000074505806D, 0));
						    break;
						}
				    }
				}
		    }
		}
	
		if (this.isEntityInvulnerable(dmgSource)){
            return false;
        }
        else{
            // Get close groundhogs and set them to attack the player
            Entity entity = dmgSource.getEntity();
            if (entity instanceof EntityPlayer){
                List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.getCollisionBoundingBox().expand(32.0D, 32.0D, 32.0D));
                for (int i = 0; i < list.size(); ++i){
                    Entity entity1 = (Entity)list.get(i);
                    if (entity1 instanceof EntityGroundhog){
                	EntityGroundhog entitypigzombie = (EntityGroundhog)entity1;
                        entitypigzombie.becomeAngryAt(entity);
                    }
                }
                this.becomeAngryAt(entity);
            }
            return true;
        }
    }

    /**
     * Checks if the entity's current position is a valid location to spawn this entity.
     */
    public boolean getCanSpawnHere(){
    	return this.worldObj.getDifficulty().getDifficultyId() > 0 && this.worldObj.checkNoEntityCollision(this.getCollisionBoundingBox()) && this.worldObj.getCollidingBoundingBoxes(this, this.getCollisionBoundingBox()).isEmpty() && !this.worldObj.isAnyLiquid(this.getCollisionBoundingBox());
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound){
		super.writeEntityToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setShort("Anger", (short)this.angerLevel);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound){
		super.readEntityFromNBT(par1NBTTagCompound);
		this.angerLevel = par1NBTTagCompound.getShort("Anger");
    }

    /**
     * Finds the closest player within 16 blocks to attack, or null if this Entity isn't interested in attacking
     * (Animals, Spiders at day, peaceful PigZombies).
     */
    protected Entity findPlayerToAttack(){
    	return this.angerLevel == 0 ? null : this.attackingPlayer;
    }

    /**
     * Causes this PigZombie to become angry at the supplied Entity (which will be a player).
     */
    private void becomeAngryAt(Entity par1Entity){
		this.setAttackTarget((EntityLivingBase) par1Entity);
		this.angerLevel = 400 + this.rand.nextInt(400);
		this.randomSoundDelay = this.rand.nextInt(40);
    }

    /**
     * If Animal, checks if the age timer is negative
     */
    public boolean isChild(){
    	return this.getDataWatcher().getWatchableObjectByte(12) == 1;
    }

    /**
     * Set whether this zombie is a child.
     */
    public void setChild(boolean par1){
		this.getDataWatcher().updateObject(12, Byte.valueOf((byte)(par1 ? 1 : 0)));
	
		if (this.worldObj != null && !this.worldObj.isRemote){
		    IAttributeInstance attributeinstance = this.getEntityAttribute(SharedMonsterAttributes.movementSpeed);
		    if (par1){
		    	//attributeinstance.applyModifier(babySpeedBoost);
		    }
		}
    }

    @Override
    public void onKillEntity(EntityLivingBase par1EntityLivingBase){
	super.onKillEntity(par1EntityLivingBase);
	this.dropRareDrop(2);
    }

    @Override
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData par1EntityLivingData){
		Object par1EntityLivingData1 = super.onInitialSpawn(difficulty, par1EntityLivingData);
		float f = difficulty.getClampedAdditionalDifficulty();
		this.setCanPickUpLoot(this.rand.nextFloat() < 0.55F * f);
	
		if (par1EntityLivingData1 == null){
		    par1EntityLivingData1 = new EntityGroundhogGroupData(null, this.worldObj.rand.nextFloat() < 0.05F, this.worldObj.rand.nextFloat() < 0.05F);
		}
	
		if (par1EntityLivingData1 instanceof EntityGroundhogGroupData){
		    EntityGroundhogGroupData entityGroundhoggroupdata = (EntityGroundhogGroupData)par1EntityLivingData1;
	
		    if (entityGroundhoggroupdata.field_142048_a){
			this.setChild(true);
		    }
		}
	
		if (this.getEquipmentInSlot(4) == null){
		    Calendar calendar = this.worldObj.getCurrentDate();
	
		    if (calendar.get(2) + 1 == 10 && calendar.get(5) == 31 && this.rand.nextFloat() < 0.25F){
				this.setCurrentItemOrArmor(4, new ItemStack(this.rand.nextFloat() < 0.1F ? Blocks.lit_pumpkin : Blocks.pumpkin));
				this.equipmentDropChances[4] = 0.0F;
		    }
		}
	
		this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).applyModifier(new AttributeModifier("Random spawn bonus", this.rand.nextDouble() * 0.05000000074505806D, 0));
		//this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).applyModifier(new AttributeModifier("Random zombie-spawn bonus", this.rand.nextDouble() * 1.5D, 2));
	
		if (this.rand.nextFloat() < f * 0.05F){  
		    this.getEntityAttribute(groundhogReinforce).applyModifier(new AttributeModifier("Leader zombie bonus", this.rand.nextDouble() * 0.25D + 0.5D, 0));
		    //this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).applyModifier(new AttributeModifier("Leader zombie bonus", this.rand.nextDouble() * 3.0D + 1.0D, 2));
		}
	
		return (IEntityLivingData)par1EntityLivingData1;
    }

    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound(){
    	return "mob.zombiepig.zpig";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound(){
    	return "mob.zombiepig.zpighurt";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound(){
    	return "mob.zombiepig.zpigdeath";
    }

    /**
     * Drop 0-2 items of this living's type. @param par1 - Whether this entity has recently been hit by a player. @param
     * par2 - Level of Looting used to kill this mob.
     */
    @Override
    protected void dropFewItems(boolean par1, int par2){
		Random r = new Random();
		this.dropItem(SoulItems.StrengthShard.get(), r.nextInt(3) + 1);
		this.dropItem(SoulItems.Soul.get(), r.nextInt(5) + 1);
    }

    /**
     * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
     */
    public boolean interact(EntityPlayer par1EntityPlayer){
    	return false;
    }

    protected void dropRareDrop(int par1){
		switch (this.rand.nextInt(4)){
		case 0:
		    this.dropItem(SoulItems.TitaniumUncut.get(), 1);
		    break;
		case 1:
		    this.dropItem(SoulItems.OnyxUncut.get(), 1);
		    break;
		case 2:
		    this.dropItem(SoulItems.BlackdiamondUncut.get(), 1);
		    break;
		case 3:
		    this.dropItem(SoulItems.StrengthShard.get(), 1);
		    break;
		}
    }

    /**
     * Returns the item ID for the item the mob drops on death.
     */
    @Override
    protected Item getDropItem(){
    	return SoulItems.StrengthShard.get();
    }
}