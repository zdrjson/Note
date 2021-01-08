// Solution: Counting
// Time complexity: O(n)
// Space complexity: O(1)
class Solution {
    public boolean halvesAreAlike(String s) {
        return count(s.substring(0, s.length() / 2)) == count(s.substring(s.length() / 2));
    }
    private int count(String s) {
        int ans = 0;
        for (char c : s.toCharArray()) {
            if ("aeiouAEIOU".contains(String.valueOf(c))) ++ans;
        }
        return ans;
    }
}
