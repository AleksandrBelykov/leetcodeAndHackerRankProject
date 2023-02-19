package reverseLinkedList;

public class Solution {
    public static void main(String[] args) {
        ListNode head5 = new ListNode(5);
        ListNode head4 = new ListNode(4, head5);
        ListNode head3 = new ListNode(3, head4);
        ListNode head2 = new ListNode(2, head3);
        ListNode head1 = new ListNode(1, head2);
        System.out.println(head1);

        reverseList(head1);
        System.out.println(head1);

        reverseListRecursion(head1);
        System.out.println(head1);
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while(current != null) {
            ListNode next = current.next; // make next node as current's next.
            current.next = prev; // make current's next node as previous.
            prev = current; // make current as previous.
            current = next; // make nextpointer as current.
        }
        return prev;
    }

    //----------------

    private static ListNode reverseListRecursion(ListNode head) {
        if (null == head || null == head.next){
            return head;
        }

        ListNode reversedHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return reversedHead;
    }
}
