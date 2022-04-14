package solutions.StringsAndPatternsProblems;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        // write your code here
        Map<String,List<String>> map = new HashMap<>();
        for(String s : strings){
            char[] chs = s.toCharArray();
            int base = chs[0]-'a';
            for(int i = 0 ; i <chs.length; i++){
                int c = chs[i] - 'a';
                c -= base;
                if(c < 0)
                    c += 26;
                chs[i] = (char)(c + 'a');
            }
            String b = new String(chs);
            map.putIfAbsent(b,new LinkedList<>());
            map.get(b).add(s);
        }
        return new LinkedList(map.values());
    }

    public static void main(String[] args) {
        String[] ss = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
        GroupShiftedStrings g = new GroupShiftedStrings();
        List<List<String>> l = g.groupStrings(ss);
    }
}
