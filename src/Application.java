import company.*;
import leasecompany.Contract;
import leasecompany.LeaseCompany;
import leasecompany.vehicles.Car;
import leasecompany.vehicles.FuelType;
import leasecompany.vehicles.Motorcycle;
import leasecompany.vehicles.Vehicle;
import java.time.LocalDate;


public class Application {

    public static void main(String[] args)
    {
        setDatabase();
    }


    public static void setDatabase() // After startup create database.
    {
        //Create companies.
        Company company = new Company();
        LeaseCompany ls = company.getLeaseCompanies()[0];

        //Create omployees.
        Employee jeffrey = new Employee("Jeffrey","Scheidelaar",1,company);
        Employee Bas = new Employee("Bas","Weeterings",1,company);
        Employee Koen = new Employee("Koen","Weeterings",1,company);
        company.addEmployee(jeffrey);
        company.addEmployee(Bas);
        company.addEmployee(Koen);

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

    }
}

