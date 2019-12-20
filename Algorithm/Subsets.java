class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<>();
        for (int i = 0; i <= nums.length; ++i) {
            dfs(nums, i, 0, cur, ans);
        }
        return ans;
    }
    private void dfs(int[] nums, int n, int s, List<Integer> cur, List<List<Integer>> ans) {
        if (n == cur.size()) {
            ans.add(new ArrayList<Integer>(cur)); //这里一定要clone
            return;
        }
        for (int i = s; i < nums.length; ++i) {
            cur.add(nums[i]);
            dfs(nums, n, i + 1, cur, ans);
            cur.remove(cur.size() - 1);
        }
    }
}
