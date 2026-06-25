/**
 * BinarySearch.java
 * Implements Binary Search on a SORTED array of products.
 *
 * How it works:
 *   - Looks at the MIDDLE element of the array.
 *   - If middle matches → found!
 *   - If target is smaller → search the LEFT half
 *   - If target is larger  → search the RIGHT half
 *   - Repeat until found or no elements left.
 *
 * IMPORTANT: Array must be sorted by productId before using this!
 *
 * Time Complexity:
 *   - Best Case:    O(1)    → Target is the middle element
 *   - Average Case: O(log n) → Cuts search space in half each time
 *   - Worst Case:   O(log n) → Target not found after all splits
 */
public class BinarySearch {

    public static int search(Product[] products, int targetId) {

        int low = 0;
        int high = products.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2; // Find middle index

            if (products[mid].productId == targetId) {
                return mid; // Found!

            } else if (products[mid].productId < targetId) {
                low = mid + 1; // Target is in the RIGHT half

            } else {
                high = mid - 1; // Target is in the LEFT half
            }
        }

        return -1; // Not found
    }
}
