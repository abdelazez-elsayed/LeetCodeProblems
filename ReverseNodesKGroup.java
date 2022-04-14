package solutions;

import Datastructure.ListNode;

public class ReverseNodesKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        //Empty or 1 only element or K=1 --> return the same list
        if(head==null || head.next==null || k==1)return head;

        ListNode newHead=null;

        //Get the Kth node from list head (Assuming head is ordered as 1)
        ListNode KthNode  = getKthNode(head,k);

        //Set the rightNode as next of Kth Node
        ListNode rightNode = KthNode.next;

        //Reverse first K group
        ListNode[] head_tail= reverseSublist(head,KthNode);

        //Set LeftNode to the tail of reversed first K group
        ListNode leftNode = head_tail[1];
        //Returned head is the head of first reversed K group
        newHead = head_tail[0];

        while (true) {
                try {
                    //Set Head node of rightNode of last Iteration
                    head = rightNode;
                    /*Get tail Node from head to K
                    When this method fails (Throws a NullPointerException)
                    It means the last group is less than K
                    So we don't reverse and catch the exception
                    */
                    ListNode tail = getKthNode(head,k);

                    //Right node is the next of tail of sublist
                    rightNode = tail.next;
                    //Reverse Between from head to tail
                   head_tail = reverseSublist(head,tail);

                   leftNode.next = head_tail[0];
                   leftNode = head_tail[1];
                   head_tail[1].next=rightNode;
                }
                catch (NullPointerException e){
                    //When exception is thrown just attach the left Node to the head of remained list
                    leftNode.next=head;
                    break;
                }
        }
        return newHead;
    }
    /*
    Args:
    ListNode head : head of sublist of to be reversed
    ListNode tail : tail of //             //      //
    Returns array of size 2
    arr[0] : head of reversed list
    arr[1] : tail of reversed list

     */
    public ListNode[] reverseSublist(ListNode head, ListNode tail){
        ListNode prev=null;
        ListNode cur=head;
        ListNode next=null;

        while (cur != tail){
            next = cur.next;
            cur.next = prev;
            prev=cur;
            cur = next;
        }

        if(tail!=null)tail.next=prev;
        else tail=prev;
        return new ListNode[]{tail,head};
    }
    //Returns Kth node starting from head (Head is based as 1)
    public ListNode getKthNode(ListNode head,int k){
        ListNode tail=null;
        for(int i=1;i<k;i++){
            tail = head.next;
            head = head.next;
        }
        return tail;
    }
}
