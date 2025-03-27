package binarytree;

public class LowestCommonAncestor {

    TreeNode ans;

    public static void main(String[] args) {
        // Sample test case
        /*
                    3
                   / \
                  5   1
                 / \  / \
                6   2 0  8
                   / \
                  7   4
         */
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        LowestCommonAncestor lca = new LowestCommonAncestor();
        TreeNode result = lca.lowestCommonAncestor(root, root.left, root.left.right.right);

        System.out.println("LCA: " + (result != null ? result.val : "null"));
    }

    /**
     * Finds the lowest common ancestor of two nodes in a binary tree.
     * @param root The root of the binary tree.
     * @param p First target node.
     * @param q Second target node.
     * @return The lowest common ancestor node.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lcaFinder(root, p, q);
        return this.ans;
    }

    /**
     * Helper method to find the lowest common ancestor using recursive DFS.
     * @param treeNode The current node being processed.
     * @param p First target node.
     * @param q Second target node.
     * @return True if this node or its children contain either p or q.
     */
    public boolean lcaFinder(TreeNode treeNode, TreeNode p, TreeNode q) {
        if (treeNode == null) {
            return false; // Base case: null node can't be an ancestor.
        }

        // Check left and right subtrees recursively.
        int left = lcaFinder(treeNode.left, p, q) ? 1 : 0;
        int right = lcaFinder(treeNode.right, p, q) ? 1 : 0;

        // Check if the current node is either p or q.
        int mid = (treeNode == p || treeNode == q) ? 1 : 0;

        // If at least two of these three conditions are true, this node is the LCA.
        if (left + right + mid >= 2) {
            this.ans = treeNode;
        }

        // Return true if p or q is found in this subtree.
        return (left + right + mid > 0);
    }
}
