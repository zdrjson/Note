// Time complexity: O(m * n) 公交车数量 * 每辆公交车路线stop数量
// Space complexity: O(m * n)
class Solution {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if (S == T) return 0;
        
        Map<Integer, List<Integer>> m = new HashMap<>(); // stop -> {bus}
        for (int i = 0; i < routes.length; ++i) 
            for (final int stop : routes[i]) 
                m.computeIfAbsent(stop, k -> new ArrayList<Integer>()).add(i);
            
        int[] ride = new int[routes.length];
        Queue<Integer> q = new LinkedList<Integer>(); // 标记当前要扩展的stop Id。
        q.offer(S);
        int buses = 0;
        
        while (!q.isEmpty()) {
            int size = q.size();
            ++buses;
            while (size-- != 0) {
                int curr = q.poll();
                for (final Integer bus : m.get(curr)) {
                    if (ride[bus] == 1) continue;
                    ride[bus] = 1;
                    for (int stop : routes[bus]) {
                        if (stop == T) return buses;
                        q.offer(stop);
                    }
                }
            }
        }
        return -1;
    }
}
