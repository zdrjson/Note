// Solution: HashTable + Greedy
// if both seat[2~5] seat[6~9] are empty, seat two groups.
// if any of seat[2~5] seat[4~7] seat[6~9] is empty seat one group.
// if there is no noe sit in a row, seat two groups.
// Time complexity: O(|reservedSeats|)
// Space complexity: O(|rows|)
class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> rows = new HashMap<>();
        for (int[] seat : reservedSeats)
            rows.put(seat[0], rows.getOrDefault(seat[0], 0) | (1 << (seat[1] - 1)));
        
        int ans = (n - rows.size()) * 2;
        
        for (Map.Entry<Integer, Integer> kv : rows.entrySet()) {
            int s2 = kv.getValue() & 0b0000011110;
            int s4 = kv.getValue() & 0b0001111000;
            int s6 = kv.getValue() & 0b0111100000;
            if (s2 == 0 && s6 == 0) 
                ans += 2;
            else if (s2 == 0 || s4 == 0 || s6 == 0)
                ans += 1;
        }
        
        return ans;    
    }
}
