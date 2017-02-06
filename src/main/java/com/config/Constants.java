package com.config;


import java.io.File;

/**
 * @author Daniel
 */
public class Constants {

    private static final String SERVER_NAME = "ArteroPk Cleaned";

    public static final File MAIN_DIRECTORY = new File(System.getProperty("user.home"), SERVER_NAME);
    public static final File ERROR_DIRECTORY = new File(MAIN_DIRECTORY, "UpdaterErrors");
    public static final File PROGRAM_DIRECTORY = new File(MAIN_DIRECTORY, "Client");
    public static final File PROGRAM_FILE = new File(PROGRAM_DIRECTORY, "Client.jar");

    //TODO: private static final String REMOTE_ROOT_LINK = String.format("https://%s.org/", SERVER_NAME);
    //TODO: private static final String REMOTE_DATA_LINK = String.format("%sdata/", REMOTE_ROOT_LINK);

    public static final String REMOTE_PROGRAM_LINK = "https://www.dropbox.com/s/u1c5eeuts3kq4u7/Client-Obfuscated.jar?dl=1";

    private static final String[] ALGORITHMS = new String[]{"MD5", "SHA-1", "SHA-256"};

    static final String ALGORITHM = ALGORITHMS[2];

}
