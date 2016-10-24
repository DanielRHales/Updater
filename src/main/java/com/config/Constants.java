package com.config;


import java.io.File;

/**
 * @author Daniel
 */
public class Constants {

    private static final String SERVER_NAME = "RedemptionPk";

    public static final File MAIN_DIRECTORY = new File(System.getProperty("user.home"), SERVER_NAME);
    public static final File ERROR_DIRECTORY = new File(MAIN_DIRECTORY, "UpdaterErrors");
    public static final File PROGRAM_DIRECTORY = new File(MAIN_DIRECTORY, "Client");
    public static final File PROGRAM_FILE = new File(PROGRAM_DIRECTORY, "Client.jar");

    private static final String REMOTE_ROOT_LINK = String.format("http://services.%s.org/", SERVER_NAME);
    private static final String REMOTE_DATA_LINK = String.format("%sdata/", REMOTE_ROOT_LINK);
    public static final String REMOTE_PROGRAM_LINK = String.format("%sClient.jar", REMOTE_DATA_LINK);

    private static final String[] ALGORITHMS = new String[]{"MD5", "SHA-1", "SHA-256"};

    static final String ALGORITHM = ALGORITHMS[2];

}
