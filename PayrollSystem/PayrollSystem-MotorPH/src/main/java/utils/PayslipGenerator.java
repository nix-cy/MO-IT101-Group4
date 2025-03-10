package utils;

import model.Employee;

public class PayslipGenerator {
    public static void generatePayslip(Employee emp, double hoursWorked, double grossSalary,
                                       double sss, double philHealth, double pagIbig,
                                       double withholdingTax, double netSalary) {
        System.out.println("\n=================================");
        System.out.println("            PAYSLIP              ");
        System.out.println("=================================");

        System.out.printf("Employee: %-30s%n", emp.getFullName());
        System.out.printf("Employee ID: %-30s%n", emp.getEmployeeId());
        System.out.printf("Position: %-30s%n", emp.getPosition());
        System.out.printf("Address: %-30s%n", emp.getAddress());
        System.out.printf("Tax ID: %-30s%n", emp.getTin());
        System.out.printf("SSS ID: %-30s%n", emp.getSss());

        System.out.println("---------------------------------");
        System.out.printf("Basic Salary: PHP %,10.2f%n", grossSalary);
        System.out.printf("Hourly Rate: PHP %,10.2f%n", emp.getHourlyRate());
        System.out.printf("Hours Worked: %10.2f%n", hoursWorked);
        System.out.printf("Gross Salary: PHP %,10.2f%n", grossSalary);

        System.out.println("------------- Deductions -------------");
        System.out.printf("- Pag-IBIG: PHP %,10.2f%n", Math.max(0, pagIbig));
        System.out.printf("- PhilHealth: PHP %,10.2f%n", Math.max(0, philHealth));
        System.out.printf("- SSS: PHP %,10.2f%n", Math.max(0, sss));
        System.out.printf("- Tax: PHP %,10.2f%n", Math.max(0, withholdingTax));

        System.out.println("---------------------------------");
        System.out.printf("Net Salary: PHP %,10.2f%n", netSalary);
        System.out.println("=================================\n");
    }
}