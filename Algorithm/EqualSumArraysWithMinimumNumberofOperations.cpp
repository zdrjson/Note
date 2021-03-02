class Solution {
public:
    int minOperations(vector<int>& nums1, vector<int>& nums2) {
        const int l1 = nums1.size();
        const int l2 = nums2.size();
        if (min(l1, l2) * 6 < max(l1, l2)) return -1;
        int s1 = accumulate(begin(nums1), end(nums1), 0);
        int s2 = accumulate(begin(nums2), end(nums2), 0);
        if (s1 > s2) return minOperations(nums2, nums1);
        sort(begin(nums1), end(nums1));
        sort(begin(nums2), end(nums2));
        int ans = 0;
        int i = 0;
        int j = l2 - 1;
        while (s1 != s2) {
            const int diff = s2 - s1;
            if (j == l2 || (i != l1 && 6 - nums1[i] >= nums2[j] - 1)) {
                const int x = min(6, nums1[i] + diff);
                s1 += x - nums1[i++];
            } else {
                const int x = max(1, nums2[j] - diff);
                s2 += x - nums2[j--];
            }
            ++ans;
        }
        return ans;
    }
};
