// Solution: Heap + TreeSet
// Use a min heap to store the release time -> server.
// Use a treeset to track the current available servers.
// For reach request, check whether servers can be released at that time.
// Time complexity: O(nlogk)
// Space complexity: O(k)
class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        PriorityQueue<int[]> q = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]); // {release_time, server}
        TreeSet<Integer> servers = new TreeSet<Integer>();
        int[] requests = new int[k];
        
        for (int i = 0; i < k; ++i)
            servers.add(i);
        
        for (int i = 0; i < arrival.length; ++i) {
            final int t = arrival[i];
            final int l = load[i];
            
            // Release servers. O(logk) per pop()
            while (!q.isEmpty() && q.peek()[0] <= t) {
                servers.add(q.peek()[1]);
                q.poll();
            }
            
            // Drop the request.
            if (servers.isEmpty()) continue;
            
            // Find first available one O(logk)
            Integer it = servers.ceiling(i % k); // 注意TreeSet和TreeMap的ceiling和ceilingKey或者ceilingEntry的API不同。
            if (it == null) it = servers.first();
            final int idx = it;
            
            ++requests[idx];
            servers.remove(it);
            q.offer(new int[]{t + l, idx});
        }
        int max_req = Integer.MIN_VALUE;
        for (int e : requests)
            max_req = Math.max(max_req, e);
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < k; ++i)
            if (requests[i] == max_req) ans.add(i);
        return ans;
    }
}
