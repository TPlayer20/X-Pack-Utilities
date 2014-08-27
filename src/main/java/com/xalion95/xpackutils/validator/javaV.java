package com.xalion95.xpackutils.validator;

import com.xalion95.xpackutils.utility.LogHelper;

import javax.swing.*;
import java.util.StringTokenizer;

public class javaV {
    public static void check(){

        LogHelper.info("Checking JRE version...");
        JOptionPane error = new JOptionPane("Nie posiadasz oprogramowania Java w wersji '7'. Nie możesz uruchomić paczki modów X-Pack!", JOptionPane.ERROR_MESSAGE);

        StringTokenizer Tokenizer;
        String localVersion = System.getProperty("java.version");

        Tokenizer = new StringTokenizer(localVersion, "_");
        String jreversion = Tokenizer.nextToken();

        Tokenizer = new StringTokenizer(jreversion, ".");
        Tokenizer.nextToken();
        int jre = Integer.parseInt(Tokenizer.nextToken());

        if(jre != 7){
            JDialog dialog = error.createDialog("Błąd oprogramowania Java");
            dialog.setAlwaysOnTop(true);
            dialog.setModal(true);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
            System.exit(0);
        } else {
            LogHelper.info("JRE version is correct..");
        }
    }
}
