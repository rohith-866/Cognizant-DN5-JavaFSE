public class ForecastTest {

    public static void main(String[] args) {

        double presentValue = 10000.0;
        double growthRate = 0.08;
        int years = 5;

        System.out.println("========================================");
        System.out.println("      Financial Forecasting Tool");
        System.out.println("========================================");
        System.out.println("Present Value : Rs." + presentValue);
        System.out.println("Growth Rate   : " + (growthRate * 100) + "%");
        System.out.println("Years         : " + years);
        System.out.println("========================================\n");

        System.out.println("-- Year-by-Year Recursive Forecast --");
        for (int y = 1; y <= years; y++) {
            double value = FinancialForecast.futureValueRecursive(presentValue, growthRate, y);
            System.out.printf("  Year %d : Rs.%.2f%n", y, value);
        }

        System.out.println();
        System.out.println("-- Memoized Recursive Forecast (Year " + years + ") --");
        double memoResult = FinancialForecast.futureValueMemoized(presentValue, growthRate, years);
        System.out.printf("  Future Value : Rs.%.2f%n", memoResult);

        System.out.println();
        System.out.println("-- Iterative Forecast (Year " + years + ") --");
        double iterResult = FinancialForecast.futureValueIterative(presentValue, growthRate, years);
        System.out.printf("  Future Value : Rs.%.2f%n", iterResult);

        System.out.println();
        System.out.println("========================================");
        System.out.println("           ANALYSIS SUMMARY");
        System.out.println("========================================");
        System.out.println("Recursive (Plain)   : O(n) time, O(n) stack space");
        System.out.println("Recursive (Memoized): O(n) time, O(n) memo space");
        System.out.println("Iterative           : O(n) time, O(1) space");
        System.out.println();
        System.out.println("CONCLUSION:");
        System.out.println("  Plain recursion is simple but risks stack overflow");
        System.out.println("  for large n. Memoization avoids re-computation.");
        System.out.println("  Iterative is most efficient for this problem.");
        System.out.println("========================================");
    }
}
