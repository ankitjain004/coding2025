package LinkedList;

/**
 * Logic Summary:
 * - Rearranges a linked list so that odd-indexed nodes appear before even-indexed nodes.
 * - Uses two pointers: `odd` (tracks last odd node) and `even` (tracks last even node).
 * - `evenHead` stores the head of the even list to connect later.
 * - Iterates through the list, skipping even nodes while maintaining order.
 * - Connects the last odd node to the first even node.
 * <p>
 * Time Complexity: O(N) - Single traversal through the list.
 * Space Complexity: O(1) - No extra space used.
 */
class OddEvenLinkedList
{
    public static ListNode oddEvenList(ListNode head)
    {
        if (head == null || head.next == null)
        {
            return head;
        }

        ListNode odd = head;
        ListNode evenHead = head.next;
        ListNode even = evenHead;

        // Reorganize the linked list
        while (even != null && even.next != null)
        {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        // Connect odd list to even list
        odd.next = evenHead;
        return head;
    }
}
