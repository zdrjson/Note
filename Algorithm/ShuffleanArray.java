class Solution {
    private int[] nums_; 
    private Random random_;
    public Solution(int[] nums) {
        nums_ = nums;
        random_ = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums_;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] output = nums_.clone();
        final int n = output.length;
        for (int i = 0; i < n - 1; ++i) {
            int j = random_.nextInt(n - i) + i; // 注意随机函数的名字叫nextInt()
            int tmp = output[i];
            output[i] = output[j];
            output[j] = tmp;
        }
        return output;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
