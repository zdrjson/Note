class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> dp = new HashMap<>();
        int ans = 0;
        for (int x : arr) {
            dp.put(x ,dp.getOrDefault(x - difference, 0) + 1);
            ans = Math.max(ans, dp.get(x));
        }
        return ans;
    }
}
