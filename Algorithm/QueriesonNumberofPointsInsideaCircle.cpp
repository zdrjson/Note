class Solution {
public:
    vector<int> countPoints(vector<vector<int>>& points, vector<vector<int>>& queries) {
        vector<int> ans;
        ans.reserve(queries.size());
        for (const auto& q : queries) {
            const int rs = q[2] * q[2];
            int cnt = 0;
            for (const auto& p : points)
                if ((q[0] - p[0]) * (q[0] - p[0]) + 
                    (q[1] - p[1]) * (q[1] - p[1]) <= rs)
                    ++cnt;
            ans.push_back(cnt);
        }
        return ans;
    }
};
