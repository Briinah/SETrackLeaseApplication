package company;

public class Employee {

    public String firstName;
    public String lastName;
    public boolean contract; //Initialises to false
    public int leaseLevel;

    public Employee(String firstname, String lastname, int leaseLevel){
        this.firstName = firstname;
        this.lastName = lastname;
        this.leaseLevel = leaseLevel;
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
}