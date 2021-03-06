package com.task.impl;

import com.action.Action;
import com.config.Constants;
import com.config.util.Environment;
import com.logging.Logger;
import com.task.UpdateTask;

import java.io.IOException;
import java.util.logging.Level;

/**
 * @author Daniel
 */
public class Launcher implements UpdateTask {

    public String getDescription() {
        return "Launching...";
    }

    public int getValue() {
        return 100;
    }

    public Action getAction() {
        return null;
    }

    public void process() {
        launch();
    }

    private void launch() {
        try {
            new ProcessBuilder("java", "-jar", "-Xmx256m", Constants.PROGRAM_FILE.getAbsolutePath()).start();
        } catch (IOException ex) {
            Logger.log(Launcher.class, Level.SEVERE, "Error invoking external program", ex);
        }
        Environment.exit(false);
    }

}
