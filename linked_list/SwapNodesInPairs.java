package linked_list;

public class SwapNodesInPairs {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode swapPairs(ListNode head) {
        // corner case
        if (head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        ListNode right = head.next;

        while (right != null){
            ListNode temp = right.next;
            head.next = temp;
            pre.next = right;
            // move
            pre = pre.next.next;
            right = temp.next;
            head = temp; 
        }
        return dummy;
    }
}
