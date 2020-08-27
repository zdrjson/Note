// Solution: Hashtable
// Similar to LC 128
// Time complexity: O(n)
// Space complexity: O(n)
class Solution {
    public int findLatestStep(int[] arr, int m) {
        int n = arr.length;
        int[] len = new int[n + 2];
        int[] counts = new int[n + 2];
        int ans = -1;
        for (int i = 0; i < n; ++i) {
            int x = arr[i];
            int l = len[x - 1];
            int r = len[x + 1];
            int t = 1 + l + r;
            len[x - l] = len[x + r] = t;
            --counts[l];
            --counts[r];
            ++counts[t];
            if (counts[m] != 0) ans = i + 1;
        }
        return ans;
    }
}
