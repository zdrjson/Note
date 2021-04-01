// Solution: Brute Force / Simulation
// Time complexity: O(n^2)
// Space complexity: O(n)
class Solution {
public:
    int reinitializePermutation(int n) {
        vector<int> perm(n);
        vector<int> arr(n);
        for (int i = 0; i < n; ++i) perm[i] = i;
        int ans = 0;
        bool flag = true;
        while (flag && ++ans) {
            flag = false;
            for (int i = 0; i < n; ++i) {
                arr[i] = i & 1 ? perm[n / 2 + (i - 1) / 2] : perm[i / 2];
                flag |= arr[i] != i;
            }
            swap(perm, arr);
        }
        return ans;
    }
};
