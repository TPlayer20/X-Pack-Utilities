package com.xalion95.xpackutils.utility;

public class ColorHelper {

    public enum setColor {

        BLACK(0),
        DARK_BLUE(1),
        DARK_GREEN(2),
        DARK_AQUA(3),
        DARK_RED(4),
        DARK_PURPLE(5),
        GOLD(6),
        GREY(7),
        DARK_GREY(8),
        BLUE(9),
        GREEN("a"),
        AQUA("b"),
        RED("c"),
        LIGHT_PURPLE("d"),
        YELLOW("e"),
        WHITE("f"),
        OBFUSCATED('k'),
        BOLD('l'),
        STRIKETHROUGH('m'),
        UNDERLINE('n'),
        ITALIC('o'),
        RESET('r');
        private String index;

        private setColor(int index) {
            this.index = String.valueOf(index);
        }

        private setColor(String index) {
            this.index = index;
        }

        public String ColorString(String s) {
            return getColorString() + s + setColor.WHITE.getColorString();
        }

        public String getColorString() {
            return "\u00a7" + this.index;
        }
    }
}
