// // Solutiom: Brute Force
// // Try all combinations.
// // Time complexity: O(2^n)
// // Space complexity: O(n)
// // Iterative
// class Solution {
//     public int maxUniqueSplit(String s) {
//         final int n = s.length();
//         if (n == 1) return 1;
//         int ans = 1;
//         Set<String> seen = new HashSet<String>();
//         for (int m = 1; m < (1 << n - 1); ++m) {
//             if (Integer.bitCount(m) < ans) continue;
//             boolean valid = true;
//             int p = 0;
//             for (int i = 1; i <= n && valid; ++i) {
//                 if ((m & (1 << (i - 1))) != 0 || i == n) {
//                     valid &= seen.add(s.substring(p, i));
//                     p = i;
//                 }
//             }
//             if (valid) ans = Math.max(ans, seen.size());
//             seen.clear();
//         }
//         return ans;
//     }
// }

// DFS
class Solution {
    private int ans;
    private int n;
    private Set<String> seen;
    private String s;
    public int maxUniqueSplit(String s) {
        ans = 1;
        n = s.length();
        seen = new HashSet<String>();
        this.s = s;
        dfs(0);
        return ans;
    }
    private void dfs(int p) {
        if (p == n) {
            ans = Math.max(ans, seen.size());
            return;
        }
        for (int i = p; i < n; ++i) {
            String ss = s.substring(p, i + 1);
            if (!seen.add(ss)) continue;
            dfs(i + 1);
            seen.remove(ss);
        }
    }
}
