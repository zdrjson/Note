class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0;
        int r = letters.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (letters[m] <= target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return letters[(l % letters.length)]; // l != letters.length 返回 l 
    }                                         // l == letters.length 返回 0
}
