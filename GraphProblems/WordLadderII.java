package solutions.GraphProblems;

import java.util.*;

public class WordLadderII {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return ans;

        Queue<List<String>> queue = new LinkedList<>();   // each element in queue is a path
        queue.offer(Arrays.asList(beginWord));
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        while (!queue.isEmpty()) {
            int sz = queue.size();
            while (sz-- > 0) {
                List<String> currPath = queue.poll();
                String lastWord = currPath.get(currPath.size()-1);
                List<String> neighbors = findChilds(lastWord, wordSet);
                for (String neigh : neighbors) {
                    List<String> newPath = new ArrayList<>(currPath);
                    newPath.add(neigh);
                    visited.add(neigh);
                    if (neigh.equals(endWord)) {
                        ans.add(newPath);
                    } else {
                        queue.offer(newPath);
                    }
                }
            }
            for (String s : visited)   // remove used words from wordSet to avoid going back
                wordSet.remove(s);
        }

        return ans;
    }
    List<String> findChilds(String word, Set<String> wordList) {
        List<String> ans = new LinkedList<>();
        for (int i = 0; i < word.length(); i++) {
            char[] arr = word.toCharArray();
            for (char c = 'a'; c <= 'z'; c++) {
                arr[i] = c;
                String s = new String(arr);
                if (wordList.contains(s))
                    ans.add(s);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String b = "hit";
        String e = "cog";
        List<String> l = List.of("hot","dot","dog","lot","log","cog");
        WordLadderII wl= new WordLadderII();
        List<List<String>> res = wl.findLadders(b,e,l);
        for(List<String> list:res){
            System.out.println(list);
        }
    }
}
