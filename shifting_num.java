class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] shiftCounts = new int[n + 1];

        // Accumulate shifts in the shiftCounts array
        for (int[] shift : shifts) {
            int start = shift[0], end = shift[1], direction = shift[2];
            if (direction == 1) {
                shiftCounts[start] += 1;
                shiftCounts[end + 1] -= 1;
            } else {
                shiftCounts[start] -= 1;
                shiftCounts[end + 1] += 1;
            }
        }

        // Compute the prefix sum to calculate the net shifts for each character
        for (int i = 1; i < n; i++) {
            shiftCounts[i] += shiftCounts[i - 1];
        }

        // Apply the shifts to the string
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int effectiveShift = (shiftCounts[i] % 26 + 26) % 26; // Normalize shifts
            char newChar = (char) ((s.charAt(i) - 'a' + effectiveShift) % 26 + 'a');
            result.append(newChar);
        }

        return result.toString();
    }
