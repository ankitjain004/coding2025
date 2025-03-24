package binarytree;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees
{
    public static void main(String[] args)
    {
        // Example trees
        TreeNode root1 = new TreeNode(3,
                new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4))),
                new TreeNode(1, new TreeNode(9), new TreeNode(8)));

        TreeNode root2 = new TreeNode(3,
                new TreeNode(5, new TreeNode(6), new TreeNode(7)),
                new TreeNode(1, new TreeNode(4), new TreeNode(2, new TreeNode(9), new TreeNode(8))));

        LeafSimilarTrees obj = new LeafSimilarTrees();
        System.out.println("Are leaf sequences similar? " + obj.leafSimilar(root1, root2));
    }

    /**
     * Checks if two trees have the same leaf sequence.
     *
     * @param root1 First tree root.
     * @param root2 Second tree root.
     * @return True if leaf sequences match, else false.
     */
    public boolean leafSimilar(TreeNode root1, TreeNode root2)
    {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        // Collect leaf nodes of both trees
        getLeafsInAList(root1, list1);
        getLeafsInAList(root2, list2);

        // Compare the leaf sequences
        return list1.equals(list2);
    }

    /**
     * Performs DFS to collect leaf nodes in a list.
     *
     * @param root Current node.
     * @param list List to store leaf node values.
     */
    private void getLeafsInAList(TreeNode root, List<Integer> list)
    {
        if (root == null) return;

        // If it's a leaf node, add its value to the list
        if (root.left == null && root.right == null)
        {
            list.add(root.val);
            return;
        }

        // Recursively check left and right subtrees
        getLeafsInAList(root.left, list);
        getLeafsInAList(root.right, list);
    }
}
