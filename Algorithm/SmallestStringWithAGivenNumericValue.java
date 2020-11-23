// Solution: Greedy, Fill in reverse order
// Fill then entire string with 'a', k-=n,then fill in reverse order, replace 'a' with 'z' until not enough k left.
// Time complexity: O(n)
// Space complexity: O(n)
class Solution {
    public String getSmallestString(int n, int k) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; ++i)
            ans.append('a');
        k -= n;
        while (k != 0) {
            int d = Math.min(k, 25);
            ans.setCharAt(--n, (char)(d + 'a'));
            k -= d;
        }
        return ans.toString();
    }
}
