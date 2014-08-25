package com.xalion95.xpackutils.validator;

import com.xalion95.xpackutils.utility.LogHelper;
import javax.swing.*;

public class OS {

    public static void check(){

        LogHelper.info("Checking the system architecture...");

        String os = System.getProperty("os.arch");

        if (!os.equals("amd64")){
            JOptionPane.showMessageDialog(null, "Nie posiadasz systemu w wersji 64-bitowej. Nie możesz uruchomić paczki modów X-Pack!", "Błąd Systemu", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } else {
            LogHelper.info("The system architecture is correct...");
        }
    }

}
