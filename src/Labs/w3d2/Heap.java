package Labs.w3d2;

import java.util.Arrays;

public class Heap {
    public static void main(String[] args) {
        int[] dataset1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        int[] dataset2 = new int[]{2, 1, 4, 3, 6, 5, 8, 7, 10, 9, 12, 11, 14, 13, 16, 15};
        int[] dataset3 = new int[]{4, 2, 3, 1, 5, 8, 7, 6, 11, 10, 12, 9, 13, 14, 16, 15};
        int[] dataset4 = new int[]{5, 6, 7, 4, 2, 3, 1, 8, 11, 13, 14, 16, 10, 12, 11, 9};
        //Build Max Heap with Top-Down
        System.out.println("Build Max Heap with Top-Down");
        System.out.println(buildHeapTopDown(dataset1));
        System.out.println(Arrays.toString(dataset1));
        System.out.println(buildHeapTopDown(dataset2));
        System.out.println(Arrays.toString(dataset2));
        System.out.println(buildHeapTopDown(dataset3));
        System.out.println(Arrays.toString(dataset3));
        System.out.println(buildHeapTopDown(dataset4));
        System.out.println(Arrays.toString(dataset4));

        //Build Max Heap with Bottom-Up
        int[] dataset5 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        int[] dataset6 = new int[]{2, 1, 4, 3, 6, 5, 8, 7, 10, 9, 12, 11, 14, 13, 16, 15};
        int[] dataset7 = new int[]{4, 2, 3, 1, 5, 8, 7, 6, 11, 10, 12, 9, 13, 14, 16, 15};
        int[] dataset8 = new int[]{5, 6, 7, 4, 2, 3, 1, 8, 11, 13, 14, 16, 10, 12, 11, 9};
        System.out.println("Build Max Heap with Bottom-Up");
        System.out.println(buildHeapBottomUp(dataset5));
        System.out.println(Arrays.toString(dataset5));
        System.out.println(buildHeapBottomUp(dataset6));
        System.out.println(Arrays.toString(dataset6));
        System.out.println(buildHeapBottomUp(dataset7));
        System.out.println(Arrays.toString(dataset7));
        System.out.println(buildHeapBottomUp(dataset8));
        System.out.println(Arrays.toString(dataset8));

    }

    static int buildHeapBottomUp(int[] arr) {
        int n = arr.length, numOfComparison = 0;
        for (int i = n / 2 - 1; i >= 0; i--) {
            numOfComparison += bottomUp(arr, i);
        }
        return numOfComparison;
    }

    private static int bottomUp(int[] arr, int i) {
        int index = i, numofComparison = 0;
        int maxChildIndex = maxChildIndex(arr, index);
        while (maxChildIndex < arr.length) {
            if (arr[maxChildIndex] > arr[index]) {
                swap(arr, index, maxChildIndex);
                index = maxChildIndex;
                maxChildIndex = maxChildIndex(arr, index);
                numofComparison++;
            }
        }
        return numofComparison;
    }

    private static int maxChildIndex(int[] arr, int i) {
        if(2 * i + 1 >= arr.length) {
            return Integer.MAX_VALUE;
        } else if (2 * i + 2 >= arr.length) {
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
