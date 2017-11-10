package leasecompany;

import company.*;
import leasecompany.vehicles.*;

import java.time.LocalDate;
import java.time.Period;

public class Contract {

    Employee employee;
    Vehicle vehicle;
    LocalDate startDate;
    LocalDate endDate;

    public Contract (LocalDate startDate, LocalDate endDate, Employee employee, Vehicle vehicle) {
        this.employee = employee;
        this.vehicle = vehicle;
        this.startDate=startDate;
        this.endDate=endDate;
        getEmployee().setHasContract(true);
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

    public void getTimeRemaining(LocalDate currentDate, LocalDate endDate) {
        Period d = Period.between(currentDate, endDate);
        int days  = d.getDays();
        int months = d.getMonths();
        int years = d.getYears();

        System.out.println("You have " + days + " days, " + months + " months and " + years + " years remaining.");

    }

    public void endContract() {
        getEmployee().setHasContract(false);
    }

    public void printContractDetails() {

        System.out.println("The contract is with " + getEmployee().getFullName() + ".");

        System.out.println(getVehicle().getDetails());

        System.out.println("The contract started on " + startDate.getDayOfMonth() + "-" + startDate.getMonthValue() + "-" + startDate.getYear() + ".");

        System.out.println("The contract will end on " + endDate.getDayOfMonth() + "-" + endDate.getMonthValue() + "-" + endDate.getYear() + ".");
    }


}
