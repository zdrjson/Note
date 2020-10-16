class ParkingSystem {
public:
    ParkingSystem(int big, int medium, int small): 
      slots_{{big, medium, small}} {}
    
    bool addCar(int carType) {
        return slots_[carType - 1]-- > 0;
    }
private:
    vector<int> slots_;
};

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem* obj = new ParkingSystem(big, medium, small);
 * bool param_1 = obj->addCar(carType);
 */
