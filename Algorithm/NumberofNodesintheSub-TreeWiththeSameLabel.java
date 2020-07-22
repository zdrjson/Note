// Solution: Post order traversal + hashtable
// For each label, record the count. When visiting a node. we first record the current count of its label as before, and traverse its children, when done, increment the current count, ans[i] = current - before.
// Time complexity: O(n)
// Space complexity: O(n)
class Solution {
    private List<List<Integer>> g;
    private String labels;
    private int[] ans;
    private int[] seen;
    private int[] count;
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        g = new ArrayList<List<Integer>>();
        this.labels = labels;
        for (int i = 0; i < n; ++i)
            g.add(new ArrayList<Integer>());
        for (int[] e : edges) {
            g.get(e[0]).add(e[1]);
            g.get(e[1]).add(e[0]);
        }
        ans = new int[n];
        seen = new int[n];
        count = new int[26];
        postOrder(0);
        return ans;
    }
    private void postOrder(int i) {
        if (seen[i]++ > 0) return;
        int before = count[labels.charAt(i) - 'a'];
        for (int j : g.get(i)) postOrder(j);
        ans[i] = ++count[labels.charAt(i) - 'a'] - before;
    }
}
