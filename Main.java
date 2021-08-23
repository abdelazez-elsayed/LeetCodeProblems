package solutions;

import Datastructure.ListNode;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Main {

    /* Usually don't bother yourself by looking here, it's just for testing purpose (Yeah, people before JUnit lives here) */
    public static void main(String[] args) {
    medianOfTwoArraysSolver();

    }
    static void medianOfTwoArraysSolver(){
        MedianOfTwoSortedArrays median = new MedianOfTwoSortedArrays();
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        System.out.println(median.findMedianSortedArrays(nums1,nums2));
    }



    static void addTwoNumbersSolver(){
        addTwoNumbersLinkedList solver = new addTwoNumbersLinkedList();

        /*ListNode l1 = new ListNode(2);
        l1.next  = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
*/
      /*  ListNode l1 =new ListNode(0);
        ListNode l2 =new ListNode(0);*/
        int[] numbers = {9,9,9,9};
        ListNode l1 = new ListNode(numbers[0]);
        ListNode node_ref = l1;
        for(int i=1;i<numbers.length;i++){
            node_ref.next = new ListNode(numbers[i]);
            node_ref = node_ref.next;
        }

        int[] numbers2 = {9,9,9,9,9,9,9};
        ListNode l2 = new ListNode(numbers2[0]);
        node_ref = l2;
        for(int i=1;i<numbers2.length;i++){
            node_ref.next = new ListNode(numbers2[i]);
            node_ref = node_ref.next;
        }

        ListNode sum  = solver.addTwoNumbers(l1,l2);
        Utils.printList(l1);
        Utils.printList(l2);
        Utils.printList(sum);
    }
}
