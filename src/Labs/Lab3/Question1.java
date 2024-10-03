package Labs.Lab3;

public class Question1 {
    public static void main(String[] args) {
        int[] firstArray = new int[]{1, 2, 3, 4, 5};
        int[] secondArray = new int[]{5, 4, 3, 2, 1};
        System.out.println(beautiful(firstArray, firstArray.length));
        System.out.println(beautiful(secondArray, secondArray.length));
    }

    /**
     * Time Complexity Analysis:
     * Best Case: If the minimum element is the first element, the algorithm will still need to iterate through the entire array to confirm that no other smaller element exists. Therefore, the time complexity is O(n).
     * <p>
     * Worst Case: If the minimum element is the last element, the algorithm will still have to iterate through all n elements. Therefore, the time complexity remains O(n).
     */
    static int beautiful(int[] A, int n) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, A[i]);
        }
        return min;
    }
}
