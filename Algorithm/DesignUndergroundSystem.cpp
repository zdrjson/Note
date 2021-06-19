// Solution: Hashtable
// For each user, store the checkin station and time.
// For each trip (startStation + "_" + endStation), store the total time and counts.
// Time complexity: O(n)
// Space complexity: O(n)
class UndergroundSystem {
public:
    UndergroundSystem() {
        
    }
    
    void checkIn(int id, string stationName, int t) {
        m_[id] = {stationName, t};
    }
    
    void checkOut(int id, string stationName, int t) {
        const auto& [s0, t0] = m_[id];
        string key = s0 + "_" + stationName;
        times_[key].first += (t - t0);
        ++times_[key].second;
    }
    
    double getAverageTime(string startStation, string endStation) {
        const auto& [sum, count] = times_[startStation + "_" + endStation];
        return static_cast<double>(sum) / count;
    }
private:
    unordered_map<int, pair<string, int>> m_; // id -> {station, t}
    unordered_map<string, pair<int, int>> times_; // trip -> {sum, count}
};

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem* obj = new UndergroundSystem();
 * obj->checkIn(id,stationName,t);
 * obj->checkOut(id,stationName,t);
 * double param_3 = obj->getAverageTime(startStation,endStation);
 */
