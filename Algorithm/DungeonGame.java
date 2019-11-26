class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        
        // hp[y][x]: min hp required to reach bottom right (P)
        int[][] hp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; ++i) { //hp是二维数组
            Arrays.fill(hp[i], Integer.MAX_VALUE);
        }
        hp[m][n - 1] = hp[m - 1][n] = 1;
        
        for (int y = m - 1; y >= 0; --y) {
             for (int x = n - 1; x >= 0; --x) {
                 hp[y][x] = Math.max(1, Math.min(hp[y + 1][x], hp[y][x + 1]) - dungeon[y][x]);
             }
        }
        return hp[0][0];
    }
}
