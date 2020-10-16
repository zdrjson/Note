class Solution {
public:
    int maximumRequests(int n, vector<vector<int>>& requests) {
        const int r = requests.size();
        int ans = 0;
        vector<int> nets(n);
        for (int s = 0; s < 1 << r; ++s) {
            fill(begin(nets), end(nets), 0);
            for (int j = 0; j < r; ++j)
                if (s & (1 << j)) {
                    --nets[requests[j][0]];
                    ++nets[requests[j][1]];
                }
            if (all_of(begin(nets), end(nets), [](const int x) { return x == 0; }))
                ans = max(ans, __builtin_popcount(s));
        }
        return ans;
    }
};
