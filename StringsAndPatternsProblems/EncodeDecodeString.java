package solutions.StringsAndPatternsProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeDecodeString {
    /*
     * @param strs: a list of strings
     * @return: encodes a list of strings to a single string.
     */
    public String encode(List<String> strs) {
        // write your code here
        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            sb.append(str.length()).append("#").append(str);
        }
        return sb.toString();
    }

    /*
     * @param str: A string
     * @return: dcodes a single string to a list of strings
     */
    public List<String> decode(String str) {
        // write your code here
        int i=0;
        List<String> res = new ArrayList<>();
        while (i < str.length()){
            StringBuilder inte = new StringBuilder();
            while(str.charAt(i) != '#') {
                inte.append(str.charAt(i++));
            }
            i++;
            int len = Integer.parseInt(inte.toString());
            StringBuilder word =  new StringBuilder(len);
            for(int j=0; j<len; j++)
                word.append(str.charAt(i++));
            res.add(word.toString());
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("we", "say", ":", "yes");
        EncodeDecodeString e = new EncodeDecodeString();
        String encode = e.encode(list);
        System.out.println(encode);

        List<String> decode = e.decode(encode);
        System.out.println(decode.equals(list));
    }
}
