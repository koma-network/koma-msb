package com.micro.msb.util;

/**
 *
 * @author yanyan
 */
import java.util.Date;
import java.text.SimpleDateFormat;

public class Format {

    public static final char SPACE = ' ';
    static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    static SimpleDateFormat fileFormat = new SimpleDateFormat("yyyyMMddHHmmss");

    public static String trimLeftZero(String s) {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (first && (ch == '0')) {
                continue;
            }
            sb.append(ch);
            first = false;
        }
        if (sb.length() > 0) {
            return sb.toString();
        }
        return "";
    }

    public static String zeroLeading(String s, int width) {
        StringBuilder sb = new StringBuilder(s);
        while (sb.length() < width) {
            sb.insert(0, "0");
        }
        return sb.toString();
    }

    public static String zeroLeading(long n, int width) {
        return zeroLeading(String.valueOf(n), width);
    }

    public static String leftAlign(String s, int width, char ch) {
        StringBuilder sb = new StringBuilder();
        if (s != null) {
            sb.append(s);
        }
        while (sb.length() < width) {
            sb.append(ch);
        }
        return sb.toString().substring(0, width);
    }

    public static String leftAlign(String s, int width) {
        return leftAlign(s, width, SPACE);
    }

    public static String rightAlign(String s, int width, char ch) {
        StringBuilder sb = new StringBuilder(s);
        while (sb.length() < width) {
            sb.insert(0, ch);
        }
        return sb.toString().substring(0, width);
    }

    public static String rightAlign(String s, int width) {
        return rightAlign(s, width, SPACE);
    }

    public static String rightAlign(long n, int width) {
        return rightAlign(String.valueOf(n), width);
    }

    public static String formatMillis(Date d) {
        long millis = d.getTime() % 1000;
        return Long.toString(millis);
    }
    
    public static String formatMillis(long millis) {
        long hour = 0;
        long minute = 0;
        long second = millis / 1000;
        millis %= 1000;
        while (second >= 60) {
            minute = second / 60;
            second %= 60;
            while (minute >= 60) {
                hour = minute / 60;
                minute %= 60;
            }
        }
        return Format.zeroLeading(hour, 2) + ":"
                + Format.zeroLeading(minute, 2) + ":"
                + Format.zeroLeading(second, 2) + "."
                + Format.zeroLeading(millis, 3);
    }

    public static String formatDate(Date d) {
        long millis = d.getTime() % 1000;
        return dateFormat.format(d) + "." + zeroLeading(millis, 3);
    }

    public static String formatDate(long millis) {
        return formatDate(new Date(millis));
    }

    public static String formatDate() {
        return formatDate(new Date());
    }

    public static String formatFileDate(Date d) {
        return fileFormat.format(d);
    }

    public static String formatFileDate(long millis) {
        return fileFormat.format(new Date(millis));
    }

    public static String formatFileDate() {
        return formatFileDate(new Date());
    }

    public static String repli(String s, int width) {
        StringBuilder sb = new StringBuilder();
        while (sb.length() < width) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static String repli(char ch, int width) {
        return repli(String.valueOf(ch), width);
    }
}
