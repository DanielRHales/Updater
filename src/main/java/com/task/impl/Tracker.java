package com.task.impl;

import com.action.Action;
import com.config.Constants;
import com.config.util.Environment;
import com.logging.Logger;
import com.task.UpdateTask;

import java.io.*;
import java.util.logging.Level;
import java.util.zip.GZIPOutputStream;

/**
 * @author Daniel
 */
public class Tracker implements UpdateTask {

    @Override
    public int getValue() {
        return 0;
    }

    @Override
    public Action getAction() {
        return Action.CHECK_DIRECTORIES;
    }

    @Override
    public void process() {
        Environment.createParentDirectories(Constants.TRACE_FILE);
        Environment.createFiles(Constants.TRACE_FILE);
        try {
            DataOutputStream stream = new DataOutputStream(new GZIPOutputStream(new FileOutputStream(Constants.TRACE_FILE)));
            final byte[] bytes = new File(Tracker.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath()).getAbsolutePath().getBytes();
            stream.writeInt(bytes.length);
            stream.write(bytes);
            stream.flush();
            stream.close();
        } catch (Exception ex) {
            Logger.log(Tracker.class, Level.WARNING, "Error writing stack file", ex);
        }
    }

    @Override
    public String getDescription() {
        return "Creating Identifier...";
    }
}
