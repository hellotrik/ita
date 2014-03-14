package com.joe.ita.graph;

public class ITAUtils {
    public static String lineSeparator = getLineSeparator();

    public static String getLineSeparator() {
        String lineSeparator = java.security.AccessController
                .doPrivileged(new sun.security.action.GetPropertyAction(
                        "line.separator"));
        return lineSeparator;
    }

}
