package company;

import leasecompany.Contract;
import leasecompany.LeaseCompany;

public class Employee {

    String firstName;
    String lastName;
    boolean contract; //Initialises to false
    int leaseLevel;
    Company company;

    public Employee(String firstname, String lastname, int leaseLevel, Company company){
        this.firstName = firstname;
        this.lastName = lastname;
        this.leaseLevel = leaseLevel;
        this.company=company;
    }

    public String getFullName() {
        return firstName+" "+lastName;
    }

    public boolean getHasContract() {
        return this.contract;
    }

    public void setHasContract(boolean set) {
        this.contract=set;
    }

    public Contract getContract() {
        for(LeaseCompany lc : company.getLeaseCompanies()){
            if(lc.getContractOfEmployee(this) != null){
                Contract c = lc.getContractOfEmployee(this);
                return c;
            }
        }
        System.out.println("Couldn't find a contract for " + this.getFullName());
        return null;

    }

}