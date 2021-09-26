package solutions;
import Datastructure.ListNode;

import java.io.*;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Utils {
    public static List<Integer> readArrayFromFile(String file_path) throws FileNotFoundException {
        File f = new File(file_path);
        LinkedList<Integer> linkedList = new LinkedList<>();


            FileInputStream fis = new FileInputStream(f);
            Scanner scanner = new Scanner(fis);
            while (scanner.hasNextInt())
                linkedList.add(scanner.nextInt());
            return linkedList;



    }

    public static void downloadFile(URL url, String outputFileName) throws IOException
    {
        try (InputStream in = url.openStream();
             ReadableByteChannel rbc = Channels.newChannel(in);
             FileOutputStream fos = new FileOutputStream(outputFileName)) {
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        }
    }
    public static void printList(ListNode node){
        System.out.print('[');
        if(node != null)
            System.out.print(node.val);
        while (node.next != null){
            node = node.next;
            System.out.print(","+node.val);

        }
        System.out.println("]");
    }
    public int binarySearch(int[] nums,int target){
        int low=0;
        int high=nums.length;
        int mid;
        while (low <= high){
            mid = (low+high)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid] > target){
                high = mid;
            }
            else
                low = mid;

        }
        return -1;
    }
    public static ListNode makeList(int[] arr){
        if(arr == null)return null;

        ListNode head=new ListNode();
        ListNode node=head;
        for(int i=0; i<arr.length; i++){
            node.val = arr[i] ;
            if(i+1<arr.length){
                node.next = new ListNode();
                node = node.next;
            }
        }
        return head;
    }
    public static ListNode getListTail(ListNode head){
        if(head==null || head.next==null)return head;
        ListNode tail=null;
        while (head.next!=null){
            tail = head.next;
            head = head.next;
        }
        return tail;
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
