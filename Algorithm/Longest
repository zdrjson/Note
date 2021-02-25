// // Solution: Brute Force
// // Time complexity: O(n^3)
// // Space complexity: O(1)
// class Solution {
//     public String longestNiceSubstring(String s) {
//         final int n = s.length();
//         String ans = "";
//         for (int i = 0; i < n; ++i) 
//             for (int j = i + 1; j < n; ++j) {
//                 String ss = s.substring(i, j + 1); // 这里substring是左闭右开，所以右边用的j + 1。C++中j - i + 1对应是长度。
//                 if (isNice(ss) && ss.length() > ans.length())
//                     ans = ss;
//             }
//         return ans;
//     }
//     private boolean isNice(String s) {
//         int[] u = new int[26]; // 注意这里基本数组u和l不能放在同一行初始化，否则编译失败。
//         int[] l = new int[26];
//         for (char c : s.toCharArray()) 
//             if (Character.isUpperCase(c)) u[c - 'A'] = 1;
//             else l[c - 'a'] = 1;
//         return Arrays.equals(u, l);
//     }
// }

// Optimized 1:
// Time complexity: O(n^2*26)
// Space complexity: O(1)
class Solution {
    public String longestNiceSubstring(String s) {
        final int n = s.length();
        String ans = "";
        for (int i = 0; i < n; ++i) {
            int[] u = new int[26];
            int[] l = new int[26];
            for (int j = i; j < n; ++j) {
                final char c = s.charAt(j);
                if (Character.isUpperCase(c)) u[c - 'A'] = 1;
                else l[c - 'a'] = 1;
                if (Arrays.equals(u, l) && j - i + 1 > ans.length())
                    ans = s.substring(i, j + 1);
            }
        }
        return ans;
    }
}
