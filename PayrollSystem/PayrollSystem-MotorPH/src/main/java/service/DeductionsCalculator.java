package service;

public class DeductionsCalculator {
    private static final double TAX_RATE = 0.12; // 12% tax deduction
    private static final double SSS_RATE = 0.045; // 4.5% SSS deduction
    private static final double PHILHEALTH_RATE = 0.035; // 3.5% PhilHealth deduction
    private static final double PAGIBIG_RATE = 0.02; // 2% Pag-IBIG deduction

    public static double calculateTax(double salary) {
        return salary * TAX_RATE;
    }

    public static double calculateSSS(double salary) {
        return salary * SSS_RATE;
    }

    public static double calculatePhilHealth(double salary) {
        return salary * PHILHEALTH_RATE;
    }

    public static double calculatePagIbig(double salary) {
        return salary * PAGIBIG_RATE;
    }

    public static double calculateTotalDeductions(double salary) {
        return calculateTax(salary) + calculateSSS(salary) + calculatePhilHealth(salary) + calculatePagIbig(salary);
    }
}