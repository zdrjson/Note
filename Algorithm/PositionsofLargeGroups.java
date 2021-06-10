// Solution: Brute Force
// Time complexity: O(n)
// Space complexity: O(n)
// 花花的代码暂时无法编译，Java这里改了第10，和第11行就能编译通过了。
class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        final int kLargeGroupSize = 3;
        final int n = S.length();
        List<List<Integer>> ans = new ArrayList<>();
        int c = 1;
        for (int i = 1; i <= n; ++i, ++c) {
            if (i == n || S.charAt(i) != S.charAt(i - 1)) { // 由于Java字符串取S.charAt(-1)属于越界，不能编译。代码和C++改了一点点不同。
                if (c >= kLargeGroupSize) ans.add(Arrays.asList(i - c, i - 1));
                c = 0;
            }
        }
        return ans;
    }
}
