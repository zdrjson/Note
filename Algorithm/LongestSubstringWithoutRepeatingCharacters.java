// Using a hashtable to remember the last index of every char. And keep tracking the starting point of a valid substring.
// start = max(start, last[s[i]] + 1)
// ans = max(ans, i - start + 1)
// Time complexity: O(n)
// Space complexity: O(128)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] last = new int[128];
        Arrays.fill(last, -1);
        int start = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (last[s.charAt(i)] != -1) 
                start = Math.max(start, last[s.charAt(i)] + 1);
            last[s.charAt(i)] = i;
            ans = Math.max(ans, i - start + 1);
        }
        return ans;
    }
}
