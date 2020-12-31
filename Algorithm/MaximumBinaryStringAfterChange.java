// Solution: Greedy + Counting
// Leading 1s are good, no need to change them.
// For the rest of the string
// 1. Apply operation 2 to make the string into 3 parts, leading 1s, middle 0s and tailing 1s.
// e.g. 11010101 => 11001101 => 11001011 => 11000111
// 2. Apply operation 1 to make flip zeros to ones except the last one.
// e.g. 11000111 => 11100111 => 11110111
// There will be only one zero (if the input string is not all 1s) is the final largest string, the position of the zero is leading 1s + zeros - 1.
// Time complexity: O(n)
// Space complexity: O(n)
class Solution {
    public String maximumBinaryString(String s) {
        final int n = s.length();
        int l = 0;
        int z = 0;
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < n; ++i) {
            char c = s.charAt(i);
            if (c == '0') {
                ++z;
            } else if (z == 0) { // leading 1s
                ++l;
            }
            sb.setCharAt(i, '1');
        }
        if (l != n) sb.setCharAt(l + z - 1, '0');
        return sb.toString();
    }
}
