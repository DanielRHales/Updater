package com.frame;

/**
 * @author Daniel
 */
public class UI extends javax.swing.JFrame {

    private UI() {
        initialize();
    }

    public static UI getInstance() {
        return InstanceHolder.instance != null ? InstanceHolder.instance : (InstanceHolder.instance = new UI());
    }

    private void initialize() {
        javax.swing.JPanel panel = new javax.swing.JPanel();
        javax.swing.JProgressBar progressBar = new javax.swing.JProgressBar();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setMinimumSize(new java.awt.Dimension(200, 35));
        setUndecorated(true);
        setResizable(false);
        panel.setLayout(new java.awt.BorderLayout());
        progressBar.setStringPainted(true);
        panel.add(progressBar, java.awt.BorderLayout.CENTER);
        getContentPane().add(panel, java.awt.BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
        postInitiation(progressBar);
    }

    private void postInitiation(javax.swing.JProgressBar progress) {
        com.action.Action.setAction(progress, com.action.Action.CHECK_DIRECTORIES);
    }

    private static class InstanceHolder {
        private static UI instance;
    }

}
