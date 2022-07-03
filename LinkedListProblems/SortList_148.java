package solutions.LinkedListProblems;

import Datastructure.ListNode;

public class SortList_148 {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(-1, head);
        ListNode fast = head , slow  = dummy;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode next = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(next);
        return merge(left,right);
    }
    ListNode merge(ListNode left , ListNode right){
        ListNode dummy = new ListNode();
        ListNode prv = dummy;
        while(left != null && right != null){
            if(left.val < right.val){
                prv.next = left;
                prv = left;
                left = left.next;
            }else{
                prv.next=  right;
                prv = right;
                right = right.next;
            }
        }
        prv.next = (left != null ? left : right);
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.makeList(4,2,1,3);
        SortList_148 s = new SortList_148();
        ListNode r = s.sortList(head);
        ListNode.printList(r);
    }
}
