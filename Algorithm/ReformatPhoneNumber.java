// Solution:
// Time complexity: O(n)
// Space complexity: O(1)
class Solution {
    public String reformatNumber(String number) {
        StringBuilder ans = new StringBuilder();
        int total = 0;
        for (char c : number.toCharArray())
            if (Character.isDigit(c)) ++total; // 这里if执行条件可以不用大括号包住。
        int l = 0;
        for (char c : number.toCharArray()) {
            if (!Character.isDigit(c)) continue;
            ans.append(c);
            ++l;
            if ((l % 3 == 0 && total - l >= 4) || 
                (total % 3 != 0 && total - l == 2) || 
                (total % 3 == 0 && total - l == 3))
                ans.append('-');
        }
        return ans.toString();
    }
}
