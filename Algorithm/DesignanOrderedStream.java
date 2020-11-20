// Solution: Straight Forward
// Time complexity: O(n) in total
// Space complexity: O(n)
class OrderedStream {
    private String[] data_;
    private int ptr_ = 1;
    public OrderedStream(int n) {
        data_ = new String[n + 1];
    }
    
    public List<String> insert(int id, String value) {
        data_[id] = value;
        List<String> ans = new ArrayList<String>();
        if (ptr_ == id)
            while (ptr_ < data_.length && data_[ptr_] != null) // Java里面基本数组初始化后里面元素是null，所以这里判断方式不能用字符串是否为空判断，而要判断是否为null值。
                ans.add(data_[ptr_++]);
        return ans;
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(id,value);
 */
