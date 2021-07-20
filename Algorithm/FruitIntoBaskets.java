// Solution: Hashtable + Sliding window
// Time complexity: O(n)
// Space complexity: O(1)
// Keep track of the last index of each element. If a third type of fruit comes in, the new window starts after the fruit with smaller last index. Otherwise extend the current window.
// [1 3 1 3 1 1] 4 1 4 ... <- org window, 3 has a smaller last index than 1.
// 1 3 1 3 [1 1 4] 1 4 ... <- new window
class Solution {
    public int totalFruit(int[] tree) {
        TreeMap<Integer, Integer> idx = new TreeMap<>(); // {fruit -> last_index}
        int ans = 0;
        int cur = 0;
        for (int i = 0; i < tree.length; ++i) {
            int f = tree[i];
            if (!idx.containsKey(f)) {
                if (idx.size() == 2) {
                    Map.Entry<Integer, Integer> it1 = idx.firstEntry();
                    Map.Entry<Integer, Integer> it2 = idx.lastEntry();
                    if (it1.getValue() > it2.getValue()) {
                        Map.Entry<Integer, Integer> tmp = it1;
                        it1 = it2;
                        it2 = tmp;
                    }
                    cur = i - it1.getValue() - 1;
                    idx.remove(it1.getKey());
                }
            }
            idx.put(tree[i], i);
            ans = Math.max(++cur, ans);
        }
        return ans;
    }
}
