import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//time complexity O(n^2)
//Space Complexity: O(n)

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // Target sum we are looking for
        int target = 0;
        
        // Sort the array to enable the two-pointer technique
        Arrays.sort(nums);
        
        // A Set to store unique triplets (no duplicates allowed)
        Set<List<Integer>> s = new HashSet<>();
        
        // List to store the final result (list of triplets)
        List<List<Integer>> output = new ArrayList<>();
        
        // Loop through the array, starting from the first element
        for (int i = 0; i < nums.length; i++) {
            // Left pointer (j) starts just after the current element
            int j = i + 1;
            
            // Right pointer (k) starts at the last element of the array
            int k = nums.length - 1;
            
            // Two-pointer approach: iterate until the left and right pointers meet
            while (j < k) {
                // Calculate the sum of the three elements
                int sum = nums[i] + nums[j] + nums[k];
                
                if (sum == target) {
                    // If the sum is 0, we've found a valid triplet
                    // Add the triplet to the set (Set automatically handles duplicates)
                    s.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    
                    // Move both pointers inward to find the next potential triplet
                    j++;
                    k--;
                } else if (sum < target) {
                    // If the sum is less than 0, move the left pointer to the right to increase the sum
                    j++;
                } else {
                    // If the sum is greater than 0, move the right pointer to the left to decrease the sum
                    k--;
                }
            }
        }
        
        // Add all unique triplets from the set to the output list
        output.addAll(s);
        
        // Return the final list of unique triplets
        return output;
    }
}
