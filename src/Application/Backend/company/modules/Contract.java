package Application.Backend.company.modules;

import Application.Backend.vehicles.*;

import java.time.LocalDate;
import java.time.Period;

//The contract class that represents the lease contracts held by a lease ApplicationBE.Backend.company.
public class Contract {

    //contract variables and get and set methods
    private Employee employee;
    private Vehicle vehicle;
    private LocalDate startDate;
    private LocalDate endDate;

    public Contract (LocalDate startDate, LocalDate endDate, Employee employee, Vehicle vehicle) {
        this.employee = employee;
        this.vehicle = vehicle;
        this.startDate=startDate;
        this.endDate=endDate;
    }


    public Employee getEmployee() {
        return this.employee;
    }
    public Vehicle getVehicle() {
        return this.vehicle;
    }
    public LocalDate getEndDate() {
        return this.endDate;
    }
    public LocalDate getStartDate() {
        return this.startDate;
    }


    //Calculates the difference between the current and end date of the contract,
    //puts it in a Period class and prints the results.
    public void printTimeRemaining(LocalDate currentDate, LocalDate endDate) {
        Period d = Period.between(currentDate, endDate);
        int days  = d.getDays();
        int months = d.getMonths();
        int years = d.getYears();

        System.out.println("You have " + days + " days, " + months + " months and " + years + " years remaining.");

    }

    //Prints relevant information from all the instance variables of the contract.
    public void printDetails() {
        System.out.println("The contract is with " + getEmployee().getFullName() + ".");

        System.out.println(getVehicle().getDetails());

        System.out.println("The contract started on " + startDate.getDayOfMonth() + "-" + startDate.getMonthValue() + "-" + startDate.getYear() + ".");

        System.out.println("The contract will end on " + endDate.getDayOfMonth() + "-" + endDate.getMonthValue() + "-" + endDate.getYear() + ".");
    }



}
