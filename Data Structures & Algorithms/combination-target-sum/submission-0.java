
class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, target, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int index, int[] nums, int target, List<Integer> cur, List<List<Integer>> res) {
        // Base Case: Found a valid combination
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        
        // Base Case: Exceeded target or exhausted the array
        if (target < 0 || index >= nums.length) {
            return;
        }

        // Choice 1: Include nums[index]. Reduce target, keep index the same for reuse.
        cur.add(nums[index]);
        backtrack(index, nums, target - nums[index], cur, res);
        
        // Choice 2: Exclude nums[index] and skip to the next index.
        cur.remove(cur.size() - 1); // Backtrack step
        backtrack(index + 1, nums, target, cur, res);
    }
}
