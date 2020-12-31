// // Solution 1: Simulation
// // Time complexity: O(n^2)
// // Space complexity: O(n)
// class Solution {
//     public int countStudents(int[] students, int[] sandwiches) {
//         Queue<Integer> q = new LinkedList<>();
//         for (int s : students) q.offer(s);
//         int c = 0;
//         int i = 0;
//         while (!q.isEmpty()) {
//             int s = q.poll();
//             if (s == sandwiches[i]) {
//                 ++i;
//                 c = 0;
//             } else {
//                 q.offer(s);
//             }
//             if (++c > q.size()) break;
//         }
//         return q.size();
//     }
// }

// Solution 2: Counting
// Count student's preferences. Then process students from 1 to n, if there is no sandwich for current student then we can stop, since he/she will block all the sudents behind him/her
// Time complexity: O(n)
// Space complexity: O(1)
class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        final int n = students.length;
        int[] c = new int[2];
        for (int p : students) ++c[p];
        for (int i = 0; i < n; ++i) 
            if (--c[sandwiches[i]] < 0) return n - i;
        return 0;
    }
}
