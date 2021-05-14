// Solution: Search
// Search from left to right, largest to smallest.
// Time complexity: O(n!)?
// Space complexity: O(n)
class Solution {
    private boolean dfs(int[] ans, int n, int i, int s) {
        if (i == ans.length) return true;
        if (ans[i] > 0) return dfs(ans, n, i + 1, s);
        for (int d = n; d > 0; --d) {
            int j = i + (d == 1 ? 0 : d);
            if ((s & (1 << d)) > 0 || j >= ans.length || ans[j] > 0)
                continue;
            ans[i] = ans[j] = d;
            if (dfs(ans, n, i + 1, s | (1 << d))) return true;
            ans[i] = ans[j] = 0;
        }
        return false;
    }
    public int[] constructDistancedSequence(int n) {
        int[] ans = new int[n * 2  - 1];
        dfs(ans, n, 0, 0);
        return ans;
    }
}
