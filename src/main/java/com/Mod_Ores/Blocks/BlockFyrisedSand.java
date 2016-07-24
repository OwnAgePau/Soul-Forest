package com.Mod_Ores.Blocks;

import java.util.Random;

import javax.swing.Icon;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
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
import com.Mod_Ores.Particles.RenderParticles;

public class BlockFyrisedSand extends Block{
    
	/*@SideOnly(Side.CLIENT)
    private IIcon iconFyrisedTop;
    @SideOnly(Side.CLIENT)
    private IIcon iconSnowSide;
    @SideOnly(Side.CLIENT)
    private IIcon iconFyrisedSideOverlay;*/
	
	public final String textureName;
	
	public String getName(){
		return this.textureName;
	}

    public BlockFyrisedSand(String Unlname){
		super(Material.sand);
		this.setTickRandomly(true);
		this.setCreativeTab(soul_forest.tabSoulBlocks);
		this.setStepSound(soundTypeSand);
		this.setUnlocalizedName(soul_forest.MODID + "_" + Unlname);
		this.textureName = Unlname;
		this.setHardness(0.2F);
		GameRegistry.registerBlock(this, Unlname);
    }

    @SideOnly(Side.CLIENT)

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    /*@Override
    public IIcon getIcon(int par1, int par2){
    	return par1 == 1 ? this.iconFyrisedTop : (par1 == 0 ?  SoulBlocks.FyrisedSand.get().getBlockTextureFromSide(par1) : this.blockIcon);
    }*/

    @Override
    public boolean canSustainPlant(IBlockAccess world, BlockPos pos, EnumFacing direction, IPlantable plant){
		if(plant != Block.getBlockFromName("red_flower") || plant != Block.getBlockFromName("yellow_flower")){
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
		    	par1World.setBlockState(pos, SoulBlocks.FyrisedSand.get().getDefaultState());
		    }
		    else if (par1World.getBlockLightOpacity(pos.up()) < 5){
				for (int l = 0; l < 4; ++l){
				    int i1 = pos.getX() + par5Random.nextInt(3) - 1;
				    int j1 = pos.getX() + par5Random.nextInt(5) - 3;
				    int k1 = pos.getX() + par5Random.nextInt(3) - 1;
				    IBlockState l1 = par1World.getBlockState(new BlockPos(i1, j1 + 1, k1));
		
				    if (par1World.getBlockState(new BlockPos(i1, j1, k1)).getBlock() == SoulBlocks.FyrisedSand.get() && par1World.getBlockLightOpacity(new BlockPos(i1, j1 + 1, k1)) >= 4 && par1World.getBlockLightOpacity(new BlockPos(i1, j1 + 1, k1)) <= 2){
				    	par1World.setBlockState(new BlockPos(i1, j1, k1), SoulBlocks.FyrisedSand.get().getDefaultState());
				    }
				}
		    }
		}
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    /*public int idDropped(int par1, Random par2Random, int par3)
    {
        return SoulBlocks.FyrisedSand.get();
    }*/

    /*@SideOnly(Side.CLIENT)

    public IIcon getBlockTexture(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5){
		if (par5 == 1){
		    return this.iconFyrisedTop;
		}
		else if (par5 == 0){
		    return SoulBlocks.FyrisedSand.get().getBlockTextureFromSide(par5);
		}
		else{
		    Material material = par1IBlockAccess.getBlock(par2, par3 + 1, par4).getMaterial();
		    return material != Material.snow && material != Material.craftedSnow ? this.blockIcon : this.iconSnowSide;
		}
    }

    @SideOnly(Side.CLIENT)

    @Override
    public void registerBlockIcons(IIconRegister par1IconRegister){
		this.blockIcon = par1IconRegister.registerIcon("soulforest:Fyrised_sand_side");
		this.iconFyrisedTop = par1IconRegister.registerIcon("soulforest:Fyrised_sand_top");
		this.iconSnowSide = par1IconRegister.registerIcon("soulforest:Fyrised_sand_side");
		this.iconFyrisedSideOverlay = par1IconRegister.registerIcon("soulforest:Fyrised_sand_side");
    }*/

    @Override
    public void randomDisplayTick(World par1World, BlockPos pos, IBlockState state, Random par5Random){
		//super.randomDisplayTick(par1World, par2, par3, par4, par5Random);
	
		/*if (par5Random.nextInt(6) == 0)
		{
		    RenderParticles.spawnParticle("fyrite", (double)((float)par2 + par5Random.nextFloat()), (double)((float)par3 + 1.1F), (double)((float)par4 + par5Random.nextFloat()), 0.0D, 0.0D, 0.0D);
		}*/
    }

    @Override
    public boolean isFlammable(IBlockAccess world, BlockPos pos, EnumFacing face){
    	return true;
    }
}