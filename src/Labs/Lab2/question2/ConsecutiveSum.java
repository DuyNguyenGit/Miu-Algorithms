package Labs.Lab2.question2;

public class ConsecutiveSum {
    public static void main(String[] args) {
        printArray(consecutiveSum(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 3));
        System.out.println();
        printArray(consecutiveSum2(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 3));
    }

    static int[] consecutiveSum(int[] arr, int k) {
        int l = arr.length;
        int[] result = new int[l - k + 1];
        for (int i = k - 1; i < l; i++) {
            int sum = 0;
            for (int j = i; j > i - k; j--) {
                sum += arr[j];
            }
            result[i - k + 1] = sum;
        }
        return result;
    }

    static int[] consecutiveSum2(int[] arr, int k) {
        int l = arr.length;
        int[] result = new int[l - k + 1];
        int sum = 0;
        for(int i = 0; i < k; i++) {
            sum += arr[i];
        }
        result[0] = sum;
        for (int i = k; i < l; i++) {
            sum = sum - arr[i-k] + arr[i];
            result[i - k + 1] = sum;
        }
        return result;
    }

    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
