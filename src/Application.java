
import company.*;
import leasecompany.LeaseCompany;
import leasecompany.vehicles.Car;
import leasecompany.vehicles.FuelType;
import leasecompany.vehicles.Vehicle;

import java.time.LocalDate;


public class Application {

    public static void main(String[] args)
    {
        setDatabase();
    }


    public static void setDatabase()
    {
        Company company = new Company();
        LeaseCompany ls = new LeaseCompany(5,5);

        Employee jeffrey = new Employee("Jeffrey","Scheidelaar",1,company);
        Employee Bas = new Employee("Bas","Weeterings",1,company);
        company.addEmployee(jeffrey);
        company.addEmployee(Bas);

        Vehicle BMW = new Car("BMW","I3","GHFD45",LocalDate.of(2015,2,10),22, FuelType.Gasoline);
        Vehicle Audi = new Car("Audi","A1","HH88FF",LocalDate.of(2016,8,14),22, FuelType.Diesel);
        ls.addVehicle(BMW);
        ls.addVehicle(Audi);





    }
}

