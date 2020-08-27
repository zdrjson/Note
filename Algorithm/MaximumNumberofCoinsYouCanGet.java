// // Solution: Greedy
// // Always take the second largest element of a in the sorted array.
// // [1, 2, 3, 4, 5, 6, 7, 8, 9]
// // tuples: (1, 8, 9), (2, 6, 7), (3, 4, 5)
// // Alice: 9, 7, 5
// // You: 8, 6, 4
// // Bob: 1, 2, 3
// // Time complexity: O(nlogn) => O(n + k)
// // Space complexity: O(1)
// class Solution {
//     public int maxCoins(int[] piles) {
//         int n = piles.length / 3;
//         Arrays.sort(piles);
//         int ans = 0;
//         for (int i = 0; i < n; ++i)
//             ans += piles[n * 3 - 2 - i * 2];
//         return ans;
//     }
// }

// Counting sort
class Solution {
    public int maxCoins(int[] piles) {
        final int kMax = 10000;
        int n = piles.length / 3;
        int[] counts = new int[kMax + 1];
        for (int v : piles) ++counts[v];
        int idx = 0;
        for (int i = 1; i <= kMax; ++i)
            while (counts[i]-- != 0) piles[idx++] = i;
        int ans = 0;
        for (int i = 0; i < n; ++i)
            ans += piles[n * 3 - 2 - i * 2];
        return ans;
    }
}
