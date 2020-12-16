// Solution: Return the max digit
// Proof: For a given string, we find the maximum number m, we create m binary strings.
// for each one, check each digit, if it's greater than 0, we mark 1 at that position and decrease the digit by 1.
// e.g. 21534
// max is 5, we need five binary strings.
// 1. 11111:21534 -> 10423
// 2. 10111:1-423 -> 00312
// 3. 00111:00312 -> 00201
// 4. 00101:00201 -> 00100
// 5: 00100:00100 -> 00000
// We can ignore the leading zeros.
// Time complexity: O(n)
// Space complexity: O(1)
class Solution {
    public int minPartitions(String n) {
        return n.chars().max().getAsInt() - '0';
    }
}
