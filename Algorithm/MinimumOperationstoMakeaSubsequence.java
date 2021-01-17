// // Solution 1: LCS (TLE)
// // LCS is a clasic DP problem that can be solved in the following time/space.
// // Time complexity: O(mn)
// // Space complexity: O(mn) -> O(min(n, m))
// class Solution {
//     public int minOperations(int[] target, int[] arr) {
//         int m = target.length, n = arr.length;
//         int[][] dp = new int[m + 1][n + 1];
//         for (int i = 1; i < m + 1; ++i)
//             for (int j = 1; j < n + 1; ++j)
//                 dp[i][j] = Math.max(dp[i - 1][j],
//                            Math.max(dp[i][j - 1],      // 注意三目运算符外面加括号，不然会运行错误，导致答案不对。
//                                     dp[i - 1][j - 1] + (target[i - 1] == arr[j - 1] ? 1 : 0)));
//         return m - dp[m][n];
//     }
// }

// Solution 2: Reduce to LIS
// The original problem is a LCS (Longest common subsequence) problem that can be solved in O(n*m) time.
// Since the elements in the target array is unique, we can convert the numbers into indices that helps to reduce the problems to LIS (Longest increasing subsequence) that can be solved in O(mlogn) time.
// e.g.
// target:[6,4,8,1,3,2] => [0, 1, 2, 3, 4, 5]
// array:[4,7,6,2,3,8,6,1] => [1,-1, 0, 5, 4, 2, 0, 3] => [1, 0, 5, 4, 2, 3]
// and the LIS is [0, 2, 3] => [6, 8, 1], we need to insert the rest of the numbers.
// Ans = len(target) - len(LIS)
// Time complexity: O(mlogn)
// Space complexity: O(n)
class Solution {
    public int minOperations(int[] target, int[] arr) {
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        for (int i = 0; i < target.length; ++i)
            m.put(target[i], i);
        List<Integer> s = new ArrayList<Integer>();
        for (int a : arr) {
            Integer mit = m.get(a);
            if (mit == null) continue; // 注意对象才能判断是否为null。
            final int idx = mit;
            int it = lower_bound(s, idx, 0, s.size());
            if (it == s.size())
                s.add(idx);
            else
                s.set(it, idx);
        }
        return target.length - s.size();
    }
    private int lower_bound(List<Integer> A, int val, int l, int r) {
        while (l < r) {
            int m = l + (r - l) / 2;
            if (A.get(m) >= val)
                r = m;
            else
                l = m + 1;
        }
        return l;
    }
}
