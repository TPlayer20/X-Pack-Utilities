package com.xalion95.xpackutils;

import com.xalion95.xpackutils.proxy.IProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = "XPackUtils", name = "X-Pack Utilities", version = "1.7.10-1.0")

public class XPackUtils {

    @Mod.Instance("XPackUtils")
    public static XPackUtils instance;

    @SidedProxy(clientSide = "com.xalion95.xpackutils.proxy.ClientProxy", serverSide = "com.xalion95.xpackutils.proxy.ServerProxy")
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){

    }
}