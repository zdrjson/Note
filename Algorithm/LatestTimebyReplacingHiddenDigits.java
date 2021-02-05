// // Solution 1: Brute Force
// // Enumerate all possible clock in reverse order and find the first matching one.
// // Time complexity: O(1)
// // Space complexity: O(1)
// class Solution {
//     public String maximumTime(String time) {
//         char[] ans = time.toCharArray();
//         for (int m = 24 * 60 - 1; m >= 0; --m) {
//             int hh = m / 60;
//             int mm = m % 60;
//             if (ans[0] != '?' && ans[0] - '0' != hh / 10) continue;
//             if (ans[1] != '?' && ans[1] - '0' != hh % 10) continue;
//             if (ans[3] != '?' && ans[3] - '0' != mm / 10) continue;
//             if (ans[4] != '?' && ans[4] - '0' != mm % 10) continue;
//             ans[0] = (char)(hh / 10 + '0');
//             ans[1] = (char)(hh % 10 + '0');
//             ans[3] = (char)(mm / 10 + '0');
//             ans[4] = (char)(mm % 10 + '0');
//         }
//         // return String.valueOf(ans); // char[]这样转成String也是对的。
//         return new String(ans);
//     }
// }

// Solution 2: Rules
// Using rules, fill from left to right.
// Time complexity: O(1)
// Space cmplexity: O(1)
class Solution {
    public String maximumTime(String time) {
        char[] ans = time.toCharArray();
        if (ans[0] == '?') ans[0] = ans[1] >= '4' && ans[1] <= '9' ? '1' : '2';
        if (ans[1] == '?') ans[1] = ans[0] == '2' ? '3' : '9';
        if (ans[3] == '?') ans[3] = '5';
        if (ans[4] == '?') ans[4] = '9';
        return String.valueOf(ans);
    }
}
