// Solution: Union Find
// Since queries are offline, we can reorder them to optimize time complexity. Answer queries by their limits in ascending order while union edges by weights up to the limit. In this case, we just need to go through the entire edge list at most once.
// Time complexity: O(Q + E)
// Space complexity: O(Q + E)
class Solution {
    private int[] parents;
    public boolean[] distanceLimitedPathsExist(int n, int[][] E, int[][] Q) {
        parents = new int[n];
        for (int i = 0; i < parents.length; ++i)
            parents[i] = i;
        final int m = Q.length;
        int[][] Q1 = new int[m][Q[0].length + 1];
        for (int i = 0; i < m; ++i) {
            Q1[i][0] = Q[i][0];
            Q1[i][1] = Q[i][1];
            Q1[i][2] = Q[i][2];
        }
        for (int i = 0; i < m; ++i) Q1[i][Q1[0].length - 1] = i;
        // Sort edges by weight in ascending order.
        Arrays.sort(E, (a, b) -> a[2] - b[2]);
        // Sort queries by limit in ascending order
        Arrays.sort(Q1, (a, b) -> a[2] - b[2]);
        boolean[] ans = new boolean[m];
        int i = 0;
        for (final int[] q : Q1) {
            while (i < E.length && E[i][2] < q[2]) 
                parents[find(E[i][0])] = find(E[i++][1]); // Java执行顺序和C++不同，所以这里i放到后面去加加。
            ans[q[3]] = find(q[0]) == find(q[1]);
        }
        return ans;
    }
    private int find(int x) {
        return parents[x] == x ? x : (parents[x] = find(parents[x])); // Java代码注意这里三目运算符冒号的赋值等式后面整个要加上括号！！！
    }
}
