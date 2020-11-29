// // Solution: DFS with backtracking (set)
// // Time complexity: O(2^n)
// // Space complexity: O(kn)
// class Solution {
//     public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//         Set<List<Integer>> ans = new HashSet<List<Integer>>();
//         Arrays.sort(candidates);
//         List<Integer> cur = new ArrayList<Integer>();
//         dfs(candidates, target, 0, cur, ans);
//         return new ArrayList<List<Integer>>(ans);
//     }
//     private void dfs(int[] candidates, int target, int s, List<Integer> cur, Set<List<Integer>> ans) {
//         if (target == 0) {
//             ans.add(new ArrayList<Integer>(cur));
//             return;
//         }
        
//         for (int i = s; i < candidates.length; ++i) {
//             int num = candidates[i];
//             if (num > target) return;
//             cur.add(num);
//             dfs(candidates, target - num, i + 1, cur, ans);
//             cur.remove(cur.size() - 1);
//         }
//     }
// }

// Solution: DFS with backtracking (vector)
// 深度大的节点先被扩展，子节点为数组中所有序号比父节点大的数。
// Time complexity: O(2^n)
// Space complexity: O(kn) // k为答案的数量，n为元素的个数。
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
            if (num > target) return;
            if (i > s && candidates[i] == candidates[i - 1]) continue;
            cur.add(num);
            dfs(candidates, target - num, i + 1, ans, cur);
            cur.remove(cur.size() - 1);
        }
    }
}
