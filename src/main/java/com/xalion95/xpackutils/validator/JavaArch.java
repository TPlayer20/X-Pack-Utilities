package com.xalion95.xpackutils.validator;

import com.xalion95.xpackutils.utility.LogHelper;

import javax.swing.*;

public class JavaArch {

    public static void check(){

        LogHelper.info("Checking the JVM architecture...");

         String jvm = System.getProperty("sun.arch.data.model");

        if (!jvm.equals("64")){
            JOptionPane.showMessageDialog(null, "Nie posiadasz środowiska Java w wersji 64-bitowej. Nie możesz uruchomić paczki modów X-Pack!", "Błąd Javy", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } else {
            LogHelper.info("The JVM architecture is correct...");
        }
    }

}
