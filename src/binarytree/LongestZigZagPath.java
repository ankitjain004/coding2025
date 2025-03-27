package binarytree;

public class LongestZigZagPath {

    public enum Direction {
        LEFT, RIGHT;
    }

    private int maxPathLength = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                null,
                new TreeNode(1,
                        new TreeNode(1),
                        new TreeNode(1,
                                new TreeNode(1, null, new TreeNode(1)),
                                new TreeNode(1)
                        )
                )
        );

        LongestZigZagPath obj = new LongestZigZagPath();
        System.out.println("Longest ZigZag path length: " + obj.longestZigZag(root));
    }

    /**
     * This method finds the longest ZigZag path in a binary tree.
     * A ZigZag path alternates between left and right child nodes.
     *
     * @param root The root node of the binary tree.
     * @return The length of the longest ZigZag path.
     */
    public int longestZigZag(TreeNode root) {
        dfs(root, Direction.LEFT, 0);
        dfs(root, Direction.RIGHT, 0);
        return maxPathLength;
    }

    /**
     * Performs a DFS to calculate the longest ZigZag path.
     *
     * @param node The current node being visited.
     * @param direction The direction (LEFT or RIGHT) for the next step.
     * @param length The length of the current ZigZag path.
     */
    private void dfs(TreeNode node, Direction direction, int length) {
        if (node == null) {
            return;
        }

        // Update the longest ZigZag path length found so far
        maxPathLength = Math.max(maxPathLength, length);

        // Continue the ZigZag pattern based on direction
        if (direction == Direction.LEFT) {
            dfs(node.left, Direction.RIGHT, length + 1);
            dfs(node.right, Direction.LEFT, 1); // Reset length when switching direction
        } else {
            dfs(node.right, Direction.LEFT, length + 1);
            dfs(node.left, Direction.RIGHT, 1);
        }
    }
}
