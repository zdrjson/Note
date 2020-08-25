// Solution: In degree
// Nodes with 0 in degree will be the answer.
// Time complexity: O(E+V)
// Space complexity: O(V)
class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] in = new int[n];
        for (List<Integer> e : edges) ++in[e.get(1)];
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < n; ++i)
            if (in[i] == 0) ans.add(i);
        return ans;
    }
}
