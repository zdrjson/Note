// Solution: Search
class Solution {
    private Set<String> seen;
    private String ans;
    private int a;
    private int b;
    public String findLexSmallestString(String s, int a, int b) {
        seen = new HashSet<String>();
        ans = s;
        this.a = a;
        this.b = b;
        dfs(s);
        return ans;
    }
    private void dfs(String s) {
        if (!seen.add(s)) return;
        ans = ans.compareTo(s) < 0 ? ans : s;
        StringBuilder t = new StringBuilder(s);
        for (int i = 1; i < s.length(); i += 2) 
            t.setCharAt(i, (char)((t.charAt(i) - '0' + a) % 10 + '0'));
        dfs(t.toString());
        dfs(s.substring(b) + s.substring(0, b));
    }
}
