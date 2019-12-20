ass Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
       List<List<Integer>> ans = new ArrayList<List<Integer>>();
       List<Integer> cur = new ArrayList<>();
       Arrays.sort(candidates);
       for (int n = 1; n <= target / candidates[0]; ++n) {
           dfs(candidates, target, 0, 0, n, cur, ans);
       }
       return ans;
    }
    void dfs(int[] candidates, int target, int s, int d, int n, List<Integer> cur, List<List<Integer>> ans) {
        if (d == n) {
            if (target == 0) {
                ans.add(new ArrayList<Integer>(cur)); //一定要copy
            }
            return;
        }
        for (int i = s; i < candidates.length; ++i) {
            if (candidates[i] > target){
                break;
            }
            cur.add(candidates[i]);
            dfs(candidates, target - candidates[i], i, d + 1, n, cur, ans);
            cur.remove(cur.size() - 1);
        }
    }
}
