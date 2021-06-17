/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
// // Solution 1: Recursive
// class Solution {
//     public List<Integer> postorder(Node root) {
//         List<Integer> ans = new ArrayList<Integer>();
//         postorder(root, ans);
//         return ans;
//     }
//     private void postorder(Node root, List<Integer> ans) {
//         if (root == null) return;
//         for (Node child : root.children) 
//             postorder(child, ans);
//         ans.add(root.val);
//     }
// }

// Solution 2: Iterative
class Solution { 
    public List<Integer> postorder(Node root) {
        if (root == null) return new ArrayList<Integer>();
        List<Integer> ans = new ArrayList<Integer>();
        Stack<Node> s = new Stack<>();
        s.push(root);
        while(!s.isEmpty()) {
            Node node = s.pop(); // Stack pop可以直接取出top node。
            ans.add(node.val);
            for (Node child : node.children) 
                s.push(child);
        }
        Collections.reverse(ans);
        return ans;
    }
}
