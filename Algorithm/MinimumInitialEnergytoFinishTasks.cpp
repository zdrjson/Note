class Solution {
public:
    int minimumEffort(vector<vector<int>>& tasks) {
        sort(begin(tasks), end(tasks), [](const auto& t1, const auto& t2) {
           return t1[0] - t1[1] < t2[0] - t2[1]; 
        });
        int l = tasks[0][1], r = INT_MAX - 1;
        auto check = [&](int cur) {
            for (const auto& task : tasks) {
                if (task[1] > cur) return false;
                cur -= task[0];
            }
            return true;
        };
        while (l < r) {
            const int m = l + (r - l) / 2;
            check(m) ? r = m : l = m + 1;
        }
        return l;
    }
};
