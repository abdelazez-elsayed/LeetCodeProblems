package solutions;
import Datastructure.ListNode;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
public class Utils {
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

}
