// Solution: Recursion w/ Memoization / DP
// Let win(n) denotes whether the current play will or not.
// Try all possible square numbers and see whether the other player will lose or not.
// win(n) = any(win(n -i*i) == False) ? True : False
// base case:win(0) = False
// Time complexity: O(nsqrt(n))
// Space complexity: O(n)
class Solution {
    private int[] cache;
    public boolean winnerSquareGame(int n) {
        cache = new int[n + 1];
        return win(n) > 0;
    }
    private int win(int n) {
        if (n == 0) return -1;
        if (cache[n] != 0) return cache[n];
        for (int i = (int)Math.sqrt(n); i >= 1; --i)
            if (win(n - i * i) < 0)
                return cache[n] = 1;
        return cache[n] = -1;
    }
}
