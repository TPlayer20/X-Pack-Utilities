package com.xalion95.xpackutils;

import com.xalion95.xpackutils.handler.ConfigurationHandler;
import com.xalion95.xpackutils.handler.URLHandler;
import com.xalion95.xpackutils.proxy.IProxy;
import com.xalion95.xpackutils.reference.Reference;
import com.xalion95.xpackutils.utility.LogHelper;
import com.xalion95.xpackutils.validator.*;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartedEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)


public class XPackUtils {

    @Mod.Instance(Reference.MOD_ID)
    public static XPackUtils instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS ,serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){

        LogHelper.info("This is a MineCarft X-Pack ModPack by XalionGaming");
        OS.check();
        JavaArch.check();
        jvmArgs.check();
        RAM.check();
        javaV.check();
        javaU.check();
        LogHelper.info("Starting initialization of ModPack");
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
        FMLCommonHandler.instance().bus().register(new URLHandler());
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){

        LogHelper.info("ModPack Initialization completed!!!");

    }

    @SideOnly(Side.SERVER)
    @Mod.EventHandler
    public void serverStarted(FMLServerStartedEvent event){
          URLHandler.urlReader();
    }
}