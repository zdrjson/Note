// Solution: Counting
// Time complexity: O(n^2 + n*max(A))
// Space complexity: O(max(A))
class Solution {
    // 用map和数组都可以 不过数组快近10倍
    // 两个数&会变小 一个数&0 为0
    public int countTriplets(int[] A) {
        // Map<Integer, Integer> count = new HashMap<>();
        int max = 0;
        for (int a : A) {
            if (a > max) {
                max = a;
            }
        }
        int[] count = new int[max + 1];
        for (int a : A) {
            for (int b : A) {
                // if (count.containsKey(a & b)) {
                //     int num = count.get(a & b);
                //     count.put(a & b, ++num);
                // } else {
                //     count.put(a & b, 1);
                // }
                ++count[a & b];
            }
        }
        int ans = 0;
        for (int a : A) {
            // for (Map.Entry<Integer, Integer> entry : count.entrySet()) { //value 在[0, max(A)) 之间
            //     if ((a & entry.getKey()) == 0) { //(a & entry.getKey()) 这里外面必须要括号才能编译通过
            //         ans += entry.getValue();
            //     }
            // }
            for (int i = 0; i < count.length; ++i) {
                if ((a & i) == 0) {
                    ans += count[i];
                }
            }
        }
        return ans;
    }
}
