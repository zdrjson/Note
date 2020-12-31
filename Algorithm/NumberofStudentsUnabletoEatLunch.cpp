// // Solution 1: Simulation
// class Solution {
// public:
//     int countStudents(vector<int>& students, vector<int>& sandwiches) {
//         queue<int> q;
//         for (int s : students) q.push(s);
//         int c = 0;
//         int i = 0;
//         while (!q.empty()) {
//             int s = q.front(); q.pop();
//             if (s == sandwiches[i]) {
//                 ++i;
//                 c = 0;
//             } else {
//                 q.push(s);
//             }
//             if (++c > q.size()) break;
//         }
//         return q.size();
//     }
// };

// Solution 2: Counting
class Solution {
public:
    int countStudents(vector<int>& students, vector<int>& sandwiches) {
        const int n = students.size();
        vector<int> c(2);
        for (int p : students) ++c[p];
        for (int i = 0; i < n; ++i)
            if (--c[sandwiches[i]] < 0) return n - i;
        return 0;
    }
};
