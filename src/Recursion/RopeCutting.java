package Recursion;

public class RopeCutting {

    public static void main(String[] args) {
        System.out.println(maxPiecesOfRope(5, new int[]{2, 5, 1}));
        System.out.println(maxPiecesOfRope(23, new int[]{12, 9, 11,2,3}));
    }

    public static int maxPiecesOfRope(int n, int[] possibleLengths) {
        if (n < 0)
            return Integer.MIN_VALUE;
        if (n == 0)
            return 0;

        int max = 0;
        for (int i = 0; i < possibleLengths.length; i++) {
            if (possibleLengths[i] <= n) {
                int ans = maxPiecesOfRope(n - possibleLengths[i], possibleLengths);
                if (ans != Integer.MIN_VALUE) {
                    max = Math.max(max, 1 + ans);
                }
            }
        }
        return max;
    }
}
