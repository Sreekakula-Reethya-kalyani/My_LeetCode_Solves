class Solution {
    public int removeDuplicates(int[] nums) {
        int n = 0; // Index for placing elements in the modified array
        
        // Using a HashMap to keep track of the occurrences of each element
        Map<Integer, Integer> map = new HashMap<>();
        
        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // Increment the count of the current element in the map
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            
            // If the count of the current element is less than or equal to 2,
            // place it in the resulting part of the array
            if (map.get(nums[i]) <= 2) {
                nums[n] = nums[i];
                n++;
            }
        }
        
        // Return the new length of the array with at most two duplicates
        return n;
    }
}

/*
Time Complexity:
1. Iterating through the array: O(n), where n is the length of the array.
2. HashMap operations (put, get, and getOrDefault): Each operation is O(1) on average.
   For n elements, the total remains O(n).
Overall Time Complexity: O(n)

Space Complexity:
1. HashMap storage: The map can store at most all distinct elements in the array.
   In the worst case, this takes O(n) space.
Overall Space Complexity: O(n)
*/
