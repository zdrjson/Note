o// Solution: Recursion
// 1. If a node is not null, it must has two children, thus verify left substree and right substree recursively.
// 2. If a not is null, the current char must be '#'
// Time complexity: O(n)
// Space complexity: O(h)
class Solution {
    private int pos;
    public boolean isValidSerialization(String preorder) {
        pos = 0;
        return isValid(preorder) && pos == preorder.length();
    }
    private boolean isValid(String s) {
        if (pos >= s.length()) return false;
        if (Character.isDigit(s.charAt(pos))) {
            while (pos < s.length() && Character.isDigit(s.charAt(pos))) ++pos; // pos有可能要越界，所以Java要加上 pos < s.length(); C++不要担心这个问题。
            ++pos;
            boolean l = isValid(s);
            ++pos;
            boolean r = isValid(s);
            return l && r; 
        }
        return s.charAt(pos++) == '#';
    }
}
