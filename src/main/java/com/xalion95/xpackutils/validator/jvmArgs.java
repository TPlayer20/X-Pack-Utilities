package com.xalion95.xpackutils.validator;

import com.xalion95.xpackutils.utility.LogHelper;
import javax.swing.*;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class jvmArgs {

    public static void check() {

        LogHelper.info("Checking JVM arguments...");
        JOptionPane error = new JOptionPane("Nie używasz zalecanych argumentów JVM lub ich składnia jest niepoprawna. Zalecamy skopiować JVM Arguments ze strony xpack.pl/download.", JOptionPane.ERROR_MESSAGE);
        try {
            StringTokenizer Tokenizer;

            RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
            List<String> getFromCheck = runtimeMXBean.getInputArguments();
            String[] arguments;
            arguments = getFromCheck.toArray(new String[getFromCheck.size()]);

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

            if (xmx < 2 || xms < 1 || xxmax < 2048 || xx < 1024 ) {
                JDialog dialog = error.createDialog("Błąd argumentów");
                dialog.setAlwaysOnTop(true);
                dialog.setModal(true);
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.setVisible(true);
                System.exit(0);
            } else if(!Arrays.asList(arguments).contains("-Dfml.ignoreInvalidMinecraftCertificates=true")) {
                JDialog dialog = error.createDialog("Błąd argumentów");
                dialog.setAlwaysOnTop(true);
                dialog.setModal(true);
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.setVisible(true);
                System.exit(0);
            } else if(!Arrays.asList(arguments).contains("-Dfml.ignorePatchDiscrepancies=true")){
                JDialog dialog = error.createDialog("Błąd argumentów");
                dialog.setAlwaysOnTop(true);
                dialog.setModal(true);
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.setVisible(true);
                System.exit(0);
            } else {
                LogHelper.info("JVM arguments are correct");
            }
        } catch (NumberFormatException e){
            JDialog dialog = error.createDialog("Błąd argumentów");
            dialog.setAlwaysOnTop(true);
            dialog.setModal(true);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
            System.exit(0);
        }
    }
}
