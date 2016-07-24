/*package com.Mod_Ores.NEI;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import com.Mod_Ores.Blocks.GUI.GuiGembleTable;
import com.Mod_Ores.Blocks.GUI.GuiGemmingTable;
import com.Mod_Ores.Blocks.Recipes.GemShapelessRecipes;
import com.Mod_Ores.Blocks.Recipes.GemmingCraftingRecipes;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.oredict.ShapedOreRecipe;
import codechicken.core.ReflectionManager;
import codechicken.nei.NEIClientConfig;
import codechicken.nei.NEIClientUtils;
import codechicken.nei.NEIServerUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.api.DefaultOverlayRenderer;
import codechicken.nei.api.IOverlayHandler;
import codechicken.nei.api.IRecipeOverlayRenderer;
import codechicken.nei.api.IStackPositioner;
import codechicken.nei.recipe.GuiRecipe;
import codechicken.nei.recipe.ICraftingHandler;
import codechicken.nei.recipe.RecipeInfo;
import codechicken.nei.recipe.ShapedRecipeHandler;
import codechicken.nei.recipe.TemplateRecipeHandler;
import codechicken.nei.recipe.ShapedRecipeHandler.CachedShapedRecipe;
import codechicken.nei.recipe.TemplateRecipeHandler.CachedRecipe;
import codechicken.nei.recipe.TemplateRecipeHandler.RecipeTransferRect;

public class GemmingTableRecipeHandler extends TemplateRecipeHandler {

    @Override
    public String getRecipeName() {
    	return "Gemming Table";
    }

    @Override
    public String getGuiTexture() {
    	return GuiGemmingTable.TEXTURE.toString();
    }

    public class CachedShapedRecipe extends CachedRecipe{
	public ArrayList<PositionedStack> ingredients;
	public PositionedStack result;

	public CachedShapedRecipe(List items, ItemStack out) {
	    result = new PositionedStack(out, 111, 24);
	    ingredients = new ArrayList<PositionedStack>();
	    setIngredients(items);
	}

	public CachedShapedRecipe(GemShapelessRecipes recipe) {
	    this(recipe.recipeItems, recipe.getRecipeOutput());
	}

	public void setIngredients(List items) {
	    PositionedStack stack = new PositionedStack(items.get(0), 51, 6, false);
	    PositionedStack stack1 = new PositionedStack(items.get(1), 51, 42, false);
	    stack.setMaxSize(1);
	    stack1.setMaxSize(1);
	    ingredients.add(stack);
	    ingredients.add(stack1);
	}

	@Override
	public List<PositionedStack> getIngredients() {
	    return getCycledIngredients(cycleticks / 20, ingredients);
	}

	public PositionedStack getResult() {
	    return result;
	}

	public void computeVisuals() {
	    for (PositionedStack p : ingredients)
			p.generatePermutations();
		}
    }

    @Override
    public void loadTransferRects() {
    	transferRects.add(new RecipeTransferRect(new Rectangle(84, 23, 24, 18), "gemming"));
    }

    @Override
    public Class<? extends GuiContainer> getGuiClass() {
    	return GuiGemmingTable.class;
    }

    @Override
    public void loadCraftingRecipes(String outputId, Object... results) {
		if (outputId.equals("gemming") && getClass() == GemmingTableRecipeHandler.class) {
		    for (IRecipe irecipe : (List<IRecipe>) GemmingCraftingRecipes.getInstance().getRecipeList()) {
				CachedShapedRecipe recipe = null;
				if (irecipe instanceof GemShapelessRecipes)
				    recipe = new CachedShapedRecipe((GemShapelessRecipes) irecipe);
		
				if (recipe == null)
				    continue;
		
				recipe.computeVisuals();
				arecipes.add(recipe);
		    }
		} else {
		    super.loadCraftingRecipes(outputId, results);
		}
    }

    @Override
    public void loadCraftingRecipes(ItemStack result) {
		for (IRecipe irecipe : (List<IRecipe>) GemmingCraftingRecipes.getInstance().getRecipeList()) {
		    if (NEIServerUtils.areStacksSameTypeCrafting(irecipe.getRecipeOutput(), result)) {
			CachedShapedRecipe recipe = null;
			if (irecipe instanceof GemShapelessRecipes)
			    recipe = new CachedShapedRecipe((GemShapelessRecipes) irecipe);
	
			if (recipe == null)
			    continue;
	
			recipe.computeVisuals();
			arecipes.add(recipe);
		    }
		}
    }

    @Override
    public void loadUsageRecipes(ItemStack ingredient) {
		for (IRecipe irecipe : (List<IRecipe>) GemmingCraftingRecipes.getInstance().getRecipeList()) {
		    CachedShapedRecipe recipe = null;
		    if (irecipe instanceof GemShapelessRecipes)
		    	recipe = new CachedShapedRecipe((GemShapelessRecipes) irecipe);
	
		    if (recipe == null || !recipe.contains(recipe.ingredients, ingredient.getItem()))
		    	continue;
	
		    recipe.computeVisuals();
		    if (recipe.contains(recipe.ingredients, ingredient)) {
				recipe.setIngredientPermutation(recipe.ingredients, ingredient);
				arecipes.add(recipe);
		    }
		}
    }

    @Override
    public String getOverlayIdentifier() {
    	return "gemming";
    }

    public boolean hasOverlay(GuiContainer gui, Container container, int recipe) {
		return super.hasOverlay(gui, container, recipe) ||
			isRecipe2x2(recipe) && RecipeInfo.hasDefaultOverlay(gui, "crafting2x2");
    }

    @Override
    public IRecipeOverlayRenderer getOverlayRenderer(GuiContainer gui, int recipe) {
		IRecipeOverlayRenderer renderer = super.getOverlayRenderer(gui, recipe);
		if (renderer != null)
		    return renderer;
	
		IStackPositioner positioner = RecipeInfo.getStackPositioner(gui, "crafting2x2");
		if (positioner == null)
		    return null;
		return new DefaultOverlayRenderer(getIngredientStacks(recipe), positioner);
    }

    @Override
    public IOverlayHandler getOverlayHandler(GuiContainer gui, int recipe) {
		IOverlayHandler handler = super.getOverlayHandler(gui, recipe);
		if (handler != null)
		    return handler;
	
		return RecipeInfo.getOverlayHandler(gui, "crafting2x2");
    }

    public boolean isRecipe2x2(int recipe) {
		for (PositionedStack stack : getIngredientStacks(recipe))
		    if (stack.relx > 43 || stack.rely > 24)
			return false;
	
		return true;
    }
}*/