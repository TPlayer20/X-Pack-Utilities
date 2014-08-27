package com.xalion95.xpackutils.validator;

import com.xalion95.xpackutils.utility.LogHelper;

import javax.swing.*;
import java.lang.management.ManagementFactory;

public class RAM {

    public static void check(){

        LogHelper.info("Checking the RAM amount...");
        JOptionPane error = new JOptionPane("Nie posiadasz wymaganej minimalnej ilości fizycznej pamięci RAM (4GB). Nie możesz uruchomić paczki modów X-Pack!", JOptionPane.ERROR_MESSAGE);

        long memorySize = ((com.sun.management.OperatingSystemMXBean)ManagementFactory.getOperatingSystemMXBean()).getTotalPhysicalMemorySize();
        long requestedMemory = 4000000000L;

        if(memorySize < requestedMemory){
            JDialog dialog = error.createDialog("Błąd pamięci RAM");
            dialog.setAlwaysOnTop(true);
            dialog.setModal(true);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
            System.exit(0);
        } else {
            LogHelper.info("The RAM amount is correct...");
        }
    }
}
