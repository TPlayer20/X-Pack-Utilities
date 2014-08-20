package com.xalion95.xpackutils.client.gui;

import com.xalion95.xpackutils.handler.ConfigurationHandler;
import com.xalion95.xpackutils.reference.Reference;
import cpw.mods.fml.client.config.GuiConfig;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;

public class ModGuiConfig extends GuiConfig {
    public ModGuiConfig (GuiScreen parent) {
        super(parent,
                new ConfigElement(ConfigurationHandler.configFile.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(),
                Reference.MOD_ID, false, false, GuiConfig.getAbridgedConfigPath(ConfigurationHandler.configFile.toString()));
    }
}
