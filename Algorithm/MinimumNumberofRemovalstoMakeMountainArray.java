// Solution: DP / LIS
// LIS[i] := longest increasing subsequence ends with nums[i]
// LDS[i] := longest decreasing subsequence starts with nums[i]
// Let nums[i] be the peak, the length of the mountain array is LIS[i] + LDS[i] - 1
// Note: LIS[i] and LDS[i] must be > 1 to form a valid mountain array.
// ans = min(n - (LIS[I] + LDS[i] - 1)) 0 <= i < n
// Time complexity: O(n^2)
// Space complexity: O(n)
class Solution {
    public int minimumMountainRemovals(int[] nums) {
        final int n = nums.length;
        int[] LIS = new int[n]; // LIS[i] := Longest increasing subsequence ends with nums[i.
        Arrays.fill(LIS, 1);
        int[] LDS = new int[n]; // DIS[i] := Longest decreasing subsequence starts with nums[i]
        Arrays.fill(LDS, 1);
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < i; ++j)
                if (nums[i] > nums[j]) LIS[i] = Math.max(LIS[i], LIS[j] + 1);
        for (int i = n - 1; i >= 0; --i)
            for (int j = n - 1; j > i; --j)
                if (nums[i] > nums[j]) LDS[i] = Math.max(LDS[i], LDS[j] + 1);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i) {
            if (LIS[i] < 2 || LDS[i] < 2) continue;
            ans = Math.min(ans, n - (LIS[i] + LDS[i] - 1));
        }
        return ans;
    }
}
