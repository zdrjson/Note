// Solution: Counter
// Use a counter to track how many unique vowels we saw so far. Reset the counter whenever the s[i] < s[i - 1]. Incase the counter if s[i] > s[i - 1]. When counter becomes 5, we know we found a valid substring.
// Time complexity: O(n)
// Space complexity: O(1)
class Solution {
    public int longestBeautifulSubstring(String word) {
        final int n = word.length();
        int ans = 0;
        char p = 'a' - 1;
        for (int i = 0, vowels = 0, l = 0; i < n; ++i) {
            if (word.charAt(i) < p) {
                vowels = (word.charAt(i) == 'a' ? 1 : 0); // 注意Java三目运算符的结果不是1或者0，而是boolean值。
                l = i;
            } else if (word.charAt(i) > p) {
                ++vowels;
            }
            if (vowels == 5)
                ans = Math.max(ans, i - l + 1);
            p = word.charAt(i);
        }
        return ans;
    }
}
