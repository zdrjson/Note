// Solution: XOR
// encoded[i] = arr[i] ^ arr[i + 1]
// encoded[i] ^ arr[i] = arr[i] ^ arr[i] ^ arr[i + 1] 
// arr[i + 1] = encoded[i]^arr[i]
// Time complexity: O(n)
// Space complexity: O(n)
class Solution {
    public int[] decode(int[] encoded, int first) {
        final int n = encoded.length + 1;
        int[] ans = new int[n];
        ans[0] = first;
        for (int i = 0; i + 1 < n; ++i)
            ans[i + 1] = ans[i] ^ encoded[i];
        return ans;
    }
}
