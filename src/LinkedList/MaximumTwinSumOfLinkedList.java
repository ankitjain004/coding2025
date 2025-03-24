package LinkedList;

import java.util.Stack;

public class MaximumTwinSumOfLinkedList {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(5);
        ListNode listNode1 = new ListNode(4);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(1);

        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = null;

        System.out.println(pairSum(listNode));
    }

    /**
     * Approach 1: Reverse second half in-place
     * 1. Find the middle of the list.
     * 2. Reverse the second half of the list.
     * 3. Iterate over both halves to find max twin sum.
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public static int pairSum(ListNode head) {
        int count = 0;
        ListNode current = head;

        // Count number of nodes
        while (current != null) {
            count++;
            current = current.next;
        }

        // Move to the middle
        current = head;
        for (int i = 1; i <= count / 2; i++) {
            current = current.next;
        }

        // Reverse second half
        ListNode prev = null, next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        // Calculate twin sum
        current = head;
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= count / 2; i++) {
            ans = Math.max(prev.val + current.val, ans);
            prev = prev.next;
            current = current.next;
        }
        return ans;
    }

    /**
     * Approach 2: Using Stack
     * 1. Push all nodes onto a stack.
     * 2. Iterate through the first half, popping from the stack for twin sums.
     * 3. Track the max twin sum.
     *
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public int pairSum1(ListNode head) {
        Stack<ListNode> stk = new Stack<>();
        ListNode current = head;

        // Push all nodes into stack
        while (current != null) {
            stk.push(current);
            current = current.next;
        }

        current = head;
        int maxAnswer = Integer.MIN_VALUE;
        int sz = stk.size();
        int count = 0;

        // Compute twin sum while traversing first half
        while (count <= sz / 2) {
            maxAnswer = Math.max(maxAnswer, current.val + stk.pop().val);
            current = current.next;
            count++;
        }

        return maxAnswer;
    }
}
