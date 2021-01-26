class Solution {
public:
    vector<int> decode(vector<int>& encoded) {
        const int n = encoded.size() + 1;
        vector<int> perm(n);
        // p[0] = (p[0]^p[1]^ ... ^p[n-1]) = 1^2^...^n)
        //      ^ (p[1]^p[2]^...^p[n-1])
        for (int i = 1; i <= n; ++i)
            perm[0] ^= i;
        for (int i = 1; i < n; i += 2)
            perm[0] ^= encoded[i];
        for (int i = 1; i < n; ++i)
            perm[i] = perm[i - 1] ^ encoded[i - 1];
        return perm;
    }
};
