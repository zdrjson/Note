// Solution: Two Counters
// The final string is either 010101... or 101010...
// We just need two counters to record the number of changes needed to transform the original string to those two final strings.
// Time complexity: O(n)
// Space comlexity: O(1)
class Solution {
    public int minOperations(String s) {
        int c1 = 0, c2 = 0;
        for (int i = 0; i < s.length(); ++i) {
            c1 += (s.charAt(i) - '0' == i % 2 ? 1 : 0); // 再次注意Java三目运算符不能直接用于1和0的相加。
            c2 += (s.charAt(i) - '0' != i % 2 ? 1 : 0);
        }
        return Math.min(c1, c2);
    }
}
