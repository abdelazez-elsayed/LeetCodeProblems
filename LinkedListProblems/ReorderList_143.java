package solutions.LinkedListProblems;

import Datastructure.ListNode;

public class ReorderList_143 {
    public void reorderList(ListNode head) {
        if(head.next == null)return;
        ListNode dummy = new ListNode(-1, head);
        ListNode fast = head  , slow = dummy;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        if(fast != null)
            slow = slow.next;


        ListNode slowNext = slow.next;
        slow.next = null;

        ListNode right = reverse(slowNext);

        ListNode left = head;
        while(right != null){
            ListNode leftNext = left.next, rightNext = right.next;
            left.next = right;
            right.next = leftNext;
            left = leftNext;
            right = rightNext;
        }

    }
    public ListNode reverse(ListNode head) {
        if(head ==null || head.next ==null)
            return head;
        ListNode curr= head;
        ListNode prev = null;
        ListNode next = curr.next;
        while(next != null){
            curr.next = prev;
            prev = curr;
            curr = next;
            next = next.next;
        }
        curr.next =prev;
        return curr;
    }
    public static void main(String[] args) {
        ListNode head = ListNode.makeList(1,2,3,4);
        ReorderList_143 r = new ReorderList_143();
        r.reorderList(head);
    }
}
