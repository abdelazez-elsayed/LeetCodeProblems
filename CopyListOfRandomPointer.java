package solutions;

import java.util.HashMap;
import java.util.Map;

public class CopyListOfRandomPointer {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    //  org   copy
    Map<Node,Node> map;
    public Node copyRandomList(Node head) {
        map = new HashMap<>();
        if(head == null)
            return null;
        Node newHead = new Node(head.val);
        Node node = newHead;
        map.put(head,newHead);
        while(head.next != null){
            if(!map.containsKey(head.next)){
                node.next = new Node(head.next.val);
                map.put(head.next,node.next);
            }
            else{
                node.next = map.get(head.next);
            }
            if(head.random == null){
                node.random = null;
                head = head.next;
                node = node.next;
                continue;
            }
            if(!map.containsKey(head.random)){
                Node newRandom = new Node(head.random.val);
                map.put(head.random,newRandom);
                node.random = newRandom;
            }else{
                node.random = map.get(head.random);
            }
            node = node.next;
            head = head.next;
        }
        node.random = map.get(head.random);
        return newHead;
    }

    public static void main(String[] args) {
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node1.random = null;
        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;

        CopyListOfRandomPointer c = new CopyListOfRandomPointer();
       Node nn =  c.copyRandomList(node1);

    }
}
