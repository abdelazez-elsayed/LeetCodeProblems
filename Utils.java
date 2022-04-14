package solutions;

import java.io.*;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    public static void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static int[][] parse2DintArray(String s ){
        s = s.trim();
        s = s.substring(1,s.length()-1);
        System.out.println(s);
        Pattern pattern = Pattern.compile("(?<=\\[).+?(?=\\])");
        Matcher m = pattern.matcher(s);
        ArrayList<String> rows = new ArrayList<>();
        while (m.find()){
            String g = m.group();
            System.out.println("G = "+g);
            rows.add(g);
        }
        
        int[][] res = new int[rows.size()][];
        int i=0;
        for(String g : rows){
            int[] row = parseRow(g);
            res[i++] = row;
        }
        return res;

    }
    static int[] parseRow (String row){
        row = row.trim();
        String[] ints = row.split(",");
        int n = ints.length;
        int[] arr = new int[n];
        int i=0;
        for(String toParse : ints){
            int num = Integer.parseInt(toParse);
            arr[i++] = num;
        }
        return arr;
    }

    public static void main(String[] args) {
        String arr2d = "[[-1,2,3],[4,125,6],[7,-8,933]]";
        int[][] res = parse2DintArray(arr2d);
        for(int[] row : res){
            for(int num : row)
                System.out.print(num+",");
            System.out.println();
        }

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
