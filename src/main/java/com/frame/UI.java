package com.frame;

import java.awt.*;

/**
 * @author Daniel
 */
public class UI extends javax.swing.JFrame {

    private final javax.swing.JProgressBar PROGRESS = new javax.swing.JProgressBar();

    private UI() {
        initialize();
    }

    public static UI getInstance() {
        return InstanceHolder.instance != null ? InstanceHolder.instance : (InstanceHolder.instance = new UI());
    }

    private void initialize() {
        javax.swing.JPanel panel = new javax.swing.JPanel();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setMinimumSize(new java.awt.Dimension(200, 35));
        setUndecorated(true);
        setResizable(false);
        panel.setLayout(new java.awt.BorderLayout());
        PROGRESS.setStringPainted(true);
        panel.add(PROGRESS, java.awt.BorderLayout.CENTER);
        getContentPane().add(panel, java.awt.BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
        postInitiation(PROGRESS);
    }

    private void postInitiation(javax.swing.JProgressBar progress) {
        com.action.Action.setAction(progress, com.action.Action.CHECK_DIRECTORIES);
    }

    public javax.swing.JProgressBar getProgress() {
        return PROGRESS;
    }

    private static class InstanceHolder {
        private static UI instance;
    }

    public void focus() {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                setVisible(true);
                toFront();
                requestFocus();
            }
        });
    }

}
