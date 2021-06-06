// Solution: HashTable
// Time complexity: O(n)
// Space complexity: O(n)
// class Solution {
//     public int findLHS(int[] nums) {
//         Map<Integer, Integer> counts = new HashMap<>();
//         int ans = 0;
//         for (int num : nums) {
//             counts.put(num, counts.getOrDefault(num, 0) + 1);
//             int l = counts.getOrDefault(num - 1, 0);
//             int r = counts.getOrDefault(num + 1, 0);
//             if (l != 0 || r != 0)
//                 ans = Math.max(ans, counts.get(num) + Math.max(l, r));
//         }
//         return ans;
//     }
// }

// class Solution {
//     public int findLHS(int[] nums) {
//         Map<Integer, Integer> counts = new HashMap<>();
//         int ans = 0;
//         for (int num : nums) {
//             counts.put(num, counts.getOrDefault(num, 0) + 1);
//             final int c = counts.get(num);
//             Integer it1 = counts.get(num - 1);
//             Integer it2 = counts.get(num + 1);
//             if (it1 != null)
//                 ans = Math.max(ans, c + it1);
//             if (it2 != null)
//                 ans = Math.max(ans, c + it2);
//         }
//         return ans;
//     }
// }

class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        int ans = 0;
        for (int num : nums)
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        
        for (Map.Entry<Integer, Integer> kv : counts.entrySet()) {
            Integer it1 = counts.get(kv.getKey() - 1);
            Integer it2 = counts.get(kv.getKey() + 1);
            if (it1 != null)
                ans = Math.max(ans, kv.getValue() + it1);
            if (it2 != null)
                ans = Math.max(ans, kv.getValue() + it2);
        }
        return ans;
    }
}
