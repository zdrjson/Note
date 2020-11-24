// Solution: Greedy + Binary Search
// Sort tasks by actual - min in ascending order, this will be the order we finish those taks. Use binary search to check whether a given initial energy works or not. Note, the binary search part is unnecessary.
// Time complexity: O(nlogn + nlogk)
// Space complexity: O(1)
class Solution {
    private int[][] tasks;
    public int minimumEffort(int[][] tasks) {
        this.tasks = tasks; // this.tasks这里赋值好后，tasks后面改了值，this.tasks也会改。
        Arrays.sort(tasks, (a, b) -> (a[0] - a[1]) - (b[0] - b[1]));
        int l = tasks[0][1], r = Integer.MAX_VALUE - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (check(m))  // Java这里不能像C++这样写成三目运算符的形式，所以写成if else形式。
                r = m;
            else
                l = m + 1;
        }
        return l;
    }
    private boolean check(int cur) {
        for (int[] task : tasks) {
            if (task[1] > cur) return false;
            cur -= task[0];
        }
        return true;
    }
}
