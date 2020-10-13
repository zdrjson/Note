// Solution: Counting degrees and all pairs
// Counting degrees for each node, if a and b are not connected, ans = degrees(a) + degrees(b), otherwise ans -= 1
// Time complexity: O(E + V ^ 2)
// Space complexity: O(E)
class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[] degrees = new int[n];
        Set<Integer> connected = new HashSet<Integer>();
        for (int[] road : roads) {
            ++degrees[road[0]];
            ++degrees[road[1]];
            connected.add((road[0] << 16) | road[1]);
            connected.add((road[1] << 16) | road[0]);
        }
        int ans = 0;
        for (int i = 0; i < n; ++i)
            for (int j = i + 1; j < n; ++j)
                ans = Math.max(ans, degrees[i] + degrees[j] 
                                      - (connected.contains((i << 16) | j) ? 1 : 0)); // 整个三目运算符外面要加括号，不然不能编译。
        return ans;
    }
}
