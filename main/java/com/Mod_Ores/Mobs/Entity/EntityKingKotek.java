package com.Mod_Ores.Mobs.Entity;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

import com.Mod_Ores.Init.InitAchievements;
import com.Mod_Ores.Init.SoulItems;
import com.Mod_Ores.Init.Config.SoulConfigCreatures;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityKingKotek extends EntitySlime implements IBossDisplayData
{
    public static int slimeSize;
    public static int attackStrenght;
    public static int health;
    public static String name;

    public EntityKingKotek(World par1World)
    {
	super(par1World);
	this.isImmuneToFire = true;
	this.jumpMovementFactor = 0.05F;
	this.attackStrenght = SoulConfigCreatures.kingKotekDamage;
	this.health = SoulConfigCreatures.kingKotekHealth;
	this.setHealth(this.health);
	this.name = "King Kotek";
	this.slimeSize = 10;
	this.setCustomNameTag(this.getCommandSenderName());
	//this.setEntityHealth(this.func_110138_aP());
    }

    public void spawnKoteks(World par1World){
	while(this.getHealth() > 0){
	    Random rand = new Random();
	    int i1 = rand.nextInt(5001);
	    if(i1 == 0){
		double d0 = rand.nextDouble();
		if(d0 == 0.1){
		    if(!par1World.isRemote){
			EntityKotek kotek = new EntityKotek(par1World);
			kotek.createInstance();
			kotek.setPosition(this.posX, this.posY, this.posZ);
			boolean spawned = par1World.spawnEntityInWorld(kotek);
		    }
		}
	    }
	}
    }

    @Override
    public String getCommandSenderName() {
	return "King Kotek";
    }

    /**
     * Checks if the entity's current position is a valid location to spawn this entity.
     */
    public boolean getCanSpawnHere(){
	return true;
    }

    public int getAttackStrength(Entity par1Entity){
	return this.attackStrenght;
    }

    // Set max health and attack damage
    /*@Override
    protected void func_110147_ax()
    {
            super.func_110147_ax();
            // Max Health - default 20.0D - min 0.0D - max Double.MAX_VALUE

            // Attack Damage - default 2.0D - min 0.0D - max Doubt.MAX_VALUE
            //this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(this.getAttackStrength());
    }*/

    /**
     * Returns the current armor value as determined by a call to InventoryPlayer.getTotalArmorValue
     */
    public int getTotalArmorValue(){
	return 4;
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
    @Override
    protected String getSlimeParticle(){
	return "bubble";
    }

    public EntitySlime createInstance(){
	return new EntityKingKotek(this.worldObj);
    }

    /**
     * Returns the item ID for the item the mob drops on death.
     */
    @Override
    protected Item getDropItem(){
	return SoulItems.BlueGel.get();
    }

    @Override
    protected void dropFewItems(boolean isRecentHit, int enchantmentLootingModifier){
	int j = this.rand.nextInt(21);
	this.dropItem(SoulItems.BlueGel.get(), 10 + j);
	for(int rareDropTimes = 0; rareDropTimes < 3; rareDropTimes++){
	    switch (this.rand.nextInt(6))
	    {
	    case 0:
		this.dropItem(SoulItems.MithrilIngot.get(), 1);
		break;
	    case 1:
		this.dropItem(Items.slime_ball, 10);
		break;
	    case 2:
		this.dropItem(Items.ender_eye, 1);
		break;
	    case 3:
		this.dropItem(SoulItems.OnyxGem.get(), 1);
		break;
	    case 4:
		this.dropItem(SoulItems.TitaniumGem.get(), 1);
		break;
	    case 5:
		this.dropItem(Items.ghast_tear, 1);
		break;
	    }
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
	return super.getJumpDelay() * 4;
    }

    protected void alterSquishAmount(){
	this.squishAmount *= 0.9F;
    }

    /**
     * Causes this entity to do an upwards motion (jumping).
     */
    protected void jump(){
	this.motionY = (double)(0.12F + (float)this.getSlimeSize() * 0.1F);
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
	this.dataWatcher.updateObject(16, new Byte((byte)this.slimeSize));
	this.setSize(this.slimeSize, this.slimeSize);
	this.setPosition(this.posX, this.posY - 10, this.posZ);
	this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(this.health);
	this.setHealth(this.getHealth());
	this.experienceValue = 50;
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

    @Override
    public void setDead(){
	//Minecraft.getMinecraft().thePlayer.addStat(InitAchievements.gelKing, 1);
	super.isDead = true;
    }
}
