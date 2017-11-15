import company.*;
import company.modules.Contract;
import company.LeaseCompany;
import company.modules.Employee;
import vehicles.Car;
import vehicles.FuelType;
import vehicles.Motorcycle;
import vehicles.Vehicle;
import java.time.LocalDate;

public class Application {

    public static void main(String[] args)
    {
        setDatabase();
    }


    public static void setDatabase() // After startup create database.
    {
        //Create leasecompanies.
        TechCompany techCompany = new TechCompany();


        //Create techcompanies.
        LeaseCompany leaseCompany = new LeaseCompany(100,100, "HappyLease");

        //Add leascompany to techcompany.
        techCompany.addLeaseCompany(leaseCompany);

        //Create employees.
        Employee jeffrey = new Employee("Jeffrey","Scheidelaar",1);
        Employee Bas = new Employee("Bas","Weeterings",1);
        Employee Koen = new Employee("Koen","Weeterings",1);
        techCompany.addEmployee(jeffrey);
        techCompany.addEmployee(Bas);
        techCompany.addEmployee(Koen);

        // Create vehicles.
        Vehicle BMWBas = new Car("BMW","I3","GHFD45",LocalDate.of(2015,2,10),22, FuelType.Gasoline);
        Vehicle AudiJeff = new Car("Audi","A1","HH88FF",LocalDate.of(2016,8,14),22, FuelType.Diesel);
        Vehicle RandomVehicle = new Car("BMW","A1","HH88FF",LocalDate.of(2016,8,14),22, FuelType.Diesel);
        Motorcycle motorcycle = new Motorcycle("BMW","A1","HH88FF",LocalDate.of(2016,8,14),22, FuelType.Gasoline);
        motorcycle.setHasSideCar(true);
        leaseCompany.addVehicle(BMWBas);
        leaseCompany.addVehicle(AudiJeff);
        leaseCompany.addVehicle(RandomVehicle);
        leaseCompany.addVehicle(motorcycle);
        //create contracts.
        Contract conJeff = new Contract(LocalDate.now(),LocalDate.of(2021,2,7),jeffrey,AudiJeff);
        Contract conBas = new Contract(LocalDate.now(),LocalDate.of(2021,2,11),Bas,BMWBas);
        //Add contract to leasecompany.
        leaseCompany.addContract(conJeff);
        leaseCompany.addContract(conBas);

        techCompany.printAvailableVehicles();
    }
}

