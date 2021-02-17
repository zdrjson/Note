// Solution: Binary Search
// Find the smallest penalty that requires less or equal ops than max_ops.
// Time complexity: O(nlogm)
// Space complexity: O(1)
// maxOperations/nums[i] 到了10^9，要么是O(log(m)) 要么是 O(1).
// n到了10^5，要么O(n)，要么O(nlogn) 或 O(nlogm)
// 当数据规模非常大，又无从下手的时候就可以试试二分搜索。
// 找到最小的 | 使得 ops <= maxOperations 成立
// 剩下的问题就是怎么算ops了...
// (x + m - 1) / m - 1 == (x - 1) / m
// Time complexity: O(nlogm)
// Space complexity: O(1)
// 还不太懂
class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int l = 1;
        int r = Integer.MIN_VALUE;
        for (int x : nums)
            r = Math.max(r, x);
        while (l < r) {
            int m = l + (r - l) / 2;
            int count = 0;
            for (int x : nums)
                count += (x - 1) / m;
            if (count <= maxOperations)
                r = m;
            else 
                l = m + 1;
        }
        return l;
    }
}
