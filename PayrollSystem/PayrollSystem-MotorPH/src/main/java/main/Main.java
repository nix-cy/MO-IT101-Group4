package main;

import service.PayrollSystem;
import model.Employee;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.List;
import com.opencsv.exceptions.CsvException;

public class Main {
    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();

        try {
            File csvFile = new File("C:/PayrollSystem/PayrollSystem-MotorPH/data/MotorPh Employee Data.csv");
            payrollSystem.loadEmployeeData(csvFile.getPath());
            payrollSystem.displayEmployees();

            List<Employee> employeeList = payrollSystem.getEmployees();
            if (employeeList.isEmpty()) {
                System.out.println("⚠ No employees found. Exiting payroll processing.");
                return;
            }

            try (Scanner scanner = new Scanner(System.in)) {
                for (Employee emp : employeeList) {
                    if (emp == null) continue;

                    System.out.print("Enter hours worked for " + emp.getFullName() + ": ");

                    while (!scanner.hasNextDouble()) {
                        System.out.println("⚠ Invalid input. Please enter a valid number.");
                        scanner.next();
                    }

                    double hoursWorked = scanner.nextDouble();
                    payrollSystem.processPayroll(emp, hoursWorked);
                }
            }
        } catch (IOException | CsvException e) {
            System.err.println("❌ Error loading employee data: " + e.getMessage());
        }
    }
}