package com.xalion95.xpackutils.client.gui;

import com.xalion95.xpackutils.handler.ConfigurationHandler;
import com.xalion95.xpackutils.reference.Reference;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.IConfigElement;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ModGuiConfig extends GuiConfig {
    public ModGuiConfig (GuiScreen parent) {
        super(parent, getProps(), Reference.MOD_ID, false, false, GuiConfig.getAbridgedConfigPath(ConfigurationHandler.configFile.toString()));
    }

    @SuppressWarnings("rawtypes")
    private static List<IConfigElement> getProps()
    {
        Set<String> processed = new TreeSet<String>();
        List<IConfigElement> props = new ArrayList<IConfigElement>();
        for (String catName : ConfigurationHandler.configFile.getCategoryNames())
        {
            boolean shouldAdd = true;
            for (String prevCat : processed)
                if (catName.startsWith(prevCat))
                {
                    shouldAdd = false;
                    break;
                }
            processed.add(catName);
            if (shouldAdd)
                props.add(new ConfigElement(ConfigurationHandler.configFile.getCategory(catName)));
        }

        return props;
    }
}
