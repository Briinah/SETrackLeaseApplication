package ui.panels;

import ui.Display;
import ui.DisplayManager;

import java.awt.*;
import java.awt.event.*;

/**
 * Shows a list of companies, functions to add companies and edit a company
 * @author Daniel
 */
public class TechCompanyListPanel extends Panel {

    private Button addButton;
    private Button editButton;
    private Button backButton;
    private GridBagLayout gridBagLayout;
    private List list;
    private GridBagConstraints gbc;
    private TextField textField;
    private Label label;
    private StringBuilder sb;
    private String selectedCompany;

    /**
     * Initialises the layout, buttons and the list to manage companies
     */
    public TechCompanyListPanel(){

        // Layout settings
        gridBagLayout = new GridBagLayout();
        setLayout(gridBagLayout);
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        setBackground(Color.lightGray);

        // Label / name of app
        label = new Label("Voeg uw bedrijf toe");
        label.setFont(new Font("font", Font.BOLD, 20));
        label.setVisible(true);
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(label, gbc);

        // Company textfield
        textField = new TextField();
        textField.setColumns(10);
        textField.setVisible(true);
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(textField, gbc);

        // Start StringBuilder on the TextField
        sb = new StringBuilder();

        // Add button
        addButton = new Button("Add company");
        addButton.setVisible(true);
        gbc.gridx = 0;
        gbc.gridy = 2;
        this.add(addButton, gbc);

        // List
        list = new List(8, false );
        list.setVisible(true);
        gbc.gridx = 0;
        gbc.gridy = 3;
        this.add(list, gbc);

        // Edit button
        editButton = new Button("Edit company");
        editButton.setVisible(true);
        gbc.gridx = 0;
        gbc.gridy = 4;
        this.add(editButton, gbc);

        // Edit button
        backButton = new Button("Return");
        backButton.setVisible(true);
        gbc.gridx = 0;
        gbc.gridy = 5;
        this.add(backButton, gbc);

        // Add a Key Listener to the TextField that keeps track of the characters entered
        textField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(e.getKeyChar() == KeyEvent.VK_ENTER){
                    // If enter is pressed and StringBuilder is empty, return
                    if(sb.length() == 0)
                        return;
                    //Otherwise, process input
                    System.out.println("Added: "+sb.toString());
                    list.add(sb.toString());
                    sb.setLength(0);
                    textField.setText("");
                    return;
                }
                //If other characters are typed, append them to the StringBuilder
                sb.append(e.getKeyChar());
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // Method not used, but necessary
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // Method not used, but necessary
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // If the StringBuilder is empty, return
                if(sb.length() == 0){
                    return;
                }

                // Otherwise, add the company to the list
                System.out.println("Added: "+sb.toString());
                list.add(sb.toString());
                sb.setLength(0);
                textField.setText("");
            }
        });

        list.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                // Store the selected company in a String
                selectedCompany = list.getSelectedItem();
                System.out.println("Selected: "+selectedCompany);
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(selectedCompany == null || selectedCompany.isEmpty()){
                    return;
                }

                System.out.println("Edit: "+selectedCompany);
                DisplayManager.getInstance().setCurrentPanel(PanelType.TechCompanyItemPanel, selectedCompany);
            }
        });

        // set back button event
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("Clicked company button!");
                DisplayManager.getInstance().setCurrentPanel(PanelType.MainPanel);
            }
        });

    }
}
