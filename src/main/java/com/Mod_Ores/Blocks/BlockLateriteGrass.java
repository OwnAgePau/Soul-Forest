package com.Mod_Ores.Blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.Mod_Ores.soul_forest;
import com.Mod_Ores.Init.SoulBlocks;

public class BlockLateriteGrass extends Block{
    
	/*@SideOnly(Side.CLIENT)
    private IIcon iconLateriteTop;
    @SideOnly(Side.CLIENT)
    private IIcon iconSnowSide;
    @SideOnly(Side.CLIENT)
    private IIcon iconLateriteSideOverlay;*/
	
	public final String textureName;
	
	public String getName(){
		return this.textureName;
	}

    public BlockLateriteGrass(String Unlname){
        super(Material.grass);
        this.setTickRandomly(true);
        this.setCreativeTab(soul_forest.tabSoulBlocks);
        this.setUnlocalizedName(soul_forest.MODID + "_" + Unlname);
        this.textureName = Unlname;
		GameRegistry.registerBlock(this, Unlname);
    }

    /*@SideOnly(Side.CLIENT)

    @Override
    public IIcon getIcon(int par1, int par2){
        return par1 == 1 ? this.iconLateriteTop : (par1 == 0 ?  SoulBlocks.LateriteDirt.get().getBlockTextureFromSide(par1) : this.blockIcon);
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
                par1World.setBlockState(pos, SoulBlocks.LateriteDirt.get().getDefaultState());
            }
            else if (par1World.getBlockLightOpacity(pos.up()) >= 9){
                for (int l = 0; l < 4; ++l){
                    int i1 = pos.getX() + par5Random.nextInt(3) - 1;
                    int j1 = pos.getY() + par5Random.nextInt(5) - 3;
                    int k1 = pos.getZ() + par5Random.nextInt(3) - 1;
                    IBlockState l1 = par1World.getBlockState(new BlockPos(i1, j1 + 1, k1));

                    if (par1World.getBlockState(new BlockPos(i1, j1, k1)).getBlock() == SoulBlocks.LateriteDirt.get() && par1World.getBlockLightOpacity(new BlockPos(i1, j1 + 1, k1)) >= 4 && par1World.getBlockLightOpacity(new BlockPos(i1, j1 + 1, k1)) <= 2){
                        par1World.setBlockState(new BlockPos(i1, j1, k1), SoulBlocks.LateriteDirt.get().getDefaultState());
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
        return SoulBlocks.LateriteDirt.get().idDropped(0, par2Random, par3);
    }*/

    /*@SideOnly(Side.CLIENT)

    public IIcon getBlockTexture(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {
        if (par5 == 1)
        {
            return this.iconLateriteTop;
        }
        else if (par5 == 0)
        {
            return SoulBlocks.LateriteDirt.get().getBlockTextureFromSide(par5);
        }
        else
        {
            Material material = par1IBlockAccess.getBlock(par2, par3 + 1, par4).getMaterial();
            return material != Material.snow && material != Material.craftedSnow ? this.blockIcon : this.iconSnowSide;
        }
    }

    @SideOnly(Side.CLIENT)

    @Override
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("soulforest:Laterite_grass_side");
        this.iconLateriteTop = par1IconRegister.registerIcon("soulforest:Laterite_grass_top");
        this.iconSnowSide = par1IconRegister.registerIcon("soulforest:Laterite_grass_side");
        this.iconLateriteSideOverlay = par1IconRegister.registerIcon("soulforest:Laterite_grass_side");
    }*/
}