package com.Mod_Ores.Blocks.Recipes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.Mod_Ores.Init.SoulItems;

public class GelExtractorRecipes
{
    private static final GelExtractorRecipes gelExtractingBase = new GelExtractorRecipes();

    /** The list of smelting results. */
    private Map gelExtractorList = new HashMap();
    private Map experienceList = new HashMap();
    private Map<List<Item>, ItemStack> gelExtractorList1 = new HashMap<List<Item>, ItemStack>();
    private HashMap<List<Integer>, ItemStack> gelExtractorList2 = new HashMap<List<Integer>, ItemStack>();
    private HashMap<List<Integer>, ItemStack> gelExtractorCheckList1 = new HashMap<List<Integer>, ItemStack>();
    private HashMap<List<Integer>, ItemStack> gelExtractorCheckList2 = new HashMap<List<Integer>, ItemStack>();
    private HashMap<List<Integer>, Float> metaExperience = new HashMap<List<Integer>, Float>();

    public static final GelExtractorRecipes smelting()
    {
        return gelExtractingBase;
    }

    private GelExtractorRecipes()
    {
        this.addGelExtractorRecipe(new ItemStack(SoulItems.BlueMoltenGel.get()), new ItemStack(SoulItems.GelPot.get()), new ItemStack(SoulItems.GelPotFilled.get()), 0.5F);
    }

    /**
     * Adds a smelting recipe.
     */
    public void addGelExtractorRecipe(ItemStack input1, ItemStack input2, ItemStack output, float exp)
    {
    	this.gelExtractorList1.put(Arrays.asList(input1.getItem(), input2.getItem()), output);
    	this.experienceList.put(5, Float.valueOf(exp));
    	//this.gelExtractorList1.put(Arrays.asList(input1.itemID, input1.getItemDamage()), output);
    	//this.gelExtractorList2.put(Arrays.asList(input2.itemID, input2.getItemDamage()), output);
    	//this.gelExtractorCheckList1.put(Arrays.asList(input2.itemID, input2.getItemDamage()), input1);
    	//this.gelExtractorCheckList1.put(Arrays.asList(input2.itemID, input2.getItemDamage()), input2);
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
        return gelExtractorList1;
    }
    
    public ItemStack getExtractResult(ItemStack item1, ItemStack item2)
    {
    	if(item1 == null){return null;}
    	if(item2 == null){return null;}
    	
    	System.out.print(gelExtractorList1.get(Arrays.asList(item1.getItem(), item2.getItem())));
    	ItemStack ret = (ItemStack)gelExtractorList1.get(Arrays.asList(item1.getItem(), item2.getItem()));
        if (ret != null) 
        {
        	//System.out.print(ret.getItem().getUnlocalizedName());
            return ret;
        }
        
        return (ItemStack)gelExtractorList1.get(Arrays.asList(item1.getItem(), item2.getItem()));
    }
}
