package com.Mod_Ores.Dimension.SoulForest;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.BlockPortal;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockWorldState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockPattern;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.Mod_Ores.soul_forest;
import com.Mod_Ores.Init.InitAchievements;
import com.Mod_Ores.Init.SoulBlocks;
import com.Mod_Ores.Init.Config.SoulConfig;
import com.Mod_Ores.Particles.RenderParticles;
import com.google.common.cache.LoadingCache;

public class TeleportBlockSoulForest extends BlockBreakable{
	
    public final String textureName;
	
	public String getName(){
    	return this.textureName;
    }
	
    public TeleportBlockSoulForest(String Unlname){
        super(Material.portal, false); // "soulforest:Soulportal_inside", 
        this.setCreativeTab(soul_forest.tabSoulOther);
        this.setTickRandomly(true);
        this.setUnlocalizedName(soul_forest.MODID + "_" + Unlname);
        this.textureName = Unlname;
		GameRegistry.registerBlock(this, Unlname);
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    /*public int idDropped(int par1, Random par2Random, int par3)
    {
        return SoulBlocks.SilverBlock.get().blockID;
    }*/
    
    public void updateTick(World par1World, BlockPos pos, IBlockState state, Random par5Random){
        super.updateTick(par1World, pos, state, par5Random);
    }
    	
    /**
     * Checks to see if this location is valid to create a portal and will return True if it does. Args: world, x, y, z
     */
    public boolean tryToCreatePortal(World par1World, int par2, int par3, int par4){
        byte b0 = 0;
        byte b1 = 0;

        if (par1World.getBlockState(new BlockPos(par2 - 1, par3, par4)).getBlock()  == SoulBlocks.SilverBlock.get() || par1World.getBlockState(new BlockPos(par2 + 1, par3, par4)).getBlock()  == SoulBlocks.SilverBlock.get()){
            b0 = 1;
        }

        if (par1World.getBlockState(new BlockPos(par2, par3, par4 - 1)).getBlock()  == SoulBlocks.SilverBlock.get() || par1World.getBlockState(new BlockPos(par2, par3, par4 + 1)).getBlock()  == SoulBlocks.SilverBlock.get()){
            b1 = 1;
        }

        if (b0 == b1){
            return false;
        }
        else{
            if (par1World.isAirBlock(new BlockPos(par2 - b0, par3, par4 - b1))){
                par2 -= b0;
                par4 -= b1;
            }

            int l;
            int i1;

            for (l = -1; l <= 2; ++l){
                for (i1 = -1; i1 <= 3; ++i1){
                    boolean flag = l == -1 || l == 2 || i1 == -1 || i1 == 3;

                    if (l != -1 && l != 2 || i1 != -1 && i1 != 3){
                        IBlockState j1 = par1World.getBlockState(new BlockPos(par2 + b0 * l, par3 + i1, par4 + b1 * l));
                        boolean isAirBlock = par1World.isAirBlock(new BlockPos(par2 + b0 * l, par3 + i1, par4 + b1 * l));

                        if (flag){
                            if (j1.getBlock() != SoulBlocks.SilverBlock.get()){
                                return false;
                            }
                        }
                        else if (!isAirBlock && j1.getBlock() != SoulBlocks.SoulFire.get()){
                            return false;
                        }
                    }
                }
            }

            for (l = 0; l < 2; ++l){
                for (i1 = 0; i1 < 3; ++i1){
                	par1World.setBlockState(new BlockPos(par2 + b0 * l, par3 + i1, par4 + b1 * l), this.getDefaultState());
                    //par1World.setBlock(par2 + b0 * l, par3 + i1, par4 + b1 * l, this, 0, 2);
                }
            }
            return true;
        }
    }

    /**
     * Triggered whenever an entity collides with this block (enters into the block). Args: world, x, y, z, entity
     */
    public void onEntityCollidedWithBlock(World var1, int var2, int var3, int var4, Entity var5){
    	if ((var5.ridingEntity == null) && (var5.riddenByEntity == null) && ((var5 instanceof EntityPlayerMP))){
    		EntityPlayerMP var6 = (EntityPlayerMP)var5;
            //var1.getMinecraftServerInstance(); 
            MinecraftServer mServer = MinecraftServer.getServer();
            if (var6.timeUntilPortal > 0){
            	var6.timeUntilPortal = 10;
            } 
            else if (var6.dimension != SoulConfig.SoulForestID){
            	var6.timeUntilPortal = 10;
                var6.mcServer.getConfigurationManager().transferPlayerToDimension(var6, SoulConfig.SoulForestID, new TeleporterSoulForest(mServer.worldServerForDimension(SoulConfig.SoulForestID)));
                var6.addStat(InitAchievements.soulForest, 1);
            }
            else {
                var6.timeUntilPortal = 10;
                var6.mcServer.getConfigurationManager().transferPlayerToDimension(var6, 0, new TeleporterSoulForest(mServer.worldServerForDimension(0)));
            }
    	}
    }
    
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4){
        return null;
    }

