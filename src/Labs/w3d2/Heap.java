package Labs.w3d2;

import java.util.Arrays;

public class Heap {
    public static void main(String[] args) {
//        int[] dataset1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
//        int[] dataset2 = new int[]{2, 1, 4, 3, 6, 5, 8, 7, 10, 9, 12, 11, 14, 13, 16, 15};
//        int[] dataset3 = new int[]{4, 2, 3, 1, 5, 8, 7, 6, 11, 10, 12, 9, 13, 14, 16, 15};
//        int[] dataset4 = new int[]{5, 6, 7, 4, 2, 3, 1, 8, 11, 13, 14, 16, 10, 12, 11, 9};
//        //Build Max Heap with Top-Down
//        System.out.println("Build Max Heap with Top-Down");
//        System.out.println(buildHeapTopDown(dataset1));
//        System.out.println(Arrays.toString(dataset1));
//        System.out.println(buildHeapTopDown(dataset2));
//        System.out.println(Arrays.toString(dataset2));
//        System.out.println(buildHeapTopDown(dataset3));
//        System.out.println(Arrays.toString(dataset3));
//        System.out.println(buildHeapTopDown(dataset4));
//        System.out.println(Arrays.toString(dataset4));
//
//        //Build Max Heap with Bottom-Up
//        int[] dataset5 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
//        int[] dataset6 = new int[]{2, 1, 4, 3, 6, 5, 8, 7, 10, 9, 12, 11, 14, 13, 16, 15};
//        int[] dataset7 = new int[]{4, 2, 3, 1, 5, 8, 7, 6, 11, 10, 12, 9, 13, 14, 16, 15};
//        int[] dataset8 = new int[]{5, 6, 7, 4, 2, 3, 1, 8, 11, 13, 14, 16, 10, 12, 11, 9};
//        System.out.println("Build Max Heap with Bottom-Up");
//        System.out.println(buildHeapBottomUp(dataset5));
//        System.out.println(Arrays.toString(dataset5));
//        System.out.println(buildHeapBottomUp(dataset6));
//        System.out.println(Arrays.toString(dataset6));
//        System.out.println(buildHeapBottomUp(dataset7));
//        System.out.println(Arrays.toString(dataset7));
//        System.out.println(buildHeapBottomUp(dataset8));
//        System.out.println(Arrays.toString(dataset8));

        //Heap Sort
        int[] dataset9 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        int[] dataset10 = new int[]{2, 1, 4, 3, 6, 5, 8, 7, 10, 9, 12, 11, 14, 13, 16, 15};
        int[] dataset11 = new int[]{4, 2, 3, 1, 5, 8, 7, 6, 11, 10, 12, 9, 13, 14, 16, 15};
        int[] dataset12 = new int[]{5, 6, 7, 4, 2, 3, 1, 8, 11, 13, 14, 16, 10, 12, 11, 9};
        System.out.println("Heap Sort:");
        System.out.println(heapSort(dataset9));
        System.out.println(Arrays.toString(dataset9));
        System.out.println(heapSort(dataset10));
        System.out.println(Arrays.toString(dataset10));
        System.out.println(heapSort(dataset11));
        System.out.println(Arrays.toString(dataset11));
        System.out.println(heapSort(dataset12));
        System.out.println(Arrays.toString(dataset12));
    }

    static int heapSort(int[] arr) {
        int numOfComparison = 0;
        numOfComparison += buildHeapBottomUp(arr);
        numOfComparison += heapSortPhase2(arr);
        return numOfComparison;
    }

    static int heapSortPhase2(int[] arr) {
        int n = arr.length, numOfComparison = 0;
        for (int i = n - 1; i >= 1; i--) {
            swap(arr, 0, i);
            numOfComparison += downHeap(arr, 0, i-1);
        }
        return numOfComparison;
    }

    static int buildHeapBottomUp(int[] arr) {
        int n = arr.length, numOfComparison = 0;
        for (int i = n / 2 - 1; i >= 0; i--) {
            numOfComparison += downHeap(arr, i, n);
        }
        return numOfComparison;
    }

    private static int downHeap(int[] arr, int i, int n) {
        int index = i, numofComparison = 0;
        int maxChildIndex = maxChildIndex(arr, index, n);
        while (maxChildIndex != 0) {
            if (arr[maxChildIndex] > arr[index]) {
                swap(arr, index, maxChildIndex);
                index = maxChildIndex;
                maxChildIndex = maxChildIndex(arr, index, n);
                numofComparison++;
            } else {
                break;
            }
        }
        return numofComparison;
    }

    private static int maxChildIndex(int[] arr, int i, int n) {
        if(2 * i + 1 >= n) {
            return 0;
        } else if (2 * i + 2 >= n) {
            return 2 * i + 1;
        } else if (arr[2 * i + 1] > arr[2 * i + 2]) {
            return 2 * i + 1;
        } else {
            return 2 * i + 2;
        }
    }

    static int buildHeapTopDown(int[] arr) {
        int n = arr.length, numOfComparison = 0;
        for (int i = 0; i < n; i++) {
            numOfComparison += upHeap(arr, i);
        }
        return numOfComparison;
    }

    private static int upHeap(int[] arr, int i) {
        int index = i;
        int parent = (index - 1) / 2, numOfComparison = 0;
        while (index > 0 && arr[index] > arr[parent]) {
            swap(arr, index, parent);
            index = parent;
            parent = (index - 1) / 2;
            numOfComparison++;
        }
        return numOfComparison;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
