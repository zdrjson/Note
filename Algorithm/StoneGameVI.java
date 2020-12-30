// Solution: Greedy
// Sort by the sum of stone values.
// Time complexity: O(nlogn)
// Space complexity: O(n)
class Solution {
    public int stoneGameVI(int[] A, int[] B) {
        final int n = A.length;
        List<int[]> s = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            s.add(new int[]{A[i] + B[i], i});
        }
        s.sort((a, b) -> b[0] - a[0]);
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int idx = s.get(i)[1];
            ans += ((i & 1) == 1 ? B[idx] : A[idx]) * ((i & 1) == 1 ? -1 : 1); // 注意Java中一个数&一个数外面加括号。不加括号会影响运算顺序，导致不能编译。
        }
        return ans < 0 ? -1 : (ans > 0 ? 1 : 0);
    }
}
