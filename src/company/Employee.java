package company;

public class Employee {

    public String firstName;
    public String lastName;
    public boolean contract;
    public int leaseLevel;

    public Employee(String firstname, String lastname,boolean hasContract, int leaseLevel){
        this.firstName = firstname;
        this.lastName = lastname;
        this.contract = hasContract;
        this.leaseLevel = leaseLevel;
    }
}
