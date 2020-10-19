class Solution {
public:
    vector<int> bestCoordinate(vector<vector<int>>& towers, int radius) {
        constexpr int n = 50;
        vector<int> ans;
        int max_q = 0;
        for (int x = 0; x <= n; ++x)
            for (int y = 0; y <= n; ++y) {
                int q = 0;
                for (const auto& tower: towers) {
                    const int tx = tower[0], ty = tower[1];
                    const float d = sqrt((x - tx) * (x - tx) + (y - ty) * (y - ty));
                    if (d > radius) continue;
                    q += floor(tower[2] / (1 + d));
                }
                if (q > max_q) {
                    max_q = q;
                    ans= {x, y};
                }
            }
        return ans;
    }
};
