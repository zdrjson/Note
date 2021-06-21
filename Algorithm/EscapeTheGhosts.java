// Solution: Greedy / Math
// You can escape if and only if no ghosts can reach target before you. Just need to compare the Manhattan distance.
// Time complexity: O(|ghost|)
class Solution {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        final int steps = Math.abs(target[0]) + Math.abs(target[1]);
        for (int[] g : ghosts)
            if (Math.abs(g[0] - target[0]) + Math.abs(g[1] - target[1]) <= steps)
                return false;
        return true;
    }
}
