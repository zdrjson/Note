// Solution: 
// Time complexity: O(n)
// Space complexity: O(n)
class Solution {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder s = new StringBuilder();
        for (char c : S.toCharArray())
            if (c != '-') s.append(Character.toUpperCase(c));
        int first = s.length() % K;
        StringBuilder ans = new StringBuilder(s.substring(0, first));
        for (int i = 0; i < s.length() - first; ++i) {
            if (i % K == 0 && (i + first) != 0) ans.append('-');
            ans.append(s.charAt(i + first));
        }
        return ans.toString();
    }
}
