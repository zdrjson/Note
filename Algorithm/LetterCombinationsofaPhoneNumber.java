// DFS
// Time complexity: O(4^n), n is the length of the input
// Space complexity: O(4^n + n)
class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return new ArrayList<String>();
        char[][] d = new char[10][];
        
        d[0] = new char[]{' '};
        d[1] = new char[]{};
        d[2] = new char[]{'a', 'b', 'c'};
        d[3] = new char[]{'d', 'e', 'f'};
        d[4] = new char[]{'g', 'h', 'i'};
        d[5] = new char[]{'j', 'k', 'l'};
        d[6] = new char[]{'m', 'n', 'o'};
        d[7] = new char[]{'p', 'q', 'r', 's'};
        d[8] = new char[]{'t', 'u', 'v'};
        d[9] = new char[]{'w', 'x', 'y', 'z'};
        String cur = "";
        List<String> ans = new ArrayList<String>();
        dfs(digits, d, 0, cur, ans);
        return ans;
    }
    
    private void dfs(String digits, char[][] d, int l, String cur, List<String> ans) {
        if (l == digits.length()) {
            ans.add(cur);
            return;
        }
        
        for (final char c : d[digits.charAt(l) - '0']) {
            cur += c;
            dfs(digits, d, l + 1, cur, ans);
            cur = cur.substring(0, cur.length() - 1);
        }
    }
}

// // BFS
// // Time complexity: O(4^n)
// // Space complexity: O(2x4^n)
// class Solution {
//     public List<String> letterCombinations(String digits) {
//         if (digits.isEmpty()) return new ArrayList<String>();
        
//         char[][] d = new char[10][];
//         d[0] = new char[]{' '};
//         d[1] = new char[]{};
//         d[2] = new char[]{'a', 'b', 'c'};
//         d[3] = new char[]{'d', 'e', 'f'};
//         d[4] = new char[]{'g', 'h', 'i'};
//         d[5] = new char[]{'j', 'k', 'l'};
//         d[6] = new char[]{'m', 'n', 'o'};
//         d[7] = new char[]{'p', 'q', 'r', 's'};
//         d[8] = new char[]{'t', 'u', 'v'};
//         d[9] = new char[]{'w', 'x', 'y', 'z'};
//         List<String> ans = new ArrayList<>();
//         ans.add("");
//         for (char digit : digits.toCharArray()) {
//             List<String> tmp = new ArrayList<>();
//             for (final String s : ans) 
//                 for (char c : d[digit - '0']) 
//                     tmp.add(s + c);
//             List<String> swapList = new ArrayList<>();
//             swapList = tmp;
//             tmp = ans;
//             ans = swapList;
//         }
//         return ans;
//     }
// }

