package com.Mod_Ores.Enums;

import net.minecraft.entity.EntityLivingBase;

import com.Mod_Ores.Mobs.Entity.EntityEnt;
import com.Mod_Ores.Mobs.Entity.EntityFurivoli;
import com.Mod_Ores.Mobs.Entity.EntityGroundhog;
import com.Mod_Ores.Mobs.Entity.EntityIceFairy;
import com.Mod_Ores.Mobs.Entity.EntityIceQueen;
import com.Mod_Ores.Mobs.Entity.EntityIceQueenIllusion;
import com.Mod_Ores.Mobs.Entity.EntityKingKotek;
import com.Mod_Ores.Mobs.Entity.EntityKotek;
import com.Mod_Ores.Mobs.Entity.EntitySnowCreeper;

public class EnumCreatureHelper {	
    public static EnumSoulCreatureAttribute getSoulCreatureAttribute(EntityLivingBase par1Entity){
		if(par1Entity instanceof EntityKotek || par1Entity instanceof EntityKingKotek){
		    return EnumSoulCreatureAttribute.SOUL;
		}
		else if(par1Entity instanceof EntityFurivoli){
		    return EnumSoulCreatureAttribute.FIRE;
		}
		else if(par1Entity instanceof EntityEnt || par1Entity instanceof EntityIceFairy || 
			par1Entity instanceof EntitySnowCreeper || par1Entity instanceof EntityIceQueen || 
			par1Entity instanceof EntityIceQueenIllusion){
		    return EnumSoulCreatureAttribute.FROST;
		}
		else if(par1Entity instanceof EntityGroundhog){
		    return EnumSoulCreatureAttribute.GROUND;
		}
		else{
		    return EnumSoulCreatureAttribute.UNDEFINED;
		}		
    }
}