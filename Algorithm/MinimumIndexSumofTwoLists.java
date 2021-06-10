// Solution:
// Time complexity: O(n + m)
// Space complexity: O(n)
class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> indices = new HashMap<>();
        for (int i = 0; i < list1.length; ++i)
            indices.put(list1[i], i);
        
        List<String> ans = new ArrayList<>();
        int best_index = Integer.MAX_VALUE;
        
        for (int i = 0; i < list2.length; ++i) {
            if (!indices.containsKey(list2[i])) continue;
            int index = indices.get(list2[i]) + i;
            if (index < best_index) ans.clear();
            if (index <= best_index) {
                best_index = index;
                ans.add(list2[i]);
            }
        }
        
        String[] res = new String[ans.size()];
        for (int i = 0; i < res.length; ++i)
            res[i] = ans.get(i);
        
        return res;
    }
}
