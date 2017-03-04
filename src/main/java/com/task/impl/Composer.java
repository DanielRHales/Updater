package com.task.impl;

import com.action.Action;
import com.config.Constants;
import com.logging.Logger;
import com.task.UpdateTask;

import java.io.*;
import java.util.logging.Level;
import java.util.zip.GZIPInputStream;

/**
 * @author Daniel
 */
public class Composer implements UpdateTask {

    @Override
    public int getValue() {
        return 85;
    }

    @Override
    public Action getAction() {
        return Action.INVOKE_PROGRAM;
    }

    @Override
    public void process() {
        try {
            final DataInputStream dataInputStream = new DataInputStream(new GZIPInputStream(new FileInputStream(Constants.PROGRAM_FILE)));
            final int length = dataInputStream.readInt();
            final byte[] bytes = new byte[length];
            dataInputStream.readFully(bytes);
            dataInputStream.close();
            final DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(Constants.EXECUTABLE_FILE));
            dataOutputStream.write(bytes);
            dataOutputStream.flush();
            dataInputStream.close();
        } catch (IOException ex) {
            Logger.log(Composer.class, Level.SEVERE, "Unable to Compose Application File", ex);
        }
    }

    @Override
    public String getDescription() {
        return "Composing...";
    }
}
