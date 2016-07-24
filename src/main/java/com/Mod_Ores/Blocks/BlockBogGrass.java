package com.Mod_Ores.Blocks;

import java.util.Random;

import javax.swing.Icon;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.Mod_Ores.soul_forest;
import com.Mod_Ores.Init.SoulBlocks;

public class BlockBogGrass extends Block{
    
	
	/*@SideOnly(Side.CLIENT)
    private IIcon iconBogTop;
    @SideOnly(Side.CLIENT)
    private IIcon iconSnowSide;
    @SideOnly(Side.CLIENT)
    private IIcon iconBogSideOverlay;*/
	
	public final String textureName;
	
	public String getName(){
		return this.textureName;
	}

    public BlockBogGrass(String Unlname){
		super(Material.grass);
		this.setTickRandomly(true);
		this.setCreativeTab(soul_forest.tabSoulBlocks);
		this.setUnlocalizedName(soul_forest.MODID + "_" + Unlname);
		this.textureName = Unlname;
		this.setStepSound(soundTypeGrass);
		this.setHardness(0.2F);
		GameRegistry.registerBlock(this, Unlname);
    }

    @SideOnly(Side.CLIENT)


    /*@Override
    public IIcon getIcon(int par1, int par2){
    	return par1 == 1 ? this.iconBogTop : (par1 == 0 ?  SoulBlocks.BogDirt.get().getBlockTextureFromSide(par1) : this.blockIcon);
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(IBlockAccess p_149673_1_, int p_149673_2_, int p_149673_3_, int p_149673_4_, int p_149673_5_){
    	return this.getIcon(p_149673_5_, p_149673_1_.getBlockMetadata(p_149673_2_, p_149673_3_, p_149673_4_));
    }*/


    @Override
    public boolean canSustainPlant(IBlockAccess world, BlockPos pos, EnumFacing direction, IPlantable plant) {
		if(plant != Block.getBlockFromName("yellow_flower") || plant != Block.getBlockFromName("red_flower")){
		    return true;
		}
		else{
		    return false;
		}
    }

    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World par1World, BlockPos pos, IBlockState state, Random par5Random){
		if (!par1World.isRemote){
		    if (par1World.getBlockLightOpacity(pos.up()) < 4 && par1World.getBlockLightOpacity(pos.up()) > 2){
		    	par1World.setBlockState(pos, SoulBlocks.BogDirt.get().getDefaultState());
		    }
		    else if (par1World.getBlockLightOpacity(pos.up()) >= 9){
				for (int l = 0; l < 4; ++l){
				    int i1 = pos.getX() + par5Random.nextInt(3) - 1;
				    int j1 = pos.getY() + par5Random.nextInt(5) - 3;
				    int k1 = pos.getZ() + par5Random.nextInt(3) - 1;
				    IBlockState l1 = par1World.getBlockState(new BlockPos(i1, j1 + 1, k1));
		
				    if (par1World.getBlockState(new BlockPos(i1, j1, k1)).getBlock() == SoulBlocks.BogDirt.get() && par1World.getBlockLightOpacity(new BlockPos(i1, j1 + 1, k1)) >= 4 && par1World.getBlockLightOpacity(new BlockPos(i1, j1 + 1, k1)) <= 2){
				    	par1World.setBlockState(new BlockPos(i1, j1, k1), SoulBlocks.BogDirt.get().getDefaultState());
				    }
				}
		    }
		}
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    @Override
    public Item getItemDropped(IBlockState state, Random par2Random, int fortune){
    	return SoulBlocks.BogDirt.get().getItemDropped(state, par2Random, fortune);
    }

    //@SideOnly(Side.CLIENT)

    /**
     * Retrieves the block texture to use based on the display side. Args: iBlockAccess, x, y, z, side
     */
    /*public IIcon getBlockTexture(int par1){
    	return this.getIcon(par1, 0);
    }

    @SideOnly(Side.CLIENT)

    @Override
    public void registerBlockIcons(IIconRegister par1IconRegister){
	this.blockIcon = par1IconRegister.registerIcon("soulforest:Bog_grass");
	this.iconBogTop = par1IconRegister.registerIcon("soulforest:Bog_grass_top");
	this.iconSnowSide = par1IconRegister.registerIcon("soulforest:Bog_grass");
	this.iconBogSideOverlay = par1IconRegister.registerIcon("soulforest:Bog_grass");
    }*/
}