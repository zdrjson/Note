// Solution: Hashtable
// Time complexity: O(n)
// Space complexity: O(n)
class Solution {
public:
    int findLucky(vector<int>& arr) {
        unordered_map<int, int> freq;
        for (int x : arr) ++freq[x];
        int ans = -1;
        for (const auto& [key, count] : freq)
            if (key == count) ans = max(ans, key);
        return ans;
    }
};
