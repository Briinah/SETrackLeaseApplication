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
        //Create companies.
        TechCompany techCompany = new TechCompany();
        LeaseCompany ls = techCompany.getLeaseCompanies()[0];

        //Create omployees.
        Employee jeffrey = new Employee("Jeffrey","Scheidelaar",1, techCompany);
        Employee Bas = new Employee("Bas","Weeterings",1, techCompany);
        Employee Koen = new Employee("Koen","Weeterings",1, techCompany);
        techCompany.addEmployee(jeffrey);
        techCompany.addEmployee(Bas);
        techCompany.addEmployee(Koen);

        // Create vehicles.
        Vehicle BMWBas = new Car("BMW","I3","GHFD45",LocalDate.of(2015,2,10),22, FuelType.Gasoline);
        Vehicle AudiJeff = new Car("Audi","A1","HH88FF",LocalDate.of(2016,8,14),22, FuelType.Diesel);
        Vehicle RandomVehicle = new Car("BMW","A1","HH88FF",LocalDate.of(2016,8,14),22, FuelType.Diesel);
        Motorcycle motorcycle = new Motorcycle("BMW","A1","HH88FF",LocalDate.of(2016,8,14),22, FuelType.Gasoline);
        motorcycle.setHasSideCar(true);
        ls.addVehicle(BMWBas);
        ls.addVehicle(AudiJeff);
        ls.addVehicle(RandomVehicle);
        ls.addVehicle(motorcycle);
        //create contracts.
        Contract conJeff = new Contract(LocalDate.now(),LocalDate.of(2021,2,7),jeffrey,AudiJeff);
        Contract conBas = new Contract(LocalDate.now(),LocalDate.of(2021,2,11),Bas,BMWBas);
        //Add contract to leasecompany.
        ls.addContract(conJeff);
        ls.addContract(conBas);

        Koen.printAvailableVehicles();

        techCompany.checkIfEmpHasContract(Bas);

    }
}

