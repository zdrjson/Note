// Solution: Math
// 1: Find the mean (final value) of the array, assuming x, easy to show x == n
// 2: Compute the sum of an arithmetic progression of (x - 1) + (x - 3) + ... for n // 2 pairs
// e.g n = 6
// arr = [1, 3, 5, 7, 9, 11]
// x = (a + 2 * n - 1) / 2 = 6 = n
// steps = (6 - 1) + (6 - 3) + (6 - 5) = (n // 2) * (n - (1 + n - 1) / 2) = (n // 2) * (n - n // 2) = 3 * 3 = 9
// e.g n = 5
// arr = [1, 3, 5, 7, 9]
// x = (1 + 2 * n - 1) / 2 = 5 = n
// steps = (5 - 1) + (5 - 3)=(n//2) * (n - n // 2) = (n // 2) * ((n + 1) // 2) = 2 * 3 = 6
// Time complexity: O(1)
// Space complexity: O(1)
class Solution {
    public int minOperations(int n) {
        return (n / 2) * ((n + 1) / 2);
    }
}
