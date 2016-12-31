package com.xalion95.xpackutils.utility;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.xalion95.xpackutils.XPackUtils;
import com.xalion95.xpackutils.reference.Paczka;
import com.xalion95.xpackutils.reference.RConfig;
import com.xalion95.xpackutils.reference.Reference;
import com.xalion95.xpackutils.reference.VNet;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

public class updateChecker {
    public static boolean urlReader(){

        try {
            Gson gson = new Gson();
            URL updateService = new URL(Reference.UPDATE_HOSTNAME + Reference.UPDATE_FILE);
            BufferedReader reader = new BufferedReader(new InputStreamReader(updateService.openStream()));
            List<Paczka> list = gson.fromJson(reader, new TypeToken<List<Paczka>>(){}.getType());
            reader.close();
            for(Paczka paczka: list){
                if(paczka.getName().equals(Reference.UNIQUE_ID)){
                    VNet.hasNewerVersion = paczka.isHasNewerVersion();
                    if(VNet.hasNewerVersion){
                        VNet.updateMessage = paczka.getUpdateMessage();
                    }
                }
            }

        } catch (IOException e){
            LogHelper.warn("An error has occurred while connecting to X-Pack Services!");
            return false;
        } catch (JsonSyntaxException e){
            LogHelper.warn("An error has occurred while connecting to X-Pack Services!");
            return false;
        }


        return VNet.hasNewerVersion && RConfig.CONFIG_BOOLEAN_GENERAL_UPDATE_CHECK;

    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void go(PlayerEvent.PlayerLoggedInEvent event){
        if(urlReader()){
            XPackUtils.proxy.inform();
        }
    }
}
