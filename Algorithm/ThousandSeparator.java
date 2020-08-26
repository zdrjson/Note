// Solution: Digit by digit
// Time complexity: O(log^2(n)) -> O(logn)
// Space complexity: O(log(n))
class Solution {
    public String thousandSeparator(int n) {
        String ans = new String();
        int count = 0;
        do {
            if (count++ % 3 == 0 && ans.length() != 0)
                ans = "." + ans;
            ans = String.valueOf(n % 10) + ans;
            n /= 10;
        } while (n != 0);
        return ans;
    }
}
