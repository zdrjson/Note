// Solution: Brute Force
// Sort the range of each query and check.
// Time complexity: O(nlogn * m)
// Space complexity: O(n)
class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans = new ArrayList<Boolean>();
        for (int i = 0; i < l.length; ++i)
            ans.add(true);
        for (int i = 0; i < l.length; ++i) {
            int[] arr = new int[r[i] - l[i] + 1];
            for (int x = 0; x < arr.length; ++x)
                arr[x] = nums[x + l[i]];
            Arrays.sort(arr);
            final int d = arr[1] - arr[0];
            for (int j = 1; j < arr.length && ans.get(i); ++j)
                ans.set(i, ans.get(i) && (arr[j] - arr[j - 1] == d));
        }
        return ans;
    }
}
