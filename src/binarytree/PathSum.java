package binarytree;

import java.util.HashMap;
import java.util.Map;

public class PathSum
{

    Map<Long, Integer> hm = new HashMap<>();
    long targetSum;
    int count = 0;

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(10,
                new TreeNode(5, new TreeNode(3, new TreeNode(3), new TreeNode(-2)), new TreeNode(2, null, new TreeNode(1))),
                new TreeNode(-3, null, new TreeNode(11))
        );

        PathSum obj = new PathSum();
        System.out.println("Number of paths with sum 8: " + obj.pathSum(root, 8L));
    }

    /**
     * This method finds the number of paths in the binary tree whose sum equals targetSum.
     * A HashMap is used to store prefix sums, allowing efficient lookup of valid paths.
     *
     * @param root      The root of the binary tree.
     * @param targetSum The target sum to find in the tree.
     * @return The count of paths that sum to targetSum.
     */
    public int pathSum(TreeNode root, long targetSum)
    {
        this.targetSum = targetSum;
        pathSumPreorder(root, 0L);
        return count;
    }

    /**
     * Performs a pre-order traversal to find valid paths.
     * Uses a HashMap to track prefix sums and backtracks to maintain correct counts.
     *
     * @param node       The current node being processed.
     * @param currentSum The sum of the path from root to the current node.
     */
    private void pathSumPreorder(TreeNode node, long currentSum)
    {
        if (node == null)
        {
            return;
        }

        // Update the running sum of the current path
        currentSum += node.val;

        // If the exact sum has been reached, increment the count
        if (currentSum == this.targetSum)
        {
            count++;
        }

        // Check if a prefix sum exists that forms targetSum
        count += hm.getOrDefault(currentSum - targetSum, 0);

        // Store the running sum in HashMap
        hm.put(currentSum, hm.getOrDefault(currentSum, 0) + 1);

        // Recur for left and right children
        pathSumPreorder(node.left, currentSum);
        pathSumPreorder(node.right, currentSum);

        // Backtrack: Remove the current sum from the HashMap to maintain correct counts
        hm.put(currentSum, hm.get(currentSum) - 1);
    }
}
