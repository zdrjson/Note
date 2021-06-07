// Solution: Hashtable
// Similar to LC 128
// Time complexity: O(n)
// Space complexity: O(n)
class Solution {
    public int findLatestStep(int[] arr, int m) {
        final int n = arr.length;
        int[] lens = new int[n + 2];
        int[] counts = new int[n + 2];
        int ans = -1;
        for (int i = 0; i < n; ++i) {
            final int x = arr[i];
            final int l = lens[x - 1];
            final int r = lens[x + 1];
            final int t = 1 + l + r;
            lens[x - l] = lens[x + r] = t;
            --counts[l];
            --counts[r];
            ++counts[t];
            if (counts[m] != 0) ans = i + 1;
        }
        return ans;
    }
}
