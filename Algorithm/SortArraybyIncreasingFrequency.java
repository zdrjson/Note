// Solution: Hashtable + Sorting
// Use a hashtable to track the frequency of each number
// Time complexity: O(nlogn)
// Space complexity: O(n)
class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) freq.put(num, freq.getOrDefault(num, 0) + 1);
        Integer[] newNums = new Integer[nums.length];
        for (int i = 0; i < nums.length; ++i)
            newNums[i] = nums[i];
        Arrays.sort(newNums, (a, b) -> { // 再次再次再次强调下，Java的Arrays.sort里面展开lamda表达式是用Integer[]的数组，不是int[]数组，还有里面的return返回不是C++的大小于号，而是减号！！！
            if (freq.get(a) != freq.get(b)) return freq.get(a) - freq.get(b);
            return b - a;
        });
        for (int i = 0; i < nums.length; ++i)
            nums[i] = newNums[i];
        return nums;
    }
}
