package service;

import model.Employee;
import utils.SSSCalculator;
import utils.PhilHealthCalculator;
import utils.TaxCalculator;

public class PayrollCalculator {

    // Compute gross salary based on hourly rate and hours worked
    public double computeGrossSalary(Employee employee, double hoursWorked) {
        return employee.getHourlyRate() * hoursWorked;
    }

    // Compute net salary after deductions
    public double computeNetSalary(Employee employee, double hoursWorked) {
        double grossSalary = computeGrossSalary(employee, hoursWorked);

        // Compute government deductions
        double sss = SSSCalculator.getSSSContribution(grossSalary);
        double philHealth = PhilHealthCalculator.getPhilHealthContribution(grossSalary);
        double pagIbig = Math.min(grossSalary * 0.02, 100); // Pag-IBIG maxes at PHP 100

        // Compute taxable income AFTER deductions
        double taxableIncome = grossSalary - (sss + philHealth + pagIbig);
        double tax = TaxCalculator.computeWithholdingTax(taxableIncome);

        return grossSalary - (sss + philHealth + pagIbig + tax);
    }

    // Display payroll summary for an employee
    public void displayPayroll(Employee employee, double hoursWorked) {
        double grossSalary = computeGrossSalary(employee, hoursWorked);
        double sss = SSSCalculator.getSSSContribution(grossSalary);
        double philHealth = PhilHealthCalculator.getPhilHealthContribution(grossSalary);
        double pagIbig = Math.min(grossSalary * 0.02, 100);
        double taxableIncome = grossSalary - (sss + philHealth + pagIbig);
        double tax = TaxCalculator.computeWithholdingTax(taxableIncome);
        double netSalary = grossSalary - (sss + philHealth + pagIbig + tax);

        System.out.println("\n💰 Payroll Summary for " + employee.getFullName());
        System.out.println("-------------------------------------");
        System.out.println("Gross Salary: PHP " + grossSalary);
        System.out.println("SSS Deduction: PHP " + sss);
        System.out.println("PhilHealth Deduction: PHP " + philHealth);
        System.out.println("Pag-IBIG Deduction: PHP " + pagIbig);
        System.out.println("Tax Deduction: PHP " + tax);
        System.out.println("Net Salary: PHP " + netSalary);
    }
}