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


public class CompanyItemPanel extends Panel{


    private Button addEmployee,delEmployee,addLeaseCompany,delLeaseCompany;
    private Label employeeLabel, leaseCompanyLabel;
    private List employeeList,leaseCompanieList;
    private GridBagLayout layout;
    Company companyClass = new Company();
    LeaseCompany ls = new LeaseCompany(5,5);
    final TextField fullNameText,leaseCompanyText;





    public CompanyItemPanel() {

        employeeLabel = new Label("Employees ");
        leaseCompanyLabel = new Label("Lease company's ");
        addEmployee = new Button("Add employee");
        delEmployee = new Button("Delete employee");
        addLeaseCompany = new Button("Add company");
        delLeaseCompany = new Button("Delete company");
        fullNameText = new TextField(25);
        leaseCompanyText = new TextField(25);

        employeeList = new List();
        leaseCompanieList = new List();

        layout = new GridBagLayout();
        this.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();

        employeeLabel.setVisible(true);
        leaseCompanyLabel.setVisible(true);
        addEmployee.setVisible(true);
        delEmployee.setVisible(true);
        employeeList.setVisible(true);
        leaseCompanieList.setVisible(true);
        fullNameText.setVisible(true);

        gbc.fill = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(employeeLabel,gbc);
        gbc.gridx = 4;
        gbc.gridy = 0;
        this.add(leaseCompanyLabel,gbc);

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
        this.add(fullNameText,gbc);
        gbc.gridx = 4;
        gbc.gridy = 2;
        this.add(leaseCompanyText,gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10,0,0,110);
        gbc.ipady = 10;
        gbc.gridx = 0;
        gbc.gridy = 3;
        this.add(delEmployee,gbc);

        gbc.insets = new Insets(10,110,0,0);
        gbc.gridx = 0;
        gbc.gridy = 3;
        this.add(addEmployee,gbc);

        gbc.insets = new Insets(10,0,0,105);
        gbc.ipady = 10;
        gbc.gridx = 4;
        gbc.gridy = 3;

        this.add(delLeaseCompany,gbc);
        gbc.insets = new Insets(10,105,0,0);
        gbc.gridx = 4;
        gbc.gridy = 3;
        this.add(addLeaseCompany,gbc);

        Handlers();
    }

    // Buttons for adding and deleting Items
    private void Handlers(){

        addEmployee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = fullNameText.getText();
                if(!name.contains(" "))
                    return;
                String[] fullName = name.split(" ");
                Employee employee = new Employee(fullName[0],fullName[1],1,companyClass);
                addEmployeeToList(employee.getFullName(),employee);
            }
        });

        delEmployee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delEmployeeFromList(employeeList.getSelectedIndex());
            }
        });

        addLeaseCompany.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String company = leaseCompanyText.getText();
                /// Missing Add lease company
                addLeaseCompanyToList(company);
            }
        });

        delLeaseCompany.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delLeaseCompanyFromList(leaseCompanieList.getSelectedIndex());
            }
        });
    }

    // add and delete called from buttons
    public void addEmployeeToList(String emp,Employee employee)
    {
        employeeList.add(emp);
        companyClass.addEmployee(employee);
    }

    public void delEmployeeFromList(int index)
    {
        employeeList.remove(index);
    }

    public void addLeaseCompanyToList(String ls)
    {
        leaseCompanieList.add(ls);
    }

    public void delLeaseCompanyFromList(int index)
    {
        leaseCompanieList.remove(index);
    }
}