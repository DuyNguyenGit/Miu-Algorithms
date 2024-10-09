package Labs.w2d1;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
//        System.out.println(medianOfThree(new int[]{3,5,1}, 0, 2));
        int[] arr = new int[]{1, 2, 3, 4, 5, 2};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    static void quickSort(int[] arr, int left, int right) {
        if (right <= left) return;
        int pivot = medianOfThree(arr, left, right);
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
            if(i > j) break;
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

    static int medianOfThree(int[] arr, int left, int right) {
        int mid = (left + right) / 2;
        int a = arr[left];
        int b = arr[mid];
        int c = arr[right];
        if (a < b) {
            if (a < c) {
                if (b < c) {
                    return right;
                } else {
                    return mid;
                }
            } else {
                return left;
            }
        } else if (b > c) {
            return mid;
        } else if (a < c) {
            return left;
        } else {
            return right;
        }
    }
}
