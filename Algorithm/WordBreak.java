// // Solution: DP
// // Time complexity: O(n^2)
// // Space complexity: O(n^2)
// class Solution {
//     public boolean wordBreak(String s, List<String> wordDict) {
//         // Create a hashset of words for fast query.
//         Set<String> dict = new HashSet<String>(wordDict);
//         // Query the answer of the original string.
//         Map<String, Boolean> mem = new HashMap<String, Boolean>();
//         return workBreak(s, mem, dict);
//     }
    
//     private boolean workBreak(String s, Map<String, Boolean> mem, Set<String> dict) {
//         // In memory. directly return.
//         if (mem.containsKey(s)) return mem.get(s);
//         // Whose string is a word, memorize and return.
//         if (dict.contains(s)) {
//             mem.put(s, true);
//             return true;
//         }
//         // Try every break point.
//         for (int i = 1; i < s.length(); ++i) {
//             // Find the solution for s.
//             if (dict.contains(s.substring(i)) && workBreak(s.substring(0, i), mem, dict)) {
//                 mem.put(s, true);
//                 return true;
//             }
//         }
//         // No solution for s, memorize and return.
//         mem.put(s, false);
//         return false;
//     }
// }

// Solution: without using dict. 
class Solution {
    private Map<String, Boolean> mem_;
    public boolean wordBreak(String s, List<String> wordDict) {
        // Mark evert word as breakable.
        mem_ = new HashMap<>();
        for (String word : wordDict)
            mem_.put(word, true);

        // Query the answer of the original string.
        return wordBreak(s);
    }
    
    private boolean wordBreak(String s) {
        // In memory, directly return.
        if (mem_.containsKey(s)) return mem_.get(s);
        
        // Try every break point.
        for (int j = 1; j < s.length(); ++j) {
            Boolean it = mem_.get(s.substring(j));  // 这里注意接受it用Boolean类型，而不是boolean。
            // Find the solution for s.
            if (it != null && it && wordBreak(s.substring(0, j))) {
                mem_.put(s, true);
                return true;
            }
        }
        
        // No solution for s, memorize and return.
        mem_.put(s, false);
        return false;
    }
}
