// Solution: Priority queue / min heap
// Time complexity: O(nlogk)
// Space complexity: O(n)
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap<>();
        for (String word : words) 
            count.put(word, count.getOrDefault(word, 0) + 1);
        
        Queue<Map.Entry<String, Integer>> q = new PriorityQueue<>((a, b) -> {
            // if (a.getValue() != b.getValue()) 
            //     return a.getValue() - b.getValue();
            // return b.getKey().compareTo(a.getKey());
            // 上面注释的代码也可以运行正确。
            // 注意这个下面的两个注释和C++写的相反，是因为Java的PriorityQueue默认是最小堆，而C++是默认最大堆。
            // order by alphabet DESC
            if (a.getValue() == b.getValue())
                return b.getKey().compareTo(a.getKey());
            // order by freq ASC
            return a.getValue() - b.getValue();
        });
        
        // O(n*logk)
        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            q.offer(entry);
            if (q.size() > k) q.poll(); // 一旦q.size() > k，把频率最底的，以及字典排在后面的单词扔掉，这样就维护了q.size()永远等于k。
        }
        
        List<String> ans = new ArrayList<>();
        
        while (!q.isEmpty()) {
            ans.add(q.peek().getKey());
            q.poll();
        }
        
        Collections.reverse(ans);
        return ans;
    }
}
