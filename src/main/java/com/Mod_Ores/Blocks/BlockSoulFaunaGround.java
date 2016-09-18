package com.Mod_Ores.Blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.Icon;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.Mod_Ores.IScollectable;
import com.Mod_Ores.soul_forest;

public class BlockSoulFaunaGround extends BlockBush implements IScollectable{
	
	public static final PropertyEnum<BlockSoulFaunaGround.EnumType> VARIANT = PropertyEnum.<BlockSoulFaunaGround.EnumType>create("variant", BlockSoulFaunaGround.EnumType.class);
	
    public static final String[] grassTypes = new String[] {"Bog_grass_tall_grey", "Bog_grass_tall_grey", "Bog_grass_tall_green", "Bog_grass_tall_dark", "Bog_grass_tall_purple", "Frozen_tallgrass", "Bush"};

	public final String textureName;
	
	public String getName(){
		return this.textureName;
	}
    
    public BlockSoulFaunaGround(String unlocalizedName){
		super(Material.vine);
		this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, BlockSoulFaunaGround.EnumType.BOG_GREEN));
		float f = 0.4F;
		this.setStepSound(soundTypeGrass);
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.8F, 0.5F + f);
		this.setCreativeTab(soul_forest.tabSoulBerries);
		this.setUnlocalizedName(soul_forest.MODID + "_" + unlocalizedName);
		this.textureName = unlocalizedName;
		GameRegistry.registerBlock(this, unlocalizedName);
    }
    
    @Override
    public int damageDropped(IBlockState state){
        return ((BlockSoulFaunaGround.EnumType)state.getValue(VARIANT)).getMetadata();
    }
    
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List<ItemStack> list){
        for (BlockSoulFaunaGround.EnumType blockplanks$enumtype : BlockSoulFaunaGround.EnumType.values()){
            list.add(new ItemStack(itemIn, 1, blockplanks$enumtype.getMetadata()));
        }
    }
    
    public IBlockState getStateFromMeta(int meta){
        return this.getDefaultState().withProperty(VARIANT, BlockSoulFaunaGround.EnumType.byMetadata(meta));
    }

    /**
     * Get the MapColor for this Block and the given BlockState
     */
    public MapColor getMapColor(IBlockState state){
        return ((BlockSoulFaunaGround.EnumType)state.getValue(VARIANT)).func_181070_c();
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int getMetaFromState(IBlockState state){
        return ((BlockSoulFaunaGround.EnumType)state.getValue(VARIANT)).getMetadata();
    }

    protected BlockState createBlockState(){
        return new BlockState(this, new IProperty[] {VARIANT});
    }

    public static enum EnumType implements IStringSerializable{
        BOG_GREY(0, "Bog_grass_tall_grey", MapColor.grayColor),
        BOG_GREEN(1, "Bog_grass_tall_green", MapColor.foliageColor),
        BOG_DARK(2, "Bog_grass_tall_dark", MapColor.dirtColor),
        BOG_PURPLE(3, "Bog_grass_tall_purple", MapColor.purpleColor),
        FROZEN(4, "Frozen_tallgrass", MapColor.blueColor),
        BUSH(5, "Bush", MapColor.greenColor);

        private static final BlockSoulFaunaGround.EnumType[] META_LOOKUP = new BlockSoulFaunaGround.EnumType[values().length];
        private final int meta;
        private final String name;
        private final String unlocalizedName;
        private final MapColor field_181071_k;

        private EnumType(int p_i46388_3_, String p_i46388_4_, MapColor p_i46388_5_){
            this(p_i46388_3_, p_i46388_4_, p_i46388_4_, p_i46388_5_);
        }

        private EnumType(int p_i46389_3_, String p_i46389_4_, String p_i46389_5_, MapColor p_i46389_6_){
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

        public String toString(){
            return this.name;
        }

        public static BlockSoulFaunaGround.EnumType byMetadata(int meta){
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

        static {
            for (BlockSoulFaunaGround.EnumType blockplanks$enumtype : values()){
                META_LOOKUP[blockplanks$enumtype.getMetadata()] = blockplanks$enumtype;
            }
        }
    }
    
    @Override
    public int getRenderType() {
    	  return 3;
    }

    /*@SideOnly(Side.CLIENT)
    public IIcon getIcon(int par1, int par2){
		if (par2 > 6){
		    par2 = 0;
		}
		return this.iconArray[par2];
    }*/

    @Override
    public boolean canPlaceBlockAt(World par1World, BlockPos pos){
		IBlockState block = par1World.getBlockState(pos.down());
		if(block != null){
		    if(block.getBlock().canSustainPlant(par1World, pos.down(), EnumFacing.UP, this))
			return true;   
		}
		else{
		    return false;
		}
	
		return block.getBlock().canSustainPlant(par1World, pos.down(), EnumFacing.UP, this);
    }

    @Override
    public boolean canBeReplacedByLeaves(IBlockAccess world, BlockPos pos){
    	return true;
    }

    @Override
    public boolean canSustainPlant(IBlockAccess world, BlockPos pos, EnumFacing direction, IPlantable plant){
    	return false;
    }

    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor blockID
     */
    public void onNeighborBlockChange(World par1World, BlockPos pos, IBlockState state){
    	this.checkBlockCoordValid(par1World, pos, state);
    }

    /**
     * Checks if current block pos is valid, if not, breaks the block as dropable item. Used for reed and cactus.
     */
    protected final void checkBlockCoordValid(World par1World, BlockPos pos, IBlockState state){
		if (!this.canBlockStay(par1World, pos, state)){
		    //this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
		    par1World.setBlockToAir(pos);
		}
    }

    /**
     * Can this block stay at this position.  Similar to canPlaceBlockAt except gets checked often with plants.
     */
    @Override
    public boolean canBlockStay(World par1World, BlockPos pos, IBlockState state){
    	return this.canPlaceBlockAt(par1World, pos);
    }

    public static EnumPlantType getPlantType(World world, int x, int y, int z){
    	return EnumPlantType.Cave;
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3){
    	return -1;
    }

    /**
     * Returns the usual quantity dropped by the block plus a bonus of 1 to 'i' (inclusive).
     */
    public int quantityDroppedWithBonus(int par1, Random par2Random){
    	return 0;
    }

    /**
     * Called when the player destroys a block with an item that can harvest it. (i, j, k) are the coordinates of the
     * block and l is the block's subtype/damage.
     */
    public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state, TileEntity te){
    	super.harvestBlock(worldIn, player, pos, state, te);
    }

    @SideOnly(Side.CLIENT)
    public int getBlockColor(){
        double d0 = 0.5D;
        double d1 = 1.0D;
        return ColorizerGrass.getGrassColor(d0, d1);
    }

    @SideOnly(Side.CLIENT)

    /**
     * Returns the color this block should be rendered. Used by leaves.
     */
    public int getRenderColor(int par1){
        return 0;
    }

    @SideOnly(Side.CLIENT)

    /**
     * Returns a integer with hex for 0xrrggbb with this color multiplied against the blocks color. Note only called
     * when first determining what to render.
     */
    public int colorMultiplier(IBlockAccess par1IBlockAccess, int par2, int par3, int par4){
		//int l = par1IBlockAccess.getBlockMetadata(par2, par3, par4);	
		return 0xFFFFFF;
    }

    /*@SideOnly(Side.CLIENT)

    @Override
    public void registerBlockIcons(IIconRegister par1IconRegister){
		this.iconArray = new IIcon[this.grassTypes.length];
		for (int i = 0; i < this.iconArray.length; ++i){
		    this.iconArray[i] = par1IconRegister.registerIcon(soul_forest.MODID + ":" + grassTypes[i]);
		}
    }*/

    public ArrayList<ItemStack> getBlockDropped(World world, int x, int y, int z, int meta, int fortune){
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
		if (world.rand.nextInt(8) != 0){
		    return ret;
		}
	
		ItemStack item = ForgeHooks.getGrassSeed(world.rand);
		if (item != null){
		    ret.add(item);
		}
		return ret;
    }

    @Override
    public boolean isCollectable(ItemStack item, World world, BlockPos pos){
    	return true;
    }

    @Override
    public ArrayList<ItemStack> onCollected(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
		ret.add(new ItemStack(this, 1, ((BlockSoulFaunaGround.EnumType)world.getBlockState(pos).getValue(VARIANT)).getMetadata()));
		return ret;
    }
}