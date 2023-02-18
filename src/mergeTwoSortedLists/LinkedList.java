package mergeTwoSortedLists;

public class LinkedList {
    private ListNode first;

    LinkedList(){}

    public ListNode getFirst() {
        return first;
    }

    public void setFirst(ListNode first) {
        this.first = first;
    }

    public boolean isEmpty(){
        return first==null;
    }

    public void insertFirst(int val){
        ListNode newNode = new ListNode(val);
        newNode.next = first;
        first = newNode;
    }

    public ListNode deleteFirst(){
        ListNode temp = first;
        first = first.next;
        return temp;
    }

    public void displayList(){
        System.out.println("Your list is: ");
        ListNode current = first;
        while (current != null){
            System.out.print("{"+current.val+"} ");
            current = current.next;
        }
        System.out.println();
    }
}
