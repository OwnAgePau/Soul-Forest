package com.Mod_Ores.Blocks.Special.Slab;

public class SoulDoubleSlab extends SoulSlab {
	
	public SoulDoubleSlab(int meta, float hardness, float resistance) {
		super(meta, hardness, resistance);
	}

	@Override
	public boolean isDouble(){
        return true;
    }
}