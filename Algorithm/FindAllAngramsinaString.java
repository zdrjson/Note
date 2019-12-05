/* Solution : HashTable + Sliding Window
   Time complexity: O(n)
   Space complexity: O(n)
*/
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length();
        int l = p.length();
        List<Integer> ans = new ArrayList<Integer>();
        int[] vp = new int[26];
        Arrays.fill(vp, 0);
        int[] vs = new int[26];
        Arrays.fill(vs, 0);
        for (char c : p.toCharArray()) {
            ++vp[c - 'a'];
        }
        char[] s1 = s.toCharArray();
        for (int i = 0; i < n; ++i) {
            if (i >= l) {
                --vs[s1[i - l] - 'a'];
            }
            ++vs[s1[i] - 'a'];
            if (Arrays.equals(vs, vp)) {
                ans.add(i + 1 - l);
            }
        }
        return ans;
    }
}
