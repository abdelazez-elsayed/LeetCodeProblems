package solutions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        int wordLen = words[0].length();
        int n_words = words.length;
        int s_len = s.length();
        List<Integer> result = new LinkedList<>();
        int[] mask = new int[n_words];


        for(int i=0; i<= s_len- wordLen*n_words;  i++){
            boolean break_flag=false;
            Arrays.fill(mask,-1);

            for(int j=0; j<n_words;j++){
                if(checkInInterval(i,i+wordLen*n_words,s,words[j],mask,j)) {
                }
                else {
                    break_flag = true;
                    break;
                }
            }
            if(!break_flag && !contains(mask)) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean contains(int[] mask) {
        for(int i : mask) if (i == -1) return true;
            return false;
    }


    public boolean checkInInterval(int start,int end,String str,String word, int[] mask,int word_id) {

        //Check if this word have been seen before
        for (int value : mask) {
            if (value == word_id)
                return false;
        }
        //Check if the substring contains this word
        int c=0;
        for (int i = start; i < end; i+=word.length()){
            if(str.startsWith(word,i) && mask[c] ==-1){
                mask[c]=word_id;
                return true;
            }
            c++;

        }
        return false;
    }
}
