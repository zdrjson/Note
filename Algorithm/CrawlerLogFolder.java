// Solution: Simulation
// We only need to track the depth of current folder, and name and path can be ignored.
// Time complexity: O(n)
// Space complexity: O(1)
class Solution {
    public int minOperations(String[] logs) {
        int ans = 0;
        for (String log : logs) {
            if (log.equals("../"))
                ans = Math.max(ans - 1, 0);
            else if (!log.equals("./"))
                ++ans;
        }
        return ans;
    }
}
