// Solution 2  速度比Solution 1 慢 Space Complexity: O(n^2) Time Complexity: O(n)
class MyCalendarTwo {
    private TreeMap<Integer, Integer> delta_; // key : 时刻 value : 这个时刻发生的event数量
    
    public MyCalendarTwo() {
       delta_ = new TreeMap<Integer, Integer>();
    }
    
    public boolean book(int start, int end) {
      
       delta_.put(start, delta_.getOrDefault(start, 0) + 1);
       delta_.put(end, delta_.getOrDefault(end, 0) - 1);
        
       int count = 0;
       for (Map.Entry<Integer, Integer> kv : delta_.entrySet()) {
           count += kv.getValue();
           if (count == 3) {
               delta_.put(start, delta_.get(start) - 1);
               delta_.put(end, delta_.get(end) + 1);
               return false;
           }
           if (kv.getKey() > end) break; // 小剪枝
       }
       return true;
    }
}


// // Solution 1 Brute Force  Space Complexity: O(n) Time Complexity: O(n^2)
// class MyCalendarTwo {

//     private List<int[]> booked_;
//     private List<int[]> overlaps_;
    
//     public MyCalendarTwo() {
//         booked_ = new ArrayList<>();
//         overlaps_ = new ArrayList<>();
//     }
    
//     public boolean book(int start, int end) {
//         for (int[] range : overlaps_) {
//             if (Math.max(range[0], start) < Math.min(range[1], end)) {
//                 return false;
//             }
//         }
        
//         for (int[] range: booked_) {
//             int ss = Math.max(range[0], start);
//             int ee = Math.min(range[1], end);
//             if (ss < ee) {
//                 overlaps_.add(new int[]{ss, ee});
//             }
//         }
        
//         booked_.add(new int[]{start, end});
//         return true;
//     }
// }

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
