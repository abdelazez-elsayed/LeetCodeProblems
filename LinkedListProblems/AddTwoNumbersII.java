package solutions.LinkedListProblems;

import Datastructure.ListNode;

public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int s1 = size(l1), s2 = size(l2);
        ListNode ansHead = new ListNode(-1),node,prv = null;
        while(s1 > s2){
            --s1;
            node = new ListNode(l1.val);
            l1 = l1.next;
            node.next = prv;
            prv = node;
            ansHead.next = node;
        }
        while(s2 > s1){
            --s2;
            node = new ListNode(l2.val);
            l2 = l2.next;
            node.next = prv;
            prv = node;
            ansHead.next = node;
        }
        while(s2-- > 0){
            int sum = l1.val + l2.val;
            l1 = l1.next;
            l2 = l2.next;
            node = new ListNode(sum);
            node.next = prv;
            prv = node;
            ansHead.next = node;
        }
        ListNode cur = ansHead.next;
        int carry = 0;
        prv = null;
        while(cur != null){
            int val = cur.val + carry;
            carry = val/10;
            cur.val = val%10;
            ListNode next = cur.next;
            cur.next = prv;
            prv = cur;
            cur = next;

        }
        if(carry > 0){
            node = new ListNode(1);
            node.next = prv;
            return node;
        }
        return prv;
    }
    int size(ListNode head){
        int size = 0;
        while(head != null){
            ++size;
            head = head.next;
        }
        return size;
    }
}
