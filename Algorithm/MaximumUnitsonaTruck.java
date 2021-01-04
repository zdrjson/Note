// Solution: Greedy
// Sort by unit in descending order.
// Time complexity: O(nlogn)
// Space complexity: O(1)
class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]); // Sort by unit DESC
        
        int ans = 0;
        for (int[] b : boxTypes) {
            ans += b[1] * Math.min(b[0], truckSize);
            if ((truckSize -= b[0]) <= 0) break;
        }
        return ans;
    }
}
