package com.Mod_Ores.Blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.Mod_Ores.soul_forest;

public class BlockSoulLog extends Block{
    
	/*@SideOnly(Side.CLIENT)
    private IIcon[] iconArray;
    @SideOnly(Side.CLIENT)
    private IIcon tree_top;*/
    
    public static final PropertyEnum<BlockSoulLog.EnumType> VARIANT = PropertyEnum.<BlockSoulLog.EnumType>create("variant", BlockSoulLog.EnumType.class);

	public final String textureName;
	
	public String getName(){
		return this.textureName;
	}
    
    /**
     * 
     * @param id This is the logs id
     * @param unlocalizedName this is the logs unlocalized name
     * @param InGname this is the logs in game name
     * @param Hardness this is the logs hardness
     */
    public BlockSoulLog(String unlocalizedName, float Hardness){
		super(Material.wood);
		this.setCreativeTab(soul_forest.tabSoulBlocks);
		setHardness(Hardness);
		this.textureName = unlocalizedName;
		this.setUnlocalizedName(soul_forest.MODID + "_" + unlocalizedName);
		setStepSound(soundTypeWood);
		GameRegistry.registerBlock(this, unlocalizedName);
		this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, BlockSoulLog.EnumType.OAK));
    }

    /**
     * The type of render function that is called for this block
     */
    public int getRenderType(){
    	return 31;
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random par1Random){
    	return 1;
    }

    @Override
    public int damageDropped(IBlockState state){
        return ((BlockSoulLog.EnumType)state.getValue(VARIANT)).getMetadata();
    }

    /**
     * ejects contained items into the world, and notifies neighbours of an update, as appropriate
     */
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state){
        int i = 4;
        int j = i + 1;
        if (worldIn.isAreaLoaded(pos.add(-j, -j, -j), pos.add(j, j, j))){
            for (BlockPos blockpos : BlockPos.getAllInBox(pos.add(-i, -i, -i), pos.add(i, i, i))){
                IBlockState iblockstate = worldIn.getBlockState(blockpos);

                if (iblockstate.getBlock().isLeaves(worldIn, blockpos)){
                    iblockstate.getBlock().beginLeavesDecay(worldIn, blockpos);
                }
            }
        }
    }

    /**
     * Called when a block is placed using its ItemBlock. Args: World, X, Y, Z, side, hitX, hitY, hitZ, block metadata
     */
    public int onBlockPlaced(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9){
		int j1 = par9 & 3;
		byte b0 = 0;
	
		switch (par5){
		case 0:
		case 1:
		    b0 = 0;
		    break;
		case 2:
		case 3:
		    b0 = 8;
		    break;
		case 4:
		case 5:
		    b0 = 4;
		}
	
		return j1 | b0;
	}

    /*@SideOnly(Side.CLIENT)

    @Override
    public IIcon getIcon(int par1, int par2){
		int k = par2 & 12;
		int l = par2 & 3;
		return k == 0 && (par1 == 1 || par1 == 0) ? this.tree_top : (k == 4 && (par1 == 5 || par1 == 4) ? this.tree_top : (k == 8 && (par1 == 2 || par1 == 3) ? this.tree_top : this.iconArray[l]));
    }*/

    /**
     * returns a number between 0 and 3
     */
    public static int limitToValidMetadata(int par0){
    	return par0 & 3;
    }

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List<ItemStack> list){
        for (BlockPlanks.EnumType blockplanks$enumtype : BlockPlanks.EnumType.values()){
            list.add(new ItemStack(itemIn, 1, blockplanks$enumtype.getMetadata()));
        }
    }

    /**
     * Convert the given metadata into a BlockState for this Block
     */
    public IBlockState getStateFromMeta(int meta){
        return this.getDefaultState().withProperty(VARIANT, BlockSoulLog.EnumType.byMetadata(meta));
    }

    /**
     * Get the MapColor for this Block and the given BlockState
     */
    public MapColor getMapColor(IBlockState state){
        return ((BlockSoulLog.EnumType)state.getValue(VARIANT)).func_181070_c();
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int getMetaFromState(IBlockState state){
        return ((BlockSoulLog.EnumType)state.getValue(VARIANT)).getMetadata();
    }

    protected BlockState createBlockState(){
        return new BlockState(this, new IProperty[] {VARIANT});
    }

    /**
     * Returns an item stack containing a single instance of the current block type. 'i' is the block's subtype/damage
     * and is ignored for blocks which do not support subtypes. Blocks which cannot be harvested should return null.
     */
    protected ItemStack createStackedBlock(int par1){
    	return new ItemStack(this, 1, limitToValidMetadata(par1));
    }

    /*@SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister par1IconRegister){
		this.tree_top = par1IconRegister.registerIcon("soulforest:" + this.unlName + "_top");
	
		this.iconArray = new IIcon[2];
	
		for (int i = 0; i < 2; ++i){
		    this.iconArray[i] = par1IconRegister.registerIcon("soulforest:" + this.unlName);
		}
    }*/
    
    public static enum EnumType implements IStringSerializable{
    	// TODO change all these EnumTypes with all plants, and wood etc.
        OAK(0, "oak", MapColor.woodColor),
        SPRUCE(1, "spruce", MapColor.obsidianColor),
        BIRCH(2, "birch", MapColor.sandColor),
        JUNGLE(3, "jungle", MapColor.dirtColor),
        ACACIA(4, "acacia", MapColor.adobeColor),
        DARK_OAK(5, "dark_oak", "big_oak", MapColor.brownColor);

        private static final BlockSoulLog.EnumType[] META_LOOKUP = new BlockSoulLog.EnumType[values().length];
        private final int meta;
        private final String name;
        private final String unlocalizedName;
        private final MapColor field_181071_k;

        private EnumType(int p_i46388_3_, String p_i46388_4_, MapColor p_i46388_5_){
            this(p_i46388_3_, p_i46388_4_, p_i46388_4_, p_i46388_5_);
        }

        private EnumType(int p_i46389_3_, String p_i46389_4_, String p_i46389_5_, MapColor p_i46389_6_)
        {
            this.meta = p_i46389_3_;
            this.name = p_i46389_4_;
            this.unlocalizedName = p_i46389_5_;
            this.field_181071_k = p_i46389_6_;
        }

        public int getMetadata(){
            return this.meta;
        }

        public MapColor func_181070_c(){
            return this.field_181071_k;
        }

        public String toString()
        {
            return this.name;
        }

        public static BlockSoulLog.EnumType byMetadata(int meta){
            if (meta < 0 || meta >= META_LOOKUP.length){
                meta = 0;
            }

            return META_LOOKUP[meta];
        }

        public String getName(){
            return this.name;
        }

        public String getUnlocalizedName(){
            return this.unlocalizedName;
        }

        static{
            for (BlockSoulLog.EnumType blockplanks$enumtype : values()){
                META_LOOKUP[blockplanks$enumtype.getMetadata()] = blockplanks$enumtype;
            }
        }
    }

    @Override
    public boolean canSustainLeaves(IBlockAccess world, BlockPos pos){
    	return true;
    }

    @Override
    public boolean canSustainPlant(IBlockAccess world, BlockPos pos, EnumFacing direction, IPlantable plant) {
    	return false;
    }

    @Override
    public boolean isWood(IBlockAccess world, BlockPos pos){
    	return true;
    }
}