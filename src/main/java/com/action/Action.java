package com.action;

import com.task.UpdateTask;
import com.task.impl.*;

import javax.swing.*;
import java.awt.*;

/**
 * @author Daniel
 */
public enum Action {
    CHECK_DIRECTORIES(new Director()),
    CHECK_INFORMATION(new Interpreter()),
    DOWNLOAD_PROGRAM(new Downloader()),
    DECOMPRESS_PROGRAM(new Composer()),
    INVOKE_PROGRAM(new Launcher());

    private final UpdateTask task;

    Action(UpdateTask task) {
        this.task = task;
    }

    public static void setAction(final JProgressBar progress, final Action action) {
        if (action != null) {
            progress.setString(action.task.getDescription());
            EventQueue.invokeLater(
                    new SwingWorker() {
                        protected Void doInBackground() throws Exception {
                            action.task.process();
                            return null;
                        }

                        protected void done() {
                            progress.setValue(action.task.getValue());
                            progress.revalidate();
                            progress.repaint();
                            setAction(progress, action.task.getAction());
                        }
                    }
            );

        }
    }

}
