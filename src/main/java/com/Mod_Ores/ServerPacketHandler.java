package com.Mod_Ores;

import ibxm.Player;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

import net.minecraft.network.EnumConnectionState;
import net.minecraft.network.INetHandler;
import net.minecraft.network.NetworkManager;
import net.minecraft.util.IChatComponent;

public class ServerPacketHandler implements INetHandler{


    /*@Override
        public void onPacketData(NetworkManager manager, net.minecraft.network.packet.Packet250CustomPayload payload, Player player){
                DataInputStream data = new DataInputStream(new ByteArrayInputStream(payload.data));
                net.minecraft.entity.player.EntityPlayer sender = (net.minecraft.entity.player.EntityPlayer) player;
        }*/

    @Override
    public void onDisconnect(IChatComponent var1) {
	// TODO Auto-generated method stub

    }

    @Override
    public void onConnectionStateTransition(EnumConnectionState var1,
	    EnumConnectionState var2) {
	// TODO Auto-generated method stub

    }

    @Override
    public void onNetworkTick() {
	// TODO Auto-generated method stub

    }
}