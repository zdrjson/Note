class RandomizedSet {
    // val -> index in the array
    private Map<Integer, Integer> m_;
    private List<Integer> vals_;
    Random r = new Random();
    /** Initialize your data structure here. */
    public RandomizedSet() {
        m_ = new HashMap<Integer, Integer>();
        vals_ = new ArrayList<Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (m_.containsKey(val)) return false;
        m_.put(val, vals_.size()); //数组加之前的长度为索引
        vals_.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!m_.containsKey(val)) return false;
        int index = m_.get(val);
        m_.put(vals_.get(vals_.size() - 1), index);
        m_.remove(val);
        int temp = vals_.get(index);
        vals_.set(index, vals_.get(vals_.size() - 1));
        vals_.set(vals_.size() - 1, temp);
        vals_.remove(vals_.size() - 1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int index = r.nextInt(vals_.size());
        return vals_.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
