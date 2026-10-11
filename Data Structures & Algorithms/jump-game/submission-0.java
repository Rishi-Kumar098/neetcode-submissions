class Solution {
    public boolean canJump(int[] nums) {
        // Set the initial goal to the last index
        int goal = nums.length - 1;
        
        // Iterate backwards from the second-to-last index down to 0
        for (int i = nums.length - 2; i >= 0; i--) {
            // If the current index can reach or surpass the current goal
            if (i + nums[i] >= goal) {
                // Move the goal closer to the start
                goal = i;
            }
        }
        
        // If the goal reached the starting index, return true
        return goal == 0;
    }
}
