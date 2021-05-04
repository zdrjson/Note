// Solution: DFS
// Time complexity: O(2^n)
// Space complexity: O(n)
class Solution {
    private String s;
    private List<Long> nums;
    private int n;
    public boolean splitString(String s) {
        this.s = s;
        this.n = s.length();
        this.nums = new ArrayList<Long>();
        return dfs(0);
    }
    private boolean dfs(int p) {
        if (p == n) return nums.size() >= 2;
        long cur = 0;
        for (int i = p; i < n && cur < 1e11; ++i) {
            cur = cur * 10 + (s.charAt(i) - '0');
            if (nums.isEmpty() || cur + 1 == nums.get(nums.size() - 1)) {
                nums.add(cur);
                if (dfs(i + 1)) return true;
                nums.remove(nums.size() - 1);
            }
            if (!nums.isEmpty() && cur >= nums.get(nums.size() - 1)) break;
        }
        return false;
    }
}
