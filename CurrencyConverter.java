import java.util.Scanner;

public class CurrencyConverter {

    // Define exchange rates for demo purposes (static exchange rates)
    private static double getExchangeRate(String baseCurrency, String targetCurrency) {
        // Example exchange rates (static for simplicity)
        // For example: 1 USD = 0.85 EUR, 1 USD = 75 INR
        if (baseCurrency.equals("USD") && targetCurrency.equals("EUR")) {
            return 0.85;  // USD to EUR rate
        } else if (baseCurrency.equals("USD") && targetCurrency.equals("INR")) {
            return 75.0;  // USD to INR rate
        } else if (baseCurrency.equals("EUR") && targetCurrency.equals("USD")) {
            return 1.18;  // EUR to USD rate
        } else if (baseCurrency.equals("EUR") && targetCurrency.equals("INR")) {
            return 88.0;  // EUR to INR rate
        } else if (baseCurrency.equals("INR") && targetCurrency.equals("USD")) {
            return 0.013;  // INR to USD rate
        } else if (baseCurrency.equals("INR") && targetCurrency.equals("EUR")) {
            return 0.012;  // INR to EUR rate
        } else {
            return -1;  // Invalid conversion
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the base and target currencies from the user
        System.out.println("Enter the base currency (e.g., USD, EUR, INR): ");
        String baseCurrency = scanner.nextLine().toUpperCase();

        System.out.println("Enter the target currency (e.g., USD, EUR, INR): ");
        String targetCurrency = scanner.nextLine().toUpperCase();

        // Get the amount to convert
        System.out.println("Enter the amount to convert: ");
        double amount = scanner.nextDouble();

        // Fetch the exchange rate
        double exchangeRate = getExchangeRate(baseCurrency, targetCurrency);

        if (exchangeRate != -1) {
            // Convert the amount
            double convertedAmount = amount * exchangeRate;
            System.out.printf("Converted amount: %.2f %s\n", convertedAmount, targetCurrency);
        } else {
            System.out.println("Invalid currency conversion. Please check your currencies.");
        }

        scanner.close();
    }
}
