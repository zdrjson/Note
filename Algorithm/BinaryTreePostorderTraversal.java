/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// // Solution 1: 
// class Solution {
//     public List<Integer> postorderTraversal(TreeNode root) {
//         List<Integer> ans = new ArrayList<Integer>();
//         postorder(root, ans);
//         return ans;
//     }
//     private void postorder(TreeNode root, List<Integer> ans) {
//         if (root == null) return;
//         postorder(root.left, ans);
//         postorder(root.right, ans);
//         ans.add(root.val);
//     }
// }

// // Solution 2:
// class Solution {
//     public List<Integer> postorderTraversal(TreeNode root) {
//         if (root == null) return new ArrayList<Integer>();
//         List<Integer> ans = new ArrayList<Integer>();
//         List<Integer> l = postorderTraversal(root.left);
//         List<Integer> r = postorderTraversal(root.right);
//         ans.addAll(l);
//         ans.addAll(r);
//         ans.add(root.val);
//         return ans;
//     }
// }

// Solution 3:
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Deque<Integer> ans = new LinkedList<>();
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode n = s.pop();
            ans.addFirst(n.val); // 0(1)
            if (n.left != null) s.push(n.left);
            if (n.right != null) s.push(n.right);
        }
        return new ArrayList<Integer>(ans);
    }
}

// class Solution {
//     public List<Integer> postorderTraversal(TreeNode root) {
//         if (root == null) return new ArrayList<Integer>();
//         List<Integer> ans = new ArrayList<>();
//         Stack<TreeNode> s = new Stack<>();
//         s.push(root);
//         while (!s.isEmpty()) {
//             TreeNode n = s.pop();
//             ans.add(n.val); // 这里时间为O(n) C++ 的queue方法 push_front为 0(1)。
//             if (n.left != null) s.push(n.left);
//             if (n.right != null) s.push(n.right);
//         }
//         Collections.reverse(ans);
//         return ans;
//     }
// }
