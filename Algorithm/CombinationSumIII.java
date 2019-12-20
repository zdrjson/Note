class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();
        dfs(k, n, 1, cur, ans);
        return ans;
    }
    private void dfs(int k, int n, int s, List<Integer> cur, List<List<Integer>> ans) {
        if (k == 0) {
            if (n == 0) {
                ans.add(new ArrayList<Integer>(cur));
            }
            return;
        }
        for (int i = s; i <= 9; ++i) {
            if (i > n) {
                return;
            }
            cur.add(i);
            dfs(k - 1, n - i, i + 1, cur, ans);
            cur.remove(cur.size() - 1);
        }
    }
}
