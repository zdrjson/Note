// // Solution 1: Greedy
// // Take two stones (one each) from the largest two piles, until one is empty.
// // Time complexity: O(n)
// // Space complexity: O(1)
// class Solution {
//     public int maximumScore(int a, int b, int c) {
//         int[] s = new int[]{a, b, c};
//         int ans = 0;
//         Arrays.sort(s);
//         while (s[1]-- != 0 && s[2]-- != 0) {
//             ++ans;
//             Arrays.sort(s);
//         }
//         return ans;
//     }
// }

// Solution 2: Math
// First, let's assuming a <= b <= c.
// There are two condiitions:
// 1. a + b <= c, we can pair c with a first and then b. Total pairs is (a + b + (a + b)) / 2
// 2. a + b > c, we can pair c with a,b "evently", and then pair a with b, total pairs is (a + b + c) / 2
// ans = (a + b + min(a + b, c)) / 2
// Time complexity: O(1)
// Space complexity: O(1)
// 这道题还可以，推不出公式还可以用"PQ"来做：一直从最大的两堆石子拿。 T:O(n), S: O(1)
// 下面我们来推一些公式：
// 为了不失一般性，我们假设a <= b <= c, 只有两种情况需要考虑：
// 1. a + b <= c
// 我们可以先让c和a配对，直到a全部用完。再让c和b配对，直到b全部用完，这时候c >= 0。总的用掉的石子是 (a + a) + (b + b)，答案是 ((a + a) + (b + b)) / 2，即a+b。比如 [2, 4, 9], 最后c=3, ans=2+4=6。
// 2. a + b > c，这个时候如果我们用最优的分配方式：一直选a和b中较大的一个和c配对。我们可以把c全部用完。剩下的a和b再配对，最后最多"只剩一个石子"。e.g.[6, 6,7]，c全部用完, ans = 7, a = 2, b = 3，a和b再配对，最后b=1, ans = 9 = (6+6+7) / 2。 答案就是稍微有点难理解：（a + b + c）/ 2。我们可以反过来想：由于最后最多只剩下一个石子无法匹配(a + b + c是奇数的情况)，我们的配对数量就是(a + b + c) / 2。
// 最后我们把两种情况合并 ans = (a + b + min(a+b, c)) / 2
class Solution {
    public int maximumScore(int a, int b, int c) {
        int[] s = new int[]{a, b, c};
        Arrays.sort(s);
        return (s[0] + s[1] + Math.min(s[0] + s[1], s[2])) / 2;
    }
}
