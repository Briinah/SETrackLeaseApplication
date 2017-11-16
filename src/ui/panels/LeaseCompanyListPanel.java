package ui.panels;

import ui.DisplayManager;
import ui.elements.MenuButton;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeaseCompanyListPanel extends Panel {

    private Label title;
    private MenuButton backButton;

    Font myFont = new Font("myfont", Font.BOLD, 20);

    public LeaseCompanyListPanel(){
        setBackground(Color.RED);

        // set layout
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // margins between buttons
        gbc.gridx = 0;

        // initialize label with title and add to panel
        title = new Label("Lease Company list");
        title.setFont(myFont);
        gbc.gridy = 0;
        this.add(title);

        // initialize buttons and add to panel
        backButton = new MenuButton("Return");
        gbc.insets = new Insets(60, 10, 10, 10);
        gbc.gridy = 1;
        this.add(backButton, gbc);

        // set back button event
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("Clicked Backend.company button!");
                DisplayManager.getInstance().setCurrentPanel(PanelType.MainPanel);
            }
        });

    }
}
