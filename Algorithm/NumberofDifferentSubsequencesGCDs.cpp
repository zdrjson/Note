class Solution {
public:
    int countDifferentSubsequenceGCDs(vector<int>& nums) {
        const int kMax = *max_element(begin(nums), end(nums));
        vector<int> s(kMax + 1);
        for (int x : nums) s[x] = 1;
        int ans = 0;
        for (int i = 1; i <= kMax; ++i) {
            int g = 0;
            for (int j = i; j <= kMax; j += i)
                if (s[j]) g = gcd(g, j);
            ans += g == i;
        }
        return ans;
    }
};
