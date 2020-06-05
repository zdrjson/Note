// Solution: Greedy
// 1. Compute the time when each car can reach target.
// 2. Sort cars by position DESC
// Answer will be number slow cars in the time array.
// Time complexity: O(nlogn)
// Space complexity: O(n)
class Solution {
    class Pair {
        public int p;
        public float t;
        public Pair(int p, float t) {
            this.p = p;
            this.t = t;
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
        Pair[] cars = new Pair[position.length];
        for (int i = 0; i < position.length; ++i) 
            cars[i] = new Pair(position[i], (float)(target - position[i]) / speed[i]);
        Arrays.sort(cars, (a, b) -> b.p - a.p);
        // 注释的排序代码不能运行。
        // Arrays.setAll(cars, i -> ~cars[i]);
        // Arrays.sort(cars);
        // Arrays.setAll(cars, i -> ~cars[i]);
        int ans = 0;
        float max_t = 0;
        for (Pair p : cars) 
            if (p.t > max_t) {
                max_t = p.t;
                ++ans;
            }
        return ans;
    }
}
