// Solution: Bit Operation
// f(n) = f(f(n - 1) << length(n)) | n
// length(n) increase by 1 whenever n is power of 2.
// n = 1, YES, len = 1
// n = 2, YES, len = 2
// n = 3, NO, len = 2
// n = 4, YES, len = 3
// n = 5, NO, len = 3
// n = 6, NO, len = 3
// n = 7, NO, len = 3
// n = 8, YES, len = 4
// ...
// Time complexity: O(n)
// Space complexity: O(1)
class Solution {
    public int concatenatedBinary(int n) {
        final int kMod = (int)1e9 + 7;
        long ans = 0;
        for (int i = 1, len = 0; i <= n; ++i) {
            if ((i & (i - 1)) == 0) ++len;
            ans = ((ans << len) % kMod + i) % kMod;
        }
        return (int)ans;
    }
}
