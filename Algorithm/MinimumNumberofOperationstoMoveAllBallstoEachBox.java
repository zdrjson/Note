// Solution: Prefix Sum + DP
// Time complexity: O(n)
// Space complexity: O(n)
class Solution {
    public int[] minOperations(String boxes) {
        final int n = boxes.length();
        int[] ans = new int[n];
        for (int i = 0, c = 0, s = 0; i < n; ++i) {
            ans[i] += c;
            c += (s += boxes.charAt(i) - '0'); // Java这里boxes.charAt(i) - '0'外面不要包括号也可以运行。
        }
        for (int i = n - 1, c = 0, s = 0; i >= 0; --i) {
            ans[i] += c;
            c += (s += boxes.charAt(i) - '0');
        }
        return ans;
    }
}
