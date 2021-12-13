package solutions;
import Datastructure.ListNode;
import Datastructure.TreeNode;

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
