class Solution {
    public String reverseStr(String s, int k) {
        final int n = s.length();
        StringBuilder ans = new StringBuilder(s);
        for (int i = 0; i <= n / k; i += 2) {
            StringBuilder sb = new StringBuilder(s.substring(i * k, Math.min(n, (i + 1) * k)));
            ans.replace(i * k, Math.min(n, (i + 1) * k), sb.reverse().toString());
        }
        return ans.toString();
    }
}
