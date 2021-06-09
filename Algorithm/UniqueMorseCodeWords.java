// Solution: HashTable
// Time complexity: O(n)
// Space complexity: O(n)
class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] m = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> s = new HashSet<>();
        for (final String word : words) {
            String code = ""; // JavaS的tring一定要初始化后才能添加字符串。
            for (char c : word.toCharArray()) 
                code += m[c - 'a'];
            s.add(code);
        }
        return s.size();
    }
}
