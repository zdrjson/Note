// Solution: Hashtable
// Remember the first position each letter occurs.
// Time complexity: O(n)
// Space complexity: O(26)
class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] first = new int[26];
        Arrays.fill(first, -1);
        int ans = -1;
        for (int i = 0; i < s.length(); ++i) {
            int p = first[s.charAt(i) - 'a'];
            if (p != -1) {
                ans = Math.max(ans, i - p - 1);
            } else {
                p = i;
            }
            first[s.charAt(i) - 'a'] = p;
        }
        return ans;
    }
}
