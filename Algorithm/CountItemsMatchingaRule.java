// Solution: Brute Force
// Time complexity: O(n)
// Space complexity: O(1)
class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int ans = 0;
        for (List<String> item : items) {
            ans += ((ruleKey.equals("type") && item.get(0).equals(ruleValue)) ||
                    (ruleKey.equals("color") && item.get(1).equals(ruleValue)) ||
                    (ruleKey.equals("name") && item.get(2).equals(ruleValue))) ? 1 : 0;
        }
        return ans;
    }
}
