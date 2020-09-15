// We can move a smaller digit from right to left by sorting two adjacent digits.
// e.g. 18572 -> 18527 -> 18257 -> 12857, but we can not move a larger to the left of a smaller one.
// Thus, for each digit in the target string, we find the first occurrence of it int s, and try to move it to the front by checking if there is any smaller one in front of it.
// Time complexity: O(n)
// Space complexity: O(n)
class Solution {
    public boolean isTransformable(String s, String t) {
        Deque<Integer>[] idx = new Deque[10]; 
        for (int i = 0; i < s.length(); ++i) {
            if (idx[s.charAt(i) - '0'] == null) idx[s.charAt(i) - '0'] = new LinkedList<Integer>();
            idx[s.charAt(i) - '0'].offerLast(i);
        }
        for (char c : t.toCharArray()) {
            int d = c - '0';
            if (idx[d] == null || idx[d].isEmpty()) return false; // Java这里还要先判断数组里面的Deque是否为空。
            for (int i = 0; i < d; ++i) 
                if (idx[i] != null && 
                    !idx[i].isEmpty() &&  // Java这里还要先判断数组里面的Deque是否为空。
                    idx[i].peekFirst() < idx[d].peekFirst())
                    return false;
            idx[d].pollFirst();
        }
        return true;
    }
}
