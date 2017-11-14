package ui.panels;

import java.awt.*;
import java.awt.event.*;

public class TechCompanyListPanel extends Panel {

    Button addButton;
    Button editButton;
    GridBagLayout gridBagLayout;
    List list;
    GridBagConstraints gbc;
    TextField textField;
    Label label;
    StringBuilder sb;
    String selectedCompany;

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

            }

            @Override
            public void keyReleased(KeyEvent e) {

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
                // Ga naar Jeffrey's scherm en geef 'selectedCompany' mee!

            }
        });

    }
}
