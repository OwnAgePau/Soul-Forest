package com.Mod_Ores.Mobs.Entity;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.Mod_Ores.Init.SoulItems;
import com.Mod_Ores.Init.Config.SoulConfigCreatures;

public class EntityKotek extends EntitySlime{
    public static int slimeSize;
    public static int attackStrenght;
    public static int health;

    public EntityKotek(World par1World){
		super(par1World);
		this.isImmuneToFire = false;
		this.jumpMovementFactor = 0.05F;
		if(this.slimeSize == 1){
		    this.setCustomNameTag("Blue Kotek");
		}
		else if(this.slimeSize == 2){
		    this.setCustomNameTag("Red Kotek");
		}
		else{
		    this.setCustomNameTag("Green Kotek");
		}
		this.health = SoulConfigCreatures.kotekHealth;
		this.attackStrenght = SoulConfigCreatures.kotekDamage;
    }


    public String getCommandSenderName() {
		if(this.slimeSize == 1){
		    return "Blue Kotek";
		}
		else if(this.slimeSize == 2){
		    return "Red Kotek";
		}
		else{
		    return "Green Kotek";
		}
    }

    /**
     * Checks if the entity's current position is a valid location to spawn this entity.
     */
    public boolean getCanSpawnHere(){
    	return this.worldObj.getDifficulty().getDifficultyId() > 0 && this.worldObj.checkNoEntityCollision(this.getCollisionBoundingBox()) && this.worldObj.getCollidingBoundingBoxes(this, this.getCollisionBoundingBox()).isEmpty() && !this.worldObj.isAnyLiquid(this.getCollisionBoundingBox());
    }

    public int getAttackStrength(Entity par1Entity){
    	return 20;
    }

    // Set max health and attack damage
    @Override
    protected void applyEntityAttributes(){
		super.applyEntityAttributes();
		// Max Health - default 20.0D - min 0.0D - max Double.MAX_VALUE
		//this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(this.health);
		//this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(this.getAttackStrength());
		// Attack Damage - default 2.0D - min 0.0D - max Doubt.MAX_VALUE
		//this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(15.0D);
    }

    /**
     * Returns the current armor value as determined by a call to InventoryPlayer.getTotalArmorValue
     */
    public int getTotalArmorValue(){
    	return this.getSlimeSize() * 4;
    }

    @SideOnly(Side.CLIENT)
    public int getBrightnessForRender(float par1){
    	return 15728880;
    }

    /**
     * Gets how bright this entity is.
     */
    public float getBrightness(float par1){
    	return 4.0F;
    }

    /**
     * Returns the name of a particle effect that may be randomly created by EntitySlime.onUpdate()
     */
    /*@Override
    protected String getSlimeParticle(){
    	return "bubble";
    }*/

    protected EntitySlime createInstance(){
    	return new EntityKotek(this.worldObj);
    }

    @Override
    public void onKillEntity(EntityLivingBase par1EntityLivingBase){
		super.onKillEntity(par1EntityLivingBase);
		this.dropRareDrop(2);
    }

    /**
     * Returns the item ID for the item the mob drops on death.
     */
    @Override
    protected Item getDropItem(){
    	return SoulItems.BlueGel.get();
    }
    
    @Override
    protected void dropFewItems(boolean par1, int par2){
		Random r = new Random();
		this.dropItem(SoulItems.BlueGel.get(), r.nextInt(3) + 1);
		this.dropItem(SoulItems.Soul.get(), r.nextInt(5) + 1);
    }

    protected void dropRareDrop(int par1){
		int i = this.rand.nextInt(20);
		if(i == 0){
		    this.dropItem(SoulItems.BlueberryMuffin.get(), 1);   
		}
		else{
		    this.dropItem(SoulItems.Soul.get(), 1);   
		}
    }

    /**
     * Returns true if the entity is on fire. Used by render to add the fire effect on rendering.
     */
    public boolean isBurning(){
    	return false;
    }

    /**
     * Gets the amount of time the slime needs to wait between jumps.
     */
    @Override
    protected int getJumpDelay(){
    	return super.getJumpDelay() * 2;
    }

    protected void alterSquishAmount(){
    	this.squishAmount *= 0.9F;
    }

    /**
     * Causes this entity to do an upwards motion (jumping).
     */
    protected void jump(){
		this.motionY = (double)(0.42F + (float)this.getSlimeSize() * 0.2F);
		this.isAirBorne = true;
    }

    /**
     * Called when the mob is falling. Calculates and applies fall damage.
     */
    protected void fall(float par1) {}

    /**
     * Indicates weather the slime is able to damage the player (based upon the slime's size)
     */
    protected boolean canDamagePlayer(){
    	return true;
    }

    /**
     * Gets the amount of damage dealt to the player when "attacked" by the slime.
     */
    @Override
    protected int getAttackStrength(){
    	return this.attackStrenght;
    }

    @Override
    protected void setSlimeSize(int par1){
		this.dataWatcher.updateObject(16, new Byte((byte)par1));
		this.setSize(0.6F * (float)par1, 0.6F * (float)par1);
		this.setPosition(this.posX, this.posY, this.posZ);
		// small (1) = 20 health, medium (2) = 40 health, big (4) = 80 health
		// Base health = 10
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(this.health * par1);
		this.setHealth(this.health * par1);
		this.experienceValue = par1;
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound(){
    	return "mob.slime." + (this.getSlimeSize() > 1 ? "big" : "small");
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound(){
    	return "mob.slime." + (this.getSlimeSize() > 1 ? "big" : "small");
    }

    /**
     * Returns the name of the sound played when the slime jumps.
     */
    protected String getJumpSound(){
    	return this.getSlimeSize() > 1 ? "mob.magmacube.big" : "mob.magmacube.small";
    }

    /**
     * Whether or not the current entity is in lava
     */
    public boolean handleLavaMovement(){
    	return false;
    }

    /**
     * Returns true if the slime makes a sound when it lands after a jump (based upon the slime's size)
     */
    protected boolean makesSoundOnLand(){
    	return true;
    }

    @Override
    public int getSlimeSize(){
		this.slimeSize = this.dataWatcher.getWatchableObjectByte(16);
		return this.slimeSize;
    }
}