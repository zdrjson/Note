// // Solution: DP / Bitmask
// // Variant 1:
// class Solution {
// public:
//     int minNumberOfSemesters(int n, vector<vector<int>>& dependencies, int k) {
//       const int S = 1 << n;
//       vector<int> deps(n); // deps[i] = dpendency mask for course i.
//       for (const auto& d : dependencies)
//         deps[d[1] - 1] |= 1 << (d[0] - 1);
//       // dp(i)[s] := reachable(s) at semester i.
//       vector<int> dp(S);
//       dp[0] = 1;
//       for (int d = 1; d <= n; ++d) { // at most n semesters.
//         vector<int> tmp(S); // start a new semesters.
//         for (int s = 0; s < S; ++s) {
//             if (!dp[s]) continue; // not a reachable state.
//             int mask = 0;
//             for (int i = 0; i < n; ++i)
//                 if (!(s & (1 << i)) && (s & deps[i]) == deps[i])
//                     mask |= (1 << i);
//             // Pruning, take all.
//             if (__builtin_popcount(mask) <= k) {
//                 tmp[s | mask] = 1;
//             } else {
//                 // Try all subsets.
//                 for (int c = mask; c; c = (c - 1) & mask)
//                   if (__builtin_popcount(c) <= k) {
//                       tmp[s | c] = 1;
//                   }
//             }
//             if (tmp.back()) return d;
//         }
//         dp.swap(tmp);
//       }
//       return -1;
//     }
// };

// Variant 2:
class Solution {
public:
  int minNumberOfSemesters(int n, vector<vector<int>>& dependencies, int k) {
    const int kInf = 1e9;
    const int S = 1 << n;
    vector<int> deps(n); // deps[i] = dependency mask for course i.
    for (const auto& d : dependencies)
      deps[d[1] - 1] |= 1 << (d[0] - 1);
    // dp[m] := min semesters to reach state m.
    vector<int> dp(S, kInf);
    dp[0] = 0;
    for (int s = 0; s < S; ++s) {
        if (dp[s] == kInf) continue; // not reachable.
        // Generate a mask of courses we can study under state s.
        int mask = 0;
        for (int i = 0; i < n; ++i)
            if (!(s & (1 << i)) && (s & deps[i]) == deps[i])
                mask |= (1 << i);
        // Pruning, take all.
        if (__builtin_popcount(mask) <= k) {
            dp[s | mask] = min(dp[s | mask], dp[s] + 1);
        } else {
            // Try all subsets.
            for (int c = mask; c; c = (c - 1) & mask)
              if (__builtin_popcount(c) <= k)
                  dp[s | c] = min(dp[s | c], dp[s] + 1);
        }
        // Early termination?
        if (dp.back() != kInf) return dp.back();
    }
    return dp.back();
  }
};
