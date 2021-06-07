// // Solution: BST + Greedy
// // Time complexity: O(nlogn)
// // Space complexity: O(n)
// class Solution {
//     public boolean isPossibleDivide(int[] nums, int k) {
//         if (nums.length % k != 0) return false;
//         TreeMap<Integer, Integer> m = new TreeMap<>();
//         for (int num : nums)
//             m.put(num, m.getOrDefault(num, 0) + 1);
//         while (m.size() != 0) {
//             int s = m.firstKey();
//             for (int i = 0; i < k; ++i) {
//                 if (!m.containsKey(s + i)) return false;
//                 int v = m.get(s + i) - 1;
//                 if (v == 0) m.remove(s + i);
//                 else m.put(s + i, v);
//             }
//         }
//         return true;
//     }
// }

// Solution: V2 BST + Greedy
// Time complexity: O(nlogn)
// Space complexity: O(n)
class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0) return false;
        TreeMap<Integer, Integer> m = new TreeMap<>();
        for (int num : nums)
            m.put(num, m.getOrDefault(num, 0) + 1);
        while (m.size() != 0) {
            Map.Entry<Integer, Integer> it = m.firstEntry();
            int s = it.getKey();
            for (int i = 0; i < k; ++i) {
                if (it.getKey() != s + i) return false;
                int v = it.getValue() - 1;
                if (v == 0) m.remove(it.getKey());
                else m.put(it.getKey(), v);
                it = m.higherEntry(it.getKey());
            }
        }
        return true;
    }
}

// Solution 2: HashTable
// Time complexity: O(n)
// Space complexity: O(n)
class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0) return false;
        Map<Integer, Integer> f = new HashMap<>();
        for (int num : nums) f.put(num, f.getOrDefault(num, 0) + 1);
        Queue<Integer> starts = new LinkedList<>();
        for (Map.Entry<Integer, Integer> kv : f.entrySet())
            if (!f.containsKey(kv.getKey() - 1)) starts.offer(kv.getKey());
        while (!starts.isEmpty()) {
            int s = starts.poll();
            for (int t = s + k - 1; t >= s; --t) {
                if (f.getOrDefault(t, 0) < f.get(s)) return false; //这里写成f.getOrDefault(t, 0) 因为有可能t不存在。
                f.put(t, f.get(t) - f.get(s));
                if (f.get(t) == 0) {
                    f.remove(t);
                    if (f.containsKey(t + 1)) starts.offer(t + 1);
                }
            }
        }
        return true;
    }
}
