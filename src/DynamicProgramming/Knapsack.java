package DynamicProgramming;

public class Knapsack {
    public static void main(String[] args) {

        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int W = 50;
        System.out.println(dpSolutionSpaceOPtimized(val, wt, W));
        System.out.println(dpSolution(val, wt, W));
        System.out.println(recursiveSolution(val, wt, W, 0));
        System.out.println(dpSolutionSuperSpaceOneDimensionalDPOPtimized(val,wt,W));
    }

    public static int recursiveSolution(int[] prices, int[] weights, int capacity, int i) {
        if (i == prices.length)
            return 0;
        int include = Integer.MIN_VALUE;
        int exclude = Integer.MIN_VALUE;
        if (weights[i] <= capacity) {
            include = prices[i] + recursiveSolution(prices, weights, capacity - weights[i], i + 1);
            exclude = recursiveSolution(prices, weights, capacity, i + 1);
            return Math.max(include, exclude);
        } else
            return recursiveSolution(prices, weights, capacity, i + 1);
    }

    private static int dpSolution(int[] prices, int[] weights, int capacity) {
        int[][] dp = new int[prices.length + 1][capacity + 1];

        for (int i = 1; i <= prices.length; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (weights[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], prices[i - 1] + dp[i - 1][j - weights[i - 1]]);
                } else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[prices.length][capacity];
    }

    private static int dpSolutionSpaceOPtimized(int[] prices, int[] weights, int capacity) {
        int[][] dp = new int[2][capacity + 1];
        int c = 0;
        for (int i = 1; i <= prices.length; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (weights[i - 1] <= j) {
                    dp[c][j] = Math.max(dp[c ^ 1][j], prices[i - 1] + dp[c ^ 1][j - weights[i - 1]]);
                } else
                    dp[c][j] = dp[c ^ 1][j];
            }
            c = c ^ 1;
        }
        return dp[c ^ 1][capacity];
    }

    private static int dpSolutionSuperSpaceOneDimensionalDPOPtimized(int[] prices, int[] weights, int capacity) {
        int[] dp = new int[capacity + 1];
        for (int i = 0; i < prices.length; i++) {
            for (int j = capacity; j >= 0; j--) {
                if (weights[i] <= j) {
                    dp[j] = Math.max(dp[j], prices[i ] + dp[j - weights[i]]);
                }
            }
        }
        /*think of it likes this
        * - For the i-1 th state we only use the values to the left of it in ith iteration. which basically mean
        * -when constructing solution for ith product we have to make sure we do not overurite the values to left of a capacity j for i-1 th iteration
        * since we need it for future solutions ,
        * since the values of capacity[j] of i-1 th iteration is requird to calculation answers of capacity[j+k] k>=0 for the ith iteration
        * which means we have to start from write to maxke solution of new state otherwise it will be over-riden if we start from left*/
        return dp[capacity];
    }

}
