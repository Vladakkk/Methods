package app;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    static double totalAmount;
    static int discount;
    static double payAmount;
    static String payAmountRounder;
    static String totalAmountRounder;
    static String discountSumRounder;
    static double discountSum;
    private static final String CURRENCY = "EUR";

    public static void main(String[] args) {
        getData();
        showTitle();
        discountOne();
        discountTwo();
        discountThree();
    }

    private static void getData() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter sum of purchase: ");
        totalAmount = sc.nextDouble();
    }

    private static void showTitle() {
        System.out.println("Info: ");
    }

    private static void discountOne() {
        if (totalAmount > 0 & totalAmount <= 5000) {
            discount = 5;
            payAmount = calculatePayAmount(totalAmount, discount);
            payAmountRounder = roundCost(payAmount);
            totalAmountRounder = roundCost(totalAmount);
            discountSum = calculateDiscountSum(totalAmount, discount);
            discountSumRounder = roundCost(discountSum);
            getOutput();
        }
    }

    private static void discountTwo() {
        if (totalAmount > 5000 & totalAmount <= 10000){
            discount = 10;
            payAmount = calculatePayAmount(totalAmount, discount);
            payAmountRounder = roundCost(payAmount);
            totalAmountRounder = roundCost(totalAmount);
            discountSum = calculateDiscountSum(totalAmount, discount);
            discountSumRounder = roundCost(discountSum);
            getOutput();
        }
    }

    private static void discountThree() {
        if (totalAmount > 10000) {
            discount = 15;
            payAmount = calculatePayAmount(totalAmount, discount);
            payAmountRounder = roundCost(payAmount);
            totalAmountRounder = roundCost(totalAmount);
            discountSum = calculateDiscountSum(totalAmount, discount);
            discountSumRounder = roundCost(discountSum);
            getOutput();
        }
    }

    private static void getOutput() {
        System.out.println("\nTotal sum: " + CURRENCY + " " + totalAmountRounder  +
                "\nDiscount: " + discount + "%" +
                "\nSum of discount: " + CURRENCY + " " + discountSumRounder +
                "\nSum with discount: " + CURRENCY + " " + payAmountRounder);
    }

    private static double calculatePayAmount(double totalAmount, int discount) {
        return totalAmount - (totalAmount/100 * discount);
    }

    private static String roundCost(double value){
        return new DecimalFormat("#.00").format(value);
    }

    private static double calculateDiscountSum(double totalAmount, int discount) {
        return totalAmount/100 * discount;
    }
}
