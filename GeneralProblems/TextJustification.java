package solutions.GeneralProblems;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    List<String> fullJustify(String[] words , int maxWidth){
        int i = 0;
        int n = words.length;
        List<String> res = new ArrayList<>();
        while(i < n){

            int chars = words[i].length();
            int spaces = maxWidth-chars;
            int next = i+1;
            while(next < n && spaces - (words[next].length()+1) >= 0){
                spaces -= (words[next].length()+1);
                chars += words[next].length();
                next++;
            }
            spaces = maxWidth - chars;
            StringBuilder sb = new StringBuilder();
            if(next != n){
                int rem,spacePerWord;
                if(next-1==i){
                    spacePerWord = spaces;
                    rem = 0;
                }
                else{
                    spacePerWord = spaces/(next-i-1);
                    rem= spaces % (next-i-1);
                }
                String spaceString = conSpaces(spacePerWord);
                for(int j=i;j<next;j++){
                    sb.append(words[j]);
                    if(spaces > 0){
                        spaces -= spacePerWord;
                        sb.append(spaceString);
                    }
                    if(rem>0){
                        sb.append(" ");
                        rem--;
                        spaces--;
                    }
                }
                res.add(sb.toString());
            }else{
                for(int j=i; j<n; j++){
                    sb.append(words[j]);
                    if(spaces > 0){
                        spaces--;
                        sb.append(" ");
                    }
                }
                if(spaces > 0)
                    sb.append(conSpaces(spaces));
                res.add(sb.toString());
            }
            i = next;
        }
        return res;
    }
    String conSpaces(int num){
        return new String(new char[num]).replace("\0", " ");
    }

    public static void main(String[] args) {
        String[] words1 = {"This","is", "an" , "example" , "of" , "text","justification."};
        int max1= 16;
        String[] words2 = {"ask","not","what","your","country","can","do","for","you","ask","what","you","can","do","for","your","country"};
        int max2 = 16;
        TextJustification t = new TextJustification();
        List<String> list = t.fullJustify(words2,max2);
        for(String s : list){
            System.out.println(s);
        }
    }
}
