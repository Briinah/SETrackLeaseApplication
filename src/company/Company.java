package company;

public class Company {

    Employee[] employees;

    public Company(){
        employees = new Employee[]{
                new Employee("Daniel", "Oliemans",true,1),
                new Employee("Jeffrey", "Scheidelaar",false,2),
                new Employee("Bas", "Weeterings",true,3),
                new Employee("Carolien", "Gilbers",false,4),
                new Employee("Koen", "Griffioen",true,1),
                new Employee("Jeran", "Kapel",false,2),
                new Employee("Maarten", "Stienstra",true,3),
                new Employee("Anton", "Quelle",false,4)
        };
    }
}