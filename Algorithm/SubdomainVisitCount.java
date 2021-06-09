// Solution: HashTable
// Time complexity: O(n)
// Space complexity: O(n)
class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> counts = new HashMap<>();
        for (final String cpdomain : cpdomains) {
            int index = cpdomain.indexOf(' '); // Java库中indexOf参数是传入字符串，这里试一下传入字符运行可以。
            int count = Integer.valueOf(cpdomain.substring(0, index));
            String domain = cpdomain.substring(index + 1);
            while (true) {
                counts.put(domain, counts.getOrDefault(domain, 0) + count);
                int i = domain.indexOf('.');
                if (i == -1) break;
                domain = domain.substring(i + 1);
            }
        }
        List<String> ans = new ArrayList<>();
        for (final Map.Entry<String, Integer> kv : counts.entrySet())  // 不要忘了Map.Entry前面加上final。
            ans.add(String.valueOf(kv.getValue()) + " " + kv.getKey());
        return ans; 
    }
}
