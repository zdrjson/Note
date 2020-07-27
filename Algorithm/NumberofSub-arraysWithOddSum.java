// Solution: We would like to know how many subarrays end with arr[i] have odd or even sums.
// dp[i][0] := # end with arr[i] has even sum
// dp[i][1] := # end with arr[i] has odd sum
// if arr[i] is even:
// dp[i][0]=dp[i-1][0] + 1, dp[i][1]=dp[i-1][1]
// else:
// dp[i][1]=dp[i-1][0],do[i][0]=dp[i-1][0] + 1
// ans = sum(dp[i][1])
// Time complexity: O(n)
// Space complexity: O(n) -> O(1)
class Solution {
    public int numOfSubarrays(int[] arr) {
        int n = arr.length;
        int kMod = (int)1e9 + 7;
        // dp[i][0] # of subarrays ends with a[i-1] have even sums.
        // dp[i][1] # of subarrays ends with a[i-1] have odd sums.
        int[][] dp = new int[n + 1][2];
        long ans = 0;
        for (int i = 1; i <= n; ++i) {
            if ((arr[i - 1] & 1) == 1) { // 注意arr[i - 1] & 1 外面加括号和 arr[i - 1]取的是i - 1，因为i是从1开始的。
                dp[i][0] = dp[i - 1][1];
                dp[i][1] = dp[i - 1][0] + 1;
            } else {
                dp[i][0] = dp[i - 1][0] + 1;
                dp[i][1] = dp[i - 1][1];
            }
            ans += dp[i][1];
        }
        return (int)(ans % kMod);
    }
}

// // Simple version of above code
// class Solution {
//     public int numOfSubarrays(int[] arr) {
//         long ans = 0, odd = 0, even = 0;
//         for (int a : arr) {
//             even += 1;
//             if (a % 2 == 1) { // 这个大括号不能省略，否则不能运行
//                 long t = even; even = odd; odd = t;
//             }
//             ans += odd;
//         }
//         return (int)(ans % (int)(1e9 + 7));
//     }
// }
