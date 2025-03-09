package model;

public class Employee {
    private int employeeId;
    private String lastName;
    private String firstName;
    private String birthday;
    private String address;
    private String phoneNumber;
    private String sss;
    private String philhealth;
    private String tin;
    private String pagibig;
    private String status;
    private String position;
    private String immediateSupervisor;
    private double basicSalary;
    private double riceSubsidy;
    private double phoneAllowance;
    private double clothingAllowance;
    private double grossSalary;
    private double hourlyRate;

    // ✅ Constructor matching the PayrollSystem.java call
    public Employee(int employeeId, String lastName, String firstName, String birthday, String address, 
                    String phoneNumber, String sss, String philhealth, String tin, String pagibig, 
                    String status, String position, String immediateSupervisor, double basicSalary, 
                    double riceSubsidy, double phoneAllowance, double clothingAllowance, 
                    double grossSalary, double hourlyRate) {
        this.employeeId = employeeId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthday = birthday;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.sss = sss;
        this.philhealth = philhealth;
        this.tin = tin;
        this.pagibig = pagibig;
        this.status = status;
        this.position = position;
        this.immediateSupervisor = immediateSupervisor;
        this.basicSalary = basicSalary;
        this.riceSubsidy = riceSubsidy;
        this.phoneAllowance = phoneAllowance;
        this.clothingAllowance = clothingAllowance;
        this.grossSalary = grossSalary;
        this.hourlyRate = hourlyRate;
    }

    // ✅ Get full name
    public String getFullName() {
        return firstName + " " + lastName;
    }

    // ✅ Calculate salary based on hours worked
    public double calculateSalary(double hoursWorked) {
        return hoursWorked * hourlyRate;
    }

    // ✅ Getters
    public int getEmployeeId() { return employeeId; }
    public String getLastName() { return lastName; }
    public String getFirstName() { return firstName; }
    public String getBirthday() { return birthday; }
    public String getAddress() { return address; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getSss() { return sss; }
    public String getPhilhealth() { return philhealth; }
    public String getTin() { return tin; }
    public String getPagibig() { return pagibig; }
    public String getStatus() { return status; }
    public String getPosition() { return position; }
    public String getImmediateSupervisor() { return immediateSupervisor; }
    public double getBasicSalary() { return basicSalary; }
    public double getRiceSubsidy() { return riceSubsidy; }
    public double getPhoneAllowance() { return phoneAllowance; }
    public double getClothingAllowance() { return clothingAllowance; }
    public double getGrossSalary() { return grossSalary; }
    public double getHourlyRate() { return hourlyRate; }

    // ✅ Setters
    public void setEmployeeId(int employeeId) { this.employeeId = employeeId; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setBirthday(String birthday) { this.birthday = birthday; }
    public void setAddress(String address) { this.address = address; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setSss(String sss) { this.sss = sss; }
    public void setPhilhealth(String philhealth) { this.philhealth = philhealth; }
    public void setTin(String tin) { this.tin = tin; }
    public void setPagibig(String pagibig) { this.pagibig = pagibig; }
    public void setStatus(String status) { this.status = status; }
    public void setPosition(String position) { this.position = position; }
    public void setImmediateSupervisor(String immediateSupervisor) { this.immediateSupervisor = immediateSupervisor; }
    public void setBasicSalary(double basicSalary) { this.basicSalary = basicSalary; }
    public void setRiceSubsidy(double riceSubsidy) { this.riceSubsidy = riceSubsidy; }
    public void setPhoneAllowance(double phoneAllowance) { this.phoneAllowance = phoneAllowance; }
    public void setClothingAllowance(double clothingAllowance) { this.clothingAllowance = clothingAllowance; }
    public void setGrossSalary(double grossSalary) { this.grossSalary = grossSalary; }
    public void setHourlyRate(double hourlyRate) { this.hourlyRate = hourlyRate; }

    // ✅ ToString() method for debugging
    @Override
    public String toString() {
        return "Employee ID: " + employeeId + "\n" +
               "Name: " + getFullName() + "\n" +
               "Birthday: " + birthday + "\n" +
               "Address: " + address + "\n" +
               "Phone: " + phoneNumber + "\n" +
               "SSS: " + sss + ", PhilHealth: " + philhealth + ", TIN: " + tin + ", Pag-IBIG: " + pagibig + "\n" +
               "Status: " + status + ", Position: " + position + "\n" +
               "Immediate Supervisor: " + immediateSupervisor + "\n" +
               "Basic Salary: PHP " + basicSalary + "\n" +
               "Allowances - Rice: PHP " + riceSubsidy + ", Phone: PHP " + phoneAllowance + ", Clothing: PHP " + clothingAllowance + "\n" +
               "Gross Salary: PHP " + grossSalary + "\n" +
               "Hourly Rate: PHP " + hourlyRate + "\n";
    }
}