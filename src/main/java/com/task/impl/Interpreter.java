package com.task.impl;

import com.action.Action;
import com.config.Configuration;
import com.task.UpdateTask;

/**
 * @author Daniel
 */
public class Interpreter implements UpdateTask {

    public int getValue() {
        return 50;
    }

    public Action getAction() {
        return Configuration.getIdentifier().updateRequired() ? Action.DOWNLOAD_PROGRAM : Action.DECOMPRESS_PROGRAM;
    }

    public String getDescription() {
        return String.format("%s...", Configuration.getIdentifier().getRemote() != null ? "Verifying Information" : "Checking Identifiers");
    }

    public void process() {
        appendValues();
    }

    private void appendValues() {
        Configuration.getIdentifier().refresh();
    }

}
