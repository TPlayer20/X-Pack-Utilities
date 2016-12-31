package com.xalion95.xpackutils.handler;

import com.xalion95.xpackutils.reference.Reference;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;
import java.io.File;

public class ConfigurationHandler {

    public static Configuration configFile;

    // Register Booleans

    public static boolean CONFIG_UPDATE_CHECK = true;

    public static void init(File configName) {

        if (configFile == null) {

            // Create the configuration object
            configFile = new Configuration(configName);
            syncConfig();

        }
    }

    private static void syncConfig(){

        CONFIG_UPDATE_CHECK = configFile.getBoolean("Check for pack updates", Configuration.CATEGORY_GENERAL, true, "This is an option to check updates for the modpack");

        if (configFile.hasChanged()){

            configFile.save();

        }

    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event){

        if (event.getModID().equalsIgnoreCase(Reference.MOD_ID)){

            syncConfig();

        }

    }

}
