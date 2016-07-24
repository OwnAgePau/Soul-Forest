package com.Mod_Ores.Blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockLeavesBase;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.Mod_Ores.IScollectable;
import com.Mod_Ores.soul_forest;

public class BlockSoulLeaves extends BlockLeaves implements IScollectable{
    
	public static final PropertyEnum<BlockSoulLeaves.EnumType> TYPE = PropertyEnum.<BlockSoulLeaves.EnumType>create("type", BlockSoulLeaves.EnumType.class);
    private Block sapling;
    //private IIcon icon;
    
	public final String textureName;
	
	public String getName(){
		return this.textureName;
	}
    
    /**
     * 
     * @param id The block ID
     * @param unlName this is the Unlocalized name
     * @param InGname this is the in game name
     * @param Hardness this is the blocks hardness
     * @param Resistance this is the blocks resistance
     */
    public BlockSoulLeaves(String unlName, float Hardness, float Resistance){
		super();
		this.setTickRandomly(true);
		this.setCreativeTab(soul_forest.tabSoulBerries);
		this.setHardness(Hardness); // Default 3.0F
		this.setResistance(Resistance); // Default 2F
		this.setLightOpacity(1);
		this.setStepSound(soundTypeGrass);
		GameRegistry.registerBlock(this, unlName);
		this.textureName = unlName;
		this.setUnlocalizedName(soul_forest.MODID + "_" + unlName);
    }
    
    public Block setSapling(Block sapling){
		this.sapling = sapling;
		return this.sapling;
    }
    
    @Override
    public int colorMultiplier(IBlockAccess p_149720_1_, BlockPos pos, int renderPass){
    	return 0xFFFFFF;
    }

    public int idDropped(int par1, Random random, int par2){
    	return -1;
    }
    
    @Override
    public int quantityDropped(Random p_149745_1_){
        return p_149745_1_.nextInt(20) == 0 ? 1 : 0;
    }
    
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune){
		if(this.sapling != null){
		    return Item.getItemFromBlock(this.sapling);
		}
		return null;
    }
    
    public static enum EnumType implements IStringSerializable{
        DEAD_BUSH(0, "dead_bush"),
        GRASS(1, "tall_grass"),
        FERN(2, "fern");

        private static final BlockSoulLeaves.EnumType[] META_LOOKUP = new BlockSoulLeaves.EnumType[values().length];
        private final int meta;
        private final String name;

        private EnumType(int meta, String name){
            this.meta = meta;
            this.name = name;
        }

        public int getMeta(){
            return this.meta;
        }

        public String toString(){
            return this.name;
        }

        public static BlockSoulLeaves.EnumType byMetadata(int meta){
            if (meta < 0 || meta >= META_LOOKUP.length){
                meta = 0;
            }

            return META_LOOKUP[meta];
        }

        public String getName(){
            return this.name;
        }

        static{
            for (BlockSoulLeaves.EnumType blocktallgrass$enumtype : values()){
                META_LOOKUP[blocktallgrass$enumtype.getMeta()] = blocktallgrass$enumtype;
            }
        }
    }
    
    @Override
    public boolean isCollectable(ItemStack item, World world, BlockPos pos){
    	return true;
    }

    @Override
    public ArrayList<ItemStack> onCollected(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
		ret.add(new ItemStack(this, 1, ((BlockSoulLeaves.EnumType)world.getBlockState(pos).getValue(TYPE)).getMeta()));
		return ret;
    }

	@Override
	public List<ItemStack> onSheared(ItemStack item, IBlockAccess world,
			BlockPos pos, int fortune) {
		return null;
	}

	@Override
	public net.minecraft.block.BlockPlanks.EnumType getWoodType(int meta) {
		return null;
	}

    /*@Override
    public IIcon getIcon(int p_149691_1_, int p_149691_2_) {
    	return this.icon;
    }
    
    @Override
    public void registerBlockIcons(IIconRegister par1IconRegister){
    	this.icon = par1IconRegister.registerIcon("soulforest:" + this.unlName);
    }*/
}