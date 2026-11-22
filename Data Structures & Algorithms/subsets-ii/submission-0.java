
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // Sort the array to bring duplicates together
        Arrays.sort(nums);
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> currentSubset, int[] nums, int start) {
        // Add a copy of the current subset to the result
        result.add(new ArrayList<>(currentSubset));

        for (int i = start; i < nums.length; i++) {
            // Skip duplicate elements at the same tree level
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            // Include nums[i] in the current subset
            currentSubset.add(nums[i]);
            // Move to the next element
            backtrack(result, currentSubset, nums, i + 1);
            // Backtrack: remove the last added element
            currentSubset.remove(currentSubset.size() - 1);
        }
    }
}
