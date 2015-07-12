package com.Mod_Ores.Blocks.Recipes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityList;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

import com.Mod_Ores.soul_forest;
import com.Mod_Ores.Init.InitItems;
import com.Mod_Ores.Init.SoulBlocks;
import com.Mod_Ores.Init.SoulItems;
import com.Mod_Ores.Items.Tools.ItemSoulAxe;
import com.Mod_Ores.Items.Tools.ItemSoulHoe;
import com.Mod_Ores.Items.Tools.ItemSoulPickaxe;
import com.Mod_Ores.Items.Tools.ItemSoulShovel;
import com.Mod_Ores.Items.Tools.ItemSoulSword;
import com.Mod_Ores.Items.Tools.ItemWarAxe;
import com.Mod_Ores.Mobs.Entity.EntityKingKotek;

import cpw.mods.fml.common.registry.GameRegistry;

public class GemmerationCraftingRecipes{
    /** The static instance of this class */
    private static final GemmerationCraftingRecipes instance = new GemmerationCraftingRecipes();

    /** A list of all the recipes added */
    private List recipes = new ArrayList();
    private List enchList = new ArrayList();
    
    private ItemStack test;
    /**
     * Returns the static instance of this class
     */
    public static final GemmerationCraftingRecipes getInstance(){
        return instance;
    }

    /** All of the Ice Workbench's crafting recipes
     * 
     */
    private GemmerationCraftingRecipes(){
    	for(ItemSoulPickaxe pickaxe : InitItems.soulPickaxes){
	    this.addShapelessRecipe(new ItemStack(pickaxe, 1), new Object[] {SoulItems.JetAmuletStone.get(), pickaxe});   
	}
	for(ItemSoulAxe axe : InitItems.soulAxes){
	    this.addShapelessRecipe(new ItemStack(axe, 1), new Object[] {SoulItems.JetAmuletStone.get(), axe});   
	}
	for(ItemSoulHoe hoe : InitItems.soulHoes){
	    this.addShapelessRecipe(new ItemStack(hoe, 1), new Object[] {SoulItems.JetAmuletStone.get(), hoe});   
	}
	for(ItemSoulShovel shovel : InitItems.soulShovels){
	    this.addShapelessRecipe(new ItemStack(shovel, 1), new Object[] {SoulItems.JetAmuletStone.get(), shovel});   
	}
	for(ItemSoulSword sword : InitItems.soulSwords){
	    this.addShapelessRecipe(new ItemStack(sword, 1), new Object[] {SoulItems.JetAmuletStone.get(), sword});   
	}
	for(ItemWarAxe warAxe : InitItems.soulWarAxes){
	    this.addShapelessRecipe(new ItemStack(warAxe, 1), new Object[] {SoulItems.JetAmuletStone.get(), warAxe});   
	}	
	for(ItemArmor armor : InitItems.soulArmors){
	    this.addShapelessRecipe(new ItemStack(armor, 1), new Object[] {SoulItems.JetAmuletStone.get(), armor});   
	}
	
	this.addShapelessRecipe(new ItemStack(SoulItems.BerryCollector.get(), 1), new Object[] {SoulItems.JetAmuletStone.get(), SoulItems.BerryCollector.get()});   
	
    	Collections.sort(this.recipes, new GemmerationTableRecipeSorter(this));
    }
    
    public void addEnchantedBookRecipe(Enchantment par1Enchantment, int par2level, int par3AmmountOfBooksCrafted){
    	this.test = new ItemStack((Item)Item.getItemById(403), par3AmmountOfBooksCrafted);
    	this.test.addEnchantment(par1Enchantment, par2level);
    }

