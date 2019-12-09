class MapSum {
    
    /** Initialize your data structure here. */
    public MapSum() {
       root = new Trie();
       vals_ = new HashMap<>();
    }
    
    public void insert(String key, int val) {
        int inc = val - vals_.getOrDefault(key, 0);
        Trie p = root;
        for (char c : key.toCharArray()) {
            if (p.children[c] == null) {
                p.children[c] = new Trie();
            }
            p.children[c].sum += inc;
            p = p.children[c];
        }
        vals_.put(key, val);
    }
    
    public int sum(String prefix) {
         Trie p = root;
          for (char c : prefix.toCharArray()) {
              if (p.children[c] == null) {
                  return 0;
              }
              p = p.children[c];
          }
          return p.sum;
    }
    class Trie {
        public Trie() {
            children = new Trie[128];
            sum = 0;
        }
        public Trie[] children;
        public int sum;
    }
    private Trie root; // dummy root
    private Map<String, Integer> vals_; // key -> val
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
