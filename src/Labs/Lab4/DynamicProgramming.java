package Labs.Lab4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DynamicProgramming {
    public static void main(String[] args) {
//        System.out.println(subSetSum(new int[]{5, 2, 3}, 10));
//        System.out.println(subSetSum(new int[]{5, 2, 3}, 9));//false
//        System.out.println(subSetSum(new int[]{2, 3, 5}, 8));
//        System.out.println(subSetSum(new int[]{3, 2, 5}, 8));
//        System.out.println(subSetSum(new int[]{5, 3, 2}, 8));
//        System.out.println(subSetSum(new int[]{5, 2, 3}, 8));
//        System.out.println(subSetSum(new int[]{5, 2, 3}, 7));
//        System.out.println(subSetSum(new int[]{5, 2, 3}, 6));//false
//        System.out.println(subSetSum(new int[]{5, 2, 3}, 5));
//        System.out.println(subSetSum(new int[]{5, 2, 3}, 4));//false
//        System.out.println(subSetSum(new int[]{5, 2, 3}, 3));
//        System.out.println(subSetSum(new int[]{5, 2, 3}, 2));
//        System.out.println(subSetSum(new int[]{5, 2, 3}, 1));//false
//        System.out.println(subSetSum(new int[]{5, 2, 3, 6, 7}, 15));//true
//        System.out.println(subSetSum(new int[]{5, 2, 3, 6, 7}, 21));//true
//        System.out.println(subSetSum(new int[]{5, 2, 3, 6, 7}, 23));//true
//        System.out.println(subSetSum(new int[]{5, 2, 3, 6, 7}, 24));//false

//        System.out.println(oneSubset(new int[]{5, 2, 3}, 10));
//        System.out.println(oneSubset(new int[]{5, 2, 3}, 9));//false
//        System.out.println(oneSubset(new int[]{2, 3, 5}, 8));
//        System.out.println(oneSubset(new int[]{3, 2, 5}, 8));
//        System.out.println(oneSubset(new int[]{5, 3, 2}, 8));
//        System.out.println(oneSubset(new int[]{5, 2, 3}, 8));
//        System.out.println(oneSubset(new int[]{5, 2, 3}, 7));
//        System.out.println(oneSubset(new int[]{5, 2, 3}, 6));//false
//        System.out.println(oneSubset(new int[]{5, 2, 3}, 5));
//        System.out.println(oneSubset(new int[]{5, 2, 3}, 4));//false
//        System.out.println(oneSubset(new int[]{5, 2, 3}, 3));
//        System.out.println(oneSubset(new int[]{5, 2, 3}, 2));
//        System.out.println(oneSubset(new int[]{5, 2, 3}, 1));//false
//        System.out.println(oneSubset(new int[]{5, 2, 3, 6, 7}, 15));//true
//        System.out.println(oneSubset(new int[]{5, 2, 3, 6, 7}, 21));//true
//        System.out.println(oneSubset(new int[]{5, 2, 3, 6, 7}, 23));//true
//        System.out.println(oneSubset(new int[]{5, 2, 3, 6, 7}, 24));//false
//        System.out.println(oneSubset(new int[]{3, 4, 7, 8}, 15));//true

//        System.out.println(allSubsets(new int[]{2,3,5}, 5));//true
//        System.out.println(allSubsets(new int[]{2,3,5}, 8));//true
//        System.out.println(allSubsets(new int[]{2,3,5}, 10));//true
//        System.out.println(allSubsets(new int[]{2,3,5,7}, 10));//true
//        System.out.println(allSubsets(new int[]{2,3,5,7}, 12));//true
//        System.out.println(allSubsets(new int[]{2,3,5,7}, 7));//true
        System.out.println(allSubsets(new int[]{2,3,5,4,7,8,9}, 7));//true
    }

    static int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    static int fibUsingDP(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int prev = 0;
        int curr = 1;
        for (int i = 2; i < n; i++) {
            int temp = curr;
            curr = curr + prev;
            prev = temp;
        }
        return curr;
    }

    static boolean subSetSum(int[] arr, int sum) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        int n = arr.length;
        boolean[][] sumArr = new boolean[n + 1][sum + 1];
        for (int i = 1; i <= n; i++) {
            int e = arr[i - 1];
            for (int j = 0; j <= sum; j++) {
                sumArr[i][j] = sumArr[i - 1][j];
                if (j == 0) {
                    sumArr[i][j] = true;
                }
                if (j >= e) {
                    sumArr[i][j] = sumArr[i][j] || (i == 1 ? j == e : sumArr[i - 1][j - e]);
                }
            }
        }
        return sumArr[n][sum];
    }

    static List<Integer> oneSubset(int[] arr, int sum) {
        if (arr == null || arr.length == 0) {
            return new ArrayList<>();
        }
        int n = arr.length;
        boolean[][] sumArr = new boolean[n + 1][sum + 1];
        for (int i = 1; i <= n; i++) {
            int e = arr[i - 1];
            for (int j = 0; j <= sum; j++) {
                sumArr[i][j] = sumArr[i - 1][j];
                if (j == 0) {
                    sumArr[i][j] = true;
                }
                if (j >= e) {
                    sumArr[i][j] = sumArr[i][j] || (i == 1 ? j == e : sumArr[i - 1][j - e]);
                }
            }
        }
        if (!sumArr[n][sum]) {
            return new ArrayList<>();
        }
        //Back tracking
        List<Integer> res = new ArrayList<>();
        int i = n, j = sum;
        while (i > 0 && j > 0) {
            if(!sumArr[i-1][j]) {
                res.add(arr[i-1]);
                j = j - arr[i-1];
            }
            i--;
        }
        return res;
    }

    static List<List<Integer>> allSubsets(int[] arr, int sum) {
        if (arr == null || arr.length == 0) {
            return new ArrayList<>();
        }
        int n = arr.length;
        boolean[][] sumArr = new boolean[n + 1][sum + 1];
        for (int i = 1; i <= n; i++) {
            int e = arr[i - 1];
            for (int j = 0; j <= sum; j++) {
                sumArr[i][j] = sumArr[i - 1][j];
                if (j == 0) {
                    sumArr[i][j] = true;
                }
                if (j >= e) {
                    sumArr[i][j] = sumArr[i][j] || (i == 1 ? j == e : sumArr[i - 1][j - e]);
                }
            }
        }
        print2DArray(sumArr);

        if (!sumArr[n][sum]) {
            return new ArrayList<>();
        }
        //Back tracking
        List<List<Integer>> subSets = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        List<Integer> res2 = new ArrayList<>();

        int i = n, j = sum, prev = sum;
        while (i > 0 && j > 0) {
            if(j == arr[i-1] && sumArr[i-1][j]) {
                res2.add(arr[i - 1]);
                if (prev - arr[i - 1] != 0) {
                    res2.add(prev - arr[i-1]);
                }
                subSets.add(res2);
            }
            if(!sumArr[i-1][j]) {
                res.add(arr[i-1]);
                j = j - arr[i-1];
                prev = j;
            }
            i--;
        }
        subSets.add(res);
        return subSets;
    }

    static List<List<Integer>> allSubsets2(int[] arr, int sum) {
        if (arr == null || arr.length == 0) {
            return new ArrayList<>();
        }
        int n = arr.length;
        boolean[][] sumArr = new boolean[n + 1][sum + 1];
        for (int i = 1; i <= n; i++) {
            int e = arr[i - 1];
            for (int j = 0; j <= sum; j++) {
                sumArr[i][j] = sumArr[i - 1][j];
                if (j == 0) {
                    sumArr[i][j] = true;
                }
                if (j >= e) {
                    sumArr[i][j] = sumArr[i][j] || (i == 1 ? j == e : sumArr[i - 1][j - e]);
                }
            }
        }
        print2DArray(sumArr);

        if (!sumArr[n][sum]) {
            return new ArrayList<>();
        }
        //Back tracking
        List<List<Integer>> subSets = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        List<Integer> res2 = new ArrayList<>();

        int i = n, j = sum, prev = sum;
        while (i > 0 && sumArr[i][sum]) {
            if(sum >= arr[i-1]) {
                if(sum == arr[i-1]) {
                    subSets.add(List.of(arr[i-1]));
                } else {
                    res2.add(arr[i-1]);
                    subSets.add(res2);
                }
            }
            i--;
        }

        return subSets;
    }

    static void print2DArray(boolean[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print((arr[i][j] ? "T" : "F") + " ");
            }
            System.out.println();
        }
    }
}
