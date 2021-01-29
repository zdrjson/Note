// Solution 1: HashTable
// Time complexity: O(|J| + |S|)
// Space complexity: O(128) / O(|J|)
class Solution {
    public int numJewelsInStones(String J, String S) {
        int[] f = new int[128];
        for (final char c : J.toCharArray())
            f[c] = 1;
        int ans = 0;
        for (final char c : S.toCharArray())
            ans += f[c];
        return ans;
    }
}
