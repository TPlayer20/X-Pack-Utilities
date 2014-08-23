package com.xalion95.xpackutils.handler;


import com.xalion95.xpackutils.reference.RConfig;
import com.xalion95.xpackutils.reference.Reference;
import com.xalion95.xpackutils.reference.VNet;
import com.xalion95.xpackutils.utility.LogHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.ChatComponentText;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.StringTokenizer;

public class URLHandler {


    private static boolean urlReader(){

        try {
            URL updateService = new URL(Reference.UPDATE_HOSTNAME + Reference.UPDATE_FILE);
            Scanner versionCheck = new Scanner(updateService.openStream());

            StringTokenizer strtok;
            String strtmp;

            strtmp = versionCheck.nextLine();
            strtok = new StringTokenizer(strtmp, " = ");

            strtok.nextToken();
            VNet.informClients = Boolean.parseBoolean(strtok.nextToken());

            strtmp=versionCheck.nextLine();
            strtok=new StringTokenizer(strtmp, " = ");
            strtok.nextToken();
            VNet.packVersion = Integer.parseInt(strtok.nextToken());

            strtmp=versionCheck.nextLine();
            strtok=new StringTokenizer(strtmp, "=");
            strtok.nextToken();
            VNet.updateMessage = strtok.nextToken();

        } catch (IOException e){
            LogHelper.warn("An error has occured while while connecting to X-Pack Services!");
        }


        if (VNet.informClients && RConfig.CONFIG_BOOLEAN_GENERAL_UPDATE_CHECK) {
            if (VNet.packVersion > Reference.CURRENT_VERSION) {
                LogHelper.warn("You are using the old version of modpack! Going to inform the chat...");
                return true;
            } else if (VNet.packVersion <= Reference.CURRENT_VERSION) {
                LogHelper.info("You are using the most up-to-date version of modpack!");
                return false;
            } else {
                LogHelper.info("Cannot check the version...");
                return false;
            }
        }
        return false;
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    private void playerLogged(PlayerEvent.PlayerLoggedInEvent event){
        if(urlReader()) {
            event.player.addChatMessage(new ChatComponentText("§2[§r§5" + Reference.MOD_NAME + "§r§2]" + "§r§6" + VNet.updateMessage + "§r"));
        }
    }
}
