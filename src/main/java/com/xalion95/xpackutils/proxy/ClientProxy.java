package com.xalion95.xpackutils.proxy;

import com.xalion95.xpackutils.reference.Reference;
import com.xalion95.xpackutils.reference.VNet;
import com.xalion95.xpackutils.utility.ChatHelper;
import com.xalion95.xpackutils.utility.ColorHelper;
import com.xalion95.xpackutils.utility.gui;
import com.xalion95.xpackutils.validator.*;
import org.apache.commons.lang3.SystemUtils;


public class ClientProxy extends CommonProxy {

    @Override
    public void validateEnv() {
        boolean os = SystemUtils.IS_OS_WINDOWS;
        if (os) {
            gui.setDefaultLookAndFeel();
            OS.check();
            RAM.check();
            JavaArch.check();
            javaV.check();
            jvmArgs.check();
            javaU.check();
        }
    }

    @Override
    public void inform() {
        ChatHelper.printChatMessage(ColorHelper.setColor.DARK_GREEN.ColorString("[") + ColorHelper.setColor.DARK_PURPLE.ColorString(Reference.MOD_NAME) + ColorHelper.setColor.DARK_GREEN.ColorString("]") + ColorHelper.setColor.GOLD.ColorString(VNet.updateMessage));
    }

    @Override
    public void informSrv() {
        //NOOP
    }
}