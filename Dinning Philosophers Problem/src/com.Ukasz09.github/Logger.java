package com.Ukasz09.github;

public class Logger {

    public static void logError(Class actualClass, String errorInfo){
        System.err.println(actualClass.getSimpleName()+": ERROR="+errorInfo);
    }

}
