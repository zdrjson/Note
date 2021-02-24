// Solution 0: Brute Force TLE
// Time complexity: O(n^3logn) / O(n^3)
// Space complexity: O(n^2)

// // Solution 1: Hashtable
// // Time complexity: O(n^2)
// // Space complexity: O(n)
// class Solution {
//     public List<List<Integer>> threeSum(int[] nums) {
//         Arrays.sort(nums);
//         final int n = nums.length;
//         Map<Integer, Integer> c = new HashMap<>();
//         for (int x : nums) c.put(x, c.getOrDefault(x, 0) + 1);
//         List<List<Integer>> ans = new ArrayList<>();
//         for (int i = 0; i < n; ++i) {
//             if (i != 0 && nums[i] == nums[i - 1]) continue;
//             for (int j = i + 1; j < n; ++j) {
//                 if (j - 1 != i && nums[j] == nums[j - 1]) continue;
//                 final int t = 0 - nums[i] - nums[j];
//                 // nums[i] <= nums[j] <= nums[k]
//                 if (t < nums[j]) continue;
//                 if (!c.containsKey(t)) continue;
//                 // make sure have enough count
//                 if (c.get(t) >= 1 + (nums[i] == t ? 1 : 0) + (nums[j] == t ? 1 : 0))
//                     ans.add(Arrays.asList(nums[i], nums[j], t));
//             }
//         }
//         return ans;
//     }
// }

// Solution 2: Sorting + Two pointers
// Time complexity: O(nlogn + n^2)
// Space complexity: O(1)
// 花花视频中PPT的代码
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        final int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1, k = n - 1;
            while (j < k) {
                if (nums[j] + nums[k] > -nums[i]) --k;
                else if (nums[j] + nums[k] < -nums[i]) ++j;
                else {
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j] == nums[j + 1]) ++j;
                    while (j < k && nums[k] == nums[k - 1]) --k;
                    ++j; --k; // 注意这里两行变一行中间是分号。
                }
            }
        }
        return ans;
    }
}

// 花花blog中的代码
// class Solution {
//     public List<List<Integer>> threeSum(int[] nums) {
//         List<List<Integer>> ans = new ArrayList<List<Integer>>();
//         Arrays.sort(nums);
//         int n = nums.length;
//         for (int i = 0; i < n - 2; ++i) {
//             if (nums[i] > 0) break;
//             if (i > 0 && nums[i] == nums[i - 1]) continue;
//             int l = i + 1;
//             int r = n - 1;
//             while (l < r) {
//                 if (nums[i] + nums[l] + nums[r] == 0) {
//                     ans.add(Arrays.asList(nums[i], nums[l++], nums[r--]));
//                     while (l < r && nums[l] == nums[l - 1]) ++l;
//                     while (l < r && nums[r] == nums[r + 1]) --r;
//                 } else if (nums[i] + nums[l] + nums[r]  < 0) {
//                     ++l;
//                 } else {
//                     --r;
//                 }
//             }
//         }
//         return ans;
//     }
// }
