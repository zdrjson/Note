// Solution: BST + Greedy
// Start from the smallest available number and find k consecutive numbers.
// Time complexity: O(nlogn)
// Space complexity: O(n)
class Solution {
public:
    bool isPossibleDivide(vector<int>& nums, int k) {
        if (nums.size() % k) return false;
        map<int, int> m;
        for (int num : nums) ++m[num];
        while (m.size()) {
            const int s = m.cbegin()->first;
            for (int i = 0; i < k; ++i) {
                auto it = m.find(s + i);
                if (it == m.cend()) return false;
                if (--it->second == 0) m.erase(it);
            }
        }
        return true;
    }
};

// // Solution: BST + Greedy v2
// // Time complexity: O(nlogn)
// // Space complexity: O(n)
// class Solution {
// public:
//     bool isPossibleDivide(vector<int>& nums, int k) {
//         if (nums.size() % k) return false;
//         map<int, int> m;
//         for (int num : nums) ++m[num];
//         while (m.size()) {
//             auto it = m.begin();
//             const int s = it->first;
//             for (int i = 0; i < k; ++i, ++it) {
//                 if (it->first != s + i) return false;
//                 if (--it->second == 0) m.erase(it);
//             }
//         }
//         return true;
//     }
// };

// // Solution: HashTable
// // Time complexity: O(n)
// // Space complexity: O(n)
// class Solution {
// public:
//     bool isPossibleDivide(vector<int>& nums, int k) {
//         if (nums.size() % k) return false;
//         unordered_map<int, int> m;
//         for (int num : nums) ++m[num];
//         queue<int> starts;
//         for (auto [n, f] : m)
//             if (!m.count(n - 1)) starts.push(n);
//         while (!starts.empty()) {
//             int s = starts.front();
//             starts.pop();
//             for (int t = s + k - 1; t >= s; t--) {
//                 if (m[t] < m[s]) return false;
//                 if ((m[t] -= m[s]) == 0) {
//                     m.erase(t);
//                     if (m.count(t + 1)) starts.push(t + 1);
//                 }
//             }
//         }
//         return true;
//     }
// };
