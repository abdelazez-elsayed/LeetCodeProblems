package solutions;

import solutions.Datastructure.ListNode;

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
}
