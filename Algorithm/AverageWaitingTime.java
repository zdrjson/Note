// Solution: Simulation
// When a customer arrives, if the arrival time is greater than current, then advance the clock to arrival time. Advance the clock by cooking time. Waiting time = current time - arrival time.
// Time complexity: O(n)
// Space complexity: O(1)
class Solution {
    public double averageWaitingTime(int[][] customers) {
        int t = 0;
        double w = 0;
        for (int[] c : customers) {
            if (c[0] > t) t = c[0];
            t += c[1];
            w += t - c[0];
        }
        return w / (double)customers.length;
    }
}
