package linked_list;

// core idea: 
//      dummy node as start
//      keep refresh carry
//      the loop condition is l1 != null or l2 != null or carry != 0

public class AddTwoNumbers {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode pre = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0){
            int res = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
            ListNode cur = new ListNode();
            cur.val = res % 10;
            carry = res / 10;
            pre.next = cur;
            pre = cur;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        return dummy.next;
    }

}
