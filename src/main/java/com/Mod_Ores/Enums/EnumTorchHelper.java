package com.Mod_Ores.Enums;

public class EnumTorchHelper {
    public static double red;
    public static double blue;
    public static double green;

    public EnumTorchHelper(){}

    public void getTorchColours(String par1Name){	
		if(par1Name == "torchAmazonite"){
		    this.red = 0.0D;
		    this.blue = 0.4D;
		    this.green = 0.0D;
		}
    }
}