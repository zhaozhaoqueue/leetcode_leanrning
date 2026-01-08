package linked_array;

// core idea: 2 pointer
//      use dummy to keep track the beginning
//      move the right to get the n length of substring
//      move right and left in the same time until hit the end
//      remove the left next

public class RemoveNthNodeFromEndOfList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        ListNode pre = dummy;
        ListNode right = dummy;
        dummy.next = head;
        int counter = 0;
        while(counter < n) {
            right = right.next;
            counter ++;
        }
        while(right.next != null){
            right = right.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return dummy.next;
    }
}
