package utils;

public class SSSCalculator {
    public static double getSSSContribution(double grossSalary) {
        if (grossSalary < 3250) {
            return 135.00;
        } else if (grossSalary <= 3750) {
            return 157.50;
        } else if (grossSalary <= 4250) {
            return 180.00;
        } else if (grossSalary <= 4750) {
            return 202.50;
        } else if (grossSalary <= 5250) {
            return 225.00;
        } else if (grossSalary <= 5750) {
            return 247.50;
        } else if (grossSalary <= 6250) {
            return 270.00;
        } else if (grossSalary <= 6750) {
            return 292.50;
        } else if (grossSalary <= 7250) {
            return 315.00;
        } else if (grossSalary <= 7750) {
            return 337.50;
        } else if (grossSalary <= 8250) {
            return 360.00;
        } else if (grossSalary <= 8750) {
            return 382.50;
        } else if (grossSalary <= 9250) {
            return 405.00;
        } else if (grossSalary <= 9750) {
            return 427.50;
        } else if (grossSalary <= 10250) {
            return 450.00;
        } else if (grossSalary <= 10750) {
            return 472.50;
        } else if (grossSalary <= 11250) {
            return 495.00;
        } else if (grossSalary <= 11750) {
            return 517.50;
        } else if (grossSalary <= 12250) {
            return 540.00;
        } else if (grossSalary <= 12750) {
            return 562.50;
        } else if (grossSalary <= 13250) {
            return 585.00;
        } else if (grossSalary <= 13750) {
            return 607.50;
        } else if (grossSalary <= 14250) {
            return 630.00;
        } else if (grossSalary <= 14750) {
            return 652.50;
        } else if (grossSalary <= 15250) {
            return 675.00;
        } else if (grossSalary <= 15750) {
            return 697.50;
        } else if (grossSalary <= 16250) {
            return 720.00;
        } else if (grossSalary <= 16750) {
            return 742.50;
        } else if (grossSalary <= 17250) {
            return 765.00;
        } else if (grossSalary <= 17750) {
            return 787.50;
        } else if (grossSalary <= 18250) {
            return 810.00;
        } else if (grossSalary <= 18750) {
            return 832.50;
        } else if (grossSalary <= 19250) {
            return 855.00;
        } else if (grossSalary <= 19750) {
            return 877.50;
        } else {
            return 900.00; // Max SSS contribution
        }
    }
}