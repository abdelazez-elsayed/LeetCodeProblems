package solutions;

import java.util.LinkedList;
import java.util.List;

public class PalindromePartitioning {
    boolean[][] dp;
    List<List<String>> result;
    String s;
    public List<List<String>> partition(String s) {
        int len = s.length();
        dp = new boolean[len][len];
        this.s = s;
        result = new LinkedList<>();
        dfs(0, new LinkedList<>());
        return result;
    }

    void dfs(int start, LinkedList<String> currentList) {
        if (start >= s.length())
            result.add(new LinkedList<>(currentList));
        for (int end = start; end < s.length(); end++) {
            if (s.charAt(start) == s.charAt(end) && (end - start <= 2 || dp[start + 1][end - 1])) {
                dp[start][end] = true;
                currentList.add(s.substring(start, end + 1));
                dfs(end + 1, currentList);
                currentList.removeLast();
            }
        }
    }
}
