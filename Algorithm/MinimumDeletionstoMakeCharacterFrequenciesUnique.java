// Solution: Hashtable
// The deletion order doesn't matter, we can process from 'a' to 'z'. Use a hashtable to store the "final frequency" so far, for each char, decrease its frequency until it becomes unique in the final frequency hashtable.
// Time complexity: O(n + 26^2)
// Space complexity: O(26)
class Solution {
    public int minDeletions(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) ++freq[c - 'a'];
        Set<Integer> seen = new HashSet<Integer>();
        int ans = 0;
        for (int f : freq) {
            while (f != 0 && !seen.add(f)) {
                --f;
                ++ans;
            }
        }
        return ans;
    }
}
