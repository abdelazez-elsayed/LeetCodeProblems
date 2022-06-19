package solutions.ArraysAndNumbersProblems;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber_179 {
    public String largestNumber(int[] nums) {
        int n = nums.length;

        String[] ss = new String[n];
        for(int i=0; i<n; i++){
            ss[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(ss, (o1, o2) -> CharSequence.compare(o2+o1,o1+o2));
        StringBuilder sb = new StringBuilder();
        if(ss[0].equals("0"))
            return "0";
        for(String s: ss)
            sb.append(s);
        return sb.toString();
    }



    public static void main(String[] args) {
        LargestNumber_179 lg = new LargestNumber_179();
        int[] nums = {0,0};
        System.out.println(lg.largestNumber(nums));
    }
}
