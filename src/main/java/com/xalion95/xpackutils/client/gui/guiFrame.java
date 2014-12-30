package com.xalion95.xpackutils.client.gui;

import cpw.mods.fml.common.FMLCommonHandler;

import javax.swing.*;

public class guiFrame {
    public static void displayInform(String ErrorText, String Title){
        JOptionPane error = new JOptionPane(ErrorText, JOptionPane.INFORMATION_MESSAGE);
        JDialog dialog = error.createDialog(Title);
        dialog.setAlwaysOnTop(true);
        dialog.setModal(true);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);
    }
    public static void displayError(String ErrorText, String Title){
        JOptionPane error = new JOptionPane(ErrorText, JOptionPane.ERROR_MESSAGE);
        JDialog dialog = error.createDialog(Title);
        dialog.setAlwaysOnTop(true);
        dialog.setModal(true);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);
        FMLCommonHandler.instance().exitJava(0, false);
    }
}
