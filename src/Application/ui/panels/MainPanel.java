package Application.ui.panels;

import Application.ui.DisplayManager;
import Application.ui.elements.MenuButton;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Implements the main menu panel
 * @author Carolien
 */
public class MainPanel extends Panel {

    private MenuButton companyButton;
    private MenuButton employeeButton;
    private MenuButton leaseCompanyButton;
    private Label title;
    Font myFont = new Font("myfont", Font.BOLD, 20);

    /**
     * Main panel with buttons to ApplicationBE.Backend.company, employee and lease ApplicationBE.Backend.company
     */
    public MainPanel(){

        // set layout
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // margins between buttons
        gbc.gridx = 0;

        // initialize label with title and add to panel
        title = new Label("Welkom bij de Lease Applicatie");
        title.setFont(myFont);
        gbc.gridy = 0;
        this.add(title);

        // initialize buttons and add to panel
        companyButton = new MenuButton("Companies");
        gbc.insets = new Insets(60, 10, 10, 10);
        gbc.gridy = 1;
        this.add(companyButton, gbc);

     //   employeeButton = new MenuButton("Employees");
     //   gbc.insets = new Insets(10, 10, 10, 10);
     //   gbc.gridy = 2;
     //   this.add(employeeButton, gbc);

        leaseCompanyButton = new MenuButton("Lease Companies");
        gbc.gridy = 34;
        this.add(leaseCompanyButton, gbc);


        // set ApplicationBE.Backend.company button event
        companyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("Clicked ApplicationBE.Backend.company button!");
                DisplayManager.getInstance().setCurrentPanel(PanelType.TechCompanyListPanel);
            }
        });

   /*     // set employee button event
        employeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("Clicked employee button!");
            }
        });
        */

        // set lease ApplicationBE.Backend.company button event
        leaseCompanyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("Clicked lease ApplicationBE.Backend.company button!");
                DisplayManager.getInstance().setCurrentPanel(PanelType.LeaseCompanyListPanel);
            }
        });
    }
}
