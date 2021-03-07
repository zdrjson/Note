// // Solution 1: Brute Force
// // Time complexity: O(nlogn)
// class Solution {
//     public int rotatedDigits(int N) {
//         int ans = 0;
//         for (int i = 1; i <= N; ++i)
//             ans += isValid(i);
//         return ans;
//     }
//     private int isValid(int n) {
//         String s = String.valueOf(n);
//         StringBuilder t = new StringBuilder(s);
//         for (int i = 0; i < s.length(); ++i) {
//             if (s.charAt(i) == '3' || s.charAt(i) == '4' || s.charAt(i) == '7')
//                 return 0;
//             else if (s.charAt(i) == '2') t.setCharAt(i, '5');
//             else if (s.charAt(i) == '5') t.setCharAt(i, '2');
//             else if (s.charAt(i) == '6') t.setCharAt(i, '9');
//             else if (s.charAt(i) == '9') t.setCharAt(i, '6');
//         }
        
//         return !t.toString().equals(s) ? 1 : 0;
//     }
// }

// Bit operation
class Solution {
    public int rotatedDigits(int N) {
        int ans = 0;
        for (int i = 1; i <= N; ++i)
            ans += isValid(i);
        return ans;
    }
    private int isValid(int n) {
        final int kInvalidMask = (1 << 3) | (1 << 4) | (1 << 7); // Java这里前面不能用staic来修饰。
        final int kvalidMask = (1 << 2) | (1 << 5) | (1 << 6) | (1 << 9);
        
        int valid = 0;
        
        while (n > 0) {
            int r = 1 << (n % 10);
            if ((r & kInvalidMask) != 0)
                return 0;
            else if ((r & kvalidMask) != 0)
                valid = 1;
            n /= 10;
        }
        
        return valid;
    }
}
