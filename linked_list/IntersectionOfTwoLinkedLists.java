package linked_list;


// core idea: 2 pointers, 2 iterations
//      each pointer go through both 2 list
//      if there is an intersection, they will meet
//      otherwise, 2 pointers will be null at the end

public class IntersectionOfTwoLinkedLists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // keep the headA and headB
        ListNode p1 = headA;
        ListNode p2 = headB;
        while(p1 != p2){
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }
        return p1;
    }
}
