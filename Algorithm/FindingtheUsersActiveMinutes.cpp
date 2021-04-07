class Solution {
public:
    vector<int> findingUsersActiveMinutes(vector<vector<int>>& logs, int k) {
        unordered_map<int, unordered_set<int>> m;
        vector<int> ans(k);
        for (const auto& log : logs)
            m[log[0]].insert(log[1]);
        for (const auto& [id, s] : m)
            ++ans[s.size() - 1];
        return ans;
    }
};
