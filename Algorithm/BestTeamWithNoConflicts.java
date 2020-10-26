// Solution: Sort + DP
// Sort by (age, score) in descending order. For j < i, age[j] >= age[i]
// dp[i] = max(dp[j] | score[j] >= score[i], j < i) + score[i]
// Bascially, we want to find the player j with best score among [0, i), and make sure score[i] <= score[j] (since age[j] >= age[i]) then we don't have any conflicts.
// ans = max(dp)
class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        final int n = scores.length;
        // List<int[]> players = new ArrayList<int[]>(); // 如果用左边的List里面套int[]也可以，只是要注意后面new对象里面int[]不能写数字。
        int[][] players = new int[n][2];
        for (int i = 0; i < n; ++i) 
            players[i] = new int[]{ages[i], scores[i]};
        Arrays.sort(players, (a, b) -> a[0] == b[0] ? b[1] - a[1] : b[0] - a[0]);
        // dp[i] = max score of the first i players, i must be selected.
        int[] dp = new int[n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) 
                if (players[i][1] <= players[j][1])
                    dp[i] = Math.max(dp[i], dp[j]);
            dp[i] += players[i][1];
        }
        int ans = 0;
        for (int e : dp)
            ans = Math.max(ans, e);
        return ans;
    }
}
