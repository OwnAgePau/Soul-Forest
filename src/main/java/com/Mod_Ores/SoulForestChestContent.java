package com.Mod_Ores;

import java.util.Arrays;
import java.util.List;

import net.minecraft.util.WeightedRandomChestContent;

import com.Mod_Ores.Init.SoulItems;

public class SoulForestChestContent {

    // WeightedRandomChestContent(item, metadeta, min, max, chance)
    public static List<WeightedRandomChestContent> iceTowerChestContent = Arrays.asList(
		// Item, damage, minAmount, maxAmount, chance
		new WeightedRandomChestContent(SoulItems.FrostShard.get(), 0, 3, 7, 10), 
		new WeightedRandomChestContent(SoulItems.BurnedShard.get(), 0, 3, 7, 10), 
		new WeightedRandomChestContent(SoulItems.Soul.get(), 0, 3, 7, 10), 
		new WeightedRandomChestContent(SoulItems.LightShard.get(), 0, 3, 7, 10), 
		new WeightedRandomChestContent(SoulItems.FrostFragment.get(), 0, 1, 2, 8), 
		new WeightedRandomChestContent(SoulItems.LightFragment.get(), 0, 1, 2, 8), 
		new WeightedRandomChestContent(SoulItems.FrozenMagicFragment.get(), 0, 1, 1, 6), 
		new WeightedRandomChestContent(SoulItems.FrozenMagicFragmentHalf.get(), 0, 1, 1, 6), 
		new WeightedRandomChestContent(SoulItems.FrozenMagicFragmentAdv.get(), 0, 1, 1, 4), 
		new WeightedRandomChestContent(SoulItems.FrostWand.get(), 0, 1, 1, 1), 
		new WeightedRandomChestContent(SoulItems.FrozenRod.get(), 0, 1, 4, 7), 
		new WeightedRandomChestContent(SoulItems.FrozenStick.get(), 0, 1, 4, 7), 
		new WeightedRandomChestContent(SoulItems.BlackdiamondGem.get(), 0, 1, 3, 2), 
		new WeightedRandomChestContent(SoulItems.AmethystGem.get(), 0, 3, 6, 7), 
		new WeightedRandomChestContent(SoulItems.CranberryMuffin.get(), 0, 1, 5, 7), 
		new WeightedRandomChestContent(SoulItems.BaneberryCake.get(), 0, 1, 1, 8), 
		new WeightedRandomChestContent(SoulItems.WhiteopalGem.get(), 0, 4, 19, 10), 
		new WeightedRandomChestContent(SoulItems.Polisher.get(), 0, 3, 12, 7), 
		new WeightedRandomChestContent(SoulItems.PolisherTowel.get(), 0, 4, 19, 9), 
		new WeightedRandomChestContent(SoulItems.TitaniumGem.get(), 0, 1, 2, 1), 
		new WeightedRandomChestContent(SoulItems.OnyxGem.get(), 0, 1, 2, 1), 
		new WeightedRandomChestContent(SoulItems.BerryCollector.get(), 0, 1, 1, 5), 
		new WeightedRandomChestContent(SoulItems.CitrineGem.get(), 0, 4, 19, 10), 
		new WeightedRandomChestContent(SoulItems.SteelSword.get(), 0, 1, 1, 4), 
		new WeightedRandomChestContent(SoulItems.OpalGem.get(), 0, 4, 19, 9), 
		new WeightedRandomChestContent(SoulItems.OlivineGem.get(), 0, 5, 14, 6)
	);
    
