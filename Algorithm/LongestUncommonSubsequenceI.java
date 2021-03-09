// Idea:
// If two strings are the same, then the longest uncommon sequence does not exist, return -1.
// e.g. aaa vs aaa, return -1
// Otherwise, the longeer string is always a uncommon sequence of the shorter one.
// e.g. aaab vs aaa, return 4
// Solution 1:
// Time complexity: O(n)
// Space complexity: O(1)
class Solution {
    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }
}
