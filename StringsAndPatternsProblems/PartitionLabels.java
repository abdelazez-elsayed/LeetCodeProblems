package solutions.StringsAndPatternsProblems;

import java.util.LinkedList;
import java.util.List;

public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        List<Integer> list = new LinkedList<>();
        if(n==1){
            list.add(1);
            return list;
        }
        StringBuilder sb = new StringBuilder(s);
        int[] last = new int[26];
        char[] chars = s.toCharArray();
        for(int i=0; i<n; i++){
            last[chars[i]-'a'] = i;
        }
        int size=0;
        int end=0;
        for(int i=0;i<n;i++){
            char c = chars[i];
            if(last[c-'a'] > end)
                end = last[c-'a'];
            size++;
            if(i==end){
                list.add(size);
                size=0;
            }

        }
        return list;
    }
}
