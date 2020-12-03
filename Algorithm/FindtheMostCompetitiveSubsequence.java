// Solution: Stack
// Use a stack to track the best solution so far, pop if the current number is less than the top of the stack and there are sufficient numbers left. Then push the current number to the stack if not full.
// Time complexity: O(n)
// Space complexity: O(k)
class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[k];
        int c = 0;
        for (int i = 0; i < n; ++i) {
                  // 也可以判断c != 0，也能通过所有测试。
            while (c > 0 && ans[c - 1] > nums[i] && c + n - i - 1 >= k)
                --c;
            if (c < k) ans[c++] = nums[i];
        }
        return ans;
    }
}
