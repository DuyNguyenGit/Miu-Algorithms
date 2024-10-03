package Labs.Lab3;

public class TheMasterTheorem {
    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(findMax(A, 0, 8));
    }
    // T(n) = 2T(n/2) + c => a = 2, b = 2, k = 0 => a > b^k => According to The Master Theorem: T(n) = theta(n^logba) = theta(n^log22) = theta(n)
    static int findMax(int[] arr, int lower, int upper) {
        if(lower == upper) {
            return arr[lower];
        }
        int mid = (lower + upper) / 2;
        int left = findMax(arr, lower, mid);
        int right = findMax(arr, mid + 1, upper);
        return Math.max(left, right);
    }
}
