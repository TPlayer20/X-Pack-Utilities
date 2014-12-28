package com.xalion95.xpackutils.validator;

import com.xalion95.xpackutils.client.gui.guiFrame;
import com.xalion95.xpackutils.utility.LogHelper;

public class JavaArch {

    public static void check(){
        LogHelper.info("Checking the JVM architecture...");
         String jvm = System.getProperty("sun.arch.data.model");
        if (!jvm.equals("64")){
            guiFrame.displayError("Nie posiadasz \u015brodowiska Java w wersji 64-bitowej. Nie mo\u017cesz uruchomi\u0107 paczki mod\u00f3w X-Pack!", "B\u0142\u0105d Javy");
        } else {
            LogHelper.info("The JVM architecture is correct...");
        }
    }

}
