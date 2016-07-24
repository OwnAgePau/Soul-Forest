package com.Mod_Ores.BiomeGen.Stuctures;

import static net.minecraftforge.common.ChestGenHooks.DUNGEON_CHEST;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import scala.Int;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDoor;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.DungeonHooks;

import com.Mod_Ores.soul_forest;
import com.Mod_Ores.Init.SoulBlocks;

public class WorldGenTower extends WorldGenerator{

    private int height = 12;
    private int width = 7;
    private int k = 0;
    private boolean mobSpawner = false;
    private Block mainBlock;
    private Block stairBlock;
    private Block topBlock;
    private Block bottomBlock;
    private List<WeightedRandomChestContent> chestContent;
    
    public WorldGenTower(Block main, Block stairs, Block topBlock, List<WeightedRandomChestContent> chestContent){
		this.mainBlock = main;
		this.stairBlock = stairs;
		this.topBlock = topBlock;
		this.chestContent = chestContent;
    }

    @Override
    public boolean generate(World world, Random random, BlockPos pos){
		while (world.isAirBlock(pos) && pos.getY() > 2 && pos.getY() < 100){
			pos = pos.add(0, - 2, 0);
		}
		if(pos.getY() > 100){
		    return false;
		}
		
    	int x = pos.getX();
    	int y = pos.getY();
    	int z = pos.getZ();
	
		Block l = world.getBlockState(pos).getBlock();
	
		if(l != this.topBlock){
		    return false;
		}
		//Ice Tower
		int x1 = 0;
		int y1 = 0;
		int z1 = 0;
	
		//Air inside the tower
		for(x1 = 1; x1 < (width -1); ++x1){
		    for(z1 = 1; z1 < (width -1); ++z1){
		    	for(y1 = 0; y1 < 6; ++y1){
				    world.setBlockToAir(new BlockPos(x + x1, y + y1, z + z1));	
				}
		
				for(y1 = 7; y1 < height; ++y1){
				    world.setBlockToAir(new BlockPos(x + x1, y + y1, z + z1));	
				}
		
				for(y1 = height; y1 < 14; ++y1){
				    world.setBlockToAir(new BlockPos(x + x1, y + y1, z + z1));	
				}
		    }
		}
	
	
		//Walls
		for(x1 = 0; x1 < width; ++x1){
		    for(y1 = -1; y1 < height; ++y1){
				world.setBlockState(new BlockPos(x + x1, y + y1, z), this.mainBlock.getDefaultState());
				world.setBlockState(new BlockPos(x + x1, y + y1, z + 6), this.mainBlock.getDefaultState());
		    }     	
		}
	
		//Walls
		for(z1 = 0; z1 < width; ++z1){
		    for(y1 = -1; y1 < height; ++y1){
				world.setBlockState(new BlockPos(x, y + y1, z + z1), this.mainBlock.getDefaultState());
				world.setBlockState(new BlockPos(x + 6, y + y1, z + z1), this.mainBlock.getDefaultState());
		    }     
		}
	
		//Floors
		for(x1 = 0; x1 < width; ++x1){
		    for(z1 = 0; z1 < width; ++z1){
				world.setBlockState(new BlockPos(x + x1, y, z + z1), this.mainBlock.getDefaultState());
				world.setBlockState(new BlockPos(x + x1, y + 6, z + z1), this.mainBlock.getDefaultState());
				world.setBlockState(new BlockPos(x + x1, y + (height), z + z1), this.mainBlock.getDefaultState());
		    }
		}
	
		// Mob Spawners
		if(random.nextInt(2) == 0){
		    this.mobSpawner = false;
		}
		else{
		    this.mobSpawner = true;
		}
	
		if(this.mobSpawner){
		    if(random.nextInt(3) == 0){
				world.setBlockState(new BlockPos(x + 3, y + 1, z + 3), Blocks.mob_spawner.getDefaultState(), 0);
				this.k = 1;
				if(random.nextInt(5) == 0){
				    world.setBlockState(new BlockPos(x + 3, y + 7, z + 3), Blocks.chest.getDefaultState(), 0);
				    TileEntityChest tileentitychest = (TileEntityChest)world.getTileEntity(new BlockPos(new BlockPos(x + 3, y + 7, z + 3)));
				    if (tileentitychest != null) {
				    	WeightedRandomChestContent.generateChestContents(random, this.chestContent, tileentitychest, ChestGenHooks.getCount(DUNGEON_CHEST, random));
				    }
				}
		    }
		    else{
			world.setBlockState(new BlockPos(x + 3, y + 7, z + 3), Blocks.mob_spawner.getDefaultState(), 0);
			this.k = 7;
				if(random.nextInt(5) == 0){
				    world.setBlockState(new BlockPos(x + 3, y + 1, z + 3), Blocks.chest.getDefaultState(), 0);
				    TileEntityChest tileentitychest = (TileEntityChest)world.getTileEntity(new BlockPos(new BlockPos(x + 3, y + 1, z + 3)));
				    if (tileentitychest != null) {
				    	WeightedRandomChestContent.generateChestContents(random, this.chestContent, tileentitychest, ChestGenHooks.getCount(DUNGEON_CHEST, random));
				    }
				}
		    }
	
            TileEntity tileentitymobspawner = world.getTileEntity(new BlockPos(x + 3, y + k, z + 3));
	
            if (tileentitymobspawner instanceof TileEntityMobSpawner){
           	 	((TileEntityMobSpawner)tileentitymobspawner).getSpawnerBaseLogic().setEntityName(this.pickMobSpawner(random));
		    }
		    else{
				if(random.nextInt(1) == 0){
				    System.err.println("[Soul Forest] Failed to fetch mob spawner entity at (" + x + 3 + ", " + y + 1 + ", " + z + 3 + ")");
				}
				else{
				    System.err.println("[Soul Forest] Failed to fetch mob spawner entity at (" + x + 3 + ", " + y + 7 + ", " + z + 3 + ")");
				}
		    }			
		}
	
		//Roof
		for(x1 = 0; x1 < width; ++x1){
		    for(z1 = 0; z1 < width; ++z1){
				for(y1 = height; y1 < (height + 1); ++y1){
				    world.setBlockState(new BlockPos(x + x1, y + y1, z + z1), this.mainBlock.getDefaultState());
				}
		    }
		}
		for(int xStep = 0; xStep < 6; xStep+=2){
		    world.setBlockState(new BlockPos(x + xStep, y + (height + 2), z), this.mainBlock.getDefaultState());
		    world.setBlockState(new BlockPos(x + xStep, y + (height + 2), z + 6), this.mainBlock.getDefaultState());
		}
		for(int zStep = 0; zStep <= 6; zStep+=2){
		    world.setBlockState(new BlockPos(x, y + (height + 2), z + zStep), this.mainBlock.getDefaultState());
		    world.setBlockState(new BlockPos(x + 6, y + (height + 2), z + zStep), this.mainBlock.getDefaultState());
		}
	
		//Roof (top most layer)
		for(x1 = 0; x1 < width; ++x1){
		    world.setBlockState(new BlockPos(x + x1, y + (height + 1), z), this.mainBlock.getDefaultState());
		    world.setBlockState(new BlockPos(x + x1, y + (height + 1), z + 6), this.mainBlock.getDefaultState()); 
		}
	
		//Floors
		for(z1 = 0; z1 < width; ++z1){
		    world.setBlockState(new BlockPos(x, y + (height + 1), z + z1), this.mainBlock.getDefaultState());
		    world.setBlockState(new BlockPos(x + 6, y + (height + 1), z + z1), this.mainBlock.getDefaultState()); 
		}
	
		//Ladder
		world.setBlockToAir(new BlockPos(x + 1, y + 6, z + 1));
		world.setBlockToAir(new BlockPos(x + 1, y + height, z + 1));
	
		for(y1 = 1; y1 < (height + 1); ++y1){
			BlockPos ladderPos = new BlockPos(x + 1, y + y1, z + 1);
		    if (world.isAirBlock(new BlockPos(ladderPos))){
		    	 for (EnumFacing enumfacing : EnumFacing.Plane.HORIZONTAL){
                     if (world.getBlockState(ladderPos.offset(enumfacing)).getBlock().getMaterial().isSolid()){
                    	 ladderPos = ladderPos.offset(enumfacing);
                    	 world.setBlockState(ladderPos, Blocks.ladder.getDefaultState());
                     }
                 }
				/*for (int j1 = 2; j1 <= 5; ++j1){
				    if (Blocks.ladder.canPlaceBlockOnSide(world, x + 1, y + y1, z + 1, j1)){
				    	world.setBlockState(new BlockPos(x + 1, y + y1, z + 1, Blocks.ladder, j1, 2);
				    }
				}*/
		    }
		}
		ArrayList<Integer> sides = new ArrayList<Integer>();
		for(int side = 0; side < 4; side++){
		    if(this.isRoomToSpawnStairs(world, x + 3, y, z + 3, side)){
		    	sides.add(side);
		    }
		}
		if(sides.size() > 0){
		    int side = sides.get(random.nextInt(sides.size()));
		    if(random.nextInt(4) == 0){
				this.spawnStairsSideWay(world, random, x, y, z, side, true);
				if(side == 0){
				    this.spawnChestRoom(world, random, x, y - 4, z - 13, 5, this.mainBlock, 2, true);
				}
				else if(side == 1){
				    this.spawnChestRoom(world, random, x + 13, y - 4, z, 5, this.mainBlock, 3, true);
				}
				else if(side == 2){
				    this.spawnChestRoom(world, random, x, y - 4, z + 13, 5, this.mainBlock, 0, true);
				}
				else if(side == 3){
				    this.spawnChestRoom(world, random, x - 13, y - 4, z, 5, this.mainBlock, 1, true);
				}
		    }
		}
	
		return true;
	}

