// class Solution {
// public:
//     int findLHS(vector<int>& nums) {
//         unordered_map<int, int> counts;
//         int ans = 0;
//         for (int num : nums) {
//             ++counts[num];
//             int l = counts[num - 1];
//             int h = counts[num + 1];
//             if (l || h)
//                 ans = max(ans, counts[num] + max(l, h));
//         }
//         return ans;
//     }
// };

// class Solution {
// public:
//     int findLHS(vector<int>& nums) {
//         unordered_map<int, int> counts;
//         int ans = 0;
//         for (int num : nums) {
//             const int c = ++counts[num];
//             auto it1 = counts.find(num - 1);
//             auto it2 = counts.find(num + 1);
//             if (it1 != counts.end())
//                 ans = max(ans, c + it1->second);
//             if (it2 != counts.end())
//                 ans = max(ans, c + it2->second);
//         }
//         return ans;
//     }
// };

class Solution {
public:
    int findLHS(vector<int>& nums) {
        unordered_map<int, int> counts;
        int ans = 0;
        for (int num : nums)
            ++counts[num];
        
        for (const auto& p : counts) {
            auto it1 = counts.find(p.first - 1);
            auto it2 = counts.find(p.first + 1);
            if (it1 != counts.end())
                ans = max(ans, p.second + it1->second);
            if (it2 != counts.end())
                ans = max(ans, p.second + it2->second);
        }
        return ans;
    }
};
