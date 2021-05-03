// Solution: Sort
// arr[0] = 1,
// arr[i] = min(arr[i], arr[i - 1] + 1)
// ans = arr[n - 1]
// Time complexity: O(nlogn)
// Space complexity: O(1)
class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        final int n = arr.length;
        Arrays.sort(arr);
        arr[0] = 1;
        for (int i = 1; i < n; ++i)
            arr[i] = Math.min(arr[i], arr[i - 1] + 1);
        return arr[n - 1];
    }
}
