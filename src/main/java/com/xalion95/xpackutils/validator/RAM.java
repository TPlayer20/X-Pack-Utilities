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
            guiFrame.displayError("Nie posiadasz wymaganej minimalnej ilości fizycznej pamięci RAM (4GB). Nie możesz uruchomić paczki modów X-Pack!", "Błąd pamięci RAM");
        } else {
            LogHelper.info("The RAM amount is correct...");
        }
    }
}
