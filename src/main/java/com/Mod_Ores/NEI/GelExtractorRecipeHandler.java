/*package com.Mod_Ores.NEI;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.Mod_Ores.Blocks.GUI.GuiGelExtractor;
import com.Mod_Ores.Blocks.Recipes.GelExtractorRecipes;

import net.minecraft.block.Block;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import codechicken.nei.ItemList;
import codechicken.nei.NEIServerUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.api.IOverlayHandler;
import codechicken.nei.api.IRecipeOverlayRenderer;
import codechicken.nei.recipe.GuiRecipe;
import codechicken.nei.recipe.ICraftingHandler;
import codechicken.nei.recipe.TemplateRecipeHandler;
import codechicken.nei.recipe.TemplateRecipeHandler.CachedRecipe;
import codechicken.nei.recipe.TemplateRecipeHandler.RecipeTransferRect;

public class GelExtractorRecipeHandler extends TemplateRecipeHandler {

    @Override
    public String getRecipeName() {
    	return "Gel Extractor";
    }

    @Override
    public String getGuiTexture() {
    	return GuiGelExtractor.TEXTURE.toString();
    }
    
    public class SmeltingPair extends CachedRecipe{
		PositionedStack ingred;
		PositionedStack ingred2;
		PositionedStack result;
	
		public SmeltingPair(ItemStack result) {
		    this.result = new PositionedStack(result, 147, 13);
		}
	
		public List<PositionedStack> getIngredients() {
		    return getCycledIngredients(cycleticks / 48, Arrays.asList(ingred, ingred2));
		}
	
		public PositionedStack getResult() {
		    return result;
		}
		
		public void addItem(List<Item> items){
		    for(Item item : items){
				ItemStack stack = new ItemStack(item, 1);		
				if(ingred == null){
				    this.ingred = new PositionedStack(stack, 3, -3);
				}
				else{		    
				    this.ingred2 = new PositionedStack(stack, 147, -3);
				}
		    }
		}
    }

    @Override
    public void loadTransferRects() {
		transferRects.add(new RecipeTransferRect(new Rectangle(74, 23, 24, 18), "gelextracting"));
    }

    @Override
    public Class<? extends GuiContainer> getGuiClass() {
    	return GuiGelExtractor.class;
    }

    @Override
    public void loadCraftingRecipes(String outputId, Object... results) {
		if (outputId.equals("gelextracting") && getClass() == GelExtractorRecipeHandler.class) {//don't want subclasses getting a hold of this
		    Map<List<Item>, ItemStack> recipes = (Map<List<Item>, ItemStack>) GelExtractorRecipes.smelting().getMetaSmeltingList();
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
		Map<List<Item>, ItemStack> recipes = (Map<List<Item>, ItemStack>) GelExtractorRecipes.smelting().getMetaSmeltingList();
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
		if (inputId.equals("gelfuel") && getClass() == GelExtractorRecipeHandler.class){ //don't want subclasses getting a hold of this
		    loadCraftingRecipes("gelextracting");
		}
		else{
		    super.loadUsageRecipes(inputId, ingredients);
		}
    }

    @Override
    public void loadUsageRecipes(ItemStack ingredient) {
		Map<List<Item>, ItemStack> recipes = (Map<List<Item>, ItemStack>) GelExtractorRecipes.smelting().getMetaSmeltingList();
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
		drawProgressBar(52, 30, 176, 14, 64, 3, 48, 0);
    }

    @Override
    public String getOverlayIdentifier() {
    	return "gelextracting";
    }
}*/
