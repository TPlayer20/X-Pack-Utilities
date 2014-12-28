package com.xalion95.xpackutils.validator;

import com.xalion95.xpackutils.client.gui.guiFrame;
import com.xalion95.xpackutils.reference.Reference;
import com.xalion95.xpackutils.utility.LogHelper;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.StringTokenizer;

public class javaU{
    public static void check(){
        LogHelper.info("Checking JRE update...");
        try{
            URL updateService = new URL(Reference.UPDATE_HOSTNAME + Reference.UPDATE_FILE_JAVA);
            Scanner updatecheck = new Scanner(updateService.openStream(), "UTF-8");

            StringTokenizer Tokenizer;
            String temp;

            temp = updatecheck.nextLine();
            Tokenizer = new StringTokenizer(temp, " = ");
            Tokenizer.nextToken();
            int newestUpdate = Integer.parseInt(Tokenizer.nextToken());

            temp = System.getProperty("java.version");
            Tokenizer = new StringTokenizer(temp, "_");
            Tokenizer.nextToken();
            int localUpdate = Integer.parseInt(Tokenizer.nextToken());

            if(localUpdate < newestUpdate){
                guiFrame.displayInform("Nie posiadasz aktualnej wersji oprogramowania Java. Zalecamy aktualizacj\u0119!", "Dost\u0119pna Aktualizacja");
            } else {
                LogHelper.info("JRE update is correct...");
            }

        } catch (IOException e){

            LogHelper.warn("An error has occured while while connecting to X-Pack Services!");

        }
    }
}