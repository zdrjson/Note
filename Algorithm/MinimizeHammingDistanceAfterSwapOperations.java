// Solution: Union Find
// Simiar to 1202 花花酱 LeetCode 1202. Smallest String With Swaps
// Think each pair as an edge in a graph. Since we can swap as many time as we want, which means we can arrange the elements whose indices are in a connected component (CC) in any order.
// For each index, we increase the counter of CC(i) for key source[i] and decrease the counter of the same CC for key target[i]. If two keys are the same (can from different indices), one from source and one from target, it will cancel out, no distance. Otherwise, the counter will be off by two. Finally we sum up the counter for all the keys and divide it by two to get the hamming distance.
// Time complexity: O(V+E)
// Space complexity: O(V)
class Solution {
    private int[] p;
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        final int n = source.length;
        p = new int[n];
        for (int i = 0; i < n; ++i)
            p[i] = i;
        
        for (int[] s : allowedSwaps)
            p[find(s[0])] = find(s[1]);
        
        Map<Integer, Map<Integer, Integer>> m = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            Map<Integer, Integer> sm = m.computeIfAbsent(find(i), k -> new HashMap<Integer, Integer>());
            sm.put(source[i], sm.getOrDefault(source[i], 0) + 1);
            Map<Integer, Integer> tm = m.computeIfAbsent(find(i), k -> new HashMap<Integer, Integer>());
            tm.put(target[i], tm.getOrDefault(target[i], 0) - 1);
        }
        
        int ans = 0;
        for (Map.Entry<Integer, Map<Integer, Integer>> g : m.entrySet())
            for (Map.Entry<Integer, Integer> kv : g.getValue().entrySet())
                ans += Math.abs(kv.getValue());
        return ans / 2;
    }
    private int find(int x) {
        return x == p[x] ? x : (p[x] = find(p[x])); // 注意Java中这里三目运算符最后的merge的最外面要加括号，否则编译不能通过，return返回值不知道什么类型!!!
    }
}
