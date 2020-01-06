class Solution { // a ^ b ^ a = b a ^ 0 = a;
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] xors = new int[arr.length + 1];
        for (int i = 0; i < arr.length; ++i) {
            xors[i + 1] = xors[i] ^ arr[i];
        }
        
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; ++i) {
            int[] q = queries[i];
            int l = q[0];
            int r = q[1];
            ans[i] = xors[r + 1] ^ xors[l];
        }
        return ans;
    }
}
