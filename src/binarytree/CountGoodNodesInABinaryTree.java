package binarytree;

public class CountGoodNodesInABinaryTree
{
    public static void main(String[] args)
    {
        // Example usage
        TreeNode root = new TreeNode(3, new TreeNode(1, new TreeNode(3), null),
                new TreeNode(4, new TreeNode(1), new TreeNode(5)));
        CountGoodNodesInABinaryTree obj = new CountGoodNodesInABinaryTree();
        System.out.println("Good Nodes Count: " + obj.goodNodes(root));
    }

    /**
     * Counts the number of good nodes in a binary tree.
     * A node is considered "good" if the path from the root to that node
     * does not have a value greater than the node's value.
     * <p>
     * Uses DFS (Depth-First Search) to traverse the tree while keeping track
     * of the maximum value encountered along the path.
     *
     * @param root The root node of the binary tree
     * @return The count of good nodes
     */
    public int goodNodes(TreeNode root)
    {
        return countGoodNodes(root, Integer.MIN_VALUE);
    }

    /**
     * Helper function to traverse the tree and count good nodes.
     * Uses DFS to compare each node's value with the maximum value seen so far.
     *
     * @param node     The current tree node
     * @param maxSoFar The maximum value seen so far in the path from the root
     * @return The count of good nodes in the subtree
     */
    private int countGoodNodes(TreeNode node, int maxSoFar)
    {
        if (node == null) return 0; // Base case: If node is null, return 0

        int count = 0;

        // If the current node's value is greater than or equal to maxSoFar, it's a "good node"
        if (node.val >= maxSoFar)
        {
            count = 1;
            maxSoFar = node.val; // Update max value for this path
        }

        // Recursively check left and right subtrees while updating maxSoFar
        count += countGoodNodes(node.left, Math.max(maxSoFar, node.val));
        count += countGoodNodes(node.right, Math.max(maxSoFar, node.val));

        return count;
    }
}
