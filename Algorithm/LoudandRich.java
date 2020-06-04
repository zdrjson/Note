// Solution: DFS + memoization
// For persion i, remember the quietest person who is richer than persion i.
// Time complexity: O(n^2)
// Space complexity: O(n)
class Solution {
    private List<Integer>[] g;
    private int[] ans;
    private int[] quiet;
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        g = new List[n];
        for (int[] r : richer) {
            if (g[r[1]] == null) g[r[1]] = new ArrayList<Integer>();
            g[r[1]].add(r[0]);
        }
        ans = new int[n];
        Arrays.fill(ans, -1);
        this.quiet = quiet;
        for (int i = 0; i < n; ++i) dfs(i);
        return ans;
    }
    private void dfs(int i) {
        if (ans[i] != -1) return;
        ans[i] = i;
        if (g[i] == null) return;
        for (int j : g[i]) {
            dfs(j);
            if (quiet[ans[j]] < quiet[ans[i]])
                ans[i] = ans[j];
        }
    }
}
