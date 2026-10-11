class Solution {
    public int maxSubArray(int[] nums) {
        // Initialize with the first element of the array
        int maxSoFar = nums[0];
        int currentSum = nums[0];
        
        // Traverse through the rest of the array
        for (int i = 1; i < nums.length; i++) {
            // Decide whether to extend the current subarray or start a new one
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            
            // Update the global maximum sum found so far
            maxSoFar = Math.max(maxSoFar, currentSum);
        }
        
        return maxSoFar;
    }
}
