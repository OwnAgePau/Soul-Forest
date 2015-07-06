package com.Mod_Ores.Blocks.Gemcutter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.Mod_Ores.Init.SoulItems;

public class GemcutterRecipes
{
    private static final GemcutterRecipes gemcutterBase = new GemcutterRecipes();

    /** The list of smelting results. */
    private Map gemcutterList = new HashMap();
    private Map experienceList = new HashMap();
    private HashMap<List<Item>, ItemStack> gemcutterSmeltingList1 = new HashMap<List<Item>, ItemStack>();
    private HashMap<List<Integer>, ItemStack> gemcutterSmeltingList2 = new HashMap<List<Integer>, ItemStack>();
    private HashMap<List<Integer>, ItemStack> gemcutterSmeltingCheckList1 = new HashMap<List<Integer>, ItemStack>();
    private HashMap<List<Integer>, ItemStack> gemcutterSmeltingCheckList2 = new HashMap<List<Integer>, ItemStack>();
    private HashMap<List<Integer>, Float> metaExperience = new HashMap<List<Integer>, Float>();

    public static final GemcutterRecipes smelting()
    {
        return gemcutterBase;
    }

    private GemcutterRecipes()
    {
        this.addGemcutterSmelting(new ItemStack(SoulItems.AmazoniteUncut.get()), new ItemStack(SoulItems.PolisherTowel.get()), new ItemStack(SoulItems.AmazoniteGem.get()), 0.5F);
        this.addGemcutterSmelting(new ItemStack(SoulItems.AmethystUncut.get()), new ItemStack(SoulItems.PolisherTowel.get()), new ItemStack(SoulItems.AmethystGem.get()), 0.5F);
        this.addGemcutterSmelting(new ItemStack(SoulItems.AquamarineUncut.get()), new ItemStack(SoulItems.PolisherTowel.get()), new ItemStack(SoulItems.AquamarineGem.get()), 1.0F);
        this.addGemcutterSmelting(new ItemStack(SoulItems.BlackdiamondUncut.get()), new ItemStack(SoulItems.PolisherTowel.get()), new ItemStack(SoulItems.BlackdiamondGem.get()), 1.5F);
        this.addGemcutterSmelting(new ItemStack(SoulItems.CitrineUncut.get()), new ItemStack(SoulItems.PolisherTowel.get()), new ItemStack(SoulItems.CitrineGem.get()), 0.5F);
        this.addGemcutterSmelting(new ItemStack(SoulItems.JadeUncut.get()), new ItemStack(SoulItems.PolisherTowel.get()), new ItemStack(SoulItems.JadeGem.get()), 0.5F);
        this.addGemcutterSmelting(new ItemStack(SoulItems.JetUncut.get()), new ItemStack(SoulItems.PolisherTowel.get()), new ItemStack(SoulItems.JetGem.get()), 0.5F);
        this.addGemcutterSmelting(new ItemStack(SoulItems.LilaUncut.get()), new ItemStack(SoulItems.PolisherTowel.get()), new ItemStack(SoulItems.LilaGem.get()), 0.5F);
        this.addGemcutterSmelting(new ItemStack(SoulItems.OlivineUncut.get()), new ItemStack(SoulItems.PolisherTowel.get()), new ItemStack(SoulItems.OlivineGem.get()), 0.5F);
        this.addGemcutterSmelting(new ItemStack(SoulItems.OnyxUncut.get()), new ItemStack(SoulItems.PolisherTowel.get()), new ItemStack(SoulItems.OnyxGem.get()), 1.5F);
        this.addGemcutterSmelting(new ItemStack(SoulItems.OpalUncut.get()), new ItemStack(SoulItems.PolisherTowel.get()), new ItemStack(SoulItems.OpalGem.get()), 0.5F);
        this.addGemcutterSmelting(new ItemStack(SoulItems.ScarletiteUncut.get()), new ItemStack(SoulItems.PolisherTowel.get()), new ItemStack(SoulItems.ScarletiteGem.get()), 1.0F);
        this.addGemcutterSmelting(new ItemStack(SoulItems.TitaniumUncut.get()), new ItemStack(SoulItems.PolisherTowel.get()), new ItemStack(SoulItems.TitaniumGem.get()), 1.5F);
        this.addGemcutterSmelting(new ItemStack(SoulItems.TopazUncut.get()), new ItemStack(SoulItems.PolisherTowel.get()), new ItemStack(SoulItems.TopazGem.get()), 0.5F);
        this.addGemcutterSmelting(new ItemStack(SoulItems.TurquoiseUncut.get()), new ItemStack(SoulItems.PolisherTowel.get()), new ItemStack(SoulItems.TurquoiseGem.get()), 0.5F);
        this.addGemcutterSmelting(new ItemStack(SoulItems.VioletUncut.get()), new ItemStack(SoulItems.PolisherTowel.get()), new ItemStack(SoulItems.VioletGem.get()), 0.5F);
        this.addGemcutterSmelting(new ItemStack(SoulItems.WhiteopalUncut.get()), new ItemStack(SoulItems.PolisherTowel.get()), new ItemStack(SoulItems.WhiteopalGem.get()), 0.5F);
    }

