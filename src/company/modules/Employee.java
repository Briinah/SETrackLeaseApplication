package company.modules;

import company.LeaseCompany;
import company.TechCompany;
import vehicles.Vehicle;

public class Employee{

    String firstName;
    String lastName;
    int leaseLevel;

    public Employee(String firstname, String lastname, int leaseLevel){
        this.firstName = firstname;
        this.lastName = lastname;
        this.leaseLevel = leaseLevel;
    }

    public String getFullName(){
        return firstName+" "+lastName;
    }


}