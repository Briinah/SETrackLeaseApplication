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


    public static void setDatabase() // After startup create database.
    {
        //Create companies.
        Company company = new Company();
        LeaseCompany ls = company.getLeaseCompanies()[0];
        //Create omployees.
        Employee jeffrey = new Employee("Jeffrey","Scheidelaar",1,company);
        Employee bas = new Employee("Bas","Weeterings",1,company);
        company.addEmployee(jeffrey);
        company.addEmployee(bas);

        Employee daniel = new Employee("Daniel", "Hallo", 1, company);
        company.addEmployee(daniel);

        // Create vehicles.
        Vehicle bmwbas = new Car("BMW","I3","GHFD45",LocalDate.of(2015,2,10),22, FuelType.Gasoline);
        Vehicle audiJeff = new Car("Audi","A1","HH88FF",LocalDate.of(2016,8,14),22, FuelType.Diesel);
        Vehicle audiDan = new Car("Audi","A3","FF99HH",LocalDate.of(2016,4,28),22, FuelType.Diesel);
        ls.addVehicle(bmwbas);
        ls.addVehicle(audiJeff);
        ls.addVehicle(audiDan);
        //create contracts.
        Contract conJeff = new Contract(LocalDate.now(),LocalDate.of(2021,12,7),jeffrey,audiJeff);
        Contract conBas = new Contract(LocalDate.now(),LocalDate.of(2021,12,11),bas,bmwbas);
//        Contract conDan = new Contract(LocalDate.now(),LocalDate.of(2021,12,12),daniel,AudiDan);
        //Add contract to leasecompany.
        ls.addContract(conJeff);
        ls.addContract(conBas);
//        ls.addContract(conDan);

        daniel.printAvailableVehicles();
    }
}

