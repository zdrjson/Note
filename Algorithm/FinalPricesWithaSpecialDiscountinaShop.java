// // Solution 1: Simulation
// // Time complexity: O(n^2)
// // Space complexity: O(1)
// class Solution {
//     public int[] finalPrices(int[] prices) {
//         int n = prices.length;
//         for (int i = 0; i < n; ++i)
//             for (int j = i + 1; j < n; ++j) {
//                 if (prices[j] <= prices[i]) {
//                     prices[i] -= prices[j];
//                     break;
//                 }
//             }
//         return prices;
//     }
// }

// Solution 2: Monotonic Stack
// Use a stack to store monotonically increasing items, when the current item is cheaper than the top of the stack, we get the discount and pop that item. Repeat until the current item is no longer cheaper or the stack becomes empty.
// Time complexity: O(n)
// Space complexity: O(n)
// index version
class Solution {
    public int[] finalPrices(int[] prices) {
        // stores indices of monotonically increasing elements.
        Stack<Integer> s = new Stack<Integer>();
        for (int i = 0; i < prices.length; ++i) {
            while (!s.isEmpty() && prices[s.peek()] >= prices[i]) {
                prices[s.peek()] -= prices[i];
                s.pop();
            }
            s.push(i);
        }
        return prices;
    }
}
