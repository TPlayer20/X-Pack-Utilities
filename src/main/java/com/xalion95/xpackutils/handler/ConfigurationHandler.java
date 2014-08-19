package com.xalion95.xpackutils.handler;

import com.xalion95.xpackutils.reference.Reference;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;
import java.io.File;

public class ConfigurationHandler {

    public static Configuration configuration;
    public static boolean UPDATE_CHECK = true;

    public static void init(File configFile) {

        if (configuration == null) {

            // Create the configuration object
            configuration = new Configuration(configFile);
            loadConfiguration();

        }
    }

    private static void loadConfiguration(){

        UPDATE_CHECK = configuration.getBoolean("Check for pack updates", Configuration.CATEGORY_GENERAL, true, "This is an option to check updates for the modpack");
        //System.out.println(UPDATE_CHECK);

        if (configuration.hasChanged()){

            configuration.save();

        }

    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event){

        if (event.modID.equalsIgnoreCase(Reference.MOD_ID)){

            loadConfiguration();

        }

    }

}
