// Solution: Simulation
// Simulate multiplication one digit at a time.
// Time complexity: O(l1*l2)
// Space complexity: O(l1 + l2)
class Solution {
    public String multiply(String num1, String num2) {
        final int l1 = num1.length();
        final int l2 = num2.length();
        char[] ans = new char[l1 + l2];
        Arrays.fill(ans, '0');
        for (int i = l1 - 1; i >= 0; --i)
            for (int j = l2 - 1; j >= 0; --j) {
                int num = (ans[i + j + 1] - '0') + (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                ans[i + j + 1] = (char)(num % 10 + '0'); // 注意这里 int + '0' 外面要加上(char) 强制类型转换。
                ans[i + j] += num / 10; // 注意这里char数字可以直接+=int数字。
            }
        for (int i = 0; i < ans.length; ++i)
            if (ans[i] != '0' || i == ans.length - 1) return new String(ans).substring(i);
        return "";
    }
}
