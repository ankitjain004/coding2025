package binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximalLevelSumOfBinaryTree
{
    public static void main(String[] args)
    {
        // Creating a sample tree:
        /*
                 1
                / \
               7   0
              / \
             7  -8
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(-8);

        MaxLevelSum solution = new MaxLevelSum();
        System.out.println("Level with max sum: " + solution.maxLevelSum(root)); // Expected Output: 2
    }

    /**
     * Finds the level in a binary tree that has the maximum sum.
     *
     * @param root The root of the binary tree.
     * @return The level number with the highest sum.
     */
    public int maxLevelSum(TreeNode root)
    {
        if (root == null)
        {
            return 0; // Return 0 if the tree is empty
        }

        int maximalSumLevelName = 1; // Tracks the level with the maximum sum
        int maxLevelSum = root.val; // Stores the maximum sum encountered

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root); // Initialize queue with root node
        int levelNumber = 0; // Tracks the current level number

        while (!queue.isEmpty())
        {
            int sz = queue.size(); // Get the number of nodes at this level
            int currSum = 0; // Variable to store the sum of the current level
            levelNumber++;

            for (int i = 0; i < sz; i++)
            {
                TreeNode currNode = queue.poll(); // Remove the node from the queue
                currSum += currNode.val; // Add its value to the current level sum

                // Add left child to queue if it exists
                if (currNode.left != null)
                {
                    queue.offer(currNode.left);
                }

                // Add right child to queue if it exists
                if (currNode.right != null)
                {
                    queue.offer(currNode.right);
                }
            }

            // If the current level sum is greater than maxLevelSum, update values
            if (currSum > maxLevelSum)
            {
                maxLevelSum = currSum;
                maximalSumLevelName = levelNumber;
            }
        }
        return maximalSumLevelName;
    }
}

/**
 * Definition for a binary tree node.
 */
class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val)
    {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right)
    {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
