package com.Mod_Ores.Mobs.Entity;

import net.minecraft.entity.IEntityLivingData;


class EntityGroundhogGroupData implements IEntityLivingData
{
    public boolean field_142048_a;
    public boolean field_142046_b;

    final EntityGroundhog field_142047_c;

    EntityGroundhogGroupData(EntityGroundhog par1EntityGroundhog, boolean par2, boolean par3)
    {
        this.field_142047_c = par1EntityGroundhog;
        this.field_142048_a = false;
        this.field_142046_b = false;
        this.field_142048_a = par2;
        this.field_142046_b = par3;
    }

    EntityGroundhogGroupData(EntityGroundhog par1EntityGroundhog, boolean par2, boolean par3, Object par4EntityGroundhogINNER1)
    {
        this(par1EntityGroundhog, par2, par3);
    }
}
