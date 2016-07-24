package com.Mod_Ores;

import ibxm.Player;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

import net.minecraft.network.EnumConnectionState;
import net.minecraft.network.INetHandler;
import net.minecraft.util.IChatComponent;


public class ClientPacketHandler implements INetHandler{
    /*@Override
        public void onPacketData(net.minecraft.network.INetworkManager manager, net.minecraft.network.packet.Packet250CustomPayload payload, Player player){
                DataInputStream data = new DataInputStream(new ByteArrayInputStream(payload.data));
        }*/

    @Override
    public void onDisconnect(IChatComponent var1) {
	// TODO Auto-generated method stub

    }
}