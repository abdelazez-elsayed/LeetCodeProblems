package solutions;

import Datastructure.ListNode;

public class RmoveNthFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode front = head;
        ListNode dummy = new ListNode(-1,head);
        ListNode back = dummy;
        if(head.next == null)
            return null;
        while(n > 0){
            front = front.next;
            n--;
        }
        while(front != null){
            back = back.next;
            front = front.next;
        }
        back.next = back.next.next;
        return dummy.next;
    }
}
