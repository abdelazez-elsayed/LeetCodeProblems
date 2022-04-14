package solutions.GraphProblems;

import java.util.*;
import java.util.stream.Stream;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Set<String> dict = new HashSet<>(wordList);
        queue.add(beginWord);
        int dist = 1;
        if(!dict.contains(endWord))
            return 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0 ; i<size; i++){
                String word = queue.poll();
                if(visited.contains(word))
                    continue;
                if(word.equals(endWord))
                    return dist;
                List<String> childs = findChilds(word, dict);
                visited.add(word);
                for(String child : childs){
                    if(child.equals(endWord))
                        return dist+1;
                    if(!visited.contains(child))
                        queue.add(child);
                }
            }
            dist++;
        }
        return 0;
    }
    List<String> findChilds(String word, Set<String> wordList){
        List<String> ans = new LinkedList<>();
        for(int i=0 ; i< word.length(); i++){
            char[] arr = word.toCharArray();
            for(char c = 'a' ; c <= 'z'; c++){
                arr[i] = c;
                String s = new String(arr);
                if(wordList.contains(s))
                    ans.add(s);
            }
        }
        return ans;
    }
}
