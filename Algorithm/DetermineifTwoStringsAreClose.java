// Solution: Hashtable
// Two strings are close:
// 1. Have the same length, ccabbb => 6 == aabccc => 6
// 2. Have the same char set, ccabbb => (a, b, c) == aabccc => (a, b, c)
// 3. Have the same sorted char counts ccabbb => (1,2,3) == aabccc => (1,2,3)
// Time complexity: O(n)
// Space complexity: O(1)
class Solution {
    public boolean closeStrings(String word1, String word2) {
        final int l1 = word1.length();
        final int l2 = word2.length();
        int[] f1 = new int[128], f2 = new int[128];
        int[] s1 = new int[128], s2 = new int[128];
        for (char c : word1.toCharArray()) { ++f1[c]; s1[c] = 1; } // Java这里不好像C++这样不要大括号，并且可以中间用逗号。
        for (char c : word2.toCharArray()) { ++f2[c]; s2[c] = 1; }
        Arrays.sort(f1);
        Arrays.sort(f2);
        return Arrays.equals(f1, f2) && Arrays.equals(s1, s2);
    }
}
