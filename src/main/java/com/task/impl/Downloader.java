package com.task.impl;

import com.action.Action;
import com.config.Configuration;
import com.config.Constants;
import com.config.util.Environment;
import com.io.Connector;
import com.logging.Logger;
import com.task.UpdateTask;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;

/**
 * @author Daniel
 */
public class Downloader implements UpdateTask {

    public int getValue() {
        return 75;
    }

    public Action getAction() {
        return Action.CHECK_INFORMATION;
    }

    public void process() {
        initialize();
    }

    public String getDescription() {
        return "Downloading Latest Version...";
    }

    private void initialize() {
        try {
            download();
        } catch (IOException ex) {
            Logger.log(Downloader.class, Level.WARNING, String.format("Error downloading file %s", Constants.REMOTE_PROGRAM_LINK), ex);
        }
    }

    private void download() throws IOException {
        Environment.createFiles(Constants.PROGRAM_FILE);
        final InputStream input = Configuration.getUrlStream().setInputStream(Connector.getUrlInputStream());
        final OutputStream output = Configuration.getFileStream().setOutputStream(Connector.getFileOutputStream());
        final byte[] buffer = new byte[1024];
        int length;
        while ((Configuration.getUrlStream().getInputStream() != null
                && Configuration.getFileStream().getOutputStream() != null)
                && (length = input.read(buffer)) > 0) {
            output.write(buffer, 0, length);
        }
        Configuration.getUrlStream().close();
        Configuration.getFileStream().close();
    }

}
