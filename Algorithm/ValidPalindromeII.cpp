// Solution: Greedy
// Time complexity: O(n)
class Solution {
public:
    bool validPalindrome(string s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (s[l] != s[r])
                return isPalindrome(s, l+1, r)
                    || isPalindrome(s, l, r-1);
            else {
                ++l;
                --r;
            }
        }
        return true;
    }
private:
    bool isPalindrome(const string& s, int l, int r) {
        while (l < r)
            if (s[l++] != s[r--]) return false;
        return true;
    }
};

// // Solution: Greedy
// // Time complexity: O(n)
// // 花花blog中的写法
// class Solution {
// public:
//     bool validPalindrome(string s) {
//         int l = -1;
//         int r = s.length();
//         while (++l < --r) 
//             if (s[l] != s[r])
//                 return isPalindrome(s, l+1, r)
//                     || isPalindrome(s, l, r-1);
//         return true;
//     }
// private:
//     bool isPalindrome(const string& s, int l, int r) {
//         while (l < r)
//             if (s[l++] != s[r--]) return false;
//         return true;
//     }
// };
