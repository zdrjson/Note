// Solution: Sliding Window
// Sort all the points by angle, duplicate the points with angle + 2*PI to deal with turn around case.
// maintain a window [l, r] such that angle[r] - angle[l] <= fov
// Time complexity: O(nlogn)
// Space complexity: O(n)
class Solution {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> o) {
        int at_origin = 0;
        List<Double> ps = new ArrayList<Double>();
        for (List<Integer> p : points) 
            if (p.get(0) == o.get(0) && p.get(1) == o.get(1))
                ++at_origin;
            else
                ps.add(Math.atan2(p.get(1) - o.get(1), p.get(0) - o.get(0)));
        // ps.sort((a, b) -> a - b > 0.0 ? 1 : -1); // 排序也可以这样写，下面写的排序方法方便点。
        Collections.sort(ps);
        int n = ps.size();
        for (int i = 0; i < n; ++i)
            ps.add(ps.get(i) + 2.0 * Math.PI); // duplicate the array +2PI
        int l = 0;
        int ans = 0;
        double fov = angle * Math.PI / 180.0;
        for (int r = 0; r < ps.size(); ++r) {
            while (ps.get(r) - ps.get(l) > fov) ++l;
            ans = Math.max(ans, r - l + 1);
        }
        return ans + at_origin;
    }
}
