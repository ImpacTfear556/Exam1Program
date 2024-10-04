import java.util.Scanner;

public class OrderCalculator {

    
    static double[] itemPrices = {0.75, 0.45, 0.50, 0.09, 0.60}; // Prices for apple, banana, orange, grape, pear
    static String[] itemNames = {"Apple", "Banana", "Orange", "Grape", "Pear"};
    
    public static void main(String[] args) {
       
        Scanner scanner = new Scanner(System.in);

       
        int[] quantities = new int[itemNames.length];

       
        for (int i = 0; i < itemNames.length; i++) {
            System.out.print("How many " + itemNames[i] + "(s) do you want? ");
            quantities[i] = Integer.parseInt(scanner.nextLine());
        }

       
        double cost = calculateCost(quantities);
        boolean shouldApplyTax = checkSalesTax(cost);
        double salesTax = shouldApplyTax ? cost * 0.08 : 0; // 8% tax if applicable
        double totalCost = cost + salesTax;

       
        printReceipt(quantities, cost, salesTax, totalCost);
        
        
        double updatedSalesTax = totalCost * 0.0225; // 2.25% tax
        double updatedTotalCost = cost + updatedSalesTax;

        // Print updated total with new sales tax
        System.out.printf("Total cost of the order with 2.25%% sales tax: $%.2f\n", updatedTotalCost);

        scanner.close();
    }

    public static double calculateCost(int[] quantities) {
        double totalCost = 0.0;
        for (int i = 0; i < quantities.length; i++) {
            totalCost += quantities[i] * itemPrices[i];
        }
        return totalCost;
    }

    public static boolean checkSalesTax(double cost) {
        return cost >= 10.00;
    }

    public static void printReceipt(int[] quantities, double cost, double salesTax, double totalCost) {
        System.out.println("Receipt:");
        for (int i = 0; i < quantities.length; i++) {
            if (quantities[i] > 0) {
                double itemCost = quantities[i] * itemPrices[i];
                System.out.printf("%s: %d x $%.2f = $%.2f\n", itemNames[i], quantities[i], itemPrices[i], itemCost);
            }
        }
        System.out.printf("Cost of the order (without sales tax): $%.2f\n", cost);
        System.out.printf("Sales tax: $%.2f\n", salesTax);
        System.out.printf("Total cost of the order (with sales tax): $%.2f\n", totalCost);
    }
}

/*
Receipt:
Apple: 4 x $0.75 = $3.00
Banana: 2 x $0.45 = $0.90
Orange: 0 x $0.50 = $0.00
Grape: 60 x $0.09 = $5.40
Pear: 2 x $0.60 = $1.20
Cost of the order (without sales tax): $10.50
Sales tax: $0.84
Total cost of the order (with sales tax): $11.34
Total cost of the order with 2.25% sales tax: $10.74
*/
