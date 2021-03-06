// Solution: Greedy
// Time complexity: O(n)
class Solution {
    public boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return isPalindrome(s, l + 1, r) 
                    || isPalindrome(s, l, r - 1);
            } else {
                ++l;
                --r;
            }
        }
        return true;
    }
    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) 
            if (s.charAt(l++) != s.charAt(r--)) return false;
        return true;
    }
}

// // 花花blog中的写法
// // Solution: Greedy
// // Time complexity: O(n)
// class Solution {
//     public boolean validPalindrome(String s) {
//         int l = -1;
//         int r = s.length();
//         while (++l < --r) {
//             if (s.charAt(l) != s.charAt(r)) {
//                 return isPalidrome(s, l + 1, r) 
//                     || isPalidrome(s, l, r - 1);
//             }
//         }
//         return true;
//     }
//     private boolean isPalidrome(String s, int l, int r) {
//         while (l < r)
//             if (s.charAt(l++) != s.charAt(r--)) return false;
//         return true;
//     }
// }
