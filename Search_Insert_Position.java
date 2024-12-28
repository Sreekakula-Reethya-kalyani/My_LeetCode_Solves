class Solution {
    public int searchInsert(int[] nums, int target) {
        // Time Complexity: O(log n)
        // Space Complexity: O(1)

        int l = 0;
        int r = nums.length - 1;

        // Binary search loop
        while (l <= r) {
            int mid = l + (r - l) / 2;  // Avoid overflow while calculating mid

            if (nums[mid] == target) {
                return mid;  // If target is found, return the index
            } else if (nums[mid] < target) {
                l = mid + 1;  // If target is larger, move left boundary to the right
            } else {
                r = mid - 1;  // If target is smaller, move right boundary to the left
            }
        }

        // If target is not found, return the index where it should be inserted
        return l;
    }
}
