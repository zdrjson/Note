// Solution 1: Brute Force
// Time complexity: O(n^2)
// Space complexity: O(1)
class Solution {
    public boolean rotateString(String A, String B) {
        if (A.length() != B.length()) return false;
        if (A.equals(B)) return true; // 处理corner case: A和B都为空字符串，花花blog代码里面没有这个代码。
        for (int i = 1; i < A.length(); ++i)
            if (check(A, B, i)) return true;
        return false;
    }
    private boolean check(String A, String B, int offset) {
        for (int i = 0; i < A.length(); ++i)
            if (A.charAt((i + offset) % A.length()) != B.charAt(i)) return false;
        return true;
    }
}
