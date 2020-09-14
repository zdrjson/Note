// // Solution: Minimum Spanning Tree
// // Kruskal's algorithm
// // Time complexity: O(n^2logn)
// // Space complexity: O(n^2)
// // using vector of vector, array, pair of pair, or tuple might lead to TLE...
// struct Edge {
//     int cost;
//     int x;
//     int y;
//     bool operator<(const Edge& e) const {return cost < e.cost; }
// };
// class Solution {
// public:
//     int minCostConnectPoints(vector<vector<int>>& points) {
//         const int n = points.size();
//         vector<Edge> edges(n * (n - 1) / 2); // {cost, i, j}
//         for (int i = 0, idx = 0; i < n; ++i)
//             for (int j = i + 1; j < n; ++j)
//                 edges[idx++] = {abs(points[i][0] - points[j][0]) + 
//                                 abs(points[i][1] - points[j][1]), i, j};
//         std::sort(begin(edges), end(edges));
//         vector<int> p(n);
//         std::iota(begin(p), end(p), 0);
//         vector<int> rank(n, 0);
//         int ans = 0;
//         int count = 0;
//         for (const auto& e : edges) {
//             int rx = find(p, e.x);
//             int ry = find(p, e.y);
//             if (rx == ry) continue;
//             ans += e.cost;
//             if (rank[rx] < rank[ry]) swap(rx, ry);
//             p[rx] = ry;
//             rank[ry] += rank[rx] == rank[ry];
//             if (++count == n - 1) break;
//         }
//         return ans;
//     }
// private:
//     int find(vector<int>& p, int x) const {
//         while (p[x] != x) {
//             int tp = p[x];
//             p[x] = p[p[x]];
//             x = tp;
//         }
//         return x;
//     }
// };

// Prim's Algorithm
// ds[i] := min distance from i to ANY nodes in the tree.
// Time complexity: O(n^2) Space complexity: O(n)
class Solution {
public:
    int minCostConnectPoints(vector<vector<int>>& points) {
        const int n = points.size();
        auto dist = [](const vector<int>& pi, const vector<int>& pj) {
            return abs(pi[0] - pj[0]) + abs(pi[1] - pj[1]);
        };
        vector<int> ds(n, INT_MAX);
        for (int i = 1; i < n; ++i)
            ds[i] = dist(points[0], points[i]);
        
        int ans = 0;
        for (int i = 1; i < n; ++i) {
            auto it = min_element(begin(ds), end(ds));
            const int v = distance(begin(ds), it);
            ans += ds[v];
            ds[v] = INT_MAX; // done
            for (int i = 0; i < n; ++i) {
                if (ds[i] == INT_MAX) continue;
                ds[i] = min(ds[i], dist(points[i], points[v]));
            }
        }
        return ans;
    }
};
