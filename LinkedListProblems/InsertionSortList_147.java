package solutions.LinkedListProblems;

import Datastructure.ListNode;

public class InsertionSortList_147 {
    public ListNode insertionSortList(ListNode head) {
        ListNode cur = head;
        ListNode dummy = new ListNode(-1);
        while(cur != null){
            ListNode prv = dummy , start = dummy.next;
            ListNode next = cur.next;
            cur.next = null;
            while(start != null && cur.val > start.val){
                start= start.next;
                prv = prv.next;
            }
            ListNode prvNext = prv.next;
            prv.next = cur;
            cur.next= prvNext;
            cur = next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.makeList(4,3,2,1);
        InsertionSortList_147 i = new InsertionSortList_147();
        ListNode.printList(i.insertionSortList(head));

    }
}
