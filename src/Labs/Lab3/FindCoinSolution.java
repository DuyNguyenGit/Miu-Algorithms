package Labs.Lab3;

public class FindCoinSolution {
    public static void main(String[] args) {
        System.out.println(findCoin(new int[]{2, 2, 2, 2, 2, 2, 2, 2, 1}, 9));
        System.out.println(findCoin(new int[]{5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 3, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5}, 27));
    }

    static int findCoin(int[] coins, int numOfCoins) {
        if (numOfCoins == 1) return coins[0];

        int numOfCoinsInOneBag = numOfCoins / 3;
        int[] bag1 = new int[numOfCoinsInOneBag];
        int[] bag2 = new int[numOfCoinsInOneBag];
        int[] bag3 = new int[numOfCoinsInOneBag];

        for (int i = 0; i < numOfCoins; i++) {
            if (i < numOfCoinsInOneBag) {
                bag1[i] = coins[i];
            } else if (i < 2 * numOfCoinsInOneBag) {
                bag2[i - numOfCoinsInOneBag] = coins[i];
            } else {
                bag3[i - 2 * numOfCoinsInOneBag] = coins[i];
            }
        }
        int bag1Weight = sum(bag1);
        int bag2Weight = sum(bag2);

        int lesserCoin;
        if (bag1Weight == bag2Weight) {
            lesserCoin = findCoin(bag3, numOfCoinsInOneBag);
        } else if (bag1Weight > bag2Weight) {
            lesserCoin = findCoin(bag2, numOfCoinsInOneBag);
        } else {
            lesserCoin = findCoin(bag1, numOfCoinsInOneBag);
        }
        return lesserCoin;
    }

    static int sum(int[] A) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        return sum;
    }


}
