// Solution: XOR
// The key is to find p[0]. p[i] = p[i - 1] ^ encoded[i - 1]
// 1.p[0] ^ p[1] ... ^ p[n-1] = 1 ^ 2 ^ ... ^ n
// 2.encoded[1] ^ encode[3] ^ ... ^ encoded[n-2] = (p[1] ^ p[2]) ^ (p[3] ^ p[4]) ^ ... ^ (p[n-2] ^ p[n-1])
// 1) xor 2) = p[0]
class Solution {
    public int[] decode(int[] encoded) {
        final int n = encoded.length + 1;
        int[] perm = new int[n];
        // p[0] = (p[0]^p[1]^...^p[n-1] = 1^2^...^n)
        //      ^ (p[1]^p[2]^...^p[n-1])
        for (int i = 1; i <= n; ++i)
            perm[0] ^= i;
        for (int i = 1; i < n; i += 2)
            perm[0] ^= encoded[i];
        for (int i = 1; i < n; ++i)
            perm[i] = perm[i - 1] ^ encoded[i - 1];
        return perm;
    }
}
