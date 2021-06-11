// Solution: HashTable
// Time complexity: O(n)
// Space complexity: O(26)
class Solution {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) return false;
        int[] ca = new int[26];
        int[] cb = new int[26];
        int diff = 0;
        for (int i = 0; i < A.length(); ++i) {
            if (A.charAt(i) != B.charAt(i) && diff++ > 2) return false;
            ++ca[A.charAt(i) - 'a'];
            ++cb[B.charAt(i) - 'a'];
        }
        for (int i = 0; i < 26; ++i) {
            if (diff == 0 && ca[i] > 1) return true;
            if (ca[i] != cb[i]) return false;
        }
        return diff == 2;
    }
}
