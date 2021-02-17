// Solution: Counting
// Let me be the length of the longest homogenous substring, # of homogenous substring is m * (m + 1) / 2.
// e.g. aaabb
// "aaa" => m = 3, # = 3 * (3 + 1) / 2 = 6
// "bb" => m = 2, # = 2 * (2+1) / 2 = 3
// Total = 6 + 3 = 9
// Time complexity: O(n)
// Space complexity: O(1)
class Solution {
    public int countHomogenous(String s) {
        final int kMod = (int)1e9 + 7;
        final int n = s.length();
        long ans = 0;
        for (long i = 0, j = 0; i < n; i = j) {
            while (j < n && s.charAt((int)i) == s.charAt((int)j)) ++j;
            ans += (j - i) * (j - i + 1) / 2;
        }
        return (int)(ans % kMod);
    }
}
