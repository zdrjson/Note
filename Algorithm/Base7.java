class Solution {
    public String convertToBase7(int num) {
        boolean is_negative = num < 0;
        num = Math.abs(num);
        String ans = "";
        do {
            ans = String.valueOf(num % 7) + ans;
            num /= 7;
        } while (num > 0);
        if (is_negative) {
            ans = "-" + ans;
        }
        return ans;
    }
}
