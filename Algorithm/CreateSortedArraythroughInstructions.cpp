class FenwickTree {
public:
    FenwickTree(int n): sums_(n + 1, 0) {}
    
    void update(int i, int delta) {
        while (i < sums_.size()) {
            sums_[i] += delta;
            i += lowbit(i);
        }
    }
    
    int query(int i) const {
        int sum = 0;
        while (i > 0) {
            sum += sums_[i];
            i -= lowbit(i);
        }
        return sum;
    }
private:
    static inline int lowbit(int x) {
        return x & (-x);
    }
    vector<int> sums_;
};

class Solution {
public:
    int createSortedArray(vector<int>& instructions) {
        const int n = instructions.size();
        FenwickTree tree(1e5);
        long ans = 0;
        for (int i = 0; i < n; ++i) {
            int lt = tree.query(instructions[i] - 1);
            int gt = i - tree.query(instructions[i]);
            ans += min(lt, gt);
            tree.update(instructions[i], 1);
        }
        return ans % 1000000007;
    }
};
