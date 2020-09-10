// Solution: Greedy + Spanning Tree / Union Find
// Use type 3(both) edges first.
// Time complexity: O(E)
// Space complexity: O(n)
class DSU {
    private int[] p_;
    private int e_;
    public DSU(int n) {
        p_ = new int[n + 1];
        for (int i = 0; i < p_.length; ++i)
            p_[i] = i;
        e_ = 0;
    }
    
    public int find(int x) {
        if (p_[x] == x) return x;
        return p_[x] = find(p_[x]);
    }
    
    public int merge(int x, int y) {
        int rx = find(x);
        int ry = find(y);
        if (rx == ry) return 1;
        p_[rx] = ry;
        ++e_;
        return 0;
    }
    
    public int edges() {
        return e_;
    }
}

class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int ans = 0;
        DSU A = new DSU(n);
        DSU B = new DSU(n);
        for (int[] e : edges) {
            if (e[0] != 3) continue;
            ans += A.merge(e[1], e[2]);
            B.merge(e[1], e[2]);
        }
        for (int[] e : edges) {
            if (e[0] == 3) continue;
            DSU d = e[0] == 1 ? A : B;
            ans += d.merge(e[1], e[2]);
        }
        return (A.edges() == n - 1 && B.edges() == n - 1) ? ans : - 1;
    }
}
