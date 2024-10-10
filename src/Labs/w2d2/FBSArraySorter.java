package Labs.w2d2;

public class FBSArraySorter {

    // Helper function to swap elements in the array
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // Function to rearrange the array into the desired FBS form
    public static void FBSsortInPlace(int[] array) {
        int n = array.length;

        // Step 1: Reverse the even-indexed elements to make them in descending order
        int left = 0; // First even index
        int right = (n % 2 == 0) ? n - 2 : n - 1; // Last even index

        while (left < right) {
            swap(array, left, right);
            left += 2;
            right -= 2;
        }
        
        // No need to touch the odd-indexed elements because they are already in ascending order.
    }

    public static void main(String[] args) {
        int[] array = {7, 10, 10, 14, 15, 15, 17, 19, 20}; // Sorted input
        FBSsortInPlace(array); // Sorting the array in FBS format
        
        // Output the sorted array
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
