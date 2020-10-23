class Solution {
public:
    vector<bool> areConnected(int n, int threshold, vector<vector<int>>& queries) {
        if (threshold == 0) return vector<bool>(queries.size(), true);
        
        vector<int> ds(n + 1);
        iota(begin(ds), end(ds), 0);
        function<int(int)> find = [&](int x) {
            return ds[x] == x ? x : ds[x] = find(ds[x]);
        };
        
        for (int x = threshold + 1; x <= n; ++x)
            if (ds[x] == x)
                for (int y = 2 * x; y <= n; y += x)
                    ds[max(find(x), find(y))] = min(find(x), find(y));
        
        vector<bool> ans;
        for (const vector<int>& q : queries)
            ans.push_back(find(q[0]) == find(q[1]));
        return ans;
    }
};
