package ui;

import ui.panels.TechCompany;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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

        currentPanel = new TechCompany();

        frame.add(currentPanel);

        // Set visible, leave last!!
        frame.setVisible(true);
    }
}
