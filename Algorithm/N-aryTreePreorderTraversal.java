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
// // Solution1: Recursive
// class Solution {
//     public List<Integer> preorder(Node root) {
//         List<Integer> ans = new ArrayList<Integer>();
//         preorder(root, ans);
//         return ans;
//     }
//     private void preorder(Node root, List<Integer> ans) {
//         if (root == null) return;
//         ans.add(root.val);
//         for (Node child : root.children)
//             preorder(child, ans);
//     }
// }

// Solution2: Iterative
class Solution {
    public List<Integer> preorder(Node root) {
        if (root == null) return new ArrayList<Integer>();
        List<Integer> ans = new ArrayList<Integer>();
        Stack<Node> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            Node node = s.pop();
            ans.add(node.val);
            List<Node> children = node.children;
            if (children != null && children.size() != 0)
                for (int i = children.size() - 1; i >= 0; --i)
                    s.push(children.get(i));
        }
        return ans;
    }
}
