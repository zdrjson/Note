// // Solution: DP
// // dp[i][j] := # of playlists of length i using j different songs.
// // dp[i][j] = dp[i - 1][j - 1] * (N - (j - 1)) + // Adding a new song. j - used, choose any one from (N - (j - 1)) unused.
// // dp[i - 1][j] * max(j - K, 0) // Resue an existing song.
// // Time complexity: O(LN)
// // Space complexity: O(LN) -> O(N)
// class Solution {
//     public int numMusicPlaylists(int N, int L, int K) {
//         long kMod = (int)1e9 + 7;
//         long[][] dp = new long[L + 1][N + 1]; // 要设置为long，否则越界。
//         dp[0][0] = 1;
//         for (int i = 1; i <= L; ++i)
//             for (int j = 1; j <= Math.min(i, N); ++j)
//                 dp[i][j] = (dp[i - 1][j - 1] * (N - (j - 1)) + 
//                             dp[i - 1][j] * Math.max(j - K, 0)) % kMod;
//         return (int)dp[L][N]; 
//     }
// }

// Time complexity: O(LN)
// Space complexity: O(N)
class Solution {
    public int numMusicPlaylists(int N, int L, int K) {
        long kMod = (int)1e9 + 7;
        long[] dp = new long[N + 1];
        for (int i = 1; i <= L; ++i) {
            dp[0] = i == 1 ? 1 : 0; // 这里暂时不太懂。
            for (int j = Math.min(i, N); j >= 1; --j) 
                dp[j] = (dp[j - 1] * (N - (j - 1)) + 
                         dp[j] * Math.max(j - K, 0)) % kMod;
        }
        return (int)dp[N];
    }
}
