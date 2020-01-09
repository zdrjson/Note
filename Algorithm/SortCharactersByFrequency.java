class Solution {
    public String frequencySort(String s) {
        int[] f = new int[128];
        for (char c : s.toCharArray()) {
            ++f[(int)c];
        }
        List<int[]> v = new ArrayList<>();
        for (int i = 0; i < 128; ++i) {
            if (f[i] > 0) {
                v.add(new int[]{f[i], i});
            }
        }
        v.sort((a, b) -> b[0] - a[0]); //按照int[] 里面的第一个元素降序排序
        StringBuilder ans = new StringBuilder();
        for (int[] kv : v) {
            for (int i = 0; i < kv[0]; ++i) {
                ans.append((char)kv[1]); //直接用 ans += 直接超时
            }
        }
        return ans.toString();
    }
}
