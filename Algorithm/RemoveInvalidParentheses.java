// Solution: DFS
// Time complexity: O(2^(l+r))
// Space complexity: O((l + r)^2) ~ O(n^2)
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int l = 0;
        int r = 0;
        
        for (char ch : s.toCharArray()) {
            l += (ch == '(') ? 1 : 0;
            if (l == 0) {
                r += (ch == ')') ? 1 : 0;
            } else {
                l -= (ch == ')') ? 1 : 0;
            }
        }
        
        List<String> ans = new ArrayList<String>();
        dfs(s, 0, l, r, ans);
        return ans;
    }
    
    private boolean isValid(String s) {
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') ++count;
            if (ch == ')') --count;
            if (count < 0) return false;
        }
        return count == 0;
    }
    
    // l/ r: number of left/ right parentheses to remove.
    private void dfs(String s, int start, int l, int r, List<String> ans) {
        // Nothing to remove.
        if (l == 0 && r == 0) {
            if (isValid(s)) ans.add(s);
            return;
        }
        
        for (int i = start; i < s.length(); ++i) {
            // We only remove the first parenthes if there are consecutive ones to avoid duplications.
            if (i != start && s.charAt(i) == s.charAt(i - 1)) continue;
            
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                String curr = s;
                curr = curr.substring(0, i) + curr.substring(i + 1);
                if (r > 0 && s.charAt(i) == ')') {
                    dfs(curr, i, l, r - 1, ans);
                } else if (l > 0 && s.charAt(i) == '(') {
                    dfs(curr, i, l - 1, r, ans);
                }
            }
        }
    }
}
