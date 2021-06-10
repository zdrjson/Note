// 花花的代码暂时无法编译通过，改了第8，和第9行就能通过了。
class Solution {
public:
    vector<vector<int>> largeGroupPositions(string S) {
        constexpr int kLargeGroupSize = 3;
        const int n = S.size();
        vector<vector<int>> ans;
        int c = 1; 
        for (int i = 1; i <= n; ++i, ++c) {
            if (i == n || S[i] != S[i - 1]) {
                if (c >= kLargeGroupSize) ans.push_back({i - c, i - 1});
                c = 0;
            }
        }
        return ans;
    }
};
