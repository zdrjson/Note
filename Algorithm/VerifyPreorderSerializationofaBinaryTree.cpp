class Solution {
public:
    bool isValidSerialization(string preorder) {
        int pos = 0;
        return isValid(preorder, pos) && pos == preorder.length();
    }
private:
    bool isValid(const string& s, int& pos) {
        if (pos >= s.length()) return false;
        if (isdigit(s[pos])) {
            while (isdigit(s[pos])) ++pos;
            return isValid(s, ++pos) && isValid(s, ++pos);
        }
        return s[pos++] == '#';
    }
};
