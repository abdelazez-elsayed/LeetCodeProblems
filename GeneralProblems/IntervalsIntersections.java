package solutions.GeneralProblems;

import java.util.LinkedList;
import java.util.List;

public class IntervalsIntersections {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i=0, j=0;
        List<int[]> intrs = new LinkedList<>();
        while(i < firstList.length && j<secondList.length){
            int[] f = firstList[i];
            int[] s = secondList[j];
            //Low --> Min of starts , High--> max of ends
            //If low less than high --> intersection add it
            int lo = Math.max(f[0], s[0]);
            int hi = Math.min(f[1], s[1]);
            if (lo <= hi){
                intrs.add(new int[]{lo, hi});
            }
            if(s[1] < f[1])
                j++;
            else
                i++;

        }
        return intrs.toArray(new int[intrs.size()][2]);
    }


    public static void main(String[] args) {
        int[][] f = {{5,10}};
        int[][] s = {{3,10}};
        IntervalsIntersections i = new IntervalsIntersections();
    }
}
