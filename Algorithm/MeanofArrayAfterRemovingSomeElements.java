// Solution: Sorting
// Time complexity: O(nlogn)
// Space complexity: O(1)
class Solution {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        final int offset = arr.length / 20;
        int sum = 0;
        for (int i = offset; i < arr.length - offset; ++i)
            sum += arr[i];
        return (double)sum / (arr.length - 2 * offset); // 返回值为double类型，强制转换为double类型要对sum转换，因为sum为int类型，如何对整个sum / (arr.length - 2 * offset)来强制转换为double类型，答案不对。
    }
}
