package com.xalion95.xpackutils.utility;

import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextComponentString;

public class ChatHelper {

    public static void printChatMessage(String msg){

        Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new TextComponentString(msg));

    }
}
