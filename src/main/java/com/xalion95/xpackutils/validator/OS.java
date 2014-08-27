package com.xalion95.xpackutils.validator;

import com.xalion95.xpackutils.utility.LogHelper;
import javax.swing.*;

public class OS {

    public static void check(){

        LogHelper.info("Checking the system architecture...");
        JOptionPane error = new JOptionPane("Nie posiadasz systemu w wersji 64-bitowej. Nie możesz uruchomić paczki modów X-Pack!", JOptionPane.ERROR_MESSAGE);

        String os = System.getProperty("os.arch");

        if (!os.equals("amd64")){
            JDialog dialog = error.createDialog("Błąd systemu");
            dialog.setAlwaysOnTop(true);
            dialog.setModal(true);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
            System.exit(0);
        } else {
            LogHelper.info("The system architecture is correct...");
        }
    }

}
