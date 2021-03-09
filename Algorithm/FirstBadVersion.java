/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
// 模板中 r = n + 1, 但是会溢出(n = 2^31 -1)
// 改成r = n 也能通过的原因是：
// 如果在[1, n）这个范围内没有找到解会返回真正的解n
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int l = 1;
        int r = n;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (isBadVersion(m)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}


