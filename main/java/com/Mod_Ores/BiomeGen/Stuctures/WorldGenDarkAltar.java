package com.Mod_Ores.BiomeGen.Stuctures;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.Mod_Ores.Init.SoulBlocks;

public class WorldGenDarkAltar extends WorldGenerator{
    private int height = 20;
    private int pillarHeight = 4;

    @Override
    public boolean generate(World world, Random random, int parX, int parY, int parZ) {
	int x1;
	int y1;
	int z1;

	int y2;
	int yLevel;
	int width = 4;

	while (world.isAirBlock(parX, parY, parZ) && parY > 2 && parY < 100){
	    --parY;
	    --parY;
	}
	
	if(parY > 100){
	    return false;
	}

	//Can it spawn here?
	Block l = world.getBlock(parX, parY, parZ);
	if (l != SoulBlocks.FyrisedSandGrass.get() && l != SoulBlocks.FyrisedSand.get()){  	
	    return false;
	}

	if(!world.isAirBlock(parX, parY + height, parZ)){
	    return false;
	}

	for(x1 = 0; x1 < 5; x1++){
	    for(z1 = 0; z1 < 5; z1++){
		Block block = null;
		int r = new Random().nextInt(2);
		if(r == 0){
		    block = SoulBlocks.BauxiteMossy.get();
		}
		else{
		    block = SoulBlocks.Bauxite.get();
		}
		world.setBlock(parX + x1, parY + height, parZ + z1, block);      
	    }
	}
	
	for(int y = 0; y < this.pillarHeight; y++){
	    world.setBlock(parX + 0 , parY + height + y, parZ + 0, SoulBlocks.BauxiteBrick.get());
	    world.setBlock(parX + 4 , parY + height + y, parZ + 0, SoulBlocks.BauxiteBrick.get());
	    world.setBlock(parX + 0 , parY + height + y, parZ + 4, SoulBlocks.BauxiteBrick.get());
	    world.setBlock(parX + 4 , parY + height + y, parZ + 4, SoulBlocks.BauxiteBrick.get());
	}
	
	Block topBlock = null;
	switch(new Random().nextInt(4)){
	case 0:
	    topBlock = SoulBlocks.AmethystBlock.get();
	    break;
	case 1:
	    topBlock = SoulBlocks.TanzaniteBlock.get();
	    break;
	case 2:
	    topBlock = SoulBlocks.TopazBlock.get();
	    break;
	case 3:
	    topBlock = SoulBlocks.ScarletiteBlock.get();
	    break;
	}
	world.setBlock(parX + 0 , parY + height + this.pillarHeight, parZ + 0, topBlock);
	world.setBlock(parX + 4 , parY + height + this.pillarHeight, parZ + 0, topBlock);
	world.setBlock(parX + 0 , parY + height + this.pillarHeight, parZ + 4, topBlock);
	world.setBlock(parX + 4 , parY + height + this.pillarHeight, parZ + 4, topBlock);
	world.setBlock(parX + 2 , parY + height, parZ + 2, SoulBlocks.BlackdiamondBlock.get());
	return true;
    }
}

