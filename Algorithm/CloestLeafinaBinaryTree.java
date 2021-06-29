LC 742 Closest Leaf in a Binary Tree
// DFS +  BFS (Java)
class Solution {
        private Map<TreeNode, List<TreeNode>> graph_;
        private TreeNode start_;
        public int findClosestLeaf(TreeNode root, int k) {
              graph_.clear();
              start_ = null;
             buildGraph(root, null, k);
             Queue<TreeNode> q = new LinkedList<TreeNode>();
             q.offer(start_);
             Set<TreeNode> seen = new HashSet<TreeNode>();
             while (!q.isEmpty()) {
                     int size = q.size();
                     while(size-- != 0) {
                           TreeNode curr =  q.poll();
                           seen.add(curr);
                           if (curr.left == null && curr.right == null) return curr.val;
                           if (graph_.containsKey(curr)) {
                                for (TreeNode node : graph_.get(curr)) 
                                           if (!seen.contains(node))  q.offer(node);
                           }
                     }
             }
        }
        
       private void buildGraph(TreeNode node, TreeNode parent, int k) {
                 if (node == null) return;
                 if (node.val == k) start_ = node;
                 If (parent != null) {
                     if (!graph_.containsKey(node)) graph_.put(node, new ArrayList<TreeNode>());
                     graph_.get(node).add(parent);
                     if (!graph_.containsKey(parent)) graph_.put(parent, new ArrayList<TreeNode>());
                     graph_.get(parent).add(node);
                 }
                 buildGraph(node.left, node, k);
                 buildGraph(node.right, node, k);
       }
}

