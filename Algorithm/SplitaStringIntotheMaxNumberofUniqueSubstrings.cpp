// // Iteratvie
// class Solution {
// public:
//     int maxUniqueSplit(string_view s) {
//         const int n = s.length();
//         if (n == 1) return 1;
//         size_t ans = 1;
//         unordered_set<string_view> seen;
//         for (int m = 0; m < 1 << (n - 1); ++m) {
//             if (__builtin_popcount(m) < ans) continue; // 956ms - > 52ms
//             bool valid = true;
//             int p = 0;
//             for (int i = 1; i <= n && valid; ++i) {
//                 if (m & (1 << (i - 1)) || i == n) {
//                     valid &= seen.insert(s.substr(p, i - p)).second;
//                     p = i;
//                 }
//             }
//             // // 下面注释的代码是花花PPT中的，其实和上面一样，只是循环范围不同。
//             // for (int i = 0; i < n && valid; ++i) {
//             //     if (m & (1 << i) || i == n - 1) {
//             //         valid &= seen.insert(s.substr(p, i - p + 1)).second;
//             //         p = i + 1;
//             //     }
//             // }
//             if (valid) ans = max(ans, seen.size());
//             seen.clear();
//         }
//         return ans; 
//     }
// };

// DFS
class Solution {
public:
    int maxUniqueSplit(string_view s) {
        size_t ans = 1;
        const int n = s.length();
        unordered_set<string_view> seen;
        function<void(int)> dfs = [&](int p) {
            if (p == n) {
                ans = max(ans, seen.size());
                return;
            }
            for (int i = p; i < n; ++i) {
                string_view ss = s.substr(p, i - p + 1);
                if (!seen.insert(ss).second) continue;
                dfs(i + 1);
                seen.erase(ss);
            }
        };
        dfs(0);
        return ans;
    }
};
