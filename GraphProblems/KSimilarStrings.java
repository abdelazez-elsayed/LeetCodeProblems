package solutions.GraphProblems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class KSimilarStrings {
    public int kSimilarity(String s1, String s2) {
        if(s1.equals(s2))
            return 0;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Queue<char[]> queue = new LinkedList<>();
        queue.add(c1);
        int swaps = 0;
        int n = c1.length;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- >  0){
                char[] c = queue.poll();
                int i=0;
                while(c[i] == c2[i])
                    i++;
                for(int j=i;j<n;j++){
                    if(c[j] == c2[i]){
                        char[] nei=  Arrays.copyOf(c,n);
                        swap(nei,nei,i,j);
                        if(isEqual(nei,c2))
                            return swaps+1;
                        queue.add(nei);
                    }
                }
            }
            swaps++;
        }
        return -1;
    }
    boolean isEqual(char[] c1,char[] c2){
        for(int i=0; i < c1.length; i++){
            if(c1[i] != c2[i])
                return false;
        }
        return true;
    }
    void swap(char[] c1 , char[] c2 , int i ,int j){
        char tmp = c1[i];
        c1[i] = c2[j];
        c2[j] = tmp;
    }

}
