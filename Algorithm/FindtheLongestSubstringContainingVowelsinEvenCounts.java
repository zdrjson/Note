// Solution: HashTable
// Time complexity: O(5*n)
// Space complexity: O(32)
class Solution {
    public int findTheLongestSubstring(String s) {
        final char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        int[] idx = new int[1 << 5];
        Arrays.fill(idx, Integer.MAX_VALUE);
        idx[0] = -1;
        int state = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); ++i) {
            for (int j = 0; j < 5; ++j)
                if (s.charAt(i) == vowels[j]) state ^= 1 << j;
            if (idx[state] == Integer.MAX_VALUE) idx[state] = i;
            ans = Math.max(ans, i - idx[state]);
        }
        return ans;
    }
}
