package linkedListCycleII;

public class Solution {
    public static void main(String[] args) {
        ListNode head5 = new ListNode(5);
        ListNode head4 = new ListNode(4, head5);
        ListNode head3 = new ListNode(3, head4);
        ListNode head2 = new ListNode(2, head3);
        ListNode head1 = new ListNode(1, head2);
        System.out.println(head1);

        detectCycle(head1);
        System.out.println(head1);
    }

    public static ListNode detectCycle(ListNode head) {
        //Step 1: Detect if there is a cycle
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                //Step 2: Move one of the pointers to the head of the linked list
                slow = head;

                //Step 3: Move both pointers one step at a time until they meet again
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }

                //Return the start of the cycle
                return slow;
            }
        }

        return null;
    }
}
