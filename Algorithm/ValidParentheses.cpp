// Solution: Stack
// Using a stack to track the existing open parentheses, if the current one is a close parenthesis but does not match the top of the stack, return false, otherwise pop the stack. Check whether the stack is empty in the end.
// Time complexity: O(n)
// Space complexity: O(n)
class Solution {
public:
    bool isValid(string s) {
        map<char, char> p{{')', '('}, {']', '['}, {'}', '{'}};
        stack<char> st;
        for (char c : s) {
            if (!p.count(c)) {
                st.push(c);
            } else {
                if (st.empty() || p[c] != st.top()) return false;
                st.pop();
            }
        }
        return st.empty();
    }
};
