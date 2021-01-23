// Solution: Greedy + Stack
// Remove the parrtern with the larger score first.
// Using a stack to remove all occurrences of a pattern in place in O(n) Time.
// Time complexity: O(n)
// Space complexity: O(1)
class Solution {
    private StringBuilder sb;
    public int maximumGain(String s, int x, int y) {
        // Remove pattern p from s for t points each.
        // Return the total score.
        sb = new StringBuilder(s);
        String px = "ab";
        String py = "ba";
        if (y > x) {
            String tmpS = px;
            px = py;
            py = tmpS;
            int tmp = x;
            x = y;
            y = tmp;
        }
        return remove(px, x) + remove(py, y);
    }
    private int remove(String p, int t) {
        int total = 0;
        int i = 0;
        for (int j = 0; j < sb.length(); ++j, ++i) {
            sb.setCharAt(i, sb.charAt(j));
            if (i != 0 && sb.charAt(i - 1) == p.charAt(0) && sb.charAt(i) == p.charAt(1)) {
                i -= 2;
                total += t;
            }
        }
        sb.setLength(i);
        return total;
    }
}
