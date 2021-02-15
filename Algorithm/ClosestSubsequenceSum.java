// Solution 0: Brute Force
// Time complexity: O(2^n) = O(2^40) => TLE
// Solution 1: Binary Search
// Sinace n is too larget to generate sums for all subsets O(2^n), we have to split the array into half, generate two sum sets. O(2^(n/2)).
// Then the problem can be reduced to find the cloest sum by picking one number (sum) each from two different arrays which can be sloved in O(mlogm), where m = 2^(n/2).
// Time complexity: O(2^n/2 * long(2^(n/2))) = O(n/2*2^(n/2)) ~ O(2^24)
// Space comlexity: O(2^(n/2))
class Solution {
    public int minAbsDifference(int[] nums, int goal) {
        final int n = nums.length;
        int ans = Math.abs(goal);
        List<Integer> t1 = new ArrayList<Integer>(1 << (n / 2 + 1));
        List<Integer> t2 = new ArrayList<Integer>(1 << (n / 2 + 1));
        t1.add(0);
        t2.add(0);
        for (int i = 0; i < n / 2; ++i)
            for (int j = t1.size() - 1; j >= 0; --j)
                t1.add(t1.get(j) + nums[i]);
        for (int i = n / 2; i < n; ++i)
            for (int j = t2.size() - 1; j >= 0; --j)
                t2.add(t2.get(j) + nums[i]);
        TreeSet<Integer> s2 = new TreeSet<Integer>(t2);
        for (int x : new HashSet<Integer>(t1)) {
            Integer it = s2.ceiling(goal - x);
            if (it != null)
                ans = Math.min(ans, Math.abs(goal - x - it));
            Integer it1 = s2.floor(goal - x);
            if (it1 != null)
                ans = Math.min(ans, Math.abs(goal - x - it1)); // 这一步相当于C++中的取prev元素。
        }
        return ans;
    }
}
