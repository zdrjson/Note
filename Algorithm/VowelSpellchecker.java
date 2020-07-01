// Solution: HashTable
// Using 3 hashtabbles: original words, lower cases, lower cases with vowels replaced to "*"
// Time complexity: O(|W| + |Q|)
// Space complexity: O(|W|)
class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        List<String> ans = new ArrayList<>();
        Map<String, String> m_org = new HashMap<>();
        Map<String, String> m_low = new HashMap<>();
        Map<String, String> m_vow = new HashMap<>();
        for (String w : wordlist) {
            // Original word
            m_org.put(w, w);
            // Case-insensitive
            String l = toLower(w);
            if (!m_low.containsKey(l)) m_low.put(l, w);
            // Vowel-insensitive
            String o = replaceVowels(l);
            if (!m_vow.containsKey(o)) m_vow.put(o, w);
        }
        
        for (String q : queries) {
            if (m_org.containsKey(q)) {
                ans.add(q);
                continue;
            }
            String l = toLower(q);
            if (m_low.containsKey(l)) {
                ans.add(m_low.get(l));
                continue;
            }
            
            String o = replaceVowels(l);
            if (m_vow.containsKey(o)) {
                ans.add(m_vow.get(o));
                continue;
            }
            ans.add("");
        }
        String[] res = new String[ans.size()];
        for (int i = 0; i < res.length; ++i)
            res[i] = ans.get(i);
        return res;
    }
    private String toLower(String s) {
        String l = new String(s);
        l = l.toLowerCase();
        return l;
    }
    private String replaceVowels(String s) {
        char[] o = new String(s).toCharArray();
        for (int i = 0; i < o.length; ++i)
            if (o[i] == 'a' || o[i] == 'e' || o[i] == 'i' || o[i] == 'o' || o[i] == 'u')
                o[i] = '*';
        return new String(o);
    }
}
