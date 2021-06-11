// Solution: String
class Solution {
    public String toGoatLatin(String S) {
        final String vowels = "aeiouAEIOU";
        StringBuilder ans = new StringBuilder();
        int index = 0;
        String[] words = S.split(" ");
        for (String word : words) {
            if (!vowels.contains(String.valueOf(word.charAt(0))))  // String的contains方法参数要传入String，否则报char cannot be converted to CharSequence。
                word = word.substring(1) + word.substring(0, 1);
            ans.append(" ").append(word).append("ma").append("a".repeat(++index));
        }
        return ans.substring(1);
    }
}
