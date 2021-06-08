class Solution {
public:
    int findMinDifference(vector<string>& timePoints) {
        constexpr int kMins = 24 * 60;
        set<int> seen;
        for (const string& time : timePoints) {
            int m = stoi(time.substr(0, 2)) * 60 + stoi(time.substr(3));
            if (!seen.insert(m).second) return 0;
        }
        
        int ans = (*seen.begin() - *seen.rbegin() + kMins) % kMins;
        const int* l = nullptr;
        for (const int& t : seen) {
            if (l) ans = min(ans, t - *l);
            l = &t;
        }
        return ans;
    }
};
