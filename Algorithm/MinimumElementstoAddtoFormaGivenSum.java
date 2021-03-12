// Solution: Math
// Time complexity: O(n)
// Space complexity: O(1)
// Compute the diff = abs(sum(nums) - goal)
// ans = (diff + limit - 1) / limit // 向上取整除法
class Solution {
    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0; // 因为总和有可能为10^11，所以可能超过int类型，所以这里总和sum用long类型。
        for (int num : nums)
            sum += num;
        long diff = Math.abs(sum - goal); // 这里long类型减去int类型结果是long类型！！！
        return (int)((diff + limit - 1) / limit);
    }
}
