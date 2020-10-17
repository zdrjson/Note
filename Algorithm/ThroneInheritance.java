// Solution: HashTabel + DFS
// Record:
// 1. mapping from parent to children (ordered)
// 2. who has dead
// Time complexity: getInheritanceOrder O(n), other O(1)
// Space complexity: O(n)
class ThroneInheritance {
    private String king_;
    private Map<String, List<String>> m_; // parent -> list[children]
    private Set<String> dead_;
    public ThroneInheritance(String kingName) {
        king_ = kingName;        
        m_ = new HashMap<String, List<String>>(); // new HashMap<String, List<String>>();中数组类型要写List<String>，不能写成ArrayList<String>，不然编译不通过，类型和前面不匹配。
        m_.put(kingName, new ArrayList<String>());
        dead_ = new HashSet<String>();
    }
    
    public void birth(String parentName, String childName) {
        m_.computeIfAbsent(parentName, k -> new ArrayList<String>()).add(childName);
    }
    
    public void death(String name) {
        dead_.add(name);
    }
    
    public List<String> getInheritanceOrder() {
        List<String> ans = new ArrayList<String>();
        dfs(king_, ans);
        return ans;
    }
    private void dfs(String name, List<String> ans) {
        if (!dead_.contains(name)) ans.add(name);
        // if (m_.containsKey(name)) m_中有没有这个key的情况，可以在循环时用下面的方法，防止循环null对象导致编译不通过。
        for (String child : m_.getOrDefault(name, new ArrayList<String>())) dfs(child, ans);
    }
}

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */
