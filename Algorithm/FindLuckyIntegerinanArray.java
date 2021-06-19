// Solution: Hashtable
// Time complexity: O(n)
// Space complexity: O(n)
class Solution {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int a : arr)
            freq.put(a, freq.getOrDefault(a, 0) + 1);
        int ans = -1;
        for (Map.Entry<Integer, Integer> kv : freq.entrySet())
            if (kv.getKey() == kv.getValue()) ans = Math.max(ans, kv.getKey());
        return ans;
    }
}
