package utils;

public class TaxCalculator {
    public static double computeWithholdingTax(double taxableIncome) {
        if (taxableIncome <= 10000) {
            return 0; // No tax for low income
        } else if (taxableIncome <= 30000) {
            return taxableIncome * 0.05; // 5% tax
        } else if (taxableIncome <= 70000) {
            return taxableIncome * 0.1; // 10% tax
        } else {
            return taxableIncome * 0.2; // 20% tax
        }
    }
}