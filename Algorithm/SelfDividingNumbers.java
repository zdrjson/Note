// Solution 1
class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<Integer>();
        for (int n = left; n <= right; ++n) {
            int t = n;
            boolean valid = true;
            while (t != 0 && valid) {
                int r = t % 10;
                if (r == 0 || n % r != 0) {
                    valid = false;
                }
                t /= 10;
            }
            if (valid) {
                ans.add(n);
            }
        }
        return ans;
    }
}
// Solution 2
// class Solution {
//     public List<Integer> selfDividingNumbers(int left, int right) {
//         List<Integer> ans = new ArrayList<Integer>();
//         for (Integer n = left; n <= right; ++n) {
//             String t = n.toString();
//             boolean valid = true;
//             for (char c : t.toCharArray()) {
//                 if (c == '0' || n % (c - '0') != 0) {
//                     valid = false;
//                     break;
//                 }
//             }
//             if (valid) {
//                 ans.add(n);
//             }
//         }
//         return ans;
//     }
// }
