class Solution {
    public int maxProfit(int[] prices) {
        int sold = 0;
        int rest = 0;
        int hold = Integer.MIN_VALUE;
        for (int price : prices) {
            int prev_sold = sold;
            sold = hold + price; // 卖了要加钱
            hold = Math.max(hold, rest - price); // 买了要减钱
            rest = Math.max(rest, prev_sold);
        }
        return Math.max(sold, rest);
    }
}
