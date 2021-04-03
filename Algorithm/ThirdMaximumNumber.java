// Solution: Set
// Time complexity: O(n)
// Space complexity: O(1)
class Solution {
    public int thirdMax(int[] nums) {
        TreeSet<Integer> s = new TreeSet<>();
        for (int num : nums) {
            s.add(num);
            if (s.size() > 3) s.remove(s.first());
        }
        return s.size() != 3 ? s.last() : s.first();
    }
}
