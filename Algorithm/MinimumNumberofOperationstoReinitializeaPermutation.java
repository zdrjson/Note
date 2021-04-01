// Solution: Brute Force / Simulation
// Time complexity: O(n^2)
// Space complexity: O(n)
class Solution {
    public int reinitializePermutation(int n) {
        int[] perm = new int[n];
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i) perm[i] = i;
        int ans = 0;
        boolean flag = true;
        while (flag && ++ans != 0) {
            flag = false;
            for (int i = 0; i < n; ++i) {
                         // 注意这里Java的i & 1 判断是否奇数的外面要加上括号，并且要加上等于1来判断！！！
                arr[i] = (i & 1) == 1 ? perm[n / 2 + (i - 1) / 2] : perm[i / 2];
                flag |= arr[i] != i;
            }
            int[] temp = arr;
            arr = perm;
            perm = temp;
        }
        return ans;
    }
}

