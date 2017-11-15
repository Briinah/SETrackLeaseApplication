package company.modules;

import company.LeaseCompany;
import company.TechCompany;
import vehicles.Vehicle;


//an employee of the companies
public class Employee {


    //employee variables and get and set methods
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