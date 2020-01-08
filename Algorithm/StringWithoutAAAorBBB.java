class Solution {
    public String strWithout3a3b(int A, int B) {
        char a = 'a';
        char b = 'b';
        if (B > A) {
            int temp = A;
            A = B;
            B = temp;
            char tempChar = a;
            a = b;
            b = tempChar;
        }
        String ans = "";
        while (A != 0 || B != 0) {
            if (A > 0) { ans += a; --A; }
            if (A > B) { ans += a; --A; }
            if (B > 0) { ans += b; --B; }
        }
        return ans;
    }
}
