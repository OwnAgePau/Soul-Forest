package com.Mod_Ores.NEI;

import com.Mod_Ores.soul_forest;
import com.Mod_Ores.Blocks.GelExtractor.GuiGelExtractor;
import com.Mod_Ores.Blocks.Gemcutter.GuiGemcutter;
import com.Mod_Ores.Blocks.IceWorkbench.GuiIceCrafting;

import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;

public class NEIsoulforestConfig implements IConfigureNEI{

    @Override
    public void loadConfig() {
	API.registerRecipeHandler(new GemcutterRecipeHandler());
	API.registerUsageHandler(new GemcutterRecipeHandler());
	API.setGuiOffset(GuiGemcutter.class, 0, 0);
	API.registerRecipeHandler(new IceWorkBenchRecipeHandler());
	API.registerUsageHandler(new IceWorkBenchRecipeHandler());
	API.setGuiOffset(GuiIceCrafting.class, 0, 0);
	API.registerRecipeHandler(new GelExtractorRecipeHandler());
	API.registerUsageHandler(new GelExtractorRecipeHandler());
	API.setGuiOffset(GuiGelExtractor.class, 0, 0);
    }

    @Override
    public String getName() {
	return "Soul Forest NEI plugin";
    }

    @Override
    public String getVersion() {
	return soul_forest.VERSION;
    }
}
