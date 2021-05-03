// Solution: TreeSet
// Time complexity: O(nlogn)
// Space complexity: O(n)
class SeatManager {
    private TreeSet<Integer> s_;
    
    public SeatManager(int n) {
        s_ = new TreeSet<Integer>();
        for (int i = 1; i <= n; ++i)
            s_.add(i);
    }
    
    public int reserve() {
        int seat = s_.first();
        s_.remove(seat);
        return seat;
    }
    
    public void unreserve(int seatNumber) {
        s_.add(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */
