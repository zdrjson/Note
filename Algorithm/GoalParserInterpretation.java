// Solution: String
// If we encounter '(' check the next character to determine whether it's '()' or '(al')
// Time complexity: O(n)
// Space complexity: O(n)
class Solution {
    public String interpret(String command) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < command.length(); ++i) {
            if (command.charAt(i) == 'G') ans.append("G");
            else if (command.charAt(i) == '(') {
                if (command.charAt(i + 1) == ')') ans.append("o");
                else ans.append("al");
            }
        }
        return ans.toString();
    }
}

// // 自己比赛时候写的代码
// class Solution {
//     public String interpret(String command) {
//         StringBuilder ans = new StringBuilder();
//         for (int i = 0; i < command.length(); ++i) {
//             if (command.charAt(i) == '(') {
//                 if (command.charAt(i + 1) == ')') {
//                     ans.append('o');
//                     ++i;
//                 } else {
//                     ans.append("al");
//                    i += 3;
//                 }
//             } else {
//                 ans.append('G');
//             }
//         }
//         return ans.toString();
//     }
// }
