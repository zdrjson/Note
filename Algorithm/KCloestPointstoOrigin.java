class Solution {
      public int[][] kClosest(int[][] points, int K) {
       long[] s = new long[points.length];
       for (int i = 0; i < points.length; ++i) {
           s[i] = ((long)(points[i][0] * points[i][0] + points[i][1] * points[i][1]) << 32) | i;
       }
       Arrays.sort(s);
       int[][] ans = new int[K][2];
       for (int i = 0; i < K; ++i) {
           ans[i] = points[(int)s[i]];
       }
       return ans;
    }
}
