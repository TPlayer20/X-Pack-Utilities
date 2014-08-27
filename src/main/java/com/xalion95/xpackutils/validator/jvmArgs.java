package com.xalion95.xpackutils.validator;

import com.xalion95.xpackutils.utility.LogHelper;
import javax.swing.*;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.List;
import java.util.StringTokenizer;

public class jvmArgs {

    public static void check() {

        LogHelper.info("Checking JVM arguments...");

        try {
            StringTokenizer Tokenizer;

            RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
            List<String> getFromCheck = runtimeMXBean.getInputArguments();
            String[] arguments = getFromCheck.toArray(new String[getFromCheck.size()]);

            for (int counter=0;counter<arguments.length;counter++){
                System.out.println(counter + "\t" + arguments[counter]);
            }

            Tokenizer = new StringTokenizer(arguments[1], "-Xmx");
            String xmxBefore = Tokenizer.nextToken();
            Tokenizer = new StringTokenizer(xmxBefore, "G");
            int xmx = Integer.parseInt(Tokenizer.nextToken());

            Tokenizer = new StringTokenizer(arguments[2], "-Xms");
            String xmsBefore = Tokenizer.nextToken();
            Tokenizer = new StringTokenizer(xmsBefore, "G");
            int xms = Integer.parseInt(Tokenizer.nextToken());

            Tokenizer = new StringTokenizer(arguments[3], "-XX:MaxPermSize=");
            String xxmaxBefore = Tokenizer.nextToken();
            Tokenizer = new StringTokenizer(xxmaxBefore, "m");
            int xxmax = Integer.parseInt(Tokenizer.nextToken());

            Tokenizer = new StringTokenizer(arguments[4], "-XX:PermSize=");
            String xxBefore = Tokenizer.nextToken();
            Tokenizer = new StringTokenizer(xxBefore, "m");
            int xx = Integer.parseInt(Tokenizer.nextToken());

            if(xmx < 2 || xms < 1 || xxmax < 2048 || xx < 1024 ){
                JOptionPane.showMessageDialog(null, "Nie używasz zalecanych argumentów JVM lub ich składnia jest niepoprawna. Zalecamy skopiować JVM Arguments ze strony xpack.pl/download.", "Błąd argumentów", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            } else if(!"-Dfml.ignoreInvalidMinecraftCertificates=true".equals(arguments[5])){
                JOptionPane.showMessageDialog(null, "Nie używasz zalecanych argumentów JVM lub ich składnia jest niepoprawna. Zalecamy skopiować JVM Arguments ze strony xpack.pl/download.", "Błąd argumentów", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            } else if(!"-Dfml.ignorePatchDiscrepancies=true".equals(arguments[6])){
                JOptionPane.showMessageDialog(null, "Nie używasz zalecanych argumentów JVM lub ich składnia jest niepoprawna. Zalecamy skopiować JVM Arguments ze strony xpack.pl/download.", "Błąd argumentów", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            } else {
                LogHelper.info("JVM arguments are correct");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Nie używasz zalecanych argumentów JVM lub ich składnia jest niepoprawna. Zalecamy skopiować JVM Arguments ze strony xpack.pl/download.", "Błąd argumentów", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
}
