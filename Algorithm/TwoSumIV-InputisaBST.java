/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<Integer> nums = new ArrayList<>();
    public boolean findTarget(TreeNode root, int k) {
        inorder(root, nums);
        int l = 0;
        int r = nums.size() - 1;
        while (l < r) {
            int sum = nums.get(l) + nums.get(r);
            if (sum == k) {
                return true;
            } else if (sum < k) {
                ++l;
            } else {
                --r;
            }
        }
        return false;
    }
    
    private void inorder(TreeNode root, List<Integer> nums) {
        if (root == null) return;
        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
    }
}
