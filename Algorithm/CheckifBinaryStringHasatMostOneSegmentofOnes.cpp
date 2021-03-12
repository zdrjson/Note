class Solution {
public:
    bool checkOnesSegment(string s) {
        int count = 0;
        int ones = 0;
        for (const char c : s) {
            if (c == '1') {
                count += (++ones == 1);
            } else {
                ones = 0;
            }
        }
        return count == 1;
    }
};
