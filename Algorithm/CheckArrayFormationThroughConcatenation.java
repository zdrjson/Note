// Solution: Hashtable
// Store the index of the first number of each piece, for each number a in arr, concat the entire piece array whose first element equals to a.
// Time complexity: O(n)
// Space complexity: O(n)
class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        for (int i = 0; i < pieces.length; ++i)
            m.put(pieces[i][0], i);
        
        List<Integer> ans = new ArrayList<Integer>();
        for (int a : arr) {
            if (!m.containsKey(a)) continue;
            List<Integer> tmp = new ArrayList<Integer>();
            for (int e : pieces[m.get(a)])
                tmp.add(e);
            ans.addAll(tmp);
        }
        
        int[] res = new int[ans.size()];
        for (int i = 0; i < res.length; ++i)
            res[i] = ans.get(i);
        return Arrays.equals(res, arr); // 又出现了，长记性了！！！
    }
}
