/**
 * LinearSearch.java
 * Implements Linear Search on an UNSORTED array of products.
 *
 * How it works:
 *   - Goes through each product ONE BY ONE from start to end.
 *   - Checks if the current product's ID matches the target.
 *   - Stops when found, or returns -1 if not found.
 *
 * Time Complexity:
 *   - Best Case:    O(1)  → Target is the very first element
 *   - Average Case: O(n)  → Target is somewhere in the middle
 *   - Worst Case:   O(n)  → Target is last or not in array
 */
public class LinearSearch {

    public static int search(Product[] products, int targetId) {

        for (int i = 0; i < products.length; i++) {
            if (products[i].productId == targetId) {
                return i; // Found! Return index
            }
        }
        return -1; // Not found
    }
}
