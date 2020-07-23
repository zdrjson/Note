// Solution: KMP
// Time complexity: O(m+n)
// Space complexity: O(m)
class Solution {
    class KMP {
        public List<Integer> Build(String p) {
            int m = p.length();
            List<Integer> nxt = new ArrayList<>(Arrays.asList(0, 0));
            for (int i = 1, j = 0; i < m; ++i) {
                while (j > 0 && p.charAt(i) != p.charAt(j))
                    j = nxt.get(j);
                if (p.charAt(i) == p.charAt(j))
                    ++j;
                nxt.add(j);
            }
            return nxt;
        }
        public List<Integer> Match(String s, String p) {
            List<Integer> nxt = Build(p);
            List<Integer> ans = new ArrayList<>();
            int n = s.length();
            int m = p.length();
            for (int i = 0, j = 0; i < n; ++i) {
                while (j > 0 && s.charAt(i) != p.charAt(j))
                    j = nxt.get(j);
                if (s.charAt(i) == p.charAt(j))
                    ++j;
                if (j == m) {
                    ans.add(i - m + 1);
                    j = nxt.get(j);
                }
            }
            return ans;
        }
    }
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        KMP kmp = new KMP();
        List<Integer> matches = kmp.Match(haystack, needle);
        return matches.isEmpty() ? -1 : matches.get(0);
    }
}

// // Solution 1: Brute Force
// // Time complexity: O(mn)
// // Space complexity: O(1)
// class Solution {
//     public int strStr(String haystack, String needle) {
//         int l1 = haystack.length();
//         int l2 = needle.length();
//         for (int i = 0; i <= l1 - l2; ++i) {
//             int j = 0;
//             while (j < l2 && needle.charAt(j) == haystack.charAt(i + j)) ++j;
//             if (j == l2) return i;
//         }
//         return -1;
//     }
// }
