class Solution {
    public String reverseStr(String s, int k) {
        final int n = s.length();
        StringBuilder ans = new StringBuilder(s);
        for (int i = 0; i <= n / k; i += 2) {
            final int start = i * k;
            final int end = Math.min(n, (i + 1) * k);
            StringBuilder sb = new StringBuilder(ans.substring(start, end));
            ans.replace(start, end, sb.reverse().toString());
        }
        return ans.toString();
    }
}
