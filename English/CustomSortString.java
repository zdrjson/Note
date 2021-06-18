// Solution 1: HashTable + Sorting
// 1. Store the order of char in a hashtable
// 2. Sort the string based on the order
// Time complexity: O(nlogn)
// Space complexity: O(128)
class Solution {
    public String customSortString(String S, String T) {
        int[] order = new int[128];
        Arrays.fill(order, Integer.MAX_VALUE);
        int i = 0;
        for (char c : S.toCharArray())
            if (orders[c] == Integer.MAX_VALUE) order[c] = ++i;
        Character[] ans = new Character[T.length()];
        for (int j = 0; j < ans.length; ++j)
            ans[j] = new Character(T.charAt(j));
        Arrays.sort(ans, (c1, c2) -> {
           return order[c1] - order[c2]; 
        });
        char[] res = new char[ans.length];
        for (int k = 0; k < res.length; ++k)
            res[k] = ans[k];
        return new String(res); // 或者用 String.valueOf(res) 都可以，但是不能用String.valueOf(ans)。ans为Character[]类型，答案不对, 直接new String(ans)不能编译。
    }
}
