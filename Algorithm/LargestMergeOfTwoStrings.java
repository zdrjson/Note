// Solution: Greedy
// Always take a single char from the largest word. (NOT just the current char).
// E.g.
// ans = "", w1 = "cabba", w2 = "bcaaa"
// w1 > w2, take from w1
// ans = "c", w1 = "abba", w2 = "bcaaa"
// w1 < w2, take from w2
// ans = "cb", w1 = "abba", w2 = "caaa"
// w1 < w2, take from w2
// ans = "cbc", w1 = "abba", w2 = "aaa"
// w1 > w2, take from w1. Note: both start with "a", but we need to compare the entire word.
// ans = "cbca", w1 = "bba", w2 = "aaa"
// w1 > w2, take from w1
// ans = "cbcab", w1 = "ba", w2 = "aaa"
// ...
// Time complexity: O(min(m,n)^2)
// Space complexity: O(1)
class Solution {
    public String largestMerge(String w1, String w2) {
        StringBuilder ans = new StringBuilder();
        int m = w1.length(), n = w2.length();
        int i = 0, j = 0;
        while (i < m && j < n) // 字符串比较lexicographically大小，用compareTo()方法！！！
            ans.append(w1.substring(i).compareTo(w2.substring(j)) > 0 ? w1.charAt(i++) : w2.charAt(j++));
        ans.append(w1.substring(i));
        ans.append(w2.substring(j));
        return ans.toString();
    }
}
