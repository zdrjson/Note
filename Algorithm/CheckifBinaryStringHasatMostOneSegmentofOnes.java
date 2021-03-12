// Solution: Counting
// increase counter if s[i] == '1' otherwise, reset counter.
// increase counts when counter becomes 1.
// return counts == 1
// Time complexity: O(n)
// Space complexity: O(1)
class Solution {
    public boolean checkOnesSegment(String s) {
        int count = 0;
        int ones = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                count += (++ones == 1 ? 1 : 0); // 再次强调Java的==返回的是true或者false，而不是1或者0。要返回1或者0要用三目运算符！！！
            } else {
                ones = 0;
            }
        }
        return count == 1;
    }
}
