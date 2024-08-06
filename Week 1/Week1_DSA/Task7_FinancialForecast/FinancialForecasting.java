import java.util.HashMap;
import java.util.Map;

public class FinancialForecasting {

    // Map to store computed future values for memoization
    private static Map<Integer, Double> memo = new HashMap<>();

    // Recursive method to calculate future value with memoization
    public static double calculateFutureValue(double presentValue, double growthRate, int periods) {
        // Base case: when periods are 0, the future value is the present value
        if (periods == 0) {
            return presentValue;
        }
        // Check if the result for the current period is already computed
        if (memo.containsKey(periods)) {
            return memo.get(periods);
        }
        // Recursive case: calculate future value for (periods - 1)
        double previousValue = calculateFutureValue(presentValue, growthRate, periods - 1);
        // Apply the growth rate to get the future value
        double futureValue = previousValue * (1 + growthRate);
        // Store the computed result in the memo map
        memo.put(periods, futureValue);
        return futureValue;
    }

    public static void main(String[] args) {
        // Example usage
        double presentValue = 1000; // Initial amount
        double growthRate = 0.05; // Growth rate (5%)
        int periods = 10; // Number of periods

        double futureValue = calculateFutureValue(presentValue, growthRate, periods);
        System.out.println("Future Value after " + periods + " periods: " + futureValue);
    }
}
