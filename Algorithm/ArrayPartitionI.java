class Solution {
    public int arrayPairSum(int[] nums) {
        // Solution 1 O(nlogn)
        // Arrays.sort(nums);
        // int ans = 0;
        // for (int i = 0; i < nums.length; i += 2) {
        //     ans += nums[i];
        // }
        // return ans;
        
        // Solution 2 O(n)
        int kMaxValue = 10000;
        int[] c = new int[2 * kMaxValue + 1];
        for (int num : nums) {
            ++c[num + kMaxValue];
        }
        int ans = 0;
        int n = -kMaxValue;
        boolean first = true;
        while (n <= kMaxValue) {
            if (c[n + kMaxValue] == 0) {
                ++n;
                continue;
            }
            if (first) {
                ans += n;
                first = false;
            } else {
                // skip the element
                first = true;
            }
            --c[n + kMaxValue];
        }
        return ans;
    }
}
