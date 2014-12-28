package com.xalion95.xpackutils.validator;

import com.xalion95.xpackutils.client.gui.guiFrame;
import com.xalion95.xpackutils.utility.LogHelper;
import java.lang.management.ManagementFactory;

public class RAM {

    public static void check(){
        LogHelper.info("Checking the RAM amount...");
        long memorySize = ((com.sun.management.OperatingSystemMXBean)ManagementFactory.getOperatingSystemMXBean()).getTotalPhysicalMemorySize();
        long requestedMemory = 4000000000L;
        if(memorySize < requestedMemory){
            guiFrame.displayError("Nie posiadasz wymaganej minimalnej ilo\u015bci fizycznej pami\u0119ci RAM (4GB). Nie mo\u017cesz uruchomi\u0107 paczki mod\u00f3w X-Pack!", "B\u0142\u0105d pami\u0119ci RAM");
        } else {
            LogHelper.info("The RAM amount is correct...");
        }
    }
}
