package ui;

import ui.panels.MainPanel;
import ui.panels.PanelType;

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
    private PanelType currentPanelType;
    private Panel panelContainer;
    private CardLayout cardLayout;

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

        // Create cardLayout for the panelContainer
        cardLayout = new CardLayout();
        panelContainer = new Panel(cardLayout);

        //Add all individual panels
        addAllPanels();

        // Set current type to main
        currentPanelType = PanelType.MainPanel;

        // Set the currentPanelType to show
        cardLayout.show(panelContainer, currentPanelType.getName());

        // Add the panelContainer
        frame.add(panelContainer);

        // Set visible, leave last!!
        frame.setVisible(true);
    }

    // Adds all panels to the frame, so we can show them whenever we like
    private void addAllPanels(){
        for (PanelType panelType : PanelType.values()) {
            // Save the panel to the corresponding ID. This can also be used to show it
            panelContainer.add(panelType.getPanel(), panelType.getName());
        }
    }

    public void switchToPanel(PanelType panelType){
        // No need for a change if we are where we want to be
        if(panelType == currentPanelType) return;
        currentPanelType = panelType;
        cardLayout.show(panelContainer, panelType.getName());
    }
}
