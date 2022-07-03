package solutions.ArraysAndNumbersProblems;

import Datastructure.Utils;

import java.util.*;

public class QueueReconstructionByHeight_406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[0]!=o2[0]?-o1[0]+o2[0]:o1[1]-o2[1];
            }
        });
        List<int[]> res = new LinkedList<>();
        for(int[] cur : people){
            res.add(cur[1],cur);
        }
        return res.toArray(new int[people.length][]);

    }
    void shift(int[][] arr , int idx, int n){
        int[] prv = arr[idx];
        int[] next;
        for(int i=idx; i< n ; i++){
            next = arr[i+1];
            arr[i+1] = prv;
            prv = next;

        }
    }
    public static void main(String[] args) {
        int[][] pep = Utils.parse2DintArray("[[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]");
        QueueReconstructionByHeight_406 q= new QueueReconstructionByHeight_406();
        pep = q.reconstructQueue(pep);
        for(int[] p : pep)
        System.out.print("["+p[0]+","+p[1]+"], ");

    }
}
