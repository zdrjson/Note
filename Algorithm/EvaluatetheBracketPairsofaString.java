// Solution: Hashtable + Simulation
// Time complexity: O(n+k)
// Space complexity: O(n+k)
class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> m = new HashMap<>();
        for (List<String> p : knowledge)
            m.put(p.get(0), p.get(1));
        StringBuilder ans = new StringBuilder();
        StringBuilder cur = new StringBuilder();
        boolean in = false;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                in = true;
            } else if (c == ')') {
                if (m.containsKey(cur.toString()))
                    ans.append(m.get(cur.toString()));
                else
                    ans.append("?");
                cur.setLength(0); // 注意StringBuilder没有clear()方法！！！
                in = false;
            } else {
                if (!in) ans.append(c);
                else cur.append(c);
            }
        }
        return ans.toString();
    }
}
