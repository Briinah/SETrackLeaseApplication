package company;

public class Company {

    Employee[] employees;
    public int currentNumberOfEmployee;
    public int maxNumberOfEmployee;

    public Company(int numberOfEmployee){
        employees = new Employee[numberOfEmployee];
        maxNumberOfEmployee = numberOfEmployee;
    }

    public void addEmployee(Employee employee)
    {
        if(currentNumberOfEmployee < maxNumberOfEmployee){
            employees[currentNumberOfEmployee] = employee;
            currentNumberOfEmployee++;
        }else{
            System.out.println("Meer werknemers niet mogelijk. Check het wetboek at artikel 315, lid y.");
        }
    }

    public void removeEmployee(Employee employee) {
        for (int i = 0; i < currentNumberOfEmployee; i++){
            if (employees[i] == employee){
                employees[i] = employees[currentNumberOfEmployee - 1];
                employees[currentNumberOfEmployee - 1] = null;
                // update current number of contracts
                currentNumberOfEmployee--;
                // Exit function; we're done
                return;
            }
        }
        System.out.println("Employee not found");
    }

    public void printEmployees(){
        for(Employee employee : employees)
        {
            System.out.println(employee.firstName + " " + employee.lastName);
        }
    }
}



//        new Employee("Daniel", "Oliemans",true,1),
//        new Employee("Jeffrey", "Scheidelaar",false,2),
//        new Employee("Bas", "Weeterings",true,3),
//        new Employee("Carolien", "Gilbers",false,4),
//        new Employee("Koen", "Griffioen",true,1),
//        new Employee("Jeran", "Kapel",false,2),
//        new Employee("Maarten", "Stienstra",true,3),
//        new Employee("Anton", "Quelle",false,4)
