package com.xalion95.xpackutils.validator;

import com.xalion95.xpackutils.utility.LogHelper;
import javax.swing.*;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.List;
import java.util.StringTokenizer;

public class jvmArgs {

    public static void check(){

        LogHelper.info("Checking JVM arguments...");

        StringTokenizer Tokenizer;

        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        List<String> getFromCheck = runtimeMXBean.getInputArguments();
        String[] arguments = getFromCheck.toArray(new String[getFromCheck.size()]);

        Tokenizer = new StringTokenizer(arguments[1], "-Xmx");
        String xmxBefore = Tokenizer.nextToken();
        Tokenizer = new StringTokenizer(xmxBefore, "G");
        int xmx = Integer.parseInt(Tokenizer.nextToken());

        Tokenizer = new StringTokenizer(arguments[2], "-Xms");
        String xmsBefore = Tokenizer.nextToken();
        Tokenizer = new StringTokenizer(xmsBefore, "G");
        int xms = Integer.parseInt(Tokenizer.nextToken());

        if(xmx < 2 || xms < 1){
            JOptionPane.showMessageDialog(null, "Nie używasz zalecanych argumentów JVM (minimalne: -Xmx2G -Xms1G) lub ich składnia jest niepoprawna. Zalecamy skopiować JVM Arguments ze strony http://xpack.pl/download.", "Błąd argumentów", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } else {
            LogHelper.info("JVM arguments are correct...");
        }
    }

}
