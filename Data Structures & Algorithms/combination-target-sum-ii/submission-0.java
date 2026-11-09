
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // Sort to bring duplicate elements together and optimize pruning
        Arrays.sort(candidates);
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> currentList, int[] candidates, int remain, int start) {
        // Base Case 1: Target reached
        if (remain == 0) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // Early pruning: Since the array is sorted, if the current number is 
            // larger than the remaining target, no future elements will fit either.
            if (candidates[i] > remain) {
                break;
            }

            // Skip duplicate elements at the same recursive level
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            // Make a choice
            currentList.add(candidates[i]);
            
            // Move to the next element (i + 1 ensure each element is used at most once)
            backtrack(result, currentList, candidates, remain - candidates[i], i + 1);
            
            // Undo the choice (Backtrack)
            currentList.remove(currentList.size() - 1);
        }
    }
}
