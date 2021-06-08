// Solution:
// Time complexity: O(nlog1440)
// Space complexity: O(n)
class Solution {
    public int findMinDifference(List<String> timePoints) {
        final int kMins = 24 * 60;
        TreeSet<Integer> seen = new TreeSet<>();
        for (final String time : timePoints) {
            int m = Integer.valueOf(time.substring(0, 2)) * 60 + Integer.valueOf(time.substring(3));
            if (!seen.add(m)) return 0;
        }
        
        int ans = (seen.first() - seen.last() + kMins) % kMins;
        int l = 0;
        for (final Integer t : seen) {
            if (l != 0) ans = Math.min(ans, t - l);
            l = t;
        }
        return ans;
    }
}
