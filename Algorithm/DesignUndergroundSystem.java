// Solution: Hashtable
// For each user, store the checkin station and time.
// For each trip (startStation + "_" + endStation), store the total time and counts.
// Time complexity: O(n)
// Space complexity: O(n)
class UndergroundSystem {
    private Map<Integer, String[]> m_; // id -> {statiomn, t}
    private Map<String, int[]> times_; // trip -> {sum, count}
    public UndergroundSystem() {
        m_ = new HashMap<>();
        times_ = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        m_.put(id, new String[]{stationName, String.valueOf(t)});
    }
    
    public void checkOut(int id, String stationName, int t) {
        String s0 = m_.get(id)[0];
        Integer t0 = Integer.parseInt(m_.get(id)[1]);
        String key = s0 + "_" + stationName; // 用StringBuilder测试运行时间相差不大，所以就用加号拼接字符串。
        int[] pair = times_.getOrDefault(key, new int[]{0, 0});
        times_.put(key, new int[]{pair[0] + t - t0, pair[1] + 1});
    }
    
    public double getAverageTime(String startStation, String endStation) {
        int[] pair = times_.getOrDefault(startStation + "_" + endStation, new int[]{0, 0});
        return (double)pair[0] / pair[1];
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
