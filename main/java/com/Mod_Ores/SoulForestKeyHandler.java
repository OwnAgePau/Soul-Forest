package com.Mod_Ores;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent;
import cpw.mods.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.settings.KeyBinding;

public class SoulForestKeyHandler {

    /** Key index for easy handling */
    public static final int CUSTOM_INV = 0;
    
    public static boolean isKeyPressed = false;

    /** Key descriptions; use a language file to localize the description later */
    private static final String[] desc = {"key.tooldetail.desc"};

    /** Default key values */
    public static final int[] keyValues = {Keyboard.KEY_F};

    public static final KeyBinding[] keys = new KeyBinding[desc.length];

    public SoulForestKeyHandler() {
	for (int i = 0; i < desc.length; ++i) {
	    keys[i] = new KeyBinding(desc[i], keyValues[i], "key.tooldetail.category");
	    ClientRegistry.registerKeyBinding(keys[i]);
	}
    }
    /**
     * KeyInputEvent is in the FML package, so we must register to the FML event bus
     */
    @SubscribeEvent
    public void onKeyInput(ClientTickEvent event) {
	if(Keyboard.getEventKey() == keys[CUSTOM_INV].getKeyCode()){
	    if(Keyboard.getEventKeyState()){
        	this.isKeyPressed = true;
	    }
	    else{
		this.isKeyPressed = false;	
	    }
	}
    }
}
