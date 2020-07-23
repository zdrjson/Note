// Solution: Simulation
// Time complexity: O(logb/loge)?
// Space complexity: O(1)
class Solution {
  public int numWaterBottles(int numBottles, int numExchange) {
      int ans = 0;
      while (numExchange <= numBottles) {
          int r = numBottles % numExchange;
          ans += numBottles - r;
          numBottles = r + numBottles / numExchange;
      }
      ans += numBottles;
      return ans;
  }
}
