class Solution {
public:
    int countGoodRectangles(vector<vector<int>>& rectangles) {
        int cur = 0;
        int ans = 0;
        for (const auto& r : rectangles) {
            if (min(r[0], r[1]) > cur) {
                cur = min(r[0], r[1]);
                ans = 0;
            }
            if (min(r[0], r[1]) == cur) ++ans;
        }
        return ans;
    }
};
