package LinkedList;

/**
 * Logic Summary:
 * - Deletes the middle node from a singly linked list.
 * - If there is one node, return null.
 * - If there are two nodes, remove the second node.
 * - Uses slow and fast pointers to locate the middle node.
 * - Deletes the middle node by updating `slowPtr.next`.
 * <p>
 * Time Complexity: O(N) - Single traversal to find and delete the middle node.
 * Space Complexity: O(1) - Uses only two pointers.
 */
class MiddleNodeOfLinkedList
{

    public static void main(String[] args)
    {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = null;
    }

    public static ListNode deleteMiddle(ListNode head)
    {
        ListNode slowPtr = head;

        // Base case: If there's only one node, return null
        if (head.next == null)
        {
            return null;
        }

        // If there are only two nodes, remove the second one
        if (head.next.next == null)
        {
            head.next = null;
            return head;
        }

        ListNode fastPtr = head.next.next;

        // Move slowPtr one step and fastPtr two steps until fastPtr reaches the end
        while (fastPtr != null && fastPtr.next != null)
        {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        // Delete the middle node
        slowPtr.next = slowPtr.next.next;
        return head;
    }
}
