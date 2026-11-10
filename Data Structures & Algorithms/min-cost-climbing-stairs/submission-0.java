class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        // dp[i] represents the minimum cost to reach the i-th step
        int[] dp = new int[n + 1];
        
        // Base cases: starting at index 0 or index 1 costs nothing initially
        dp[0] = 0;
        dp[1] = 0;
        
        // Fill the DP table up to the top floor (index n)
        for (int i = 2; i <= n; i++) {
            int takeOneStep = dp[i - 1] + cost[i - 1];
            int takeTwoSteps = dp[i - 2] + cost[i - 2];
            dp[i] = Math.min(takeOneStep, takeTwoSteps);
        }
        
        return dp[n];
    }
}
