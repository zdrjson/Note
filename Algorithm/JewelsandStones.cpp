// // Solution 1: HashTable
// // Time complexity： O(|J| + |S|)
// // Space complexity: O(128) / O(|J|)
// class Solution {
// public:
//     int numJewelsInStones(string J, string S) {
//         std::vector<int> f(128, 0);
//         int ans = 0;
//         for (const char j : J)
//             f[j] = 1;
//         for (const char s : S)
//             ans += f[s] & 1;
//         return ans;
//     }
// };

// v2
class Solution {
public:
    int numJewelsInStones(string J, string S) {
        std::set<char> f(J.begin(), J.end());
        return std::count_if(S.begin(), S.end(),
                             [&f](const char c) { return f.count(c); });
    }
};
