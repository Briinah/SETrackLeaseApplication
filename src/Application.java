
import company.*;
import leasecompany.Contract;
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
        LeaseCompany ls = new LeaseCompany(10,10);

        Employee jeffrey = new Employee("Jeffrey","Scheidelaar",1,company);
        Employee Bas = new Employee("Bas","Weeterings",1,company);
        company.addEmployee(jeffrey);
        company.addEmployee(Bas);

        Employee daniel = company.getEmployeeList()[0];
        
        Vehicle BMWBas = new Car("BMW","I3","GHFD45",LocalDate.of(2015,2,10),22, FuelType.Gasoline);
        Vehicle AudiJeff = new Car("Audi","A1","HH88FF",LocalDate.of(2016,8,14),22, FuelType.Diesel);
        Vehicle AudiDan = new Car("Audi","A3","FF99HH",LocalDate.of(2016,4,28),22, FuelType.Diesel);
        ls.addVehicle(BMW);
        ls.addVehicle(Audi);

        Contract conJeff = new Contract(LocalDate.now(),LocalDate.of(2021,20,7),jeffrey,AudiJeff);
        Contract conBas = new Contract(LocalDate.now(),LocalDate.of(2021,20,11),Bas,BMWBas);
        Contract conDan = new Contract(LocalDate.now(),LocalDate.of(2021,26,12),Bas,AudiDan);

        ls.addContract(conJeff);
        ls.addContract(conBas);
        ls.addContract(conDan);

    }
}

