// Solution: Greedy
// Try to match the prefix of A and suffix of B (or the other way) as much as possible and then check whether the remaining part is a palindrome or not.
// e.g. A = "abcxyzzz", B = "uuuvvcba"
// A's prefix abc matches B's suffix cba
// We just need to check whether "xy" or "vv" is palindrome or not.
// The concatenated string "abc|vvcba" is a palindrome, left abc is from A and vvcba is from B.
// Time complexity: O(n)
// Space complexity: O(1)
class Solution {
    public boolean checkPalindromeFormation(String a, String b) {
        return check(a, b) || check(b, a);
    }
    private boolean check(String a, String b) {
        int i = 0;
        int j = a.length() - 1;
        while (i < j && a.charAt(i) == b.charAt(j)) { // Java这里的不能写成++i, --j，运行顺序不对，会导致答案不对。同时这里要写i < j判断越界不越界。
            ++i; 
            --j; 
        }
        return isPalindrome(a, i, j) || isPalindrome(b, i, j);
    }
    private boolean isPalindrome(String s, int i, int j) {
        while (i < j && s.charAt(i) == s.charAt(j)) { 
            ++i; 
            --j; 
        }
        return i >= j;
    }
}
