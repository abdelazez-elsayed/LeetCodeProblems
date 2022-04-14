package solutions.DesignAndDatastructuresProblems;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LFUCache {
    private Map<Integer, ListNode> nodes;
    private Map<Integer, Integer> counter;
    private TreeMap<Integer,DoublyLinkedList> freqs_map;
    private int capacity;
    private int minCount;
    public LFUCache(int capacity) {
        this.nodes = new HashMap<>();
        this.counter = new HashMap<>();

        this.capacity = capacity;
        freqs_map = new TreeMap<>();
    }


    public int get(int key) {
        if(!this.nodes.containsKey(key))
            return -1;

        ListNode node = this.nodes.get(key);
        int freq  =  counter.get(key);
        freqs_map.get(freq).remove(node);
        removeIfListEmpty(freq);
        counter.put(key,freq+1);
        node.count++;
        freqs_map.computeIfAbsent(freq + 1, k -> new DoublyLinkedList()).addFirst(node);
        return node.val;
    }
    private void put(int key,int value,int count){
        if (this.capacity == 0)
            return;

        if(this.nodes.containsKey(key)) {
            ListNode node = nodes.get(key);
            node.val = value;
            get(key);
        } else {
            ListNode node = new ListNode(key, value, count);
            if(capacity == this.nodes.size()) {
                int lowest  = freqs_map.firstKey();
                ListNode nodetoDelet = freqs_map.get(lowest).removeLast();
                freqs_map.get(lowest).remove(nodetoDelet);
                int keyToDelete = nodetoDelet.key;
                removeIfListEmpty(lowest);
                nodes.remove(keyToDelete);
                counter.remove(keyToDelete);

            }
            nodes.put(key,node);
            counter.put(key,count);
            freqs_map.computeIfAbsent(count, k-> new DoublyLinkedList()).addFirst(node);
        }
    }
    public void put(int key, int value) {
        put(key,value,1);
    }
    private void removeIfListEmpty(int frequency) {
        if (freqs_map.get(frequency).isEmpty()) {
            freqs_map.remove(frequency);  // remove from map if list is empty
        }
    }
    public void delete(int key){
        if(!nodes.containsKey(key))
            return;
        ListNode node = nodes.get(key);
        nodes.remove(key);
        DoublyLinkedList list = freqs_map.get(node.count);
        list.remove(node);
        removeIfListEmpty(node.count);
    }



    private class ListNode {
        int key;
        int val;
        int count;
        ListNode prev;
        ListNode next;

        public ListNode(int key, int val, int count) {
            this.key = key;
            this.val = val;
            this.count = count;

        }

        public ListNode(int key, int val, int count, ListNode prev, ListNode next) {
            this.key = key;
            this.val = val;
            this.count = count;
            this.prev = prev;
            this.next = next;
        }
    }

    private class DoublyLinkedList {
        ListNode head;
        ListNode tail;

        public DoublyLinkedList() {
            this.head = new ListNode(-1, -1, -1, null, null);
            this.tail = new ListNode(-1, -1, -1, head, null);
            this.head.next = tail;
        }

        public void addFirst(ListNode node) {
            node.prev = this.head;
            node.next = this.head.next;
            this.head.next.prev = node;
            this.head.next = node;
        }

        public void remove(ListNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        public ListNode removeLast() {
            ListNode node = null;

            if(!this.isEmpty()) {
                node = this.tail.prev;
                this.remove(node);
            }

            return node;
        }

        public boolean isEmpty() {
            return this.head.next == this.tail;
        }
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);
        cache.put(3,1);
        cache.put(2,1);
        cache.put(2,2);
        System.out.println("Expected : -1 , Found "+cache.get(2));
        System.out.println("Expected : 3 , Found "+cache.get(3));
        cache.put(4,4);
        System.out.println("Expected : -1 , Found "+cache.get(1));
        System.out.println("Expected : 3 , Found "+cache.get(3));
        System.out.println("Expected : 4 , Found "+cache.get(4));
        cache.delete(3);
        System.out.println(cache.freqs_map.firstKey());
    }
}
