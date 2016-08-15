package com.task.impl;

import com.action.Action;
import com.config.Constants;
import com.config.Environment;
import com.task.UpdateTask;

/**
 * @author Daniel
 */
public class Director implements UpdateTask {

    public int getValue() {
        return 25;
    }

    public Action getAction() {
        return Action.CHECK_INFORMATION;
    }

    public String getDescription() {
        return "Checking Directories...";
    }

    public void process() {
        build();
    }

    private void build() {
        Environment.create(Constants.MAIN_DIRECTORY, true);
        Environment.create(Constants.ERROR_DIRECTORY, true);
        Environment.create(Constants.PROGRAM_DIRECTORY, true);
    }

}
