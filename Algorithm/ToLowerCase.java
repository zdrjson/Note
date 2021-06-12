// Solution
// Time complexity: O(n)
// Space complexity: O(1)
class Solution {
    public String toLowerCase(String str) {
        char[] s = str.toCharArray();
        for (int i = 0; i < s.length; ++i)
            if (s[i] >= 'A' && s[i] <= 'Z') s[i] = (char)(s[i] - 'A' + 'a');
        return new String(s);
    }
}
