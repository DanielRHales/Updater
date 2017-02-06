package com;

import com.frame.UI;

import javax.swing.*;
import java.awt.*;

/**
 * @author Daniel
 */
public class Main {

    private Main() {
        JDialog.setDefaultLookAndFeelDecorated(true);
        JPopupMenu.setDefaultLightWeightPopupEnabled(true);
        initialize();
    }

    public static void main(String... argv) {
        new Main();
    }

    private void initialize() {
        EventQueue.invokeLater(
                new Runnable() {
                    public void run() {
                        UI.getInstance().focus();
                    }
                }
        );
    }
}
