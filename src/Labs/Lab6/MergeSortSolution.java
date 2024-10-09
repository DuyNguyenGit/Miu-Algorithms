package Labs.Lab6;

import java.util.Arrays;

public class MergeSortSolution {
    public static void main(String[] args) {
//        int[] arr = {35, 31, 50, 75, 17, 10, 5, 31};
//        int[] arr = {35, 31, 50, 75, 17, 10, 31};
//        int[] arr = {100, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
//        int[] arr = {100, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 200};
////        int[] arr = {2,1};
////        int[] arr = {1};
////        int[] arr = {1,1,1,1,1};
//        int[] mergeSort = mergeSort(arr, 0, arr.length - 1);
//        System.out.println(Arrays.toString(mergeSort));;

        int[] array = {38, 27, 43, 3, 9, 82, 10, 100, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 200, 27, 43, 3, 9, 82, 10, 100, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 200, 27, 43, 3, 9, 82, 10, 100, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 200};

        System.out.println("Original Array: " + Arrays.toString(array));
        long startTime = System.nanoTime();
        mergeSortPractice(array);
        long endTime = System.nanoTime();
        System.out.println("Time for sorting out place: " + (endTime - startTime));
        System.out.println("Sorted Array: " + Arrays.toString(array));
    }

    static int[] mergeSort(int[] arr, int left, int right) {
        if (left == right) {
            return arr;
        }
        int mid = (left + right) / 2;
        int[] leftArr = leftArray(arr, mid);
        int[] rightArr = rightArray(arr, mid);

        int[] leftPart = mergeSort(leftArr, left, leftArr.length - 1);
        int[] rightPart = mergeSort(rightArr, left, rightArr.length - 1);
        int[] mergedArray = mergeArray(leftPart, rightPart);
        return mergedArray;
    }

    private static int[] leftArray(int[] arr, int mid) {
        int[] leftArr = new int[mid + 1];
        for (int i = 0; i <= mid; i++) {
            leftArr[i] = arr[i];
        }
        return leftArr;
    }

    private static int[] rightArray(int[] arr, int mid) {
        int[] rightArray = new int[arr.length - mid - 1];
        for (int i = 0; i < rightArray.length; i++) {
            rightArray[i] = arr[i + mid + 1];
        }
        return rightArray;
    }

    private static int[] mergeArray(int[] leftPart, int[] rightPart) {
        int[] mergedArray = new int[leftPart.length + rightPart.length];
        int currentIndex = 0;
        int i = 0, j = 0;
        while (i < leftPart.length && j < rightPart.length) {
            if (leftPart[i] <= rightPart[j]) {
                mergedArray[currentIndex] = leftPart[i];
                i++;
            } else {
                mergedArray[currentIndex] = rightPart[j];
                j++;
            }
            currentIndex++;
        }
        while (i < leftPart.length) {
            mergedArray[currentIndex++] = leftPart[i];
            i++;
        }
        while (j < rightPart.length) {
            mergedArray[currentIndex++] = rightPart[j];
            j++;
        }
        return mergedArray;
    }

    public static void mergeSort(int[] array) {
        if (array.length < 2) {
            return; // Base case: If the array is of size 1, it's already sorted.
        }

        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);

        // Recursively sort the left and right halves
        mergeSort(left);
        mergeSort(right);

        // Merge the sorted halves
        merge(array, left, right);
    }

    private static void merge(int[] array, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        // Compare elements from both halves and merge them into the main array
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        // Copy remaining elements from the left half, if any
        while (i < left.length) {
            array[k++] = left[i++];
        }

        // Copy remaining elements from the right half, if any
        while (j < right.length) {
            array[k++] = right[j++];
        }
    }

    static void mergeSortPractice(int[] arr) {
        if (arr.length < 2) {
            return;
        }
        int mid = arr.length / 2;
        int[] leftArray = Arrays.copyOfRange(arr, 0, mid);
        int[] rightArray = Arrays.copyOfRange(arr, mid, arr.length);

        mergeSortPractice(leftArray);
        mergeSortPractice(rightArray);
        mergePractice(arr, leftArray, rightArray);
    }

    private static void mergePractice(int[] arr, int[] leftArray, int[] rightArray) {
        int i = 0, j = 0, k = 0;
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] > rightArray[j]) {
                arr[k++] = rightArray[j++];
            } else if (leftArray[i] <= rightArray[j]) {
                arr[k++] = leftArray[i++];
            }
        }
        while (i < leftArray.length) {
            arr[k++] = leftArray[i++];
        }
        while (j < rightArray.length) {
            arr[k++] = rightArray[j++];
        }
    }
}
