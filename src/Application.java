import company.*;
import company.modules.Contract;
import company.LeaseCompany;
import company.modules.Employee;
import vehicles.*;

import java.time.LocalDate;

public class Application {

    public static void main(String[] args)
    {
        setDatabase();
    }


    public static void setDatabase() // After startup create database.
    {
        //Create techcompany.
        TechCompany techCompany = new TechCompany("test");
        TechCompany techCompany_2 = new TechCompany("newTechComp");

        //Create leaseCompany.
        LeaseCompany leaseCompany1 = new LeaseCompany(100,100, "HappyLease");
        LeaseCompany leaseCompany2 = new LeaseCompany(100,100, "LeaseAllyouCan");
        LeaseCompany leaseCompany3 = new LeaseCompany(100,100, "Alphabet");

        //Add leascompany to techcompany.
        techCompany.addLeaseCompany(leaseCompany1);
        techCompany.addLeaseCompany(leaseCompany2);
        techCompany_2.addLeaseCompany(leaseCompany2);
        techCompany_2.addLeaseCompany(leaseCompany3);

        //Create employees.
        Employee jeffrey = new Employee("Jeffrey","Scheidelaar",1);
        Employee bas = new Employee("Bas","Weeterings",1);
        Employee koen = new Employee("Koen","Weeterings",1);
        Employee rick = new Employee("Rick", "Artz", 1);
        Employee klaas = new Employee("Klaas", "Versnel", 1000);
        Employee joran = new Employee("Joran", "Capel", 0);
        Employee daniel = new Employee("Daniël", "Oliemans", 4);
        Employee anton = new Employee("Anton", "Quelle", 9);
        Employee carolien = new Employee("Carolien", "Gilbers", 9);
        Employee maarten = new Employee("Maarten", "Stienstra", 7);
        Employee randomGuy = new Employee("Random", "Dude", 9999);
        // Add employees to certain techcompany
        techCompany.addEmployee(jeffrey);
        techCompany.addEmployee(bas);
        techCompany.addEmployee(koen);
        techCompany.addEmployee(maarten);
        techCompany.addEmployee(klaas);
        techCompany.addEmployee(rick);
        techCompany.addEmployee(joran);
        techCompany.addEmployee(anton);
        techCompany.addEmployee(carolien);

        // Add one employee to the second company
        techCompany_2.addEmployee(daniel);

        // Add one employee to the first leaseCompany
        leaseCompany1.addEmployee(randomGuy);

        // Create vehicles.
        Vehicle bmwBas = new Car("BMW","I3","GHFD45",LocalDate.of(2015,2,10),22, FuelType.Gasoline);
        Vehicle audiJeff = new Car("Audi","A1","HH88FF",LocalDate.of(2016,8,14),22, FuelType.Diesel);
        Vehicle tesla = new Car("Tesla","Model S","GHFD45",LocalDate.of(2015,2,10),22, FuelType.Gasoline);
        Vehicle klaasMobiel = new Car("Ford","K","KL-AA-S",LocalDate.of(2016,8,14),22, FuelType.Electric);
        Vehicle rickFiets = new Motorcycle("BMW","Motor","RI-CK-IS-BA-AS",LocalDate.of(2015,2,10),22, FuelType.Gasoline);
        ((Motorcycle)rickFiets).setHasSideCar(false);
        ((Motorcycle)rickFiets).setHasSaddleBags(false);
        Vehicle opel = new Car("Opel","Zafira","HH88FF",LocalDate.of(2016,8,14),22, FuelType.Diesel);
        Vehicle nissan = new Car("Nissan","I3","GHFD45",LocalDate.of(2015,2,10),22, FuelType.Gasoline);
        Vehicle toyota = new Car("Toyota","Aygo","HH88FF",LocalDate.of(2016,8,14),22, FuelType.Diesel);

        // Truck
        Truck truck = new Truck ("Mercedes", "B3", "GHJXD4",LocalDate.of(2016, 8, 5), 87, FuelType.Electric);
        truck.setHasSleepingSpace(false);
        truck.setCargoType(CargoType.transporter);
        truck.setAmountOfTrailers(2);

        Vehicle RandomVehicle = new Car("BMW","A1","HH88FF",LocalDate.of(2016,8,14),22, FuelType.Diesel);
        Motorcycle motorcycle = new Motorcycle("Moto","Moto","HH88FF",LocalDate.of(2016,8,14),22, FuelType.Gasoline);
        motorcycle.setHasSideCar(true);

        // Add vehicles to leasecompanies
        leaseCompany1.addVehicle(bmwBas);
        leaseCompany1.addVehicle(audiJeff);
        leaseCompany1.addVehicle(RandomVehicle);
        leaseCompany1.addVehicle(motorcycle);

        leaseCompany2.addVehicle(tesla);
        leaseCompany2.addVehicle(klaasMobiel);
        leaseCompany2.addVehicle(truck);
        leaseCompany2.addVehicle(rickFiets);

        leaseCompany3.addVehicle(opel);
        leaseCompany3.addVehicle(nissan);
        leaseCompany3.addVehicle(toyota);

        //create contracts.
        Contract conJeff = new Contract(LocalDate.now(),LocalDate.of(2021,2,7),jeffrey,audiJeff);
        Contract conBas = new Contract(LocalDate.now(),LocalDate.of(2021,2,11),bas,bmwBas);

        //Add contract to leasecompany.
        leaseCompany1.addContract(conJeff);
        leaseCompany1.addContract(conBas);

        // Check if jeffrey has contract and print his vehicle if exists.
        if(techCompany.checkIfEmpHasContract(jeffrey)){
            System.out.println(techCompany.getVehicleDetails(jeffrey));
            techCompany.getContract(jeffrey).printDetails();
        }

        // Print available vehicles
        leaseCompany1.printAvailableVehicleDetails();
        // Contract details
        leaseCompany1.printContractDetails();
        // employees with contract
        leaseCompany1.printEmployeesWithContract();
        // Vehicle details
        leaseCompany1.printVehicleDetails();

        // Print tech company available vehicles.
        techCompany.printAvailableVehicles();
        // Print tech company available vehicles.
        techCompany_2.printAvailableVehicles();
    }
}

