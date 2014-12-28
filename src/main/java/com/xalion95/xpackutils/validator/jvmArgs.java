package com.xalion95.xpackutils.validator;

import com.xalion95.xpackutils.client.gui.guiFrame;
import com.xalion95.xpackutils.utility.LogHelper;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class jvmArgs {

    public static void check() {

        LogHelper.info("Checking JVM arguments...");

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
                guiFrame.displayError("Nie u\u017cywasz zalecanych argument\u00f3w JVM lub ich sk\u0142adnia jest niepoprawna. Zalecamy skopiowa\u0107 JVM Arguments ze strony xpack.pl/repo/instrukcja.html.", "B\u0142\u0105d argument\u00f3w");
            } else if(!Arrays.asList(arguments).contains("-Dfml.ignoreInvalidMinecraftCertificates=true")) {
                guiFrame.displayError("Nie u\u017cywasz zalecanych argument\u00f3w JVM lub ich sk\u0142adnia jest niepoprawna. Zalecamy skopiowa\u0107 JVM Arguments ze strony xpack.pl/repo/instrukcja.html.", "B\u0142\u0105d argument\u00f3w");
            } else if(!Arrays.asList(arguments).contains("-Dfml.ignorePatchDiscrepancies=true")){
                guiFrame.displayError("Nie u\u017cywasz zalecanych argument\u00f3w JVM lub ich sk\u0142adnia jest niepoprawna. Zalecamy skopiowa\u0107 JVM Arguments ze strony xpack.pl/repo/instrukcja.html.", "B\u0142\u0105d argument\u00f3w");
            } else {
                LogHelper.info("JVM arguments are correct");
            }
        } catch (NumberFormatException e){
            guiFrame.displayError("Nie u\u017cywasz zalecanych argument\u00f3w JVM lub ich sk\u0142adnia jest niepoprawna. Zalecamy skopiowa\u0107 JVM Arguments ze strony xpack.pl/repo/instrukcja.html.", "B\u0142\u0105d argument\u00f3w");

        }
    }
}
