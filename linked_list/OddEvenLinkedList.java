package linked_list;


// core idea: 2 pointers
//      loop condition, even != null && even.next != null
//      (for the pair moving, the loop condition is based on the last element)
public class OddEvenLinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null){
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenStart = even;

        while (even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenStart;
        return head;
    }
    
}
