// Solution:
// Time complexity: O(n)
// Space complexity: O(1)
class Solution {
    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        int prev = -1;
        int ans = 0;
        for (int i = 0; i <= n; ++i) {
            if (i == n) ans = Math.max(ans, n - prev - 1);
            else if (seats[i] == 1) {
                if (prev == -1) ans = i;
                else ans = Math.max(ans, (i - prev) / 2);
                prev = i;
            }
        }
        return ans;
    }
}
