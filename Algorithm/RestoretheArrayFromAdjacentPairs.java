// Solution: Hashtable
// Reverse thinking! For a given input array, e.g.
// [1, 2, 3, 4, 5]
// it's adjacent pairs are [1,2], [2,3], [3,4], [4,5]
// all numbers appeared exactly twice except 1 and 5, since they are on the boundary.
// We just need to find the head of tail of the input array, and construct the rest of the array in order.
// Time complexity: O(n)
// Space complexity: O(n)
class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        int n = adjacentPairs.length + 1;
        Map<Integer, List<Integer>> g = new HashMap<>();
        for (int[] p : adjacentPairs) {
            g.computeIfAbsent(p[0], k -> new ArrayList<Integer>()).add(p[1]);
            g.computeIfAbsent(p[1], k -> new ArrayList<Integer>()).add(p[0]);
        }
        
        int[] ans = new int[n];
        for (Map.Entry<Integer, List<Integer>> kv : g.entrySet()) {
            int u = kv.getKey();
            List<Integer> vs = kv.getValue();
            if (vs.size() == 1) {
                ans[0] = u;
                ans[1] = vs.get(0);
                break;
            }
        }
        
        for (int i = 2; i < n; ++i) {
            List<Integer> vs = g.get(ans[i - 1]);
            ans[i] = vs.get(0) == ans[i - 2] ? vs.get(1) : vs.get(0);
        }
        return ans;
    }
}
