package ui;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Display {

    private int width, height;
    private Frame frame;
    private Window window;

    public Display(int width, int height){
        this.width = width;
        this.height = height;

        frame = new Frame("LeaseApp");
        frame.setVisible(true);
        frame.setSize(width,height);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
