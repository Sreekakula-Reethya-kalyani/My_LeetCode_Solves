//Time Complexity: O(n)
//Space Complexity: O(n)

class Solution {
    public boolean isPalindrome(String s) {
        // Remove non-alphanumeric characters and convert to lowercase
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int left = 0, right = s.length() - 1;

        // Check palindrome by comparing characters from both ends
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
