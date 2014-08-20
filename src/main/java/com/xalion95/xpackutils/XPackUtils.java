package com.xalion95.xpackutils;

import com.xalion95.xpackutils.handler.ConfigurationHandler;
import com.xalion95.xpackutils.proxy.IProxy;
import com.xalion95.xpackutils.reference.Reference;
import com.xalion95.xpackutils.utility.LogHelper;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)

public class XPackUtils {

    @Mod.Instance(Reference.MOD_ID)
    public static XPackUtils instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS ,serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){

        LogHelper.info("This is a MineCarft X-Pack ModPack by XalionGaming");
        LogHelper.info("Starting initialization of ModPack");
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){

        LogHelper.info("ModPack Initialization completed!!!");

    }

}