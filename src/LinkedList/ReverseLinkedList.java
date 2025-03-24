package LinkedList;

public class ReverseLinkedList
{
    /**
     * Reverses the given linked list and returns the new head.
     *
     * @param head The head of the linked list.
     * @return The new head of the reversed linked list.
     */
    public static ListNode reverseList(ListNode head)
    {
        // Edge case: If the list is empty or has one node, return as is
        if (head == null || head.next == null)
        {
            return head;
        }

        ListNode prev = null;  // Previous node (initially null)
        ListNode current = head;  // Current node for iteration
        ListNode next = null;  // Temporary storage for next node

        // Iterate over the list and reverse pointers
        while (current != null)
        {
            next = current.next;  // Store next node
            current.next = prev;  // Reverse the link
            prev = current;       // Move prev one step forward
            current = next;       // Move current one step forward
        }

        return prev; // Return new head (previously last node)
    }
}
