// Solution: Brute Force
// Try all possible coordinates from (0, 0) to (50, 50)
// Time complexity: O(|X|*|Y|*t)
// Space complexity: O(1)
class Solution {
    public int[] bestCoordinate(int[][] towers, int radius) {
        final int n = 50;
        int[] ans = new int[2];
        int max_q = 0;
        for (int x = 0; x <= n; ++x)
            for (int y = 0; y <= n; ++y) {
                int q = 0;
                for (int[] tower : towers) {
                    final int tx = tower[0], ty = tower[1];
                    final float d = (float)Math.sqrt((x - tx) * (x - tx) + (y - ty) * (y - ty)); // 这里前面用float类型来接的，所以后面要float类型来强制转换，和C++不同。
                    if (d > radius) continue;
                    q += (int)Math.floor(tower[2] / (1 + d));
                }
                if (q > max_q) {
                    max_q = q;
                    ans = new int[]{x, y}; // 大括号里面有值，中括号里面不要数字来初始化capacity!!!
                }
            }
        return ans;
    }
}
