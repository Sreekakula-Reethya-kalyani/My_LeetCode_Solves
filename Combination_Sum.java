public class CombinationSum2 {
  
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // Sort candidates to handle duplicates and enable pruning
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> path, List<List<Integer>> result) {
        if (target == 0) { // Base case: target reached
            result.add(new ArrayList<>(path)); // Add the current combination to the result
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            // Skip duplicates at the same depth
            if (i > start && candidates[i] == candidates[i - 1]) continue;

            // If the current candidate exceeds the target, stop further exploration
            if (candidates[i] > target) break;

            // Include the current candidate in the path
            path.add(candidates[i]);

            // Recursively explore with the remaining target and the next index
            backtrack(candidates, target - candidates[i], i + 1, path, result);

            // Backtrack by removing the last added element
            path.remove(path.size() - 1);
        }
    }

/**
 * Time Complexity:
 * Sorting the array: O(n log n), where n is the number of elements in candidates.
 * Backtracking: In the worst case, we explore 2^n subsets (where n is the array size),
 * but pruning due to the target condition and skipping duplicates significantly reduces this.
 * Overall complexity is closer to O(2^n) in practice for smaller values of n.
 *
 * Space Complexity:
 * O(n) for the recursion stack and O(n) for the path list, resulting in O(n) overall.
 */
