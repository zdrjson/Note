// Solution: DP
// dp[i][j] := # of strings of length i ends with j.
// dp[i][j] = sum(dp[i - 1][k]) 0 <= k <= j
// Time complexity: O(n)
// Space complexity: O(n) -> O(1)
// O(n) Space
class Solution {
    public int countVowelStrings(int n) {
        // dp[i][j] := # of strings of length i ends with j.
        int[][] dp = new int[n + 1][5];
        for (int[] e : dp)
            Arrays.fill(e, 1);
        for (int i = 2; i <= n; ++i) {
            int s = 0;
            for (int j = 0; j < 5; ++j) {
                s += dp[i - 1][j];
                dp[i][j] = s;
            }
        }
        int ans = 0;
        for (int e : dp[n])
            ans += e;
        return ans;
    }
}

// // O(1) Space
// class Solution {
//     public int countVowelStrings(int n) {
//         // dp([i])[j] := of strings of length i ends with j.
//         int[] dp = new int[5];
//         Arrays.fill(dp, 1);
//         for (int i = 2; i <= n; ++i)
//             for (int j = 4; j >= 0; --j)
//                 for (int k = 0; k < j; ++k)
//                     dp[j] += dp[k];
//         int ans = 0;
//         for (int e : dp)
//             ans += e;
//         return ans;
//     }
// }
