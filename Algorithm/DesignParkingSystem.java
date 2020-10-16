// Solution: Simulation
// Time complexity: O(1) per addCar call
// Space complexity: O(1)
class ParkingSystem {
    private List<Integer> slots_;
    public ParkingSystem(int big, int medium, int small) {
        slots_ = new ArrayList<Integer>();
        slots_.add(big);
        slots_.add(medium);
        slots_.add(small);
    }
    
    public boolean addCar(int carType) {
        return slots_.set(carType - 1, slots_.get(carType - 1) - 1) > 0; // List的set(index, object)方法返回的object这个对象。
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
