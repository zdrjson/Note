class Solution {
public:
    bool rotateString(string A, string B) {
        if (A.length() != B.length()) return false;
        if (A == B) return true; // corner case: A为"", B也为""，花花代码里面没有这行。
        for (int i = 1; i < A.length(); ++i)
            if (check(A, B, i)) return true;
        return false;
    }
private:
    bool check(const string& A, const string& B, int offset) {
        for (int i = 0; i < A.length(); ++i)
            if (A[(i + offset) % A.length()] != B[i])
                return false;
        return true;
    }
};
