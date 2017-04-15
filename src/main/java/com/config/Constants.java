package com.config;


import java.io.File;

/**
 * @author Daniel
 */
public class Constants {

    private static final String SERVER_NAME = "ArteroPk";

    public static final File MAIN_DIRECTORY = new File(System.getProperty("user.home"), String.format("%s Files", SERVER_NAME));
    public static final File PROGRAM_DIRECTORY = new File(MAIN_DIRECTORY, "Launcher");
    public static final File PROGRAM_FILE = new File(PROGRAM_DIRECTORY, "Launcher.jar");

    private static final File TRACE_PATH = new File(MAIN_DIRECTORY, "Updater");
    public static final File TRACE_FILE = new File(TRACE_PATH, "Updater");

    private static final String REMOTE_ROOT_LINK = String.format("http://cache.%s.com/", SERVER_NAME);
    public static final String REMOTE_PROGRAM_LINK = String.format("%s%s", REMOTE_ROOT_LINK, PROGRAM_FILE.getName());
    static final String ALGORITHM = new String[]{"MD5", "SHA-1", "SHA-256"}[2];

}
