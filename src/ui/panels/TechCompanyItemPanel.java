package ui.panels;

import company.Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import company.*;
import leasecompany.*;


public class TechCompanyItemPanel extends Panel{


    private Button addEmployee_B,delEmployee_B,addLeaseCompany_B,delLeaseCompany_B;
    private Label employee_Label, leaseCompany_Label;
    private List employeeList,leaseCompanieList;
    private GridBagLayout layout;
    Company companyClass = new Company();
    final TextField fullName_Text,leaseCompany_Text;


    public TechCompanyItemPanel() {

        employee_Label = new Label("Employees ");
        leaseCompany_Label = new Label("Lease company's ");
        addEmployee_B = new Button("Add employee");
        delEmployee_B = new Button("Delete employee");
        addLeaseCompany_B = new Button("Add company");
        delLeaseCompany_B = new Button("Delete company");
        fullName_Text = new TextField(25);
        leaseCompany_Text = new TextField(25);

        employeeList = new List();
        leaseCompanieList = new List();

        layout = new GridBagLayout();
        this.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();

        employee_Label.setVisible(true);
        leaseCompany_Label.setVisible(true);
        addEmployee_B.setVisible(true);
        delEmployee_B.setVisible(true);
        employeeList.setVisible(true);
        leaseCompanieList.setVisible(true);
        fullName_Text.setVisible(true);

        gbc.fill = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(employee_Label,gbc);
        gbc.gridx = 4;
        gbc.gridy = 0;
        this.add(leaseCompany_Label,gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 150;
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(employeeList,gbc);
        gbc.gridx = 4;
        gbc.gridy = 1;
        this.add(leaseCompanieList,gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 10;
        gbc.gridx = 0;
        gbc.gridy = 2;
        this.add(fullName_Text,gbc);
        gbc.gridx = 4;
        gbc.gridy = 2;
        this.add(leaseCompany_Text,gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10,0,0,110);
        gbc.ipady = 10;
        gbc.gridx = 0;
        gbc.gridy = 3;
        this.add(delEmployee_B,gbc);

        gbc.insets = new Insets(10,110,0,0);
        gbc.gridx = 0;
        gbc.gridy = 3;
        this.add(addEmployee_B,gbc);

        gbc.insets = new Insets(10,0,0,105);
        gbc.ipady = 10;
        gbc.gridx = 4;
        gbc.gridy = 3;

        this.add(delLeaseCompany_B,gbc);
        gbc.insets = new Insets(10,105,0,0);
        gbc.gridx = 4;
        gbc.gridy = 3;
        this.add(addLeaseCompany_B,gbc);

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
                Employee employee = new Employee(fullName[0],fullName[1],1,companyClass);
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
                LeaseCompany ls = new LeaseCompany(company,5,5);
                addLeaseCompanyToList(company,ls);
            }
        });

        delLeaseCompany_B.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delLeaseCompanyFromList(leaseCompanieList.getSelectedIndex());
            }
        });
    }

    // add a employee when addEmployee_B is Pressed
    public void addEmployeeToList(String emp,Employee employee)
    {
        employeeList.add(emp);
        companyClass.addEmployee(employee);
    }
    // delete a employee when delEmployee_B is Pressed
    public void delEmployeeFromList(int index)
    {
        employeeList.remove(index);
    }
    // add a lease company when addLeaseCompany_B  is Pressed
    public void addLeaseCompanyToList(String name,LeaseCompany ls)
    {
        leaseCompanieList.add(name);
        companyClass.addLeaseCompanies(ls);
    }
    // delete a lease company when delLeaseCompany_B  is Pressed
    public void delLeaseCompanyFromList(int index)
    {
        leaseCompanieList.remove(index);
    }
}