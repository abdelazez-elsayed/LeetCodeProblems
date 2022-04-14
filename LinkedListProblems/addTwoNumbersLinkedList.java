package solutions.LinkedListProblems;

import Datastructure.ListNode;

public class addTwoNumbersLinkedList {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int carry;
        ListNode sum_list = new ListNode(0);
        ListNode sum_list_ref = sum_list;
        int sum = l1.val + l2.val;
        carry = sum / 10;
        if(sum >= 10){
            sum  = sum % 10;
        }
        sum_list_ref.val = sum;

        while(l1.next != null && l2.next != null){
            sum_list_ref.next = new ListNode(0);
            sum_list_ref = sum_list_ref.next;
            l1 = l1.next;
            l2 = l2.next;
             sum = l1.val + l2.val + carry;
            carry = sum / 10;
            if(sum >= 10){
                sum  = sum % 10;
            }
            sum_list_ref.val = sum;
        }
        while (l1.next != null){
            sum_list_ref.next = new ListNode(0);
            sum_list_ref = sum_list_ref.next;
            l1 = l1.next;
             sum = l1.val + carry;
            carry = sum / 10;
            if(sum >= 10)
                sum = sum % 10;
            sum_list_ref.val = sum;

        }
        while(l2.next != null){
            sum_list_ref.next = new ListNode(0);
            sum_list_ref = sum_list_ref.next;
            l2 = l2.next;
            sum = l2.val + carry ;
            carry = sum /10;
            if(sum >= 10)
                sum = sum %10;
            sum_list_ref.val = sum;
        }
        if(carry != 0 )
            sum_list_ref.next = new ListNode(carry);
        return sum_list;
    }
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        int rem=0,res=0;
        ListNode node;
        ListNode dummy = new ListNode(-1);
        ListNode prv = dummy;
        int base = 10;
        while(l1 != null || l2 != null){
            int sum = 0;
            sum += rem;
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            res = sum%base;
            rem = sum/base;
            node = new ListNode(res);
            prv.next = node;
            prv = node;
        }

        if(rem != 0){
            node = new ListNode(1);
            prv.next = node;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.makeList(2,4,3);
        ListNode l2 = ListNode.makeList(5,6,4);
        addTwoNumbersLinkedList a = new addTwoNumbersLinkedList();
        ListNode res = a.addTwoNumbers2(l1,l2);
        ListNode.printList(res);
    }
}
