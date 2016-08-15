package com.task;

import com.action.Action;

/**
 * @author Daniel
 */
public interface UpdateTask {

    int getValue();

    Action getAction();

    void process();

    String getDescription();

}
