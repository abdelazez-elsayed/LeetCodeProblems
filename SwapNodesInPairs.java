package solutions;

import Datastructure.ListNode;

public class SwapNodesInPairs {

        public ListNode swapPairs(ListNode head) {
            if(head ==null || head.next == null)return head;
            ListNode newHead=head.next;
            ListNode toPair = head.next.next;
            newHead.next = head;
            newHead.next.next = toPair;
            toPair = newHead.next;
            ListNode first;
            ListNode second;
            while(true){
                if(toPair.next != null && toPair.next.next !=null){
                    first = toPair.next;
                    second = first.next;
                    toPair.next = second;
                    first.next = second.next;
                    second.next = first;
                    toPair = first;

                }else break;

            }
            return newHead;
        }
}
