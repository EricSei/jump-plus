package utility;

import java.io.*;

public class Message {
    public static final String ANSI_RESET = "\u001B[0m";

    // Declaring the color
    // Custom declaration
    public static final String ANSI_WARNING = "\u001B[33m";
    public static final String ANSI_ERROR = "\u001B[31m";
    public static final String ANSI_MESSAGE = "\u001B[32m";
    public static final String ANSI_TITLE = "\u001B[34m";

    public static void message(String message) {
        System.out.println(ANSI_MESSAGE
                + message
                + ANSI_RESET);
    }

    public static void warn(String message) {
        System.out.println(ANSI_WARNING
                + message
                + ANSI_RESET);
    }

    public static void error(String message) {
        System.out.println(ANSI_ERROR
                + message
                + ANSI_RESET);
    }

    public static void title(String message) {
        System.out.println(ANSI_TITLE
                + message
                + ANSI_RESET);
    }
}
