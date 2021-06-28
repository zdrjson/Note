// Solution: DFS
// Time complexity: O(2^n) let s = target / min(nums[i]) T = c(s, 1) + c(s, 2) + ... + c(s, s) = 2^s
// Space complexity: O(n) O(target / min(nums[i]))
// 输出顺序从小的长度个数到大的长度个数排序
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
       List<List<Integer>> ans = new ArrayList<List<Integer>>();
       List<Integer> cur = new ArrayList<>();
       Arrays.sort(candidates);
       for (int n = 1; n <= target / candidates[0]; ++n) 
           dfs(candidates, target, 0, 0, n, cur, ans);
       return ans
    }
    private void dfs(int[] candidates, int target, int s, int d, int n, List<Integer> cur, List<List<Integer>> ans) {
        if (d == n) {
            if (target == 0) ans.add(new ArrayList<Integer>(cur)); //一定要copy
            return;
        }
        
        for (int i = s; i < candidates.length; ++i) {
            if (candidates[i] > target) break;
            cur.add(candidates[i]);
            dfs(candidates, target - candidates[i], i, d + 1, n, cur, ans);
            cur.remove(cur.size() - 1);
        }
    }
}

// // Solution: DFS
// // 输出的长度顺序不是从小到大
// // Time complexity: O(2^n)
// // Space complexity: O(n)
// class Solution {
//     public List<List<Integer>> combinationSum(int[] candidates, int target) {
//         List<List<Integer>> ans = new ArrayList<List<Integer>>();
//         List<Integer> cur = new ArrayList<Integer>();
//         Arrays.sort(candidates);
//         dfs(candidates, target, 0, cur, ans);
//         return ans;
//     }
//     private void dfs(int[] candidates, int target, int s, List<Integer> cur, List<List<Integer>> ans) {
//         if (target == 0) {
//             ans.add(new ArrayList<Integer>(cur));
//             return;
//         }
//         for (int i = s; i < candidates.length; ++i) {
//             if (candidates[i] > target) break;
//             cur.add(candidates[i]);
//             dfs(candidates, target - candidates[i], i, cur, ans);
//             cur.remove(cur.size() - 1);
//         }
//     }
// }


