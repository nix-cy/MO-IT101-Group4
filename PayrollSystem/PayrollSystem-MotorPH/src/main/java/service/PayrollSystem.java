package service;

import model.Employee;
import utils.PayslipGenerator;
import utils.SSSCalculator;
import utils.PhilHealthCalculator;
import utils.TaxCalculator;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PayrollSystem {
    private List<Employee> employees = new ArrayList<>();
    private PayrollCalculator payrollCalculator = new PayrollCalculator();

    public void loadEmployeeData(String filePath) throws IOException, CsvException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new IOException("❌ CSV file not found: " + filePath);
        }

        try (CSVReader csvReader = new CSVReader(new FileReader(file))) {
            List<String[]> records = csvReader.readAll();
            boolean firstRow = true; // To skip the header row

            for (String[] record : records) {
                if (firstRow) {
                    firstRow = false; // Skip the first row (header)
                    continue;
                }

                if (record.length < 19) {
                    System.out.println("⚠️ Skipping invalid row (not enough columns): " + String.join(", ", record));
                    continue;
                }

                try {
                    int employeeId = Integer.parseInt(record[0].trim());
                    String lastName = record[1].trim();
                    String firstName = record[2].trim();
                    String birthday = record[3].trim();
                    String address = record[4].trim();
                    String phoneNumber = record[5].trim();
                    String sss = record[6].trim();
                    String philhealth = record[7].trim();
                    String tin = record[8].trim();
                    String pagibig = record[9].trim();
                    String status = record[10].trim();
                    String position = record[11].trim();
                    String immediateSupervisor = record[12].trim();
                    double basicSalary = Double.parseDouble(record[13].trim().replace(",", ""));
                    double riceSubsidy = Double.parseDouble(record[14].trim().replace(",", ""));
                    double phoneAllowance = Double.parseDouble(record[15].trim().replace(",", ""));
                    double clothingAllowance = Double.parseDouble(record[16].trim().replace(",", ""));
                    double grossSalary = Double.parseDouble(record[17].trim().replace(",", ""));
                    double hourlyRate = Double.parseDouble(record[18].trim().replace(",", ""));

                    Employee emp = new Employee(employeeId, lastName, firstName, birthday, address, phoneNumber, sss,
                            philhealth, tin, pagibig, status, position, immediateSupervisor, basicSalary, riceSubsidy,
                            phoneAllowance, clothingAllowance, grossSalary, hourlyRate);

                    employees.add(emp);
                    System.out.println("✅ Successfully loaded employee: " + emp.getFullName());

                } catch (NumberFormatException e) {
                    System.out.println("⚠️ Skipping row due to number format error: " + String.join(", ", record));
                }
            }
        }
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void displayEmployees() {
        if (employees.isEmpty()) {
            System.out.println("❌ No employees loaded.");
            return;
        }
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }

    public void processPayroll(Employee emp, double hoursWorked) {
        payrollCalculator.displayPayroll(emp, hoursWorked);

        double grossSalary = payrollCalculator.computeGrossSalary(emp, hoursWorked);
        double sss = SSSCalculator.getSSSContribution(grossSalary);
        double philHealth = PhilHealthCalculator.getPhilHealthContribution(grossSalary);
        double pagIbig = Math.min(grossSalary * 0.02, 100); // Pag-IBIG maxes at PHP 100
        double taxableIncome = grossSalary - (sss + philHealth + pagIbig);
        double tax = TaxCalculator.computeWithholdingTax(taxableIncome);
        double netSalary = grossSalary - (sss + philHealth + pagIbig + tax);

        PayslipGenerator.generatePayslip(emp, hoursWorked, grossSalary, sss, philHealth, pagIbig, tax, netSalary);
    }
}