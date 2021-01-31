// Solution: Hashtable and base-10
// Max sum will be 9+9+9+9+9 = 45
// Time complexity: O((hi-lo) * log(hi))
// Space complexity: O(1)
class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        int[] balls = new int[46];
        int ans = 0;
        for (int i = lowLimit; i <= highLimit; ++i) {
            int n = i;
            int box = 0;
            // 注意Java要判断 while (n != 0); 而不是C++的 while (n)。
            while (n != 0) { box += n % 10; n /= 10; }
            ans = Math.max(ans, ++balls[box]);
        }
        return ans;
    }
}
