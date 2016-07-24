package com.Mod_Ores.Blocks;

import java.util.Random;

import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
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

public class BlockSoulIce extends BlockBreakable{
	
	public final String textureName;
	
	public String getName(){
		return this.textureName;
	}
    
    public BlockSoulIce(String unlName){
        super(Material.ice, false); // "soulforest:soul_ice", 
        this.slipperiness = 1.0F;
        this.setHardness(0.2F);
        this.setTickRandomly(true);
        this.setCreativeTab(soul_forest.tabSoulBlocks);
		this.setStepSound(this.soundTypeMetal);
		this.setUnlocalizedName(soul_forest.MODID + "_" + unlName);
		this.textureName = unlName;
		GameRegistry.registerBlock(this, unlName);
    }

    @SideOnly(Side.CLIENT)

    /**
     * Returns which pass should this block be rendered on. 0 for solids and 1 for alpha
     */
    public int getRenderBlockPass(){
        return 1;
    }

    @SideOnly(Side.CLIENT)

    /**
     * Returns true if the given side of this block type should be rendered, if the adjacent block is at the given
     * coordinates.  Args: blockAccess, x, y, z, side
     */
    public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, BlockPos pos, EnumFacing side){
        return super.shouldSideBeRendered(par1IBlockAccess, pos, side.UP);
    }

    /**
     * Called when the player destroys a block with an item that can harvest it. (i, j, k) are the coordinates of the
     * block and l is the block's subtype/damage.
     */
    public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state, TileEntity te){
    	super.harvestBlock(worldIn, player, pos, state, te);
        //par2EntityPlayer.addStat(StatList.mineBlockStatArray[this], 1);
    	player.addExhaustion(0.025F);

        if (this.canSilkHarvest() && EnchantmentHelper.getSilkTouchModifier(player)){
            ItemStack itemstack = this.createStackedBlock(state);

            if (itemstack != null){
                this.dropBlockAsItem(worldIn, pos, state , 0);
            }
        }
        else{
            int i1 = EnchantmentHelper.getFortuneModifier(player);
            this.dropBlockAsItem(worldIn, pos, state, i1);
            Material material = worldIn.getBlockState(pos.down()).getBlock().getMaterial();

            if (material.blocksMovement() || material.isLiquid()){
            	worldIn.setBlockState(pos, SoulBlocks.SoulWaterMoving.get().getDefaultState());
            }
        }
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random par1Random){
        return 0;
    }

    /**
     * Ticks the block if it's been scheduled
     */
    @Override
    public void updateTick(World par1World, BlockPos pos, IBlockState state, Random par5Random){
    	if(par1World.getBiomeGenForCoords(pos).temperature >= 0.5F){
            this.dropBlockAsItem(par1World, pos, state, 0);
            par1World.setBlockState(pos, SoulBlocks.SoulWaterMoving.get().getDefaultState());
        }
    	if(par1World.getBlockState(pos.up()).getBlock() != Blocks.air){
    	    this.dropBlockAsItem(par1World,pos, state, 0);
            par1World.setBlockState(pos, SoulBlocks.SoulWaterMoving.get().getDefaultState());
    	}
    }

    /**
     * Returns the mobility information of the block, 0 = free, 1 = can't push but can move over, 2 = total immobility
     * and stop pistons
     */
    public int getMobilityFlag(){
        return 0;
    }
    
    @Override
    public boolean canSustainPlant(IBlockAccess world, BlockPos pos, EnumFacing direction, IPlantable plant) {
    	return false;
    }
}