    private boolean isRoomToSpawnStairs(World world, int x, int y, int z, int side){
		int startX = x;
		int startY = y;
		int startZ = z;
		int airBlockCount = 0;
		if(side == 0){
		    startZ -= 4;
		    for(int z1 = 0; z1 > -6; z1--){
				for(int y1 = 0; y1 > -6; y1--){
				    if(world.isAirBlock(new BlockPos(startX, startY + y1, startZ + z1))){
				    	airBlockCount++;
				    }
				}
		    }
		    if(airBlockCount > 10){
		    	return false;
		    }
		}
		else if(side == 1){
		    startX += 4;
		    for(int x1 = 0; x1 < 6; x1++){
				for(int y1 = 0; y1 > -6; y1--){
				    if(world.isAirBlock(new BlockPos(startX + x1, startY + y1, startZ))){
				    	airBlockCount++;
				    }
				}
		    }
		    if(airBlockCount > 10){
		    	return false;
		    }
		}
		else if(side == 2){
		    startZ += 4;
		    for(int z1 = 0; z1 < 6; z1++){
				for(int y1 = 0; y1 > -6; y1--){
				    if(world.isAirBlock(new BlockPos(startX, startY + y1, startZ + z1))){
				    	airBlockCount++;
				    }
				}
		    }
		    if(airBlockCount > 10){
		    	return false;
		    }
		}
		else if(side == 3){
		    startX -= 4;
		    for(int x1 = 0; x1 > -6; x1--){
				for(int y1 = 0; y1 > -6; y1--){
				    if(world.isAirBlock(new BlockPos(startX + x1, startY + y1, startZ ))){
				    	airBlockCount++;
				    }
				}
		    }
		    if(airBlockCount > 10){
		    	return false;
		    }
		}
		return true;
    }

    private void spawnStairsSideWay(World world, Random random, int x, int y, int z, int side, boolean spawnRoom){
		int airBlocksVer = 7, airBlocksHor = 3;
		int startY = 4;
		if(side == 0){
		    int startX = 2, startZ = 0;
		    int difX = airBlocksHor + startX;
		    int difZ = airBlocksVer + startZ;
		    for(int z1 = startZ; z1 > -difZ; z1--){
				for(int x1 = startX; x1 < difX; x1++){
				    for(int y1 = startY; y1 > -4; y1--){
				    	world.setBlockToAir(new BlockPos(x + x1, y + y1, z + z1));
				    }
				    for(int y1 = startY; y1 > -5; y1--){
						world.setBlockState(new BlockPos(x + 1, y + y1, z + z1), this.mainBlock.getDefaultState());	
						world.setBlockState(new BlockPos(x + difX, y + y1, z + z1), this.mainBlock.getDefaultState());	
				    }	
				    world.setBlockState(new BlockPos(x + x1, y - 4, z + z1), this.mainBlock.getDefaultState());
				    world.setBlockState(new BlockPos(x + x1, y + startY + 1, z + z1), this.mainBlock.getDefaultState());
				    for(int y1 = startY - 5; y1 > -4; y1--){
				    	world.setBlockState(new BlockPos(x + x1, y + y1, z + z1), this.mainBlock.getDefaultState());
				    }
				    if(startY - 5 > -5){
				    	BlockPos facing = new BlockPos(x + x1, y + (startY - 4), z + z1).offset(EnumFacing.VALUES[2]);
				    	world.setBlockState(facing, this.stairBlock.getDefaultState());
				    }
				}
				if(startY >= 0){
				    startY--;
				}
		    }
		}
		else if(side == 1){
		    int startX = 6, startZ = 2;
		    int difX = airBlocksVer + startX;
		    int difZ = airBlocksHor + startZ;
		    for(int x1 = startX; x1 < difX; x1++){
				for(int z1 = startZ; z1 < difZ; z1++){
				    for(int y1 = startY; y1 > -4; y1--){
				    	world.setBlockToAir(new BlockPos(x + x1, y + y1, z + z1));
				    }
				    for(int y1 = startY; y1 > -5; y1--){
						world.setBlockState(new BlockPos(x + x1, y + y1, z + 1), this.mainBlock.getDefaultState());	
						world.setBlockState(new BlockPos(x + x1, y + y1, z + difZ), this.mainBlock.getDefaultState());
				    }	
				    world.setBlockState(new BlockPos(x + x1, y - 4, z + z1), this.mainBlock.getDefaultState());
				    world.setBlockState(new BlockPos(x + x1, y + startY + 1, z + z1), this.mainBlock.getDefaultState());
				    for(int y1 = startY - 5; y1 > -4; y1--){
				    	world.setBlockState(new BlockPos(x + x1, y + y1, z + z1), this.mainBlock.getDefaultState());
				    }
				    if(startY - 5 > -5){
				    	BlockPos facing = new BlockPos(x + x1, y + (startY - 4), z + z1).offset(EnumFacing.VALUES[4]);
				    	world.setBlockState(facing, this.stairBlock.getDefaultState());
				    }
				}
				if(startY >= 0){
				    startY--;
				}
		    }
		}
		else if(side == 2){
		    int startX = 2, startZ = 6;
		    int difX = airBlocksHor + startX;
		    int difZ = airBlocksVer + startZ;
		    for(int z1 = startZ; z1 < difZ; z1++){
				for(int x1 = startX; x1 < difX; x1++){
				    for(int y1 = startY; y1 > -4; y1--){
				    	world.setBlockToAir(new BlockPos(x + x1, y + y1, z + z1));
				    }
				    for(int y1 = startY; y1 > -5; y1--){
						world.setBlockState(new BlockPos(x + 1, y + y1, z + z1), this.mainBlock.getDefaultState());	
						world.setBlockState(new BlockPos(x + difX, y + y1, z + z1), this.mainBlock.getDefaultState());
				    }	
				    world.setBlockState(new BlockPos(x + x1, y - 4, z + z1), this.mainBlock.getDefaultState());
				    world.setBlockState(new BlockPos(x + x1, y + startY + 1, z + z1), this.mainBlock.getDefaultState());
				    for(int y1 = startY - 5; y1 > -4; y1--){
				    	world.setBlockState(new BlockPos(x + x1, y + y1, z + z1), this.mainBlock.getDefaultState());
				    }
				    if(startY - 5 > -5){
				    	BlockPos facing = new BlockPos(x + x1, y + (startY - 4), z + z1).offset(EnumFacing.VALUES[5]);
				    	world.setBlockState(facing, this.stairBlock.getDefaultState());
				    }
				}
				if(startY >= 0){
				    startY--;
				}
		    }
		}
		else if(side == 3){
		    int startX = 0, startZ = 2;
		    int difX = airBlocksVer + startX;
		    int difZ = airBlocksHor + startZ;
		    for(int x1 = startX; x1 > -difX; x1--){
				for(int z1 = startZ; z1 < difZ; z1++){
				    for(int y1 = startY; y1 > -4; y1--){
				    	world.setBlockToAir(new BlockPos(x + x1, y + y1, z + z1));	
				    }	
				    for(int y1 = startY; y1 > -5; y1--){
						world.setBlockState(new BlockPos(x + x1, y + y1, z + 1), this.mainBlock.getDefaultState());	
						world.setBlockState(new BlockPos(x + x1, y + y1, z + difZ), this.mainBlock.getDefaultState());
				    }
				    world.setBlockState(new BlockPos(x + x1, y - 4, z + z1), this.mainBlock.getDefaultState());
				    world.setBlockState(new BlockPos(x + x1, y + startY + 1, z + z1), this.mainBlock.getDefaultState());
				    for(int y1 = startY - 5; y1 > -4; y1--){
				    	world.setBlockState(new BlockPos(x + x1, y + y1, z + z1), this.mainBlock.getDefaultState());
				    }
				    if(startY - 5 > -5){
				    	BlockPos facing = new BlockPos(x + x1, y + (startY - 4), z + z1).offset(EnumFacing.VALUES[3]);
				    	world.setBlockState(facing, this.stairBlock.getDefaultState());
				    }
				}
				if(startY >= 0){
				    startY--;
				}
		    }
		}
    }

    private void spawnChestRoom(World world, Random random, int xOffset, int yOffset, int zOffset, int size, Block brick, int entranceSide, boolean hasChest){
		int roomSize = size + 2;
		int middleOffset = (roomSize - 1) / 2;
		int chestSpot = 0;
		// Spawn room
		for(int y = 0; y < size; y++){
		    for(int x = 0; x < roomSize; x++){
				for(int z = 0; z < roomSize; z++){
				    world.setBlockToAir(new BlockPos(x + xOffset, y + yOffset, z + zOffset));
				    if(x == 0 || x == roomSize - 1 || z == 0 || z == roomSize - 1 || y == 0 || y == size - 1){
				    	world.setBlockState(new BlockPos(x + xOffset, y + yOffset, z + zOffset), brick.getDefaultState());
				    }
				}
		    }
		}
		// Spawn door
		ItemDoor door = (ItemDoor) Item.getItemFromBlock(Block.getBlockFromName("wooden_door"));
		if(entranceSide == 0){
		    for(int y = 1; y < 3; y++){
		    	world.setBlockToAir(new BlockPos(xOffset + middleOffset, yOffset + y, zOffset));
		    }
		    door.placeDoor(world, new BlockPos(xOffset + middleOffset, yOffset + 1, zOffset), EnumFacing.VALUES[entranceSide], Block.getBlockFromName("wooden_door"));
		}
		else if(entranceSide == 1){
		    for(int y = 1; y < 3; y++){
		    	world.setBlockToAir(new BlockPos(xOffset + (roomSize - 1), yOffset + y, zOffset + middleOffset));
		    }
		    door.placeDoor(world, new BlockPos(xOffset + (roomSize - 1), yOffset + 1, zOffset + middleOffset), EnumFacing.VALUES[entranceSide], Block.getBlockFromName("wooden_door"));
		}
		else if(entranceSide == 2){
		    for(int y = 1; y < 3; y++){
		    	world.setBlockToAir(new BlockPos(xOffset + middleOffset, yOffset + y, zOffset + (roomSize - 1)));
		    }
		    door.placeDoor(world, new BlockPos(xOffset + middleOffset, yOffset + 1, zOffset + (roomSize - 1)), EnumFacing.VALUES[entranceSide], Block.getBlockFromName("wooden_door"));
		}
		else if(entranceSide == 3){
		    for(int y = 1; y < 3; y++){
		    	world.setBlockToAir(new BlockPos(xOffset, yOffset + y, zOffset + middleOffset));
		    }
		    door.placeDoor(world, new BlockPos(xOffset, yOffset + 1, zOffset + middleOffset), EnumFacing.VALUES[entranceSide], Block.getBlockFromName("wooden_door"));
		}
		// Spawn chest
		if(hasChest){
	    	BlockPos facing = new BlockPos(xOffset + middleOffset, yOffset + 1, zOffset + middleOffset).offset(EnumFacing.VALUES[entranceSide]);
		    world.setBlockState(facing, Blocks.chest.getDefaultState());
		    TileEntityChest tileentitychest = (TileEntityChest)world.getTileEntity(new BlockPos(xOffset + middleOffset, yOffset + 1, zOffset + middleOffset));
		    if (tileentitychest != null) {
		    	WeightedRandomChestContent.generateChestContents(random, this.chestContent, tileentitychest, ChestGenHooks.getCount(DUNGEON_CHEST, random));
		    }
		}
    }

    /**
     * Randomly decides which spawner to use in a dungeon
     */
    private String pickMobSpawner(Random par1Random){
		DungeonHooks.removeDungeonMob("Skeleton");
		DungeonHooks.removeDungeonMob("Zombie");
		DungeonHooks.removeDungeonMob("Spider");
		DungeonHooks.addDungeonMob("SoulKotek", 100);
		DungeonHooks.addDungeonMob("SoulYeti", 300);
		return DungeonHooks.getRandomDungeonMob(par1Random);
    }
}