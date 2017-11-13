package ui;

import ui.panels.MainPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeListener;

public class Display {

    private int width, height;
    private Frame frame;
    private Panel currentPanel;

    public Display(int width, int height){
        this.width = width;
        this.height = height;

        frame = new Frame("LeaseApp");
        frame.setSize(width,height);
        frame.setLocationRelativeTo(null);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        currentPanel = new MainPanel();

        frame.add(currentPanel);

        // Set visible, leave last!!
        frame.setVisible(true);
    }
}
