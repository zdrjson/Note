class Solution {
public:
    int minAbsoluteSumDiff(vector<int>& nums1, vector<int>& nums2) {
        constexpr int kMod = 1e9 + 7;
        const int n = nums1.size();
        long ans = 0;
        int gain = 0;
        set<int> s(begin(nums1), end(nums1));
        for (int i = 0; i < n; ++i) {
            const int diff = abs(nums1[i] - nums2[i]);
            ans += diff;
            if (diff <= gain) continue;
            auto it = s.lower_bound(nums2[i]);
            if (it != s.end())
                gain = max(gain, diff - abs(*it - nums2[i]));
            if (it != s.begin())
                gain = max(gain, diff - abs(*prev(it) - nums2[i]));
        }
        return (ans - gain) % kMod;
    }
};
