// Solution:
// Time complexity: O(2^n)
// Space complexity: O(2^n)
class Solution {
    private Map<String, List<String>> mem_;
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        mem_ = new HashMap<>();
        Set<String>dict = new HashSet<String>(wordDict);
        return wordBreak(s, dict);
    }
    // >> append({"cats and", "cat sand"}, "dog");
    // {"cats and dog", "cat sand dog"}
    private List<String> append(List<String> prefixes, String word) {
        List<String> results = new ArrayList<String>();
        for (String prefix : prefixes) 
            results.add(prefix + " " + word);
        return results;
    }
    
    private List<String> wordBreak(String s, Set<String> dict) {
        // Already in memory, return directly
        if (mem_.containsKey(s)) return mem_.get(s);
        
        //Answer for s
        List<String> ans = new ArrayList<String>();
        
        //s in dict, add it to the answer array
        if (dict.contains(s)) 
            ans.add(s);
        
        for (int j = 1; j < s.length(); ++j) {
            // Check whether right part is a word
            String right = s.substring(j);
            if (!dict.contains(right)) continue;
            
            // Get the ans for left part
            String left = s.substring(0 , j);
            List<String> left_ans = append(wordBreak(left, dict), right);
            
            // Notice, cant not use mem_ here,
            // Since we haven't got the ans for s yet.
            ans.addAll(left_ans);
        }
        
        // memorize and return 
        mem_.put(s, ans);
        return mem_.get(s);
    }
}
