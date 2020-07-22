// Solution:Greedy
// Observation: If a valid substring contains shorter valid strings, ignore the longer one and use the shorter one.
// e.g. "abbeefba" is a valid substring, however, it includes "bbeefb", "ee", "f" three valid substrings, thus it won't be part of the optimal solution, since we can always choose a shorter one, with potential to have one or more non-overlapping substrings. For "bbeefb", again it includes "ee" and "f", so it won't be optimal either. Thus, the optimal ones are "ee" and "f".
// 1. We just need to record the first and last occurrence of each character
// 2. When we meet a character for the first time we must include everything from current pos to it's last position. e.g. "abbeefba" | ccc, from first 'a' to last 'a', we need to cover "abbbeefba"
// 3. If any character in that range has larger end position, we must extend the string. e.g. "abcabbcc" | efg, from first 'a' to last 'a', we have characters 'b' and 'c', so we have to extend the string to cover all 'b's and 'c's. Our first valid substring extended from "abca" to "abcabbcc".
// 4. If any character in the covered range has a smallest first occurrence, then it's an invalid substring. e.g. ab | "cbc", from first 'c' to last 'c', we have 'b', but 'b' is not fully covered, thus "cbc" is an invalid substring.
// 5. For the first valid substring, we append it to the ans array. "abbeefba" => ans = ["abbeefba"]
// 6. If we find a shorter substring that is full convered by the previous valid substring, we replace that substring with the shorter one. e.g.
// "abbeefba" | ccc => ans = ["abbeefba"]
// "abbeefba" | ccc => ans = ["bbeefb"]
// "abbeefba" | ccc => ans = ["ee"]
// 7. If the current substring does not overlap with previous one. append it to ans array.
// "abbeefba" | ccc => ans = ["ee"]
// "abbeefba" | ccc => ans = ["ee", "f"]
// "abbeefbaccc" => ans = ["ee", "f", "ccc"]
// Time complexity: O(n)
// Space complexity: O(1)
class Solution {
    private String s;
    private int[] l;
    private int[] r;
    public List<String> maxNumOfSubstrings(String s) {
        this.s = s;
        int n = s.length();
        l = new int[26];
        Arrays.fill(l, Integer.MAX_VALUE);
        r = new int[26];
        Arrays.fill(r, Integer.MIN_VALUE);
        for (int i = 0; i < n; ++i) {
            l[s.charAt(i) - 'a'] = Math.min(l[s.charAt(i) - 'a'], i);
            r[s.charAt(i) - 'a'] = Math.max(r[s.charAt(i) - 'a'], i);
        }
        
        List<String> ans = new ArrayList<String>();
        int last = -1;
        for (int i = 0; i < n; ++i) {
            if (i != l[s.charAt(i) - 'a']) continue;
            int p = extend(i);
            if (p == -1) continue;
            if (i > last) ans.add("");
            ans.set(ans.size() - 1, s.substring(i, p + 1));
            last = p;
        }
        return ans;
    }
    private int extend(int i) {
        int p = r[s.charAt(i) - 'a'];
        for (int j = i; j <= p; ++j) { // invalid substring
            if (l[s.charAt(j) - 'a'] < i) // e.g. a|"ba"...b
                return -1;
            p = Math.max(p, r[s.charAt(j) - 'a']);
        }
        return p;
    }
}
