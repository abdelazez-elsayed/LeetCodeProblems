package solutions.DPProblems;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class WordBreak2 {
    HashMap<Integer,List<String>> map = new HashMap<>();
    public List<String> solve(String s, List<String> wordDict){
        List<String> list = null;
        if(s.length() == 0) {
            list = new LinkedList<>();
            list.add("");
        }
        if(map.containsKey(s.length())){
            return map.get(s.length());
        }
        for(String word : wordDict){
            if(word.length() <= s.length() && s.startsWith(word)){
                if(list == null)
                    list = new LinkedList<>();
                List<String> to_append = wordBreak(s.substring(word.length()),wordDict);
                if(to_append != null){
                    for(String sufx : to_append){
                        if(sufx.length() != 0)
                            list.add(word+" "+sufx);
                        else
                            list.add(word);

                    }
                }
            }
        }
        map.put(s.length(),list);
        return list;
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ans = solve(s,wordDict);
        if(ans == null)
            return new LinkedList<>();
        return ans;
    }


    public static void main(String[] args) {
        List<String> dic  = new LinkedList<>();
        String s = "catsanddog";
        dic.add("cat");
        dic.add("cats");
        dic.add("sand");
        dic.add("and");
        dic.add("dog");
        WordBreak2 wb = new WordBreak2();
        List<String> ans = wb.wordBreak(s,dic);
        for(String ss : ans){
            System.out.println("".length());
        }
    }
}
