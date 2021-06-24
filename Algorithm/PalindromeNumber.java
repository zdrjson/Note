// // Solution 1: Convert to string (cheating)
// // Time complexity: O(log10(x))
// // Space complexity: O(log(10)(x))
// class Solution {
//     public boolean isPalindrome(int x) {
//         StringBuilder s = new StringBuilder(String.valueOf(x)); // new StringBuilder()；初始化的时候不能传入负数。
//         return s.toString().equals(s.reverse().toString());
//     }
// }

// Solution 2: Digit by Digit
// Every time we compare the first and last digits of x, if they are not the same, return false, Otherwise, remove first and last digit and continue this process.
// How can we achieve that via int math?
// e.g. x = 9999, t = pow((10, int)log10(x)) = 1000
// first digit: x / t, last digit: x % 10
// then x = (x - x / t * t) / 10 removes first and last digits
// t /= 100 since we removed two digits.
// x / t = 9 = 9 x % 10, 9999 => 99
// 9 = 0. 99 => ""
// Time complexity: O(log10(x) / 2)
// Space complexity: O(1)
// 暂时还不太懂
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int d = (int)(Math.log10(x) + 1);
        int t = (int)Math.pow(10, d - 1); // 注意Math.pow返回的double类型的！！！
        for (int i = 0; i < d / 2; ++i) {
            if (x / t != x % 10) return false;
            x = (x - x / t * t) / 10;
            t /= 100;
        }
        return true;
    }
};
