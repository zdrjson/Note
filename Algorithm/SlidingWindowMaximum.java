// // Solution 1:Brute Force
// // Time complexity: O((n - k + 1) * k)
// // Space complexity: O(1)
// // 现在TLE了
// class Solution {
//     public int[] maxSlidingWindow(int[] nums, int k) {
//         if (k == 0) return new int[0];
        
//         int[] ans = new int[nums.length - k + 1];
//         for (int i = k - 1; i < nums.length; ++i) {
//             int maxNum = nums[i];
//             for (int j = 1; j < k; ++j) 
//                 if (nums[i - j] > maxNum) maxNum = nums[i - j];
//             ans[i - k + 1] = maxNum;
//         }
//         return ans;
//     }
// }

// Solution 2: BST
// Time complexity: O((n - k + 1) * logk)
// Space complexity: O(k)
// Java没有multiset

// // Solution 3: Monotonic Queue
// // Time complexity: O(n)
// // Space complexity: O(k)
// class Solution {
//     class MonotonicQueue {
//         private Deque<Integer> data_;
//         public MonotonicQueue() {
//             data_ = new LinkedList<Integer>();
//         }
//         public void push(int e) {
//             while (!data_.isEmpty() && e > data_.peekLast()) data_.pollLast();
//             data_.offerLast(e);
//         }
        
//         public void pop() {
//             data_.pollFirst();
//         }
        
//         public int max() {
//             return data_.peekFirst();
//         }
//     }
//     public int[] maxSlidingWindow(int[] nums, int k) {
//         MonotonicQueue q = new MonotonicQueue();
//         List<Integer> ans = new ArrayList<>();
        
//         for (int i = 0; i < nums.length; ++i) {
//             q.push(nums[i]);
//             if (i - k + 1 >= 0) {
//                 ans.add(q.max());
//                 if (nums[i - k + 1] == q.max()) q.pop();
//             }
//         }
//         int[] res = new int[ans.size()];
//         for (int i = 0; i < res.length; ++i)
//             res[i] = ans.get(i);
//         return res; 
//     }
// }

// // Solution 3:Monotonic Queue v2
// // Time complexity: O(n)
// // Space complexity: O(1)
// class Solution {    
//     public int[] maxSlidingWindow(int[] nums, int k) {
//         Deque<Integer> index = new LinkedList<>();
//         int[] ans = new int[nums.length - k + 1];
        
//         for (int i = 0; i < nums.length; ++i) {
//             while (!index.isEmpty() && nums[i] >= nums[index.peekLast()])
//                 index.pollLast();
//             index.offerLast(i);
//             if (i - k + 1 >= 0) ans[i - k + 1] = nums[index.peekFirst()];
//             // 其实只有等于Deque里面第一个元素的时候，要删掉，不可能index大于Deque里面的第一个元素。
//             if (i - k + 1 >= index.peekFirst()) index.pollFirst();
//         }
//         return ans;
//     }
// }

// Solution 3:Monotonic Queue
// Time complexity: O(n)
// Space complexity: O(1)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        
        for (int i = 0; i < nums.length; ++i) {
            while (!q.isEmpty() && nums[i] > q.peekLast()) q.pollLast();
            q.offerLast(nums[i]);
            int s = i - k + 1;
            if (s < 0) continue;
            ans.add(q.peekFirst());
            if (nums[s] == q.peekFirst()) q.pollFirst();
        }
        int[] res = new int[ans.size()];
        for (int i = 0; i < res.length; ++i)
            res[i] = ans.get(i);
        return res;
    }
}
