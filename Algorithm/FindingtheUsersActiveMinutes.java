// Solution: Hashsets in a Hashtable
// key: user_id, value: set{time}
// Time complexity: O(n + k)
// Space complexity: O(n + k)
class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> m = new HashMap<>();
        int[] ans = new int[k];
        for (int[] log : logs)
            m.computeIfAbsent(log[0], x -> new HashSet<Integer>()).add(log[1]);
        for (Map.Entry<Integer, Set<Integer>> kv : m.entrySet())
            ++ans[kv.getValue().size() - 1]; // kv.getKey()是取得key的写法，kv.getValue()是取得value的写法!!!
        return ans;
    }
}
