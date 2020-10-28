// Solution: Straightforward
// Time complexity: O(n)
// Space complexity: O(1)
class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int l = releaseTimes[0];
        char ans = keysPressed.charAt(0);
        
        for (int i = 1; i < releaseTimes.length; ++i) {
            int t = releaseTimes[i] - releaseTimes[i - 1];
            if (t > l) {
                ans = keysPressed.charAt(i);
                l = t;
            } else if (t == l) {
                ans = ans > keysPressed.charAt(i) ? ans : keysPressed.charAt(i); // Java比较单个char大小的比较方便的方法。
            }
        }
        return ans;
    }
}
