package mergeTwoSortedLists;

public class Solution {
    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();

        list1.insertFirst(8);
        list1.insertFirst(3);
        list1.insertFirst(2);
        list1.insertFirst(1);

        list2.insertFirst(10);
        list2.insertFirst(9);
        list2.insertFirst(4);
        list2.insertFirst(3);
        list2.insertFirst(1);

        System.out.println("list1 is: ");
        list1.displayList();
        System.out.println("list2 is: ");
        list2. displayList();

        ListNode result = mergeTwoLists(list1.getFirst(), list2.getFirst());

        System.out.println();
        if (result != null) {
            System.out.println(result.val);
        }

        //-----------------------------
        ListNode head3 = new ListNode(7);
        ListNode head2 = new ListNode(5, head3);
        ListNode head1 = new ListNode(1, head2);
        ListNode head0 = new ListNode(0, head1);

        ListNode head33 = new ListNode(8);
        ListNode head22 = new ListNode(4, head33);
        ListNode head11 = new ListNode(3, head22);
        ListNode head00 = new ListNode(2, head11);

        System.out.println(mergeTwoLists2(head0, head00));
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        LinkedList mergedList = new LinkedList();
        LinkedList anotherList = new LinkedList();

        /**
         * Checks for null.
         */
        if(list1 == null && list2 == null){
            return mergedList.getFirst();
        }
        if(list1 == null){
            mergedList.setFirst(list2);
            return mergedList.getFirst();
        }
        if(list2 == null){
            mergedList.setFirst(list1);
            return mergedList.getFirst();
        }

        /**
         * Choosing a list which first element val is smaller.
         */
        if(list1.val <= list2.val){
            mergedList.setFirst(list1);
            anotherList.setFirst(list2);
        } else {
            mergedList.setFirst(list2);
            anotherList.setFirst(list1);
        }

        /**
         * Adding another list to our base list element-by-element in a loop.
         */
        while (!anotherList.isEmpty()){
            int key = anotherList.getFirst().val;
            ListNode current = mergedList.getFirst();
            ListNode previous = mergedList.getFirst();

            /**
             * searching for a necessary position in the base list to insert our key.
             */
            while (current.val < key){
                /**
                 * A special case (1) - our key is greater than any other val. We get out of the loop here with "break;".
                 */
                if (current.next == null){
                    previous = current;
                    current = null;
                    break;
                    /**
                     * Else - just find the position of insertion.
                     */
                } else {
                    previous = current;
                    current = current.next;
                }
            }
            /**
             * A special case (2) - our key is smaller than any other val.
             */
            if (current == mergedList.getFirst()){
                mergedList.insertFirst(key);
            }
            /**
             * Any other case (3) - our key should be somewhere in the mid of the base list.
             * If anotherList is empty - nothing to insert.
             */
            else if(!anotherList.isEmpty()){
                ListNode temp = new ListNode(key);
                previous.next = temp;
                temp.next = current;
            }
            /**
             * Delete the element under consideration from anotherList.
             */
            if(!anotherList.isEmpty()){
                anotherList.deleteFirst();
            }
        }

        System.out.println("mergedList is: ");
        mergedList.displayList();
        return mergedList.getFirst();
    }

    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);
        ListNode cur = prehead;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        cur.next = (l1 == null) ? l2 : l1;
        return prehead.next;
    }

}
