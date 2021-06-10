// Solution: 
// Be aware of special cases: like ”  “.
// Time complexity: O(n)
// Space complexity: O(1)
class Solution {
    public int countSegments(String s) {
        if (s.isEmpty()) return 0;
        int ans = 0;
        int i = 0;
        while (i < s.length()) {
            while (i < s.length() && s.charAt(i) == ' ') ++i;
            if (i == s.length()) break;
            while (i < s.length() && s.charAt(i) != ' ') ++i;
            ++ans;
            ++i;
        }
        return ans;
    }
}
