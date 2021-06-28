// 输出长度顺序不是从小到大
// class Solution {
// public:
//     vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
//         vector<vector<int>> ans;
//         vector<int> cur;
//         std::sort(candidates.begin(), candidates.end());
//         dfs(candidates, target, 0, cur, ans);
//         return ans;
//     }
// private:
//     void dfs(vector<int>& candidates, int target, int s, vector<int>& cur, vector<vector<int>>& ans) {
//         if (target == 0) {
//             ans.push_back(cur);
//             return;
//         }
        
//         for (int i = s; i < candidates.size(); ++i) {
//             if (candidates[i] > target) break;
//             cur.push_back(candidates[i]);
//             dfs(candidates, target - candidates[i], i, cur, ans);
//             cur.pop_back();
//         }
//     }
// };

// 输出长度顺序从小到大
class Solution {
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<vector<int>> ans;
        vector<int> cur;
        std::sort(candidates.begin(), candidates.end());
        for (int n = 1; n <= target / candidates[0]; ++n)
            dfs(candidates, target, 0, 0, n, cur, ans);
        return ans;
    }
private:
    void dfs(vector<int>& candidates, int target, int s, int d, int n, vector<int>& cur, vector<vector<int>>& ans) {
        if (d == n) {
            if (target == 0) ans.push_back(cur);
            return;
        }
        for (int i = s; i < candidates.size(); ++i) {
            if (candidates[i] > target) break;
            cur.push_back(candidates[i]);
            dfs(candidates, target - candidates[i], i, d + 1, n, cur, ans);
            cur.pop_back();
        }
    }
};
