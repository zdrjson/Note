class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0 || intervals[0].length == 0) {
            return intervals;
        }
        // Arrays.sort(intervals, new Comparator<int[]>() {
        //     public int compare(int[] a, int[] b) {
        //         return a[0] - b[0];
        //     }
        // });
        // Array 二维数组两种比较方式都可以  下面的更加简洁
        Arrays.sort(intervals, (a , b) -> Integer.compare(a[0], b[0]));
        List<int[]> ans = new ArrayList<int[]>();
        for (int[] interval : intervals) {
            if (ans.size() == 0 || interval[0] > (ans.get(ans.size() - 1))[1]) {
                ans.add(interval);
            } else {
                (ans.get(ans.size() - 1))[1] = Math.max((ans.get(ans.size() - 1))[1], interval[1]);
            }
        }
        
        return ans.toArray(new int[ans.size()][]);
    }
}
