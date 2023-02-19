package middleOfTheLinkedList;

public class Solution {
    public static void main(String[] args) {
        ListNode head3 = new ListNode(3);
        ListNode head2 = new ListNode(2, head3);
        ListNode head1 = new ListNode(1, head2);
        ListNode head0 = new ListNode(0, head1);

        System.out.println(head0);
        middleNode(head0);

        System.out.println(head0);
    }

    public static ListNode middleNode(ListNode head) {
        if (null == head || null == head.next){
            return head;
        }

        int counter = 0;
        ListNode current = head;

        while (current != null){
            current = current.next;
            counter++;
        }

        for (int i = 0; i < (counter/2); i++){
            head = head.next;
        }

        return head;
    }

    //---------------------------------

    public ListNode middleNodeTortoise(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;

        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        if(fast.next!=null){
            slow=slow.next;
        }
        return slow;
    }

}
