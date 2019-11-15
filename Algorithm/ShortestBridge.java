/**
 * Solution: DFS + BFS
 * Use DFS to find one island and color all the nodes as 2 (BLUE).
 * Use BFS to find the shortest path from any nodes with color 2 (BLUE) to any nodes with color 1 (RED).
 * Time complexity: O(mn)
 *
 * Space complexity: O(mn)
 */
class Solution {
    public int shortestBridge(int[][] A) {
        Queue<int[]> q = new LinkedList<>();
        boolean found = false;
        for (int i = 0; i < A.length && !found; ++i) {
            for (int j = 0; j < A[0].length && !found; ++j) {
                if (A[i][j] == 1) {
                    dfs(A, j, i, q);
                    found = true;
                }
            }
        }
        int steps = 0;
        int[] dirs = {0, 1, 0, -1, 0};
        while(!q.isEmpty()) {
            int size = q.size();
            while(size != 0) {
                size--;
                int x = q.peek()[0];
                int y = q.peek()[1];
                q.poll();
                for (int i = 0; i < 4; ++i) {
                    int tx = x + dirs[i];
                    int ty = y + dirs[i + 1];
                    if (tx < 0 || ty < 0 || tx >= A[0].length || ty >= A.length || A[ty][tx] == 2) {
                        continue;
                    }
                    if (A[ty][tx] == 1) {
                        return steps;
                    }
                    A[ty][tx] = 2;
                    q.offer(new int[]{tx, ty});
                }
            }
            ++steps;
        }
        return -1;
    }
    private void dfs(int[][] A, int x, int y, Queue<int[]> q) {
        if(x < 0 || y < 0 || x >= A[0].length || y >= A.length || A[y][x] != 1) {
            return;
        }
        A[y][x] = 2;
        q.offer(new int[]{x, y});
        dfs(A, x - 1, y, q);
        dfs(A, x + 1, y, q);
        dfs(A, x, y - 1, q);
        dfs(A, x, y + 1, q);
    }
}