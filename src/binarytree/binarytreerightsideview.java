package binarytree;

import java.util.*;

public class binarytreerightsideview {

    public static void main(String[] args) {
        // Example test case
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        System.out.println(rightSideView(root)); // Expected Output: [1, 3, 4]
    }

    public static List<Integer> rightSideView(TreeNode root) {
        // If tree is empty, return empty list
        if (root == null) {
            return new ArrayList<>();
        }

        // Queue for BFS traversal
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();

        queue.add(root); // Start from root

        while (!queue.isEmpty()) {
            int numOfNodesInCurrentLevel = queue.size(); // Get number of nodes at this level

            for (int i = 0; i < numOfNodesInCurrentLevel; i++) {
                if (i == 0) {
                    // Add the rightmost node of the current level
                    ans.add(queue.peek().val);
                }
                TreeNode curr = queue.poll();
                // Traverse right subtree first
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
                // Traverse left subtree
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
            }
        }
        return ans;
    }
}
