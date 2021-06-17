// Solution: Bit
// Time complexity: O(logN)
// Space complexity: O(1)
class Solution {
    public int binaryGap(int N) {
        int l = -1;
        int ans = 0;
        for (int i = 0; i < 31; ++i) {
            if ((N & (1 << i)) != 0) { // Java这里要写成不等于0，答案才对。还有注意N & (1 << i)外面要加括号后才能和0作比较。
                if (l >= 0)
                    ans = Math.max(ans, i - l);
                l = i;
            }
        }
        return ans;
    }
}
