// Solution: Hashtable
// Same idea as LeetCode 1: Two Sum
// Use a hashtable to store the occurrences of all the numbers added so far. For a new number x, check all possible 2^i - x. ans += freq[2^i - x] 0 <= i <= 21
// Time complexity: O(22n)
// Space complexity: O(n)
class Solution {
    public int countPairs(int[] A) {
        final int kMod = (int)1e9 + 7;
        Map<Integer, Integer> m = new HashMap<>();
        long ans = 0;
        for (int x : A) {
            for (int t = 1; t <= 1 << 21; t *= 2) {
                Integer it = m.get(t - x);
                if (it != null) ans += it;
            }
            m.put(x, m.getOrDefault(x, 0) + 1);
        }
        // return (int)ans % kMod; 这样先截断答案是不对的。
        return (int)(ans % kMod);
    }
}
