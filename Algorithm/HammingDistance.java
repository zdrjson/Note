// Solution: Bit Operation
// Time complexity: O(logn)
// Space complexity: O(1)
class Solution {
    public int hammingDistance(int x, int y) {
       int ans = 0;
       int t = x ^ y;
       while (t > 0) {
           ans += t & 1;
           t >>= 1;
       }
       return ans;
    }
}

// class Solution {
//     public int hammingDistance(int x, int y) {
//         return Integer.bitCount(x ^ y);
//     }
// }
