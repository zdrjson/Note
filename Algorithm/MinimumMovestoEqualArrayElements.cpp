class Solution {
public:
    int minMoves(const vector<int>& a) {
        return accumulate(a.begin(), a.end(), 0L) - a.size() * *min_element(a.begin(), a.end());
    }
};
