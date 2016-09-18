package com.Mod_Ores.Blocks.Special.Slab;

import com.Mod_Ores.Init.SoulBlocks;

public class SoulHalfSlab extends SoulSlab{
    
    public SoulHalfSlab(int meta, float hardness, float resistance) {
		super(meta, hardness, resistance);
	}

	@Override
	public boolean isDouble(){
        return false;
    }
}