    /**
     * Updates the blocks bounds based on its current state. Args: world, x, y, z
     */
    public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4){
        float f;
        float f1;

        if (par1IBlockAccess.getBlockState(new BlockPos(par2 - 1, par3, par4)).getBlock()  != this && par1IBlockAccess.getBlockState(new BlockPos(par2 + 1, par3, par4)).getBlock()  != this){
            f = 0.125F;
            f1 = 0.5F;
            this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f1, 0.5F + f, 1.0F, 0.5F + f1);
        }
        else{
            f = 0.5F;
            f1 = 0.125F;
            this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f1, 0.5F + f, 1.0F, 0.5F + f1);
        }
    }

    /**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    public boolean isOpaqueCube(){
        return false;
    }

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock(){
        return false;
    }
    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor blockID
     */
    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5){
        byte b0 = 0;
        byte b1 = 1;

        if (par1World.getBlockState(new BlockPos(par2 - 1, par3, par4)).getBlock()  == this || par1World.getBlockState(new BlockPos(par2 + 1, par3, par4)).getBlock()  == this){
            b0 = 1;
            b1 = 0;
        }

        int i1;

        for (i1 = par3; par1World.getBlockState(new BlockPos(par2, i1 - 1, par4)).getBlock()  == this; --i1){
            ;
        }

        if (par1World.getBlockState(new BlockPos(par2, i1 - 1, par4)).getBlock()  != SoulBlocks.SilverBlock.get()){
            par1World.setBlockToAir(new BlockPos(par2, par3, par4));
        }
        else{
            int j1;

            for (j1 = 1; j1 < 4 && par1World.getBlockState(new BlockPos(par2, i1 + j1, par4)).getBlock()  == this; ++j1){
                ;
            }

            if (j1 == 3 && par1World.getBlockState(new BlockPos(par2, i1 + j1, par4)).getBlock()  == SoulBlocks.SilverBlock.get()){
                boolean flag = par1World.getBlockState(new BlockPos(par2 - 1, par3, par4)).getBlock()  == this || par1World.getBlockState(new BlockPos(par2 + 1, par3, par4)).getBlock()  == this;
                boolean flag1 = par1World.getBlockState(new BlockPos(par2, par3, par4 - 1)).getBlock()  == this || par1World.getBlockState(new BlockPos(par2, par3, par4 + 1)).getBlock()  == this;

                if (flag && flag1){
                    par1World.setBlockToAir(new BlockPos(par2, par3, par4));
                }
                else{
                    if ((par1World.getBlockState(new BlockPos(par2 + b0, par3, par4 + b1)).getBlock()  != SoulBlocks.SilverBlock.get() || par1World.getBlockState(new BlockPos(par2 - b0, par3, par4 - b1)).getBlock()  != this) && (par1World.getBlockState(new BlockPos(par2 - b0, par3, par4 - b1)).getBlock()  != SoulBlocks.SilverBlock.get() || par1World.getBlockState(new BlockPos(par2 + b0, par3, par4 + b1)).getBlock()  != this)){
                        par1World.setBlockToAir(new BlockPos(par2, par3, par4));
                    }
                }
            }
            else{
                par1World.setBlockToAir(new BlockPos(par2, par3, par4));
            }
        }
    }
    
    public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5){
        if (par1IBlockAccess.getBlockState(new BlockPos(par2, par3, par4)).getBlock()  == this){
            return false;
        }
        else{
            boolean flag = par1IBlockAccess.getBlockState(new BlockPos(par2 - 1, par3, par4)).getBlock()  == this && par1IBlockAccess.getBlockState(new BlockPos(par2 - 2, par3, par4)).getBlock()  != this;
            boolean flag1 = par1IBlockAccess.getBlockState(new BlockPos(par2 + 1, par3, par4)).getBlock()  == this && par1IBlockAccess.getBlockState(new BlockPos(par2 + 2, par3, par4)).getBlock()  != this;
            boolean flag2 = par1IBlockAccess.getBlockState(new BlockPos(par2, par3, par4 - 1)).getBlock()  == this && par1IBlockAccess.getBlockState(new BlockPos(par2, par3, par4 - 2)).getBlock()  != this;
            boolean flag3 = par1IBlockAccess.getBlockState(new BlockPos(par2, par3, par4 + 1)).getBlock()  == this && par1IBlockAccess.getBlockState(new BlockPos(par2, par3, par4 + 2)).getBlock()  != this;
            boolean flag4 = flag || flag1;
            boolean flag5 = flag2 || flag3;
            return flag4 && par5 == 4 ? true : (flag4 && par5 == 5 ? true : (flag5 && par5 == 2 ? true : flag5 && par5 == 3));
        }
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random par1Random){
        return 0;
    }
    
    public int getRenderBlockPass(){
        return 1;
    }
    
    public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random){
        if (par5Random.nextInt(100) == 0){
            par1World.playSound((double)par2 + 0.5D, (double)par3 + 0.5D, (double)par4 + 0.5D, "portal.portal", 0.5F, par5Random.nextFloat() * 0.4F + 0.8F, false);
        }
        
        for (int l = 0; l < 4; ++l){
            double d0 = (double)((float)par2 + par5Random.nextFloat());
            double d1 = (double)((float)par3 + par5Random.nextFloat());
            double d2 = (double)((float)par4 + par5Random.nextFloat());
            double d3 = 0.0D;
            double d4 = 0.0D;
            double d5 = 0.0D;
            int i1 = par5Random.nextInt(2) * 2 - 1;
            d3 = ((double)par5Random.nextFloat() - 0.5D) * 0.5D;
            d4 = ((double)par5Random.nextFloat() - 0.5D) * 0.5D;
            d5 = ((double)par5Random.nextFloat() - 0.5D) * 0.5D;

            if (par1World.getBlockState(new BlockPos(par2 - 1, par3, par4)) != this && par1World.getBlockState(new BlockPos(par2 + 1, par3, par4)).getBlock()  != this){
                d0 = (double)par2 + 0.5D + 0.25D * (double)i1;
                d3 = (double)(par5Random.nextFloat() * 2.0F * (float)i1);
            }
            else{
                d2 = (double)par4 + 0.5D + 0.25D * (double)i1;
                d5 = (double)(par5Random.nextFloat() * 2.0F * (float)i1);
            }

            RenderParticles.spawnParticle("soulportal", d0, d1, d2, d3, d4, d5);
        }
    }
    
    public int idPicked(World par1World, int par2, int par3, int par4){
        return 0;
    }
    
    public BlockPattern.PatternHelper func_181089_f(World p_181089_1_, BlockPos p_181089_2_){
        EnumFacing.Axis enumfacing$axis = EnumFacing.Axis.Z;
        Size blockportal$size = new Size(p_181089_1_, p_181089_2_, EnumFacing.Axis.X);
        LoadingCache<BlockPos, BlockWorldState> loadingcache = BlockPattern.func_181627_a(p_181089_1_, true);

        if (!blockportal$size.func_150860_b()){
            enumfacing$axis = EnumFacing.Axis.X;
            blockportal$size = new Size(p_181089_1_, p_181089_2_, EnumFacing.Axis.Z);
        }

        if (!blockportal$size.func_150860_b()){
            return new BlockPattern.PatternHelper(p_181089_2_, EnumFacing.NORTH, EnumFacing.UP, loadingcache, 1, 1, 1);
        }
        else{
            int[] aint = new int[EnumFacing.AxisDirection.values().length];
            
            EnumFacing enumfacing = blockportal$size.field_150866_c.rotateYCCW();
            BlockPos blockpos = blockportal$size.field_150861_f.up(blockportal$size.func_181100_a() - 1);

            for (EnumFacing.AxisDirection enumfacing$axisdirection : EnumFacing.AxisDirection.values()){
                BlockPattern.PatternHelper blockpattern$patternhelper = new BlockPattern.PatternHelper(enumfacing.getAxisDirection() == enumfacing$axisdirection ? blockpos : blockpos.offset(blockportal$size.field_150866_c, blockportal$size.func_181101_b() - 1), EnumFacing.func_181076_a(enumfacing$axisdirection, enumfacing$axis), EnumFacing.UP, loadingcache, blockportal$size.func_181101_b(), blockportal$size.func_181100_a(), 1);

                for (int i = 0; i < blockportal$size.func_181101_b(); ++i){
                    for (int j = 0; j < blockportal$size.func_181100_a(); ++j){
                        BlockWorldState blockworldstate = blockpattern$patternhelper.translateOffset(i, j, 1);

                        if (blockworldstate.getBlockState() != null && blockworldstate.getBlockState().getBlock().getMaterial() != Material.air){
                            ++aint[enumfacing$axisdirection.ordinal()];
                        }
                    }
                }
            }

            EnumFacing.AxisDirection enumfacing$axisdirection1 = EnumFacing.AxisDirection.POSITIVE;

            for (EnumFacing.AxisDirection enumfacing$axisdirection2 : EnumFacing.AxisDirection.values()){
                if (aint[enumfacing$axisdirection2.ordinal()] < aint[enumfacing$axisdirection1.ordinal()]){
                    enumfacing$axisdirection1 = enumfacing$axisdirection2;
                }
            }

            return new BlockPattern.PatternHelper(enumfacing.getAxisDirection() == enumfacing$axisdirection1 ? blockpos : blockpos.offset(blockportal$size.field_150866_c, blockportal$size.func_181101_b() - 1), EnumFacing.func_181076_a(enumfacing$axisdirection1, enumfacing$axis), EnumFacing.UP, loadingcache, blockportal$size.func_181101_b(), blockportal$size.func_181100_a(), 1);
        }
    }
    
    public static class Size{
        private final World world;
        private final EnumFacing.Axis axis;
        private final EnumFacing field_150866_c;
        private final EnumFacing field_150863_d;
        private int field_150864_e = 0;
        private BlockPos field_150861_f;
        private int field_150862_g;
        private int field_150868_h;

        public Size(World worldIn, BlockPos p_i45694_2_, EnumFacing.Axis p_i45694_3_){
            this.world = worldIn;
            this.axis = p_i45694_3_;

            if (p_i45694_3_ == EnumFacing.Axis.X){
                this.field_150863_d = EnumFacing.EAST;
                this.field_150866_c = EnumFacing.WEST;
            }
            else{
                this.field_150863_d = EnumFacing.NORTH;
                this.field_150866_c = EnumFacing.SOUTH;
            }

            for (BlockPos blockpos = p_i45694_2_; p_i45694_2_.getY() > blockpos.getY() - 21 && p_i45694_2_.getY() > 0 && this.func_150857_a(worldIn.getBlockState(p_i45694_2_.down()).getBlock()); p_i45694_2_ = p_i45694_2_.down()){
                ;
            }

            int i = this.func_180120_a(p_i45694_2_, this.field_150863_d) - 1;

            if (i >= 0){
                this.field_150861_f = p_i45694_2_.offset(this.field_150863_d, i);
                this.field_150868_h = this.func_180120_a(this.field_150861_f, this.field_150866_c);

                if (this.field_150868_h < 2 || this.field_150868_h > 21){
                    this.field_150861_f = null;
                    this.field_150868_h = 0;
                }
            }

            if (this.field_150861_f != null){
                this.field_150862_g = this.func_150858_a();
            }
        }

        protected int func_180120_a(BlockPos p_180120_1_, EnumFacing p_180120_2_){
            int i;

            for (i = 0; i < 22; ++i){
                BlockPos blockpos = p_180120_1_.offset(p_180120_2_, i);

                if (!this.func_150857_a(this.world.getBlockState(blockpos).getBlock()) || this.world.getBlockState(blockpos.down()).getBlock() != Blocks.obsidian){
                    break;
                }
            }

            Block block = this.world.getBlockState(p_180120_1_.offset(p_180120_2_, i)).getBlock();
            return block == Blocks.obsidian ? i : 0;
        }

        public int func_181100_a(){
            return this.field_150862_g;
        }

        public int func_181101_b(){
            return this.field_150868_h;
        }

        protected int func_150858_a(){
            label24:

            for (this.field_150862_g = 0; this.field_150862_g < 21; ++this.field_150862_g){
                for (int i = 0; i < this.field_150868_h; ++i){
                    BlockPos blockpos = this.field_150861_f.offset(this.field_150866_c, i).up(this.field_150862_g);
                    Block block = this.world.getBlockState(blockpos).getBlock();

                    if (!this.func_150857_a(block)){
                        break label24;
                    }

                    if (block == Blocks.portal){
                        ++this.field_150864_e;
                    }

                    if (i == 0){
                        block = this.world.getBlockState(blockpos.offset(this.field_150863_d)).getBlock();

                        if (block != Blocks.obsidian){
                            break label24;
                        }
                    }
                    else if (i == this.field_150868_h - 1){
                        block = this.world.getBlockState(blockpos.offset(this.field_150866_c)).getBlock();

                        if (block != Blocks.obsidian){
                            break label24;
                        }
                    }
                }
            }

            for (int j = 0; j < this.field_150868_h; ++j){
                if (this.world.getBlockState(this.field_150861_f.offset(this.field_150866_c, j).up(this.field_150862_g)).getBlock() != Blocks.obsidian){
                    this.field_150862_g = 0;
                    break;
                }
            }

            if (this.field_150862_g <= 21 && this.field_150862_g >= 3){
                return this.field_150862_g;
            }
            else{
                this.field_150861_f = null;
                this.field_150868_h = 0;
                this.field_150862_g = 0;
                return 0;
            }
        }

        protected boolean func_150857_a(Block p_150857_1_){
            return p_150857_1_.getMaterial() == Material.air || p_150857_1_ == Blocks.fire || p_150857_1_ == Blocks.portal;
        }

        public boolean func_150860_b(){
            return this.field_150861_f != null && this.field_150868_h >= 2 && this.field_150868_h <= 21 && this.field_150862_g >= 3 && this.field_150862_g <= 21;
        }

        public void func_150859_c(){
            for (int i = 0; i < this.field_150868_h; ++i){
                BlockPos blockpos = this.field_150861_f.offset(this.field_150866_c, i);

                for (int j = 0; j < this.field_150862_g; ++j){
                    this.world.setBlockState(blockpos.up(j), Blocks.portal.getDefaultState().withProperty(BlockPortal.AXIS, this.axis), 2);
                }
            }
        }
    }
}