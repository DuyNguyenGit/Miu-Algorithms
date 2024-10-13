package Labs.w2d3;

import java.util.Arrays;

import static Labs.w2d3.QuickSelect.quickSelect;

public class NewQuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 2};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    static void quickSort(int[] arr, int left, int right) {
        if (right <= left) return;
        int pivot = pickPivot(arr, left, right);
        swap(arr, pivot, right);
        pivot = right;
        int i = left, j = right - 1;
        while (true) {
            while (i <= j && arr[i] < arr[pivot]) {
                i++;
            }
            while (i <= j && arr[j] > arr[pivot]) {
                j--;
            }
            if (i <= j) {
                swap(arr, i++, j--);
            }
            if (i > j) break;
        }
        swap(arr, i, pivot);
        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);
    }

    private static void swap(int[] arr, int i, int pivot) {
        int temp = arr[i];
        arr[i] = arr[pivot];
        arr[pivot] = temp;
    }

    static int pickPivot(int[] arr, int left, int right) {
        return quickSelect(arr, left, right, (left + right) / 2);
    }
}
