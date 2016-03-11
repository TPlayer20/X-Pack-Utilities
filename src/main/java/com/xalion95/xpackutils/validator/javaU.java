package com.xalion95.xpackutils.validator;

import com.xalion95.xpackutils.client.gui.guiFrame;
import com.xalion95.xpackutils.utility.LogHelper;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.StringTokenizer;

public class javaU{
    public static void check(){
        LogHelper.info("Checking JRE update...");
        try{
            URL updateServer = new URL("http://xpack.pl/java8version.txt");
            Scanner scanner = new Scanner(updateServer.openStream(), "UTF-8");
            String temp = scanner.nextLine();
            StringTokenizer tokenizer = new StringTokenizer(temp, " =");
            tokenizer.nextToken();
            int update = Integer.parseInt(tokenizer.nextToken());
            String local = System.getProperty("java.version");
            String[] data = local.split("_");
            int localNumber = Integer.parseInt(data[1]);

            if(localNumber < update){
                guiFrame.displayInform("Nie posiadasz aktualnej wersji oprogramowania Java. Zalecamy aktualizacj\u0119!", "Dost\u0119pna Aktualizacja");
            } else {
                LogHelper.info("JRE update is correct...");
            }

        } catch (IOException e){

            LogHelper.warn("An error has occured while while connecting to X-Pack Servers!");

        }
    }
}