package com.xalion95.xpackutils.validator;

import com.xalion95.xpackutils.utility.LogHelper;

import javax.swing.*;
import java.util.StringTokenizer;

public class javaV {
    public static void check(){

        LogHelper.info("Checking JRE version...");

        StringTokenizer Tokenizer;
        String localVersion = System.getProperty("java.version");

        Tokenizer = new StringTokenizer(localVersion, "_");
        String jreversion = Tokenizer.nextToken();

        Tokenizer = new StringTokenizer(jreversion, ".");
        Tokenizer.nextToken();
        int jre = Integer.parseInt(Tokenizer.nextToken());

        if(jre != 8){
            JOptionPane.showMessageDialog(null, "Nie posiadasz oprogramowania Java w wersji '8'. Nie możesz uruchomić paczki modów X-Pack!", "Błąd oprogramowania Java", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } else {
            LogHelper.info("JRE version is correct..");
        }
    }
}
