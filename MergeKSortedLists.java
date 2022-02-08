package solutions;

import solutions.Datastructure.ListNode;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)
            return null;
        if(lists.length == 1)
            return lists[0];
        int amount = lists.length;
        int interval = 1;
        while(interval < amount){
            for(int i=0; i< amount - interval; i += interval*2){
                lists[i] = mergeTwoSortedLists(lists[i],lists[i+interval]);
            }
            interval *= 2;

        }
        return lists[0];
    }
    ListNode mergeTwoSortedLists(ListNode a, ListNode b){
        if(a == null )
            return b;
        if(b==null)
            return a;

        ListNode head;
        if(a.val > b.val){
            head=b;
            b = b.next;
        }else{
            head = a;
            a = a.next;
        }
        ListNode sol = head;
        while(a != null && b !=null){
            if(a.val < b.val){
                head.next = a;
                head = head.next;
                a = a.next;
            }else{
                head.next=b;
                head=head.next;
                b = b.next;
            }
        }
        if(a != null)
            head.next = a;
        else
            head.next = b;
        return sol;

    }

    public static void main(String[] args) {
        int[][] lists = {{1,4,5},{1,3,4},{2,6}};
        ListNode[] listNodes = new ListNode[lists.length];
        for(int i=0; i< lists.length;i++){
            listNodes[i] = ListNode.makeList(lists[i]);
        }
        MergeKSortedLists m = new MergeKSortedLists();
        ListNode node = m.mergeKLists(listNodes);
        ListNode.printList(node);
    }
}