    public IceWorkbenchShapedRecipes addRecipe(ItemStack par1ItemStack, Object ... par2ArrayOfObj){
        String s = "";
        int i = 0;
        int j = 0;
        int k = 0;

        if (par2ArrayOfObj[i] instanceof String[]){
            String[] astring = (String[])((String[])par2ArrayOfObj[i++]);

            for (int l = 0; l < astring.length; ++l)
            {
                String s1 = astring[l];
                ++k;
                j = s1.length();
                s = s + s1;
            }
        }
        else{
            while (par2ArrayOfObj[i] instanceof String){
                String s2 = (String)par2ArrayOfObj[i++];
                ++k;
                j = s2.length();
                s = s + s2;
            }
        }

        HashMap hashmap;

        for (hashmap = new HashMap(); i < par2ArrayOfObj.length; i += 2){
            Character character = (Character)par2ArrayOfObj[i];
            ItemStack itemstack1 = null;

            if (par2ArrayOfObj[i + 1] instanceof Item){
                itemstack1 = new ItemStack((Item)par2ArrayOfObj[i + 1]);
            }
            else if (par2ArrayOfObj[i + 1] instanceof Block){
                itemstack1 = new ItemStack((Block)par2ArrayOfObj[i + 1], 1, 32767);
            }
            else if (par2ArrayOfObj[i + 1] instanceof ItemStack){
                itemstack1 = (ItemStack)par2ArrayOfObj[i + 1];
            }

            hashmap.put(character, itemstack1);
        }

        ItemStack[] aitemstack = new ItemStack[j * k];

        for (int i1 = 0; i1 < j * k; ++i1){
            char c0 = s.charAt(i1);
            if (hashmap.containsKey(Character.valueOf(c0))){
                aitemstack[i1] = ((ItemStack)hashmap.get(Character.valueOf(c0))).copy();      
            }
            else{
                aitemstack[i1] = null;
            }
        }

        IceWorkbenchShapedRecipes shapedrecipes = new IceWorkbenchShapedRecipes(j, k, aitemstack, par1ItemStack);
        this.recipes.add(shapedrecipes);
        return shapedrecipes;
    }

    public void addShapelessRecipe(ItemStack par1ItemStack, Object ... par2ArrayOfObj){
        ArrayList arraylist = new ArrayList();
        Object[] aobject = par2ArrayOfObj;
        int i = par2ArrayOfObj.length;

        for (int j = 0; j < i; ++j){
            Object object1 = aobject[j];

            if (object1 instanceof ItemStack){
                arraylist.add(((ItemStack)object1).copy());
            }
            else if (object1 instanceof Item){
                arraylist.add(new ItemStack((Item)object1));
            }
            else{
                if (!(object1 instanceof Block)){
                    throw new RuntimeException("Invalid shapeless recipy!");
                }

                arraylist.add(new ItemStack((Block)object1));
            }
        }

        this.recipes.add(new GemShapelessRecipes(par1ItemStack, arraylist));
    }
    
    public ItemStack findMatchingRecipe(InventoryCrafting par1InventoryCrafting, World par2World){
        int i = 0;
        ItemStack itemstack = null;
        ItemStack itemstack1 = null;
        int j;
        for (j = 0; j < par1InventoryCrafting.getSizeInventory(); ++j){
            ItemStack itemstack2 = par1InventoryCrafting.getStackInSlot(j);
            
            if (itemstack2 != null){
                if (i == 0){
                    itemstack = itemstack2;
                }

                if (i == 1){
                    itemstack1 = itemstack2;
                }

                ++i;
            }
        }

        if (i == 2 && itemstack == itemstack1 && itemstack.stackSize == 1 && itemstack1.stackSize == 1 && itemstack.getItem().isRepairable()){
            Item item = itemstack.getItem();
            int k = item.getMaxDamage() - itemstack.getItemDamageForDisplay();
            int l = item.getMaxDamage() - itemstack1.getItemDamageForDisplay();
            int i1 = k + l + item.getMaxDamage() * 5 / 100;
            int j1 = item.getMaxDamage() - i1;
            if (j1 < 0)
            {
                j1 = 0;
            }

            return new ItemStack(item, 1, j1); // Was item, 1, j1
        }
        else{
            for (j = 0; j < this.recipes.size(); ++j){
            	IRecipe irecipe = (IRecipe)this.recipes.get(j);
                if (irecipe.matches(par1InventoryCrafting, par2World)){ 
                    return irecipe.getCraftingResult(par1InventoryCrafting);
                }
            }

            return null;
        }
    }

    /**
     * returns the List<> of all recipes
     */
    public List getRecipeList(){
        return this.recipes;
    }
}
