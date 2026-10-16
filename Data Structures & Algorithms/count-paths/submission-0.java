
class Solution {
    public int uniquePaths(int m, int n) {
        // We only need a 1D array representing the current row's path counts.
        int[] dp = new int[n];
        
        // Base case: There is exactly 1 way to reach any cell in the first row.
        Arrays.fill(dp, 1);
        
        // Iterate through the remaining rows
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // The new value of dp[j] is the sum of the cell above it (old dp[j]) 
                // and the cell to its left (dp[j-1])
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        
        // The last element contains the number of unique paths to the bottom-right corner
        return dp[n - 1];
    }
}
