package solutions.LinkedListProblems;

import Datastructure.ListNode;

public class RemoveDuplicatesFromSortedListII {
    class Pair{
        ListNode next;
        boolean hasDublicate;
        Pair(ListNode ne , boolean has){
            this.next = ne;
            this.hasDublicate = has;
        }
    }
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1,head);
        ListNode node = dummy;
        while(node != null){
            Pair p  = check(node.next);
            ListNode next = p.next;
            if(p.hasDublicate)
                node.next = next;
            else
                node = node.next;
        }
        return dummy.next;
    }
    Pair check(ListNode node){
        if(node == null)
            return new Pair(null, false);
        boolean dub = false;
        ListNode nextNode = node;
        while(node.next != null && node.next.val == node.val){
            node = node.next;
            dub = true;
        }
        if(dub)
            nextNode = node.next;

        return new Pair(nextNode , dub);
    }

    public static void main(String[] args) {
        ListNode head1 = ListNode.makeList(1,2,3,3,4,4,5);
        ListNode head2 = ListNode.makeList(1,1,1,2,3);
        RemoveDuplicatesFromSortedListII r = new RemoveDuplicatesFromSortedListII();
        ListNode result = r.deleteDuplicates(head2);
        ListNode.printList(result);
    }
}
