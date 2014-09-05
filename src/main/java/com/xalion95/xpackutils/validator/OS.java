package com.xalion95.xpackutils.validator;

import com.xalion95.xpackutils.client.gui.guiFrame;
import com.xalion95.xpackutils.utility.LogHelper;

public class OS {

    public static void check(){

        LogHelper.info("Checking the system architecture...");
        String os = System.getProperty("os.arch");
        if (!os.equals("amd64")){
            guiFrame.displayError("Nie posiadasz systemu w wersji 64-bitowej. Nie możesz uruchomić paczki modów X-Pack!", "Błąd systemu");
        } else {
            LogHelper.info("The system architecture is correct...");
        }
    }

}
