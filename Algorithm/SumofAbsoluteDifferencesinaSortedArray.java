// Solution: Prefix Sum
// Let s[i] denote sum(num[i] - num[j]) 0 <= j <= i
// s[i] = s[i - 1] + (num[i] - num[i - 1]) * i
// Let l[i] denote sum(nums[j] - nums[i]) i <= j < n
// l[i] = l[i + 1] + (nums[i + 1] - num[i]) * (n - i - 1)
// ans[i] = s[i] + l[i]
// e.g. 1, 3, 7, 9
// s[0] = 0
// s[1] = 0 + (3 - 1) * 1 = 2
// s[2] = 2 + (7 - 3) * 2 = 10
// s[3] = 10 + (9 - 7) * 3 = 16
// l[3] = 0
// l[2] = 0 + (9 - 7) * 1 = 2
// l[1] = 2 + (7 - 3) * 2 = 10
// l[0] = 10 + (3 - 1) * 3 = 16
// ans = [16, 12, 12, 16]
// Time complexity: O(n)
// Space complexity: O(n)
class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        final int n = nums.length;
        int[] ans = new int[n];
        for (int i = 1, sum = 0; i < n; ++i)
            ans[i] += (sum += (nums[i] - nums[i - 1]) * i);
        for (int i = n - 2, sum = 0; i >= 0; --i)
            ans[i] += (sum += (nums[i + 1] - nums[i]) * (n - i - 1));
        return ans;
    }
}
