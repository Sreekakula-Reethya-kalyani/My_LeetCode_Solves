class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // Time Complexity: O(flowerbed.length) -> Single iteration through the flowerbed array
        // Space Complexity: O(1) -> In-place modification of the array, no extra space used
        int count = 0; // To count the number of flowers that can be planted

        for (int i = 0; i < flowerbed.length; i++) { // Loop through the flowerbed array
            // Check if the current plot is empty (0) and its adjacent plots are also empty or at bounds
            if (flowerbed[i] == 0 &&
                (i == 0 || flowerbed[i - 1] == 0) &&
                (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1; // Plant a flower in the current plot
                count++; // Increment the planted flowers count
            }

            if (count >= n) { // If we have planted enough flowers, return true
                return true;
            }
        }

        // Return false if not enough flowers can be planted
        return false;
    }
}
