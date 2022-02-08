package solutions;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    Map<Integer,ListNode> map;
    DLinkedList list;
    int cap;
    int size;
    public LRUCache(int capacity) {
        this.cap = capacity;
        this.size = 0;
        this.list = new DLinkedList();
        this.map = new HashMap<>();
    }

    public int get(int key) {
        if(this.map.containsKey(key)){
            ListNode node = map.get(key);
            this.list.remove(node);
            this.list.addFirst(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(this.map.containsKey(key)){
            ListNode node = this.map.get(key);
            node.val = value;
            this.list.remove(node);
            this.list.addFirst(node);
        }else{
            ListNode node = new ListNode(key, value);
            if(size == cap){
                ListNode toRemove = this.list.removeLast();
                map.remove(toRemove.key);
                this.list.addFirst(node);
                map.put(key,node);
            }else{
                this.list.addFirst(node);
                map.put(key,node);
                size++;
            }
        }
    }
    static class ListNode{
        int key;
        int val;
        ListNode next;
        ListNode prev;
        ListNode(int key,int val){
            this.key = key;
            this.val = val;
        }
        ListNode(int key,int val,ListNode prev, ListNode next){
            this.key = key;
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }
    static class DLinkedList{
        ListNode head;
        ListNode tail;
        int size;
        DLinkedList(){
            head = new ListNode(-1, -1);
            tail = new ListNode(-1, -1, head, null);
            head.next = tail;
        }
        void addFirst(ListNode node){
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;

            size++;
        }
        ListNode removeLast(){
            ListNode node = null;
            if(tail.prev == head)
                return null;
            node = tail.prev;
            remove(node);
            size--;
            return node;

        }
        void remove(ListNode node){
            size--;
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }
}
