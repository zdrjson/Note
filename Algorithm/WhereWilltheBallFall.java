// Solution: Simulation
// Figure out 4 conditions that the ball will get stuck.
// Time complexity: O(m*n)
// Space compelxity: O(1)
class Solution {
    private int m;
    private int n;
    private int[][] G;
    public int[] findBall(int[][] G) {
        m = G.length;
        n = G[0].length;
        this.G = G;
        int[] ans = new int[n];
        for (int x = 0; x < n; ++x) 
            ans[x] = fall(x);
        return ans;
    }
    private int fall(int x) {
        for (int y = 0; y < m; ++y) {
            if ((G[y][x] == -1 && (x == 0 || G[y][x - 1] == 1)) ||
                (G[y][x] == 1 && (x == n - 1 || G[y][x + 1] == -1)))
                return -1;
            else 
                x += G[y][x];
        }
        return x;
    }
}
