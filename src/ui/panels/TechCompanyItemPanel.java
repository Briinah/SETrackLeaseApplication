package ui.panels;

import company.modules.Employee;

import java.awt.*;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import company.*;
import ui.DisplayManager;


public class TechCompanyItemPanel extends ItemPanel{

    private Button addEmployee_B,delEmployee_B,addLeaseCompany_B,delLeaseCompany_B, backButton;
    private Label employee_Label, leaseCompany_Label;
    private List employeeList, leaseCompanyList;
    private LeaseCompany[] lcObjectList;
    private GridBagLayout layout;
    final TextField fullName_Text,leaseCompany_Text;

    public TechCompanyItemPanel(){
        super();

        employee_Label = new Label("Employees ");
        leaseCompany_Label = new Label("Lease company's ");
        addEmployee_B = new Button("Add employee");
        delEmployee_B = new Button("Delete employee");
        addLeaseCompany_B = new Button("Add company");
        delLeaseCompany_B = new Button("Delete company");
        backButton = new Button("Return");
        fullName_Text = new TextField(25);
        leaseCompany_Text = new TextField(25);

        employeeList = new List();
        leaseCompanyList = new List();

        layout = new GridBagLayout();
        this.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();

        employee_Label.setVisible(true);
        leaseCompany_Label.setVisible(true);
        addEmployee_B.setVisible(true);
        delEmployee_B.setVisible(true);
        employeeList.setVisible(true);
        leaseCompanyList.setVisible(true);
        fullName_Text.setVisible(true);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0; gbc.gridy = 0;
        this.add(title, gbc);
        gbc.fill = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(employee_Label,gbc);
        gbc.gridx = 4;
        gbc.gridy = 1;
        this.add(leaseCompany_Label,gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 150;
        gbc.gridx = 0;
        gbc.gridy = 2;
        this.add(employeeList,gbc);
        gbc.gridx = 4;
        gbc.gridy = 2;
        this.add(leaseCompanyList,gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 10;
        gbc.gridx = 0;
        gbc.gridy = 3;
        this.add(fullName_Text,gbc);
        gbc.gridx = 4;
        gbc.gridy = 3;
        this.add(leaseCompany_Text,gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10,0,0,110);
        gbc.ipady = 10;
        gbc.gridx = 0;
        gbc.gridy = 4;
        this.add(delEmployee_B,gbc);

        gbc.insets = new Insets(10,110,0,0);
        gbc.gridx = 0;
        gbc.gridy = 4;
        this.add(addEmployee_B,gbc);

        gbc.insets = new Insets(10,0,0,105);
        gbc.ipady = 10;
        gbc.gridx = 4;
        gbc.gridy = 4;

        this.add(delLeaseCompany_B,gbc);
        gbc.insets = new Insets(10,105,0,0);
        gbc.gridx = 4;
        gbc.gridy = 4;
        this.add(addLeaseCompany_B,gbc);

        gbc.insets = new Insets(10,10,10,10);
        gbc.fill= GridBagConstraints.REMAINDER;
        gbc.gridx = 0;
        gbc.gridy = 5;
        this.add(backButton, gbc);

        // button function
        Handlers();
    }

    // Buttons for adding and deleting Items
    private void Handlers(){

        addEmployee_B.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = fullName_Text.getText();
                if(!name.contains(" "))
                    return;
                String[] fullName = name.split(" ");
                Employee employee = new Employee(fullName[0],fullName[1],1);
                addEmployeeToList(employee.getFullName(),employee);
            }
        });

        delEmployee_B.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delEmployeeFromList(employeeList.getSelectedIndex());
            }
        });

        addLeaseCompany_B.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String company = leaseCompany_Text.getText();
                LeaseCompany ls = new LeaseCompany(5,5, company);
                addLeaseCompanyToList(company,ls);
            }
        });

        delLeaseCompany_B.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delLeaseCompanyFromList(leaseCompanyList.getSelectedIndex());
            }
        });

        // set back button event
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("Clicked company button!");
                DisplayManager.getInstance().setCurrentPanel(PanelType.TechCompanyListPanel);
            }
        });
    }

    public void setCompany(Company company){
        this.company = company;
        fillLeaseCompanyList();
    }

    // Fills the list item with lease company names that already exist
    private void fillLeaseCompanyList(){
        for(LeaseCompany lc : ((TechCompany)company).getLeaseCompanies()){
            leaseCompanyList.add(lc.getName());
        }
    }

    // add a employee when addEmployee_B is Pressed
    public void addEmployeeToList(String emp,Employee employee){
        employeeList.add(emp);
    }
    // delete a employee when delEmployee_B is Pressed
    public void delEmployeeFromList(int index){
        employeeList.remove(index);
    }
    // add a lease company when addLeaseCompany_B  is Pressed
    public void addLeaseCompanyToList(String name,LeaseCompany ls){
        leaseCompanyList.add(name);
        ((TechCompany)company).addLeaseCompany(ls);

    }
    // delete a lease company when delLeaseCompany_B  is Pressed
    public void delLeaseCompanyFromList(int index)
    {
        leaseCompanyList.remove(index);
        ((TechCompany)company).removeLeaseCompany(((TechCompany)company).getLeaseCompanies()[index]);
    }
}