    public static List<WeightedRandomChestContent> titaniumTowerChestContent = Arrays.asList(
    		new WeightedRandomChestContent(SoulItems.BurnedShard.get(), 0, 3, 7, 10), 
		new WeightedRandomChestContent(SoulItems.Soul.get(), 0, 3, 7, 10), 
		new WeightedRandomChestContent(SoulItems.LightShard.get(), 0, 3, 7, 10), 
		new WeightedRandomChestContent(SoulItems.BurnedFragment.get(), 0, 1, 2, 8), 
		new WeightedRandomChestContent(SoulItems.LightFragment.get(), 0, 1, 2, 8), 
		new WeightedRandomChestContent(SoulItems.BurnedMagicFragment.get(), 0, 1, 1, 6),
		new WeightedRandomChestContent(SoulItems.FireMagicFragment.get(), 0, 1, 1, 6),
		new WeightedRandomChestContent(SoulItems.FireMagicFragmentHalf.get(), 0, 1, 1, 6), 
		new WeightedRandomChestContent(SoulItems.FireMagicFragmentAdv.get(), 0, 1, 1, 4), 
		new WeightedRandomChestContent(SoulItems.BurnedMagicFragmentAdv.get(), 0, 1, 1, 4), 
		new WeightedRandomChestContent(SoulItems.BlackdiamondGem.get(), 0, 1, 3, 2), 
		new WeightedRandomChestContent(SoulItems.AmethystGem.get(), 0, 3, 6, 7), 
		new WeightedRandomChestContent(SoulItems.CranberryMuffin.get(), 0, 1, 5, 7), 
		new WeightedRandomChestContent(SoulItems.BaneberryCake.get(), 0, 1, 1, 8), 
		new WeightedRandomChestContent(SoulItems.WhiteopalGem.get(), 0, 4, 19, 10), 
		new WeightedRandomChestContent(SoulItems.Polisher.get(), 0, 3, 12, 7), 
		new WeightedRandomChestContent(SoulItems.PolisherTowel.get(), 0, 4, 19, 9), 
		new WeightedRandomChestContent(SoulItems.TitaniumGem.get(), 0, 1, 2, 1), 
		new WeightedRandomChestContent(SoulItems.OnyxGem.get(), 0, 1, 2, 1), 
		new WeightedRandomChestContent(SoulItems.BerryCollector.get(), 0, 1, 1, 5), 
		new WeightedRandomChestContent(SoulItems.CitrineGem.get(), 0, 4, 19, 10), 
		new WeightedRandomChestContent(SoulItems.SteelSword.get(), 0, 1, 1, 4), 
		new WeightedRandomChestContent(SoulItems.OpalGem.get(), 0, 4, 19, 9), 
		new WeightedRandomChestContent(SoulItems.OlivineGem.get(), 0, 5, 14, 6)
	);
    
    public static List<WeightedRandomChestContent> slateTowerChestContent = Arrays.asList(
		new WeightedRandomChestContent(SoulItems.BurnedShard.get(), 0, 3, 7, 10), 
		new WeightedRandomChestContent(SoulItems.Soul.get(), 0, 3, 7, 10), 
		new WeightedRandomChestContent(SoulItems.LightShard.get(), 0, 3, 7, 10), 
		new WeightedRandomChestContent(SoulItems.SoulFragment.get(), 0, 1, 2, 8), 
		new WeightedRandomChestContent(SoulItems.LightFragment.get(), 0, 1, 2, 8), 
		new WeightedRandomChestContent(SoulItems.SoulMagicFragment.get(), 0, 1, 1, 6), 
		new WeightedRandomChestContent(SoulItems.SoulMagicFragmentHalf.get(), 0, 1, 1, 6), 
		new WeightedRandomChestContent(SoulItems.SoulMagicFragmentAdv.get(), 0, 1, 1, 4),  
		new WeightedRandomChestContent(SoulItems.BlackdiamondGem.get(), 0, 1, 3, 2), 
		new WeightedRandomChestContent(SoulItems.AmethystGem.get(), 0, 3, 6, 7), 
		new WeightedRandomChestContent(SoulItems.CranberryMuffin.get(), 0, 1, 5, 7), 
		new WeightedRandomChestContent(SoulItems.BaneberryCake.get(), 0, 1, 1, 8), 
		new WeightedRandomChestContent(SoulItems.WhiteopalGem.get(), 0, 4, 19, 10), 
		new WeightedRandomChestContent(SoulItems.Polisher.get(), 0, 3, 12, 7), 
		new WeightedRandomChestContent(SoulItems.PolisherTowel.get(), 0, 4, 19, 9), 
		new WeightedRandomChestContent(SoulItems.TitaniumGem.get(), 0, 1, 2, 1), 
		new WeightedRandomChestContent(SoulItems.OnyxGem.get(), 0, 1, 2, 1), 
		new WeightedRandomChestContent(SoulItems.BerryCollector.get(), 0, 1, 1, 5), 
		new WeightedRandomChestContent(SoulItems.CitrineGem.get(), 0, 4, 19, 10), 
		new WeightedRandomChestContent(SoulItems.SteelSword.get(), 0, 1, 1, 4), 
		new WeightedRandomChestContent(SoulItems.OpalGem.get(), 0, 4, 19, 9), 
		new WeightedRandomChestContent(SoulItems.OlivineGem.get(), 0, 5, 14, 6)
	);
}