/*package com.Mod_Ores.NEI;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.inventory.GuiContainer;

import com.Mod_Ores.soul_forest;
import com.Mod_Ores.Blocks.GUI.GuiGelExtractor;
import com.Mod_Ores.Blocks.GUI.GuiGembleTable;
import com.Mod_Ores.Blocks.GUI.GuiGemcutter;
import com.Mod_Ores.Blocks.GUI.GuiGemmerationTable;
import com.Mod_Ores.Blocks.GUI.GuiGemmingTable;
import com.Mod_Ores.Blocks.GUI.GuiIceCrafting;

import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;
import codechicken.nei.recipe.TemplateRecipeHandler;

public class NEIsoulforestConfig implements IConfigureNEI{
	
    @Override
    public void loadConfig() {
		this.registerApiRecipes(new GemcutterRecipeHandler(), GuiGemcutter.class);
		this.registerApiRecipes(new IceWorkBenchRecipeHandler(), GuiIceCrafting.class);
		this.registerApiRecipes(new GelExtractorRecipeHandler(), GuiGelExtractor.class);
		this.registerApiRecipes(new GembleTableRecipeHandler(), GuiGembleTable.class);
		this.registerApiRecipes(new GemmerationTableRecipeHandler(), GuiGemmerationTable.class);
		this.registerApiRecipes(new GemmingTableRecipeHandler(), GuiGemmingTable.class);
    }
    
    private void registerApiRecipes(TemplateRecipeHandler recipeHandler, Class<? extends GuiContainer> gui){
		API.registerRecipeHandler(recipeHandler);
		API.registerUsageHandler(recipeHandler);
		API.setGuiOffset(gui, 0, 0);
    }

    @Override
    public String getName() {
    	return "Soul Forest NEI plugin";
    }

    @Override
    public String getVersion() {
    	return soul_forest.VERSION;
    }
}*/