class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        List<Integer> cur = new ArrayList<Integer>();
        dfs(candidates, target, 0, ans, cur);
        return ans;
    }
    private void dfs(int[] candidates, int target, int s, List<List<Integer>> ans, List<Integer> cur) {
        if (target == 0) {
            ans.add(new ArrayList<Integer>(cur));
            return;
        }
        for (int i = s; i < candidates.length; ++i) {
            int num = candidates[i];
            if (num > target) {
                break;
            }
            if (i > s && candidates[i] == candidates[i - 1]) {
                continue;
            }
            cur.add(num);
            dfs(candidates, target - num, i + 1, ans, cur);
            cur.remove(cur.size() - 1);
        }
    }
}