    /**
     * Adds a smelting recipe.
     */
    public void addGemcutterSmelting(ItemStack input1, ItemStack input2, ItemStack output, float exp)
    {
    	this.gemcutterSmeltingList1.put(Arrays.asList(input1.getItem(), input2.getItem()), output);
    	this.experienceList.put(5, Float.valueOf(exp));
    	//this.gemcutterSmeltingList1.put(Arrays.asList(input1.itemID, input1.getItemDamage()), output);
    	//this.gemcutterSmeltingList2.put(Arrays.asList(input2.itemID, input2.getItemDamage()), output);
    	//this.gemcutterSmeltingCheckList1.put(Arrays.asList(input2.itemID, input2.getItemDamage()), input1);
    	//this.gemcutterSmeltingCheckList2.put(Arrays.asList(input2.itemID, input2.getItemDamage()), input2);
    }

    public float getExperience(int par1)
    {
        return this.experienceList.containsKey(Integer.valueOf(par1)) ? ((Float)this.experienceList.get(Integer.valueOf(par1))).floatValue() : 0.0F;
    }
    
    public float getExperience(ItemStack item)
    {
        if (item == null || item.getItem() == null)
        {
            return 0;
        }
        float ret = item.getItem().getSmeltingExperience(item);
        if (ret < 0 && metaExperience.containsKey(Arrays.asList(item, item.getItemDamage())))
        {
            ret = metaExperience.get(Arrays.asList(item, item.getItemDamage()));
        }
        if (ret < 0 && experienceList.containsKey(item))
        {
            ret = ((Float)experienceList.get(item)).floatValue();
        }
        return (ret < 0 ? 0 : ret);
    }
    
    public Map<List<Item>, ItemStack> getMetaSmeltingList()
    {
        return gemcutterSmeltingList1;
    }
    
    public ItemStack getGemcutterSmeltingResult(ItemStack item1, ItemStack item2)
    {
    	if(item1 == null){return null;}
    	if(item2 == null){return null;}
    	
    	//System.out.print(", emcutter Smelting List : " + gemcutterSmeltingList1.get(Arrays.asList(item1.getItem(), item2.getItem())));
    	ItemStack ret = (ItemStack)gemcutterSmeltingList1.get(Arrays.asList(item1.getItem(), item2.getItem()));
        if (ret != null) 
        {
        	//System.out.print(", ret getItemUnlocalizedName : " + ret.getItem().getUnlocalizedName());
            return ret;
        }

        return (ItemStack)gemcutterSmeltingList1.get(Arrays.asList(item1, item2));
        
    	/*if(item1.itemID == SoulItems.AmazoniteUncut.itemID && item2.itemID == SoulItems.PolisherTowel.itemID || item2.itemID == SoulItems.AmazoniteUncut.itemID && item1.itemID == SoulItems.PolisherTowel.itemID)
    	{
    		return new ItemStack(SoulItems.AmazoniteGem);
    	}*/

    	//return null;
    }

    /*public ItemStack getSlot1ReduceAmount(ItemStack input)
    {
    	return (ItemStack) this.gemcutterSmeltingList1.get(Arrays.asList(input.itemID, input.getItemDamage()));
    }
    
    public ItemStack getSlot2ReduceAmount(ItemStack input)
    {
    	return (ItemStack) this.gemcutterSmeltingList2.get(Arrays.asList(input.itemID, input.getItemDamage()));
    }*/
    
    /*public Map getSmeltingList()
    {
        return this.gemcutterList;
    }

    @Deprecated //In favor of ItemStack sensitive version
    public float getExperience(int par1)
    {
        return this.experienceList.containsKey(Integer.valueOf(par1)) ? ((Float)this.experienceList.get(Integer.valueOf(par1))).floatValue() : 0.0F;
    }

    public void addSmelting(int itemID, int metadata, ItemStack itemstack, float experience)
    {
    	gemcutterSmeltingList.put(Arrays.asList(itemID, metadata), itemstack);
        metaExperience.put(Arrays.asList(itemID, metadata), experience);
    }

    public ItemStack getSmeltingResult(ItemStack item, ItemStack item2) 
    {
        if (item == null || item2 == null)
        {
            return null;
        }
        ItemStack ret = (ItemStack)gemcutterSmeltingList.get(Arrays.asList(item.itemID, item.getItemDamage(), item2.itemID, item2.getItemDamage()));
        if (ret != null) 
        {
            return ret;
        }
        return (ItemStack)gemcutterList.get(Integer.valueOf(item.itemID));
    }

    public float getExperience(ItemStack item)
    {
        if (item == null || item.getItem() == null)
        {
            return 0;
        }
        float ret = item.getItem().getSmeltingExperience(item);
        if (ret < 0 && metaExperience.containsKey(Arrays.asList(item.itemID, item.getItemDamage())))
        {
            ret = metaExperience.get(Arrays.asList(item.itemID, item.getItemDamage()));
        }
        if (ret < 0 && experienceList.containsKey(item.itemID))
        {
            ret = ((Float)experienceList.get(item.itemID)).floatValue();
        }
        return (ret < 0 ? 0 : ret);
    }

    public Map<List<Integer>, ItemStack> getMetaSmeltingList()
    {
        return gemcutterSmeltingList;
    }*/
}
