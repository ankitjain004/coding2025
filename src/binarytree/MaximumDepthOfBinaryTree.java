package binarytree;

public class MaximumDepthOfBinaryTree {

    public static void main(String[] args) {
        // You can add test cases here if needed.
    }

    /**
     * Finds the maximum depth of a binary tree.
     * @param root The root node of the tree.
     * @return The maximum depth of the tree.
     */
    public int maxDepth(TreeNode root) {
        // Base Case: If the tree is empty, return 0
        if (root == null) {
            return 0;
        }

        // Recursively calculate the depth of the left and right subtrees
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        // The depth of the current node is the maximum of the two depths + 1
        return 1 + Integer.max(leftDepth, rightDepth);
    }
}
