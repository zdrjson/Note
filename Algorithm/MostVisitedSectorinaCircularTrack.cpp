class Solution {
public:
    vector<int> mostVisited(int n, vector<int>& rounds) {
        vector<int> counts(n);
        counts[rounds[0] - 1] = 1;
        for (int i = 1; i < rounds.size(); ++i)
            for (int s = rounds[i - 1]; ; ++s) {
                ++counts[s %= n];
                if (s == rounds[i] - 1) break;
            }
        const int max_count = *max_element(begin(counts), end(counts));
        vector<int> ans;
        for (int i = 0; i < n; ++i)
            if (counts[i] == max_count) ans.push_back(i + 1);
        return ans;
    }
};
