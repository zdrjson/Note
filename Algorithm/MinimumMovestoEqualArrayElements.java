// Solution: Idea
// Assuming the sum of array is S, the minimum element of the array is min and minimum number of moves is m.
// Each move will increase the sum of array by n - 1. Finally, every element becomes x, So we have: 
// 1. S + (n - 1) * m = x * n
// 2. min + m = x
// We got: m = S - n * min
// Solution: Math
// Time complexity: O(n)
// Space complexity: O(1)
class Solution {
    public int minMoves(int[] nums) {
        int S = 0;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            S += num;
            min = Math.min(min, num);
        }
        return S - nums.length * min;
    }
}
