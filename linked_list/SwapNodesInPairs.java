package linked_list;


// core idea: 
//  dummy as start and points to the head
//      pointer starts from dummy
//      swap pair of node
//      move the pointer to the end of the swapped pair
public class SwapNodesInPairs {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;

        while (pre.next != null && pre.next.next != null){
            ListNode left = pre.next;
            ListNode right = pre.next.next;

            // swap
            ListNode temp = right.next;
            pre.next = right;
            right.next = left;
            left.next = temp;

            // move
            pre = pre.next.next;
        }
        return dummy.next;
    }
}
