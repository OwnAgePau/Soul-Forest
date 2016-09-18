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
    }

    /**
     * The type of render function that is called for this block
     */
    @Override
    public int getRenderType(){
    	return 3;
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random par1Random){
    	return 1;
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

    
    /*@SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister par1IconRegister){
		this.tree_top = par1IconRegister.registerIcon("soulforest:" + this.unlName + "_top");
	
		this.iconArray = new IIcon[2];
	
		for (int i = 0; i < 2; ++i){
		    this.iconArray[i] = par1IconRegister.registerIcon("soulforest:" + this.unlName);
		}
    }*/
    

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