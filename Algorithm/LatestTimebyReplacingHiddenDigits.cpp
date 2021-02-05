// // Solution 1: Brute Force
// class Solution {
// public:
//     string maximumTime(string time) {
//         for (int m = 60 * 24 - 1; m >= 0; --m) {
//             int hh = m / 60;
//             int mm = m % 60;
//             if (time[0] != '?' && time[0] - '0' != hh / 10) continue;
//             if (time[1] != '?' && time[1] - '0' != hh % 10) continue;
//             if (time[3] != '?' && time[3] - '0' != mm / 10) continue;
//             if (time[4] != '?' && time[4] - '0' != mm % 10) continue;
//             time[0] = (hh / 10) + '0';
//             time[1] = (hh % 10) + '0';
//             time[3] = (mm / 10) + '0';
//             time[4] = (mm % 10) + '0';
//             break;
//         }
//         return time;
//     }
// };

// Solution 2: Rules
class Solution {
public:
    string maximumTime(string time) {
        if (time[0] == '?') time[0] = time[1] >= '4' && time[1] <= '9' ? '1' : '2';
        if (time[1] == '?') time[1] = time[0] == '2' ? '3' : '9';
        if (time[3] == '?') time[3] = '5';
        if (time[4] == '?') time[4] = '9';
        return time;
    }
};
