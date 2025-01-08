class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i = 0;
        int j = 0;
        StringBuilder t = new StringBuilder(); // Use StringBuilder for efficient concatenation.

        // Merge characters alternately from word1 and word2
        while (i < word1.length() && j < word2.length()) {
            t.append(word1.charAt(i)).append(word2.charAt(j));
            i++;
            j++;
        }

        // Append remaining characters of word1, if any
        while (i < word1.length()) {
            t.append(word1.charAt(i));
            i++;
        }

        // Append remaining characters of word2, if any
        while (j < word2.length()) {
            t.append(word2.charAt(j));
            j++;
        }

        return t.toString(); // Convert StringBuilder to String and return
    }
}

/*
Time Complexity:
- The while loops iterate through the lengths of word1 and word2. Let n = word1.length() and m = word2.length().
- Total iterations = n + m.
- StringBuilder's append operation is O(1).
- Therefore, the overall time complexity is O(n + m).

Space Complexity:
- StringBuilder uses O(n + m) space for the final merged string.
- There is no additional overhead for intermediate string creation as in the previous implementation.

This optimized approach significantly reduces the time complexity and memory overhead caused by repeated string concatenations.
*/
