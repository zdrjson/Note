// Solution: Brute Force
// Time complexity: O(mk), where k the length of common prefix.
// Space complexity: O(k)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < strs[0].length(); ++i) {
            char c = strs[0].charAt(i);
            for (String s : strs) 
                if (s.length() <= i || c != s.charAt(i)) return ans.toString();
            ans.append(c);
        }
        return ans.toString();
    }
}
