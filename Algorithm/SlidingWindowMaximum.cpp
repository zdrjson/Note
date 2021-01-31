// // Solution 1: Brute Force
// // Time complexity: O((n - k + 1) * k)
// // Space complexity: O(1)
// // 现在TLE了
// class Solution {
// public:
//     vector<int> maxSlidingWindow(vector<int>& nums, int k) {
//         vector<int> ans;
//         for (int i = k - 1; i < nums.size(); ++i) {
//             ans.push_back(*max_element(nums.begin() + i - k + 1, nums.begin() + i + 1));
//         }
//         return ans;
//     }
// };

// // Solution 2: BST
// // Time complexity: O((n - k + 1) * logk)
// // Space complexity: O(k)
// class Solution {
// public:
//     vector<int> maxSlidingWindow(vector<int>& nums, int k) {
//         vector<int> ans;
//         if (nums.empty()) return ans;
//         multiset<int> window(nums.begin(), nums.begin() + k - 1);
//         for (int i = k - 1; i < nums.size(); ++i) {
//             window.insert(nums[i]);
//             ans.push_back(*window.rbegin());
//             if (i - k + 1 >= 0)
//                 window.erase(window.equal_range(nums[i - k + 1]).first);
//         }
//         return ans;
//     }
// };

// // Solution 3: Monotonic Queue
// // Time complexity: O(n)
// // Space complexity: O(k)
// class MonotonicQueue {
// public:
//     void push(int e) {
//         while (!data_.empty() && e > data_.back()) data_.pop_back();
//         data_.push_back(e);
//     }
    
//     void pop() {
//         data_.pop_front();
//     }
    
//     int max() const { return data_.front(); }
// private:
//     deque<int> data_;
// };

// class Solution {
// public:
//     vector<int> maxSlidingWindow(vector<int>& nums, int k) {
//         MonotonicQueue q;
//         vector<int> ans;
        
//         for (int i = 0; i < nums.size(); ++i) {
//             q.push(nums[i]);
//             if (i - k + 1 >= 0) {
//                 ans.push_back(q.max());
//                 if (nums[i - k + 1] == q.max()) q.pop();
//             }
//         }
//         return ans;
//     }
// };

// // Solution 3: Monotonic Queue
// // Time complexity: O(n)
// // Space complexity: O(k)
// // v2
// class Solution {
// public:
//     vector<int> maxSlidingWindow(vector<int>& nums, int k) {
//         deque<int> index;
//         vector<int> ans;
        
//         for (int i = 0; i < nums.size(); ++i) {
//             while (!index.empty() && nums[i] >= nums[index.back()]) index.pop_back();
//             index.push_back(i);
//             if (i - k + 1 >= 0) ans.push_back(nums[index.front()]);
//             if (i - k + 1 >= index.front()) index.pop_front();
//         }
//         return ans;
//     }
// };

// Solution 3: Monotonic Queue
// Time complexity: O(n)
// Space complexity: O(k)
// v3
class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        deque<int> q;
        vector<int> ans;
        
        for (int i = 0; i < nums.size(); ++i) {
            while (!q.empty() && nums[i] > q.back()) q.pop_back();
            q.push_back(nums[i]);
            const int s = i - k + 1;
            if (s < 0) continue;
            ans.push_back(q.front());
            if (nums[s] == q.front()) q.pop_front();
        }
        return ans;
    }
};
