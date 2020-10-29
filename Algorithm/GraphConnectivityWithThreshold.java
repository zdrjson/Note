// Solution: Union Find
// For x, merge 2x, 3x, 4x,..,
// If a number is already "merged", skip it.
// Time complexity: O(nlogn? + queries)?
// Space complexity: O(n)
class Solution {
    private int[] ds;
    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        List<Boolean> ans = new ArrayList<Boolean>();
        if (threshold == 0) {
            for (int i = 0; i < queries.length; ++i)
                ans.add(true);
            return ans;
        }
        ds = new int[n + 1];
        for (int i = 0; i < ds.length; ++i) // C++的iota方法表示：用顺序递增的值复制指定范围内的元素。
            ds[i] = i;
        for (int x = threshold + 1; x <= n; ++x) 
            if (ds[x] == x) 
            for (int y = 2 * x; y <= n; y += x)
                ds[Math.max(find(x), find(y))] = Math.min(find(x), find(y));
        
        for (int[] q : queries)
            ans.add(find(q[0]) == find(q[1]));
        return ans;
    }
    private int find(int x) {
        return ds[x] == x ? x : (ds[x] = find(ds[x])); // 这个三目运算符最右边有赋值表达式的时候要加括号，否则编译不通过。
    }
}
