// Solution 1: DFS + backtracking
// Time complexity: C(m, k) = C(9, k) = 9! / k! / (9 - k)!
// Space complexity: C(k + k*# of ans)
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();
        dfs(k, n, 1, cur, ans);
        return ans;
    }
    // Use k numbers (>= s) to sum up to n
    private void dfs(int k, int n, int s, List<Integer> cur, List<List<Integer>> ans) {
        if (k == 0) {
            if (n == 0) ans.add(new ArrayList<Integer>(cur));
            return;
        }
        
        for (int i = s; i <= 9; ++i) {
            if (i > n) return;
            cur.add(i);
            dfs(k - 1, n - i, i + 1, cur, ans);
            cur.remove(cur.size() - 1);
        }
    }
}

// // Solution 2: Bit
// // Time complexity: O(2^m) = O(2^9)
// // Space complexity: O(k + k * # of ans)
// class Solution {
//     public List<List<Integer>> combinationSum3(int k, int n) {
//         List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
//         // 2^9, generate all combinations of [1 ... 9]
//         for (int i = 0; i < (1 << 9); ++i) {
//             List<Integer> cur = new ArrayList<>();
//             int sum = 0;
//             // Use j if (j - 1)-th bit is 1
//             for (int j = 1; j <= 9; ++j) {
//                 if ((i & 1 << (j - 1)) > 0) {
//                     sum += j;
//                     cur.add(j);
//                 }
//             }
//             if (sum == n && cur.size() == k)
//                 ans.add(cur);
//         }
//         return ans;
//     }
// } 
