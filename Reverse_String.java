class Solution {
    public void reverseString(char[] s) {
        // Time Complexity: O(n) 
        // - We iterate through half the array (n/2 iterations), which simplifies to O(n).
        
        // Space Complexity: O(1) 
        // - We use a constant amount of extra space (the temp variable).

       // Initialize two pointers: 
       // i starts at the beginning of the array, and j starts at the end.

      
        for (int i = 0, j = s.length - 1; i < j; i++, j--) {
            // Swap the characters at indices i and j.
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
    }
}
