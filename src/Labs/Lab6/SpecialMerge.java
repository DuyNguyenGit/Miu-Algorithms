package Labs.Lab6;

import java.util.Arrays;

/**
 * ou are given two arrays as specified below.
 * Array A:   A[0..n + m - 1] with n positive integers in A[0 .. n-1] maintained as sorted in ascending order and A[n .. n + m - 1] is filled with m zeros.
 * Array B: B[0 .. m - 1] with m positive integers maintained as sorted in ascending order.
 * Write an algorithm to merge A and B as shown in the example.
 * Example
 * Input A = {5, 8, 10, 15, 0, 0, 0}
 * B = {2, 12, 25}
 * Return  {2, 5, 8, 10, 12, 15, 25}
 * No additional data structure allowed. What is the time complexity of your algorithm.
 * Additional data structure allowed. What is the time complexity of your algorithm.
 */
public class SpecialMerge {
    public static void main(String[] args) {
        int[] A = {1, 5, 8, 10, 15, 17, 28, 33, 38, 41, 47, 48, 49, 55, 59, 60, 62, 64, 66, 69, 70, 74, 77, 79, 82, 86, 89, 92, 93, 95, 98, 99, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] B = {2, 12, 25, 28, 30, 40, 48, 67, 82, 85, 91, 92, 94, 95, 97};
//        System.out.println(B.length);
        long startTime = System.nanoTime();
        int[] merged = merge1(A, B);
        long endTime = System.nanoTime();
        System.out.println("Time taken: " + (endTime - startTime));
        System.out.println(Arrays.toString(merged));
    }

    static int[] merge1(int[] a, int[] b) {
        int m = b.length;
        int n = a.length - m;
        int i = n - 1, j = m - 1;

        while (i >= 0 && j >= 0) {
            if (a[i] > b[j]) {
                a[i + j + 1] = a[i--];
            } else {
                a[i + j + 1] = b[j--];
            }
        }
        while (j >= 0) {
            a[j] = b[j--];
        }
        return a;
    }

    static int[] merge(int[] a, int[] b) {
        int m = b.length;
        int n = a.length - m;
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (a[i] <= b[j]) {
                i++;
            } else {
                int temp = b[j];
                for (int k = n; k > i; k--) {
                    a[k] = a[k - 1];
                }
                a[i] = temp;
                i++;
                j++;
                n++;
            }
        }
        while (j < m) {
            a[i++] = b[j++];
        }
        return a;
    }
}
