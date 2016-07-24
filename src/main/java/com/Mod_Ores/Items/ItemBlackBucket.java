package com.Mod_Ores.Items;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.server.S42PacketCombatEvent.Event;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.Mod_Ores.soul_forest;
import com.Mod_Ores.Init.SoulBlocks;
import com.Mod_Ores.Init.SoulItems;

public class ItemBlackBucket extends ItemBucket{
    /** field for checking if the bucket has been filled. */
    private Block isFull;
    
    public final String textureName;
    
    public String getName(){
    	return this.textureName;
    }

    public ItemBlackBucket(Block par2, String UnlName){
        super(par2);
        this.maxStackSize = 1;
        this.isFull = par2;
        this.setCreativeTab(soul_forest.tabSoulOther);
        this.setUnlocalizedName(soul_forest.MODID + "_" + UnlName);
        this.textureName = UnlName;
		GameRegistry.registerItem(this, UnlName);
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer){
        float f = 1.0F;
        //double d0 = par3EntityPlayer.prevPosX + (par3EntityPlayer.posX - par3EntityPlayer.prevPosX) * (double)f;
        //double d1 = par3EntityPlayer.prevPosY + (par3EntityPlayer.posY - par3EntityPlayer.prevPosY) * (double)f + 1.62D - (double)par3EntityPlayer.yOffset;
        //double d2 = par3EntityPlayer.prevPosZ + (par3EntityPlayer.posZ - par3EntityPlayer.prevPosZ) * (double)f;
        boolean flag = this.isFull == Blocks.air;
        MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(par2World, par3EntityPlayer, flag);

        if (movingobjectposition == null){
            return par1ItemStack;
        }
        else{
            FillBucketEvent event = new FillBucketEvent(par3EntityPlayer, par1ItemStack, par2World, movingobjectposition);
            if (MinecraftForge.EVENT_BUS.post(event)){
                return par1ItemStack;
            }

            if (event.getResult() == Result.ALLOW){
                if (par3EntityPlayer.capabilities.isCreativeMode){
                    return par1ItemStack;
                }

                if (--par1ItemStack.stackSize <= 0){
                    return event.result;
                }

                if (!par3EntityPlayer.inventory.addItemStackToInventory(event.result)){
                    par3EntityPlayer.dropPlayerItemWithRandomChoice(event.result, false);
                }

                return par1ItemStack;
            }

            if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK){
            	BlockPos blockPos = movingobjectposition.getBlockPos();
                int i = movingobjectposition.getBlockPos().getX();
                int j = movingobjectposition.getBlockPos().getY();
                int k = movingobjectposition.getBlockPos().getZ();

                if (!par2World.canMineBlockBody(par3EntityPlayer, blockPos)){
                    return par1ItemStack;
                }

                if (this.isFull == Blocks.air){
                    if (!par3EntityPlayer.canPlayerEdit(blockPos, movingobjectposition.sideHit, par1ItemStack)){
                        return par1ItemStack;
                    }

                    IBlockState blockState = par2World.getBlockState(blockPos);
                    if (blockState.getBlock().getMaterial() == Material.water && blockState.getBlock().getMetaFromState(blockState) == 0){
                        par2World.setBlockToAir(blockPos);

                        if (par3EntityPlayer.capabilities.isCreativeMode){
                            return par1ItemStack;
                        }

                        if (--par1ItemStack.stackSize <= 0){
                            return new ItemStack(SoulItems.BucketSoulWater.get());
                        }

                        if (!par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(SoulItems.BucketSoulWater.get()))){
                            par3EntityPlayer.dropPlayerItemWithRandomChoice(new ItemStack(SoulItems.BucketSoulWater.get()), false);
                        }

                        return par1ItemStack;
                    }

                    if (blockState.getBlock().getMaterial() == Material.water && blockState.getBlock() == SoulBlocks.SoulWaterMoving.get()){
                        par2World.setBlockToAir(blockPos);

                        if (par3EntityPlayer.capabilities.isCreativeMode){
                            return par1ItemStack;
                        }

                        if (--par1ItemStack.stackSize <= 0){
                            return new ItemStack(SoulItems.BucketSoulWater.get());
                        }

                        if (!par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(SoulItems.BucketSoulWater.get()))){
                            par3EntityPlayer.dropPlayerItemWithRandomChoice(new ItemStack(SoulItems.BucketSoulWater.get()), false);
                        }

                        return par1ItemStack;
                    }
                }
                else{
                    if (this.isFull == Blocks.air){
                        return new ItemStack(SoulItems.SoulBucket.get());
                    }

                    BlockPos blockPosSide = blockPos.offset(movingobjectposition.sideHit);

                    if (!par3EntityPlayer.canPlayerEdit(blockPosSide, movingobjectposition.sideHit, par1ItemStack)){
                        return par1ItemStack;
                    }

                    if (this.tryPlaceContainedLiquid(par2World, blockPosSide) && !par3EntityPlayer.capabilities.isCreativeMode){
                        return new ItemStack(SoulItems.SoulBucket.get());
                    }
                }
            }
            else if (this.isFull == Blocks.air && movingobjectposition.entityHit instanceof EntityCow){
                return null;
            }

            return par1ItemStack;
        }
    }

    /**
     * Attempts to place the liquid contained inside the bucket.
     */
    public boolean tryPlaceContainedLiquid(World par1World, BlockPos pos){
        if (this.isFull == Blocks.air){
            return false;
        }
        else{
            Material material = par1World.getBlockState(pos).getBlock().getMaterial();
            boolean flag = !material.isSolid();

            if (!par1World.isAirBlock(pos) && !flag){
                return false;
            }
            else{
		        if (par1World.provider.doesWaterVaporize() && this.isFull == SoulBlocks.SoulWaterMoving.get()){
		        	int x = pos.getX();
                    int y = pos.getY();
                    int z = pos.getZ();
		        	par1World.playSoundEffect((double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), "random.fizz", 0.5F, 2.6F + (par1World.rand.nextFloat() - par1World.rand.nextFloat()) * 0.8F);

	                for (int l = 0; l < 8; ++l){
	                    par1World.spawnParticle(EnumParticleTypes.SMOKE_LARGE, (double)x + Math.random(), (double)y + Math.random(), (double)z + Math.random(), 0.0D, 0.0D, 0.0D);
	                }
	            }
	            else{
                    if (!par1World.isRemote && flag && !material.isLiquid()){
                        par1World.destroyBlock(pos, true);
                    }
                    
		            par1World.setBlockState(pos, this.isFull.getDefaultState(), 3);
		        }
	
	            return true;
	        }
        }
    }
    
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack par1ItemStack){
        return true;
    }
}