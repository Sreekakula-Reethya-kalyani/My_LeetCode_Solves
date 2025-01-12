#include <climits>
using namespace std;

class Solution {
public:
    int divide(int dividend, int divisor) {
        // Handle overflow cases
        if (dividend == INT_MIN && divisor == -1) return INT_MAX; // Prevent overflow
        if (dividend == INT_MIN && divisor == 1) return INT_MIN;  // Edge case

        // Determine the sign of the result
        bool negative = (dividend < 0) ^ (divisor < 0);

        // Take absolute values of dividend and divisor (cast to long long to avoid overflow)
        long long absDividend = abs((long long)dividend);
        long long absDivisor = abs((long long)divisor);

        int quotient = 0;

        // Time Complexity: O(log(absDividend))
        // - The outer loop reduces `absDividend` logarithmically since `tempDivisor` is doubled in the inner loop.
        // - The inner loop shifts `tempDivisor` left until it exceeds `absDividend`.
        while (absDividend >= absDivisor) {
            long long tempDivisor = absDivisor, multiple = 1;

            // Inner loop: Doubling the divisor until it exceeds the remaining dividend
            while (absDividend >= (tempDivisor << 1)) {
                tempDivisor <<= 1; // Multiply divisor by 2
                multiple <<= 1;    // Track the corresponding multiple
            }

            absDividend -= tempDivisor; // Subtract the largest possible multiple of divisor
            quotient += multiple;       // Add the multiple to the result
        }

        // Space Complexity: O(1)
        // - Uses only a constant amount of space for variables (`tempDivisor`, `multiple`, `quotient`, etc.).
        // - No additional data structures are created.

        return negative ? -quotient : quotient; // Return the quotient with the appropriate sign
    }
};
