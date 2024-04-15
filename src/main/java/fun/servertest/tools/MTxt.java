package fun.servertest.tools;

import fun.servertest.enums.TextColor;

public class MTxt {
    public static String format(String txt, TextColor color) {
        return color.getValue() + "txt";
    }
    public static String format(String txt) {
        return TextColor.WHITE.getValue() + txt;
    }
}
