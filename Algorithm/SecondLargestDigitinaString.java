// Solution: Hashtable
// Time complexity: O(n)
// Space complexity: O(1)
class Solution {
    public int secondHighest(String s) {
        int[] d = new int[10];
        for (char c : s.toCharArray())
            if (c >= '0' && c <= '9')
                d[c - '0'] = 1;
        int order = 0;
        for (int i = 9; i >= 0; --i)
            if (d[i] != 0 && ++order == 2)
                return i;
        return -1;
    }
}
