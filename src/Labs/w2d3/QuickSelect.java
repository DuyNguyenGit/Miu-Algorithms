package Labs.w2d3;

import java.util.Random;

public class QuickSelect {

    // Quickselect function to find the k-th smallest element
    public static int quickSelect(int[] arr, int left, int right, int k) {
        if (left == right) { // If the array contains only one element
            return arr[left];
        }

        // Choose a random pivot index between left and right
        Random rand = new Random();
        int pivotIndex = left + rand.nextInt(right - left + 1);

        // Partition the array and get the final position of the pivot
        pivotIndex = partition(arr, left, right, pivotIndex);

        // The pivot is in its final sorted position
        if (k == pivotIndex) {
            return arr[k];
        } else if (k < pivotIndex) {
            // Recur on the left partition
            return quickSelect(arr, left, pivotIndex - 1, k);
        } else {
            // Recur on the right partition
            return quickSelect(arr, pivotIndex + 1, right, k);
        }
    }

    // Partition function similar to Quicksort
    private static int partition(int[] arr, int left, int right, int pivotIndex) {
        int pivotValue = arr[pivotIndex];
        // Move pivot to the end
        swap(arr, pivotIndex, right);
        int storeIndex = left;

        // Move all smaller elements to the left of the pivot
        for (int i = left; i < right; i++) {
            if (arr[i] < pivotValue) {
                swap(arr, i, storeIndex);
                storeIndex++;
            }
        }

        // Move pivot to its final place
        swap(arr, storeIndex, right);
        return storeIndex;
    }

    // Utility function to swap two elements in an array
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Main function to test Quickselect
    public static void main(String[] args) {
        int[] arr = {12, 3, 5, 7, 4, 19, 26};
        int k = 6;

        // Find the k-th smallest element using Quickselect
        int result = quickSelect(arr, 0, arr.length - 1, k - 1);

        System.out.println(k + "rd smallest element is " + result);
    }
}
