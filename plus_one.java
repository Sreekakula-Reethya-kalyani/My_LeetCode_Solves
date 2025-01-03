class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        // Traverse from the last digit to the first
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits; // Return the array as no carry is needed
            }
            digits[i] = 0; // Set to 0 if carry is required
        }

        // If all digits were 9, we need an additional digit
        int[] result = new int[n + 1];
        result[0] = 1; // Add the leading 1
        return result;
    }
}
