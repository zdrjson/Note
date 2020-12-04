class Solution {
public:
    int maximumWealth(vector<vector<int>>& accounts) {
        int ans = 0;
        for (const vector<int>& row : accounts)
            ans = max(ans, accumulate(begin(row), end(row), 0));
        return ans;
    }
};
