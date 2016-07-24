/*package com.Mod_Ores.NEI;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.Mod_Ores.Blocks.GUI.GuiGemcutter;
import com.Mod_Ores.Blocks.Recipes.GemcutterRecipes;
import com.Mod_Ores.Blocks.TileEntities.TileEntityGemcutter;
import com.Mod_Ores.Init.SoulItems;

import net.minecraft.block.Block;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import codechicken.nei.ItemList;
import codechicken.nei.NEIClientUtils;
import codechicken.nei.NEIServerUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.api.IOverlayHandler;
import codechicken.nei.api.IRecipeOverlayRenderer;
import codechicken.nei.recipe.FurnaceRecipeHandler;
import codechicken.nei.recipe.GuiRecipe;
import codechicken.nei.recipe.ICraftingHandler;
import codechicken.nei.recipe.IUsageHandler;
import codechicken.nei.recipe.TemplateRecipeHandler;
import codechicken.nei.recipe.FurnaceRecipeHandler.FuelPair;
import codechicken.nei.recipe.FurnaceRecipeHandler.SmeltingPair;
import codechicken.nei.recipe.TemplateRecipeHandler.CachedRecipe;
import codechicken.nei.recipe.TemplateRecipeHandler.RecipeTransferRect;

public class GemcutterRecipeHandler extends TemplateRecipeHandler {

    @Override
    public String getRecipeName() {
    	return "Gemcutter";
    }

    @Override
    public String getGuiTexture() {
    	return GuiGemcutter.TEXTURE.toString();
    }

    public class SmeltingPair extends CachedRecipe{
		PositionedStack ingred;
		PositionedStack ingred2;
		PositionedStack result;
	
		public SmeltingPair(ItemStack result) {
		    this.result = new PositionedStack(result, 111, 24);
		}
	
		public List<PositionedStack> getIngredients() {
		    return getCycledIngredients(cycleticks / 48, Arrays.asList(ingred, ingred2));
		}
	
		public PositionedStack getResult() {
		    return result;
		}
	
		public PositionedStack getOtherStack() {
		    return afuels.get((cycleticks / 48) % afuels.size()).stack;
		}
	
		public void addItem(List<Item> items){
		    for(Item item : items){
				ItemStack stack = new ItemStack(item, 1);		
				if(ingred == null){
				    this.ingred = new PositionedStack(stack, 51, 6);
				}
				else{		    
				    this.ingred2 = new PositionedStack(stack, 41, 42);
				}
		    }
		}
    }

    public static class FuelPair{
		public PositionedStack stack;
		public int burnTime;
	
		public FuelPair(ItemStack ingred, int burnTime) {
		    this.stack = new PositionedStack(ingred, 60, 42, false);
		    this.burnTime = burnTime;
		}	
    }

    public static ArrayList<FuelPair> afuels;
    public static HashSet<Block> efuels;

    @Override
    public void loadTransferRects() {
		transferRects.add(new RecipeTransferRect(new Rectangle(50, 23, 18, 18), "gemcuttingfuel"));
		transferRects.add(new RecipeTransferRect(new Rectangle(74, 23, 24, 18), "gemcutting"));
    }

    @Override
    public Class<? extends GuiContainer> getGuiClass() {
    	return GuiGemcutter.class;
    }


    @Override
    public TemplateRecipeHandler newInstance() {
		if (afuels == null || afuels.isEmpty())
		    findFuels();
		return super.newInstance();
    }

    @Override
    public void loadCraftingRecipes(String outputId, Object... results) {
		if (outputId.equals("gemcutting") && getClass() == GemcutterRecipeHandler.class) {//don't want subclasses getting a hold of this
		    Map<List<Item>, ItemStack> recipes = (Map<List<Item>, ItemStack>) GemcutterRecipes.smelting().getMetaSmeltingList();
		    for (Entry<List<Item>, ItemStack> recipe : recipes.entrySet()){
				SmeltingPair smeltingPair = new SmeltingPair(recipe.getValue());
				smeltingPair.addItem(recipe.getKey());
				arecipes.add(smeltingPair);
		    }
		} else
		    super.loadCraftingRecipes(outputId, results);
    }

    @Override
    public void loadCraftingRecipes(ItemStack result) {
		Map<List<Item>, ItemStack> recipes = (Map<List<Item>, ItemStack>) GemcutterRecipes.smelting().getMetaSmeltingList();
		for (Entry<List<Item>, ItemStack> recipe : recipes.entrySet()){
		    SmeltingPair smeltingPair = new SmeltingPair(recipe.getValue());
		    smeltingPair.addItem(recipe.getKey());
		    for(Item item : recipe.getKey()){
				if (NEIServerUtils.areStacksSameType(recipe.getValue(), result)){
				    arecipes.add(smeltingPair);
				}
		    }   
		}
    }

    @Override
    public void loadUsageRecipes(String inputId, Object... ingredients) {
		if (inputId.equals("gemcuttingfuel") && getClass() == GemcutterRecipeHandler.class){ //don't want subclasses getting a hold of this
		    loadCraftingRecipes("gemcutting");
		}
		else{
		    super.loadUsageRecipes(inputId, ingredients);
		}
    }

    @Override
    public void loadUsageRecipes(ItemStack ingredient) {
		Map<List<Item>, ItemStack> recipes = (Map<List<Item>, ItemStack>) GemcutterRecipes.smelting().getMetaSmeltingList();
		for (Entry<List<Item>, ItemStack> recipe : recipes.entrySet()){
		    SmeltingPair smeltingPair = new SmeltingPair(recipe.getValue());
		    smeltingPair.addItem(recipe.getKey());	    
		    for(Item item : recipe.getKey()){
				if (NEIServerUtils.areStacksSameTypeCrafting(new ItemStack(item), ingredient)) {
				    smeltingPair.setIngredientPermutation(Arrays.asList(smeltingPair.ingred, smeltingPair.ingred2), ingredient);
				    arecipes.add(smeltingPair);
				}
		    }
		}
    }

    @Override
    public void drawExtras(int recipe) {
		drawProgressBar(51, 25, 176, 0, 14, 14, 48, 7);
		drawProgressBar(74, 23, 176, 14, 24, 16, 48, 0);
    }

    private static void findFuels() {
		afuels = new ArrayList<FuelPair>();
		int burnTime = TileEntityGemcutter.getItemBurnTime(new ItemStack(SoulItems.Polisher.get()));
		afuels.add(new FuelPair(new ItemStack(SoulItems.Polisher.get()).copy(), burnTime));
    }

    @Override
    public String getOverlayIdentifier() {
    	return "gemcutting";
    }
}*/