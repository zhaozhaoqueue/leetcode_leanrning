package linked_list;


// core idea: 2 pointer, slow and fast, find the middle position
//      disconnect from the middle position and get 2 sub linked lists
//      reverse the right part
//      connect the 2 linked list
public class ReorderList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // disconnect slow's next
        ListNode cur = slow.next;
        slow.next = null;

        // reverse the right part
        ListNode right = null;
        while (cur != null){
            ListNode temp = cur.next;
            cur.next = right;
            right = cur;
            cur = temp;
        }

        // right is the head
        // join 2 part
        while (head != null && right != null){
            ListNode p1 = head.next;
            ListNode p2 = right.next;
            head.next = right;
            right.next = p1;
            head = p1;
            right = p2;
        }
    }
}

