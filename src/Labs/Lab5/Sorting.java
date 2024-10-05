package Labs.Lab5;

public class Sorting {
    public static void main(String[] args) {
        printArray(bubbleSortOptimized(new int[]{1,2,3,4,5,4}));
        printArray(bubbleSortOptimized(new int[]{5,4,3,2,1,2}));
    }

    private static void printArray(int[] ints) {
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + ",");
        }
        System.out.println();
    }

    static int[] bubbleSortOptimized(int[] arr) {
        if(arr == null || arr.length < 2) {
            return arr;
        }
        boolean asscending = arr[0] <= arr[arr.length-1];
        boolean sorted = true;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1] && asscending) {
                sorted = false;
                break;
            } else if (arr[i] < arr[i + 1] && !asscending) {
                sorted = false;
                break;
            }
        }
        if (sorted) {
            System.out.println("Sorted Array");
            return arr;
        }
        // do Bubble Sorting
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
        return arr;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
