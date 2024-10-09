package Labs.Lab6;

import java.util.Arrays;

public class MergeSortInPlaceSolution {
    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10, 100, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 200, 27, 43, 3, 9, 82, 10, 100, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 200, 27, 43, 3, 9, 82, 10, 100, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 200};


        System.out.println("Original Array: " + Arrays.toString(array));
        long startTime = System.nanoTime();
        mergeSortInPlace(array, 0, array.length - 1);
        long endTime = System.nanoTime();
        System.out.println("Time for sorting in place: " + (endTime - startTime));
        System.out.println("Sorted Array: " + Arrays.toString(array));
    }

    static void mergeSortInPlace(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSortInPlace(arr, left, mid);
        mergeSortInPlace(arr, mid + 1, right);

        mergeArray(arr, left, mid, right);
    }

    private static void mergeArray(int[] arr, int left, int mid, int right) {
        int i = left, j = mid + 1;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                i++;
            } else {
                int temp = arr[j];
                for (int k = j; k > i; k--) {
                    arr[k] = arr[k - 1];
                }
                arr[i] = temp;
                i++;
                mid++;
                j++;
            }
        }
    }
}
