package com.task.impl;

import com.action.Action;
import com.config.Constants;
import com.config.util.Environment;
import com.logging.Logger;
import com.task.UpdateTask;

import java.io.*;
import java.util.logging.Level;

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
        Environment.createFiles(Constants.TRACE_FILE);
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(Constants.TRACE_FILE));
            dataOutputStream.writeUTF(new File(Tracker.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath()).getAbsolutePath());
            dataOutputStream.flush();
            dataOutputStream.close();
        } catch (Exception ex) {
            Logger.log(Tracker.class, Level.WARNING, "Error writing stack file", ex);
        }
    }

    @Override
    public String getDescription() {
        return "Creating Identifier...";
    }
}
