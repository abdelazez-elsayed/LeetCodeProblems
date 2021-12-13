package solutions;

import Datastructure.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)
            return null;
        if(lists.length == 1)
            return lists[0];

        return merger(lists);
    }
    ListNode merger(ListNode[] lists){
        List<ListNode> prev = new ArrayList<>();
        List<ListNode> next = new ArrayList<>() ;
        Collections.addAll(prev,lists);
        while(prev.size() != 1){
            for(int i=0;i<(prev.size()); i=i+2){
                if(i<prev.size()-1) {
                    ListNode node = sortTwoLists(prev.get(i), prev.get(i + 1));
                    next.add(node);
                }
            }
            if(prev.size()%2 == 1)
                next.add(prev.get(prev.size()-1));
            prev = next;
            next = new ArrayList<>();
        }
        return prev.get(0);

    }
    ListNode sortTwoLists(ListNode a, ListNode b){
        if(a == null )
            return b;
        if(b==null)
            return a;
        ListNode head = new ListNode();
        ListNode sol = head;
        while(a != null && b !=null){
            if(a.val < b.val){
                head.next = new ListNode();
                head = head.next;
                head.val = a.val;
                a = a.next;

            }else{
                head.next = new ListNode();
                head = head.next;
                head.val = b.val;
                b = b.next;
            }
        }
        while(a != null){
            head.next = new ListNode();
            head = head.next;
            head.val = a.val;
            a = a.next;
        }
        while(b != null){
            head.next = new ListNode();
            head = head.next;
            head.val = b.val;
            b = b.next;

        }
        return sol.next;

    }

    public static void main(String[] args) {
        int[][] lists = {{},{-1,5,11},{},{6,10}};
        ListNode[] listNodes = new ListNode[lists.length];
        for(int i=0; i< lists.length;i++){
            listNodes[i] = ListNode.makeList(lists[i]);
        }
        MergeKSortedLists m = new MergeKSortedLists();
        ListNode node = m.mergeKLists(listNodes);
        ListNode.printList(node);
    }
}
