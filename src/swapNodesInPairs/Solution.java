package swapNodesInPairs;

public class Solution {
    public static void main(String[] args) {
        ListNode head3 = new ListNode(3);
        ListNode head2 = new ListNode(2, head3);
        ListNode head1 = new ListNode(1, head2);
        ListNode head0 = new ListNode(0, head1);

        System.out.println(head0);
        swapPairs(head0);

        System.out.println(head0);
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pointer = dummy;
        ListNode current = dummy.next;
        while(current!=null){
            ListNode currentnext = current.next;
            if(currentnext==null){
                break;
            }
            current.next = currentnext.next;
            currentnext.next=pointer.next;
            pointer.next = currentnext;
            pointer = current;
            current = current.next;
        }
        return dummy.next;
    }
}
