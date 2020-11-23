// Solution: Generation
// Use numbers from {-n/2,... n/2} + {0 if n is odd}
// Time complexity: O(n)
// Space complexity: O(1)
class Solution {
    public int[] sumZero(int n) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= n / 2; ++i) {
            ans.add(i);
            ans.add(-i);
        }
        if (ans.size() != n) ans.add(0);
        int[] res = new int[ans.size()];
        for (int i = 0; i < res.length; ++i)
            res[i] = ans.get(i);
        return res;
    }
}
