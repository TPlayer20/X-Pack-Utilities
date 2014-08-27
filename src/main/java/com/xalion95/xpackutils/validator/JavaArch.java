package com.xalion95.xpackutils.validator;

import com.xalion95.xpackutils.utility.LogHelper;

import javax.swing.*;

public class JavaArch {

    public static void check(){

        JOptionPane error = new JOptionPane("Nie posiadasz środowiska Java w wersji 64-bitowej. Nie możesz uruchomić paczki modów X-Pack!", JOptionPane.ERROR_MESSAGE);

        LogHelper.info("Checking the JVM architecture...");

         String jvm = System.getProperty("sun.arch.data.model");

        if (!jvm.equals("64")){
            JDialog dialog = error.createDialog("Błąd Javy");
            dialog.setAlwaysOnTop(true);
            dialog.setModal(true);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
            System.exit(0);
        } else {
            LogHelper.info("The JVM architecture is correct...");
        }
    }

}
