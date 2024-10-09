package Labs.w2d1;

import java.util.Arrays;

public class Question1 {
    public static void main(String[] args) {
//        int[] colors = {1, 2, 1, 1, 2, 2, 2, 1, 2, 2, 1, 1, 1, 2, 1, 2, 2, 1, 1, 2};
//        int[] colors = {3, 2, 1, 1, 3, 2, 2, 3, 2, 3, 3, 1, 3, 2, 1, 2, 2, 3, 1, 2};
        int[] colors = {3, 4, 1, 5, 1, 5, 5, 2, 4, 5, 3, 3, 1, 4, 6, 1, 2, 2, 3, 4, 6};
        int k = 6;
        sortColors(colors, k, 0, colors.length - 1);
        System.out.println(Arrays.toString(colors));
    }
    static void sortColors(int[] nums, int k, int left, int right) {
        if (k == 1) {
            return;
        }
        int mid = k/2;
        int i = left, j = right;
        while (true) {
            while(i <= j && nums[i]%k < mid) i++;
            while(i <= j && nums[j]%k >= mid) j--;
            if(i > j) break;
            swap(nums, i, j);
        }
        sortColors(nums, mid, left, j);
        sortColors(nums, k - mid, i, right);
    }

    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
