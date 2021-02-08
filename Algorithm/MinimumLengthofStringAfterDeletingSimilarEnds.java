// Solution: Two Pointers + Greedy
// Delete all the chars for each prefix and suffix pair.
// Time complexity: O(n)
// Space complexity: O(1)
class Solution {
    public int minimumLength(String s) {
        int l = 0, r = s.length () - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) break;
            final char c = s.charAt(l);
            while (l <= r && s.charAt(l) == c) ++l;
            while (l <= r && s.charAt(r) == c) --r;
        }
        return r - l + 1;
    }
}
