// Solution: Brute Force
// Time complexity: O(P * Q)
// Space complexity: O(1)
class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        List<Integer> res = new ArrayList<Integer>(queries.length);
        for (int[] q : queries) {
            final int rs = q[2] * q[2];
            int cnt = 0;
            for (int[] p : points)
                if ((q[0] - p[0]) * (q[0] - p[0]) + 
                    (q[1] - p[1]) * (q[1] - p[1]) <= rs)
                    ++cnt;
            res.add(cnt);
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < ans.length; ++i)
            ans[i] = res.get(i);
        return ans;
    }
}
