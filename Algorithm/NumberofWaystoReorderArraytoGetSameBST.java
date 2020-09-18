// Solution: Recursion + Combinatorics
// For a given root (first element of the array), we can split the array into left children (nums[i] < nums[0]) ans right children (nums[i] > nums[0]). Assuming there are l nodes for the left and r nodes for the right. We have C(l + r, l) different ways to insert l elements into a (l + r) sized array. Within node l / r nodes, we have ways(left) / ways(right) different ways to re-arrange those nodes. So the total # of ways is:
// C(l + r, l) * ways(l) * ways(r)
// Don't forget to minus one for the final answer.
// Time complexity: O(n^2)
// Space complexity: O(n^2)
class Solution {
    private int kMod;
    private int[][] cnk;
    public int numOfWays(int[] nums) {
        final int n = nums.length;
        kMod = (int)1e9 + 7;
        cnk = new int[n + 1][n + 1];
        for (int[] c : cnk)
            Arrays.fill(c, 1);
        for (int i = 1; i <= n; ++i)
            for (int j = 1; j < i; ++j)
                cnk[i][j] = (cnk[i - 1][j] + cnk[i - 1][j - 1]) % kMod;
        List<Integer> numsList = new ArrayList<Integer>(nums.length);
        for (int i = 0; i < nums.length; ++i)
            numsList.add(nums[i]);
        return trees(numsList) - 1;
    }
    private int trees(List<Integer> nums) {
        int n = nums.size();
        if (n <= 2) return 1;
        List<Integer> left = new ArrayList<Integer>();
        List<Integer> right = new ArrayList<Integer>();
        for (int i = 1; i < n; ++i) // 这里for循环外面不用括号没关系，可以运行编译。
            if (nums.get(0) > nums.get(i)) left.add(nums.get(i)); 
            else right.add(nums.get(i)); 
        long ans = cnk[n - 1][left.size()];
        ans = (ans * trees(left)) % kMod;
        ans = (ans * trees(right)) % kMod;
        return (int)ans;
    }
}
