// Solution: Hashtable
// Time complexity: O(sum(len(word)))
// Space complexity: O(1)
class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int[] m = new int[26];
        for (char c : allowed.toCharArray()) m[c - 'a'] = 1;
        int ans = 0;
        for (String word : words) {
            boolean allow = true;
            for  (char c : word.toCharArray()) 
                if (m[c - 'a'] == 0) {
                    allow = false;
                    break;
                }
            ans += allow ? 1 : 0; 
        }
        return ans;
    }
}
