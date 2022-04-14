package solutions.StringsAndPatternsProblems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class SimplifyPath {
    public String simplifyPath(String path) {
        String[] dirs = path.split("[/]");
        System.out.println(Arrays.toString(dirs));
        StringBuilder sb = new StringBuilder();
        LinkedList<String> paths = new LinkedList<>();
        PriorityQueue<Integer> queue;
        for (String dir : dirs) {
            if (dir.equals("..")) {
                if (!paths.isEmpty())
                    paths.removeLast();
            } else if (dir.equals(".") || dir.equals("")) {
                continue;
            } else {
                paths.add(dir);
            }
        }
        if(paths.isEmpty()) return "/";
        for(String s : paths){
            sb.append("/").append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        SimplifyPath sm = new SimplifyPath();
        String path = "/a/./b/../../c/";
        var ans = sm.simplifyPath(path);
        System.out.println(ans);
    }
}
