// Idea: Brute Force
class Solution {
    public String reverseWords(String s) {
        int index = 0;
        StringBuilder ans = new StringBuilder(s);
        for (int i = 0; i <= s.length(); ++i) {
            if (i == s.length() || s.charAt(i) == ' ') {
                StringBuilder sb = new StringBuilder(ans.substring(index, i));
                ans.replace(index, i, sb.reverse().toString());
                index = i + 1;
            }
        }
        return ans.toString();
    }
}
