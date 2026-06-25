
public class EcommerceSearchTest {

    public static void main(String[] args) {

        System.out.println("============================================");
        System.out.println("   E-Commerce Platform Search Analysis");
        System.out.println("============================================\n");


        Product[] unsortedProducts = {
            new Product(105, "Wireless Mouse",     "Electronics"),
            new Product(202, "Running Shoes",      "Footwear"),
            new Product(318, "Coffee Maker",       "Appliances"),
            new Product(401, "Python Programming Book", "Books"),
            new Product(156, "Yoga Mat",           "Sports"),
            new Product(533, "Bluetooth Speaker",  "Electronics"),
            new Product(278, "Sunglasses",         "Accessories"),
            new Product(489, "Laptop Stand",       "Electronics"),
            new Product(612, "Water Bottle",       "Sports"),
            new Product(375, "Notebook",           "Stationery")
        };

       Product[] sortedProducts = {
            new Product(105, "Wireless Mouse",     "Electronics"),
            new Product(156, "Yoga Mat",           "Sports"),
            new Product(202, "Running Shoes",      "Footwear"),
            new Product(278, "Sunglasses",         "Accessories"),
            new Product(318, "Coffee Maker",       "Appliances"),
            new Product(375, "Notebook",           "Stationery"),
            new Product(401, "Python Programming Book", "Books"),
            new Product(489, "Laptop Stand",       "Electronics"),
            new Product(533, "Bluetooth Speaker",  "Electronics"),
            new Product(612, "Water Bottle",       "Sports")
        };
	System.out.println("── TEST 1: Linear Search (Best Case) ──");
        System.out.println("Searching for Product ID: 105 (first element)");

        long startTime = System.nanoTime();
        int result = LinearSearch.search(unsortedProducts, 105);
        long endTime = System.nanoTime();

        printResult(unsortedProducts, result, endTime - startTime);
        System.out.println("Complexity: O(1) — Found at first position\n");

        System.out.println("── TEST 2: Linear Search (Worst Case) ──");
        System.out.println("Searching for Product ID: 375 (somewhere in middle-end)");

        startTime = System.nanoTime();
        result = LinearSearch.search(unsortedProducts, 375);
        endTime = System.nanoTime();

        printResult(unsortedProducts, result, endTime - startTime);
        System.out.println("Complexity: O(n) — Had to scan multiple elements\n");

        System.out.println("── TEST 3: Linear Search (Not Found) ──");
        System.out.println("Searching for Product ID: 999 (does not exist)");

        startTime = System.nanoTime();
        result = LinearSearch.search(unsortedProducts, 999);
        endTime = System.nanoTime();

        printResult(unsortedProducts, result, endTime - startTime);
        System.out.println("Complexity: O(n) — Scanned entire array\n");

        System.out.println("============================================\n");

        System.out.println("── TEST 4: Binary Search (Best Case) ──");
        System.out.println("Searching for Product ID: 318 (middle element)");

        startTime = System.nanoTime();
        result = BinarySearch.search(sortedProducts, 318);
        endTime = System.nanoTime();

        printResult(sortedProducts, result, endTime - startTime);
        System.out.println("Complexity: O(1) — Found at first mid check\n");
        System.out.println("── TEST 5: Binary Search (Worst Case) ──");
        System.out.println("Searching for Product ID: 612 (last element)");

        startTime = System.nanoTime();
        result = BinarySearch.search(sortedProducts, 612);
        endTime = System.nanoTime();

        printResult(sortedProducts, result, endTime - startTime);
        System.out.println("Complexity: O(log n) — Array halved each step\n");
        System.out.println("── TEST 6: Binary Search (Not Found) ──");
        System.out.println("Searching for Product ID: 999 (does not exist)");

        startTime = System.nanoTime();
        result = BinarySearch.search(sortedProducts, 999);
        endTime = System.nanoTime();

        printResult(sortedProducts, result, endTime - startTime);
        System.out.println("Complexity: O(log n) — Stopped after log(10) steps\n");
        System.out.println("============================================");
        System.out.println("           COMPLEXITY ANALYSIS");
        System.out.println("============================================");
        System.out.println();
        System.out.println("Algorithm      | Best  | Average  | Worst");
        System.out.println("---------------|-------|----------|--------");
        System.out.println("Linear Search  | O(1)  | O(n)     | O(n)   ");
        System.out.println("Binary Search  | O(1)  | O(log n) | O(log n)");
        System.out.println();
        System.out.println("CONCLUSION:");
        System.out.println("  ✔ Use Binary Search for large, frequently searched catalogs.");
        System.out.println("  ✔ Binary Search is much faster: for 1 million products,");
        System.out.println("    Linear needs up to 1,000,000 steps.");
        System.out.println("    Binary needs only ~20 steps (log2 of 1,000,000 ≈ 20).");
        System.out.println("  ✔ Trade-off: Array must be kept sorted by productId.");
        System.out.println("  ✔ Use Linear Search only for very small or unsorted data.");
        System.out.println("============================================");
    }

    static void printResult(Product[] products, int index, long timeNs) {
        if (index == -1) {
            System.out.println("  Result: Product NOT FOUND");
        } else {
            System.out.print("  Result: FOUND at index [" + index + "] → ");
            products[index].display();
        }
        System.out.println("  Time taken: " + timeNs + " nanoseconds");
    }
}
