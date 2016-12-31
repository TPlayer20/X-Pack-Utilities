package com.xalion95.xpackutils;

import com.xalion95.xpackutils.handler.ConfigurationHandler;
import com.xalion95.xpackutils.proxy.IProxy;
import com.xalion95.xpackutils.reference.Reference;
import com.xalion95.xpackutils.utility.LogHelper;
import com.xalion95.xpackutils.utility.gui;
import com.xalion95.xpackutils.utility.updateChecker;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.net.UnknownHostException;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)


public class XPackUtils {

    @Mod.Instance(Reference.MOD_ID)
    public static XPackUtils instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    @Mod.EventHandler
    public void construct(FMLConstructionEvent event){
        LogHelper.info("This is a MineCraft X-Pack ModPack by XalionGaming");
        gui.setDefaultLookAndFeel();
        proxy.validateEnv();
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        LogHelper.info("Starting initialization of ModPack");
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
        MinecraftForge.EVENT_BUS.register(new ConfigurationHandler());
        MinecraftForge.EVENT_BUS.register(new updateChecker());
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        //NOOP
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){
        LogHelper.info("ModPack Initialization completed!!!");
    }

    @SideOnly(Side.SERVER)
    @Mod.EventHandler
    public void goSrv(FMLServerStartedEvent event){
        if(updateChecker.urlReader()){
           proxy.informSrv();
        }
    }
}