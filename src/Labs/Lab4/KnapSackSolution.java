package Labs.Lab4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class KnapSackSolution {
    public static void main(String[] args) {
//        int[] w1 = {5, 6, 8, 2, 7};
//        int[] v1 = {25, 12, 24, 16, 28};
//        System.out.println(knapSack(20, w1, v1, w1.length));
        int[] w2 = {2, 5, 3, 4, 6};
        int[] v2 = {15, 12, 9, 16, 17};
        System.out.println(knapSack(12, w2, v2, w2.length));
    }

    static List<Character> knapSack(int W, int[] w, int[] v, int n) {
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                if (j < w[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else if (j >= w[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i - 1]] + v[i - 1]);
                }
            }
        }
        HashMap<Integer, Character> items = new HashMap<>();
        for (int i = 0; i < n; i++) {
            items.put(v[i] - w[i], (char) ('A' + i));
        }
        // Back-tracking
//        (81-28) = 53 | (20-7) = 13 -> e
//        (53-16) = 37 | (13-2) = 11 -> d
//        (37-12) = 25 | (13-6) = 7 -> b
//        (25-25) = 0 | (7-5) = 2 -> a
        if (dp[n][W] == 0) return new ArrayList<>();
        System.out.println("Max value = " + dp[n][W]);

        int weight = W, value = dp[n][W];
        List<Integer> w_v_list = new ArrayList<>();
        int i = n;
        while (i > 0) {
            if (dp[i][weight] == value && dp[i - 1][weight] != value) {
                w_v_list.add(v[i - 1] - w[i - 1]);
                weight -= w[i - 1];
                value -= v[i - 1];
            }
            i--;
        }

        List<Character> item_list = new ArrayList<>();
        for (Integer key : w_v_list) {
            item_list.add(items.getOrDefault(key, '#'));
        }
        return item_list;
    }
}
