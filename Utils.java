package solutions;

import java.io.*;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Utils {
    public static void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
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
    static void print_arr(int[][] arr){
        System.out.println("-------------");
        for(int[] a : arr){
            for(int i : a){
                System.out.print(i+", ");
            }
            System.out.println();
        }
        System.out.println("-------------");

    }
    int convertCharToIndex(char c){
        if(Character.isLowerCase(c))
            return c-'a';
        else
            return c - 'A' + 26;
    }

}
