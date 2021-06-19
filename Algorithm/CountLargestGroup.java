// Solution: HashTable
// Time complexity: O(nlogn)
// Space complexity: O(logn)
class Solution {
    public int countLargestGroup(int n) {
        int[] c = new int[37]; // max sum is 9+9+9+9 = 36 因为数据为: 1 <= n <= 10^4。
        for (int i = 1; i <= n; ++i) {
            int x = i;
            int sum = 0;
            while (x != 0) {
                sum += x % 10;
                x /= 10;
            }
            ++c[sum];
        }
        int maxE = Integer.MIN_VALUE;
        for (int e : c)
            maxE = Math.max(maxE, e);
        int ans = 0;
        for (int e : c)
            if (maxE == e) ++ans;
        return ans;
    }
}
