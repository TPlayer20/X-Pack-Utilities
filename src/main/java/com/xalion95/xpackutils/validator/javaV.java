package com.xalion95.xpackutils.validator;

import com.xalion95.xpackutils.client.gui.guiFrame;
import com.xalion95.xpackutils.utility.LogHelper;
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
            guiFrame.displayError("Nie posiadasz oprogramowania Java w wersji '8'. Nie mo\u017cesz uruchomi\u0107 paczki mod\u00f3w X-Pack!", "B\u0142\u0105d oprogramowania Java");

        } else {
            LogHelper.info("JRE version is correct..");
        }
    }
}
