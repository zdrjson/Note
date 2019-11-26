class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        Queue<int[]> q = new PriorityQueue<>((a1, a2) -> a1[0] - a2[0]);
        q.offer(new int[]{grid[0][0], 0 * n + 0}); // {time, y * N + x}
        int[] seen = new int[n * n];
        int[] dirs = {-1, 0, 1, 0, -1};
        seen[0 * n + 0] = 1;
        while(!q.isEmpty()) {
            int[] node = q.poll();
            int t = node[0];
            int x = node[1] % n;
            int y = node[1] / n;
            if (x == n - 1 && y == n - 1) return t;
            for (int i = 0; i < 4; ++i) {
                int tx = x + dirs[i];
                int ty = y + dirs[i + 1];
                if (tx < 0 || ty < 0 || tx >= n || ty >= n) continue;
                if (seen[ty * n + tx] == 1) continue;
                seen[ty * n + tx] = 1;
                int time = Math.max(t, grid[ty][tx]);
                q.offer(new int[]{time, ty * n + tx});
            }
        }
        return -1;
    }
}