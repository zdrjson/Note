// Solution: Simulation
// Process if waiting customers > 0 or i < n.
// Pruning, if runningCost > 4 * boardingCost (max revenue), there is no way to make profit.
// Time complexity: sum(consumers) / 4
// Space complexity: O(1)
class Solution {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        final int n = customers.length;
        final int kMaxC = 4;
        if (runningCost > 4 * boardingCost) return -1;
        int c = 0;
        int ans = -1;
        int p = 0;
        int maxP = 0;
        for (int r = 0; r < n || c > 0; ++r) {
            c += (r < n ? customers[r] : 0);
            p += Math.min(c, kMaxC) * boardingCost - runningCost;
            c -= Math.min(c, kMaxC);
            if (p > maxP) {
                maxP = p;
                ans = r + 1; // 1-based
            }
        }
        return ans;
    }
}
