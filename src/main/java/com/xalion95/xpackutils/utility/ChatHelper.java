package com.xalion95.xpackutils.utility;

import net.minecraft.client.Minecraft;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;

public class ChatHelper {

    public static void printChatMessage(String msg){

        Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new ChatComponentText(msg));

    }

    public static void printServerMessage(String msg){

        MinecraftServer.getServer().addChatMessage(new ChatComponentText(msg));

    }

}
