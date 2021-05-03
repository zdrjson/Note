class SeatManager {
public:
    SeatManager(int n) {
        for (int i = 1; i <= n; ++i)
            s_.insert(i);
    }
    
    int reserve() {
        int seat = *begin(s_);
        s_.erase(begin(s_));
        return seat;
    }
    
    void unreserve(int seatNumber) {
        s_.insert(seatNumber);
    }
private:
    set<int> s_;
};

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager* obj = new SeatManager(n);
 * int param_1 = obj->reserve();
 * obj->unreserve(seatNumber);
 */
