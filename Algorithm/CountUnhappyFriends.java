// Solution: HashTable
// Put the order in a map {x -> {y, order}}, since this is dense, we use can 2D array instead of hashtable which is much fater.
// Then for each pair, we just need to check every other pair and comppare their orders.
// Time complexity: O(n^2)
// Space complexity: O(n^2)
class Solution {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int[] p = new int[n];
        for (int[] pair : pairs) {
            p[pair[0]] = pair[1];
            p[pair[1]] = pair[0];
        }
        int[][] orders = new int[n][n];
        for (int x = 0; x < n; ++x)
            for (int i = 0; i < preferences[0].length; ++i)
                orders[x][preferences[x][i]] = i;
        int ans = 0;
        for (int x = 0; x < n; ++x) {
            final int y = p[x];
            boolean found = false;
            for (int u = 0; u < n && !found; ++u) {
                final int v = p[u];
                if (u == x || u == y) continue;
                found |= orders[x][u] < orders[x][y] && orders[u][x] < orders[u][v];
            }
            if (found) ++ans;
        }
        return ans;
    }
}
