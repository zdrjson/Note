// Solution: Binary Search
// Store the days we can dry a lake in a treeset.
// Whenever we encounter a full lake, try to find the first available day that we can dry it, If no such day, return no answer.
// Time complexity: O(nlogn)
// Space complexity: O(n)
class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Map<Integer, Integer> full = new HashMap<>(); // lake -> day
        TreeSet<Integer> dry = new TreeSet<>(); // days we can dry lakes.
        for (int i = 0; i < n; ++i) {
            int lake = rains[i];
            if (lake > 0) {
                if (full.containsKey(lake)) {
                    // Find the first day we can dry it.
                    Integer it = dry.higher(full.get(lake));
                    if (it == null) return new int[]{}; // 返回空数组return new int[0]; 这样也可以。
                    ans[it] = lake;
                    dry.remove(it); // 用了以后别忘了移除。
                }
                full.put(lake, i);
            } else {
                dry.add(i);
                ans[i] = 1;
            }
        }
        return ans;
    }
}
