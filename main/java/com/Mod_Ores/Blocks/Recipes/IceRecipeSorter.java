package com.Mod_Ores.Blocks.Recipes;

import java.util.Comparator;

import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;

class IceRecipeSorter implements Comparator{
    final IceWorkbenchCraftingRecipes craftingManager;

    IceRecipeSorter(IceWorkbenchCraftingRecipes iceWorkbenchCraftingRecipes){
        this.craftingManager = iceWorkbenchCraftingRecipes;
    }

    public int compareRecipes(IRecipe par1IRecipe, IRecipe par2IRecipe){
        return par1IRecipe instanceof ShapelessRecipes && par2IRecipe instanceof ShapedRecipes ? 1 : (par2IRecipe instanceof ShapelessRecipes && par1IRecipe instanceof ShapedRecipes ? -1 : (par2IRecipe.getRecipeSize() < par1IRecipe.getRecipeSize() ? -1 : (par2IRecipe.getRecipeSize() > par1IRecipe.getRecipeSize() ? 1 : 0)));
    }

    public int compare(Object par1Obj, Object par2Obj){
        return this.compareRecipes((IRecipe)par1Obj, (IRecipe)par2Obj);
    }
}

class GembleTableRecipeSorter implements Comparator{
    final GembleCraftingRecipes craftingManager;

    GembleTableRecipeSorter(GembleCraftingRecipes iceWorkbenchCraftingRecipes){
        this.craftingManager = iceWorkbenchCraftingRecipes;
    }

    public int compareRecipes(IRecipe par1IRecipe, IRecipe par2IRecipe){
        return par1IRecipe instanceof ShapelessRecipes && par2IRecipe instanceof ShapedRecipes ? 1 : (par2IRecipe instanceof ShapelessRecipes && par1IRecipe instanceof ShapedRecipes ? -1 : (par2IRecipe.getRecipeSize() < par1IRecipe.getRecipeSize() ? -1 : (par2IRecipe.getRecipeSize() > par1IRecipe.getRecipeSize() ? 1 : 0)));
    }

    public int compare(Object par1Obj, Object par2Obj){
        return this.compareRecipes((IRecipe)par1Obj, (IRecipe)par2Obj);
    }
}

class GemmerationTableRecipeSorter implements Comparator{
    final GemmerationCraftingRecipes craftingManager;

    GemmerationTableRecipeSorter(GemmerationCraftingRecipes iceWorkbenchCraftingRecipes){
        this.craftingManager = iceWorkbenchCraftingRecipes;
    }

    public int compareRecipes(IRecipe par1IRecipe, IRecipe par2IRecipe){
        return par1IRecipe instanceof ShapelessRecipes && par2IRecipe instanceof ShapedRecipes ? 1 : (par2IRecipe instanceof ShapelessRecipes && par1IRecipe instanceof ShapedRecipes ? -1 : (par2IRecipe.getRecipeSize() < par1IRecipe.getRecipeSize() ? -1 : (par2IRecipe.getRecipeSize() > par1IRecipe.getRecipeSize() ? 1 : 0)));
    }

    public int compare(Object par1Obj, Object par2Obj){
        return this.compareRecipes((IRecipe)par1Obj, (IRecipe)par2Obj);
    }
}

class GemmingTableRecipeSorter implements Comparator{
    final GemmingCraftingRecipes craftingManager;

    GemmingTableRecipeSorter(GemmingCraftingRecipes iceWorkbenchCraftingRecipes){
        this.craftingManager = iceWorkbenchCraftingRecipes;
    }

    public int compareRecipes(IRecipe par1IRecipe, IRecipe par2IRecipe){
        return par1IRecipe instanceof ShapelessRecipes && par2IRecipe instanceof ShapedRecipes ? 1 : (par2IRecipe instanceof ShapelessRecipes && par1IRecipe instanceof ShapedRecipes ? -1 : (par2IRecipe.getRecipeSize() < par1IRecipe.getRecipeSize() ? -1 : (par2IRecipe.getRecipeSize() > par1IRecipe.getRecipeSize() ? 1 : 0)));
    }

    public int compare(Object par1Obj, Object par2Obj){
        return this.compareRecipes((IRecipe)par1Obj, (IRecipe)par2Obj);
    }
}