// Solution: DP
// p[i] := max length of positive products ends with arr[i]
// n[i] := max length of negtive products ends with arr[i]
// if arr[i] > 0: p[i] = p[i - 1] + 1, n[i] = n[i] + 1 if n[i] else 0
// if arr[i] < 0: p[i] = n[i - 1] + 1 if n[i - 1] else 0, n[i] = p[i - 1] + 1
// if arr[i] == 0: p[i] = n[i] = 0
// ans = max(p[i])
// Time complexity: O(n)
// Space complexity: O(n) -> O(1)
class Solution {
    public int getMaxLen(int[] nums) {
        int p = 0;
        int n = 0;
        int ans = 0;
        for (int x : nums) {
            if (x > 0) {
                ++p;
                if (n != 0) ++n;
            } else if (x < 0) {
                int tp = p;
                p = n != 0 ? n + 1 : 0;
                n = tp + 1;
            } else {
                p = n = 0;
            }
            ans = Math.max(ans, p);
        }
        return ans;
    }
}
