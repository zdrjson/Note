// Solution: Brute Force
// Time complexity: O(n^2)
// Space complexity: O(n)
class Solution {
    public int maxRepeating(String sequence, String word) {
        StringBuilder s = new StringBuilder(word);
        for (int i = 1; ; ++i) {
            if (!sequence.contains(s.toString())) return i - 1;
            s.append(word);
        }
        // 由于不可能走到这行，所以Java加了下面这行不能编译通过。
        // return -1;
    }
}
