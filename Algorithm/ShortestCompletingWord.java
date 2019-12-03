class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] l = new int[26];
        Arrays.fill(l, 0);
        for (char ch : licensePlate.toCharArray()) {
            if (Character.isLowerCase(ch) || Character.isUpperCase(ch)) {
                l[Character.toLowerCase(ch) - 'a'] = l[Character.toLowerCase(ch) - 'a'] + 1;
            }
        }
        String ans = new String();
        int min_l = Integer.MAX_VALUE;
        for (String word : words) {
            if (word.length() >= min_l) {
                continue;
            }
            if (!matches(l, word)) {
                continue;
            }
            min_l = word.length();
            ans = word;
        }
        return ans;
    }
    
    private boolean matches(int[] l, String word) {
        int[] c = new int[26];
        Arrays.fill(c, 0);
        for (char ch : word.toCharArray()) {
            c[Character.toLowerCase(ch) - 'a'] = c[Character.toLowerCase(ch) - 'a'] + 1;
        }
        for (int i = 0; i < 26; ++i) {
            if (c[i] < l[i]) {
                return false;
            }
        }
        return true;
    }
}
