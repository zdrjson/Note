// Solution: Brute Force
// Try all numbers from 1 to n - 1.
// Time complexity: O(n) TLE for prime numbers
// Space complexity: O(1)
// Solution: Math
// Try all numbers from 2 to sqrt(n).
// If number i is a divisor of n then n/i is another one.
// Be careful about the case when i == n/i, only one should be added to the sum.
// Time complexity: O(sqrt(n))
// Space complexity: O(1)
class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num <= 1) return false;
        int sum = 1;
        for (int i = 2; i <= (int)Math.sqrt(num); ++i)
            if (num % i == 0) sum += i + ((i == num / i) ? 0 : num / i);
        return sum == num;
    }
}
