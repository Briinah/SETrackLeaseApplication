package ui.panels;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends Panel {

    Button companyButton;
    Button employeeButton;
    Button leaseCompanyButton;

    /**
     * Main panel with buttons to company, employee and lease company
     */
    public MainPanel(){

        // set layout
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10); // margins between buttons

        // initialize buttons
        companyButton = new Button("Companies");
        employeeButton = new Button("Employees");
        leaseCompanyButton = new Button("Lease Companies");

        // add buttons to panel
        this.add(companyButton, gbc);
        this.add(employeeButton, gbc);
        this.add(leaseCompanyButton, gbc);

        // set company button event
        companyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Clicked company button!");
            }
        });

        // set employee button event
        employeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Clicked employee button!");
            }
        });

        // set lease company button event
        leaseCompanyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Clicked lease company button!");
            }
        });
    }
}
