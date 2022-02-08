package solutions;

import java.util.*;

public class OpenTheLock {
    public int openLock(String[] deadends, String target) {
        String init = "0000";
        Queue<String> queue = new LinkedList<>();
        queue.add(init);
        int steps = 0;
        Set<String> set = new HashSet<>();
        Collections.addAll(set,deadends);
        Set<String> seen = new HashSet<>();
        seen.add(init);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i<size; i++){
                String s = queue.poll();
                if(s.equals(target))
                    return steps;
                List<String> childs = getChilds(s);
                for(String child : childs){
                    if(!set.contains(child) && !seen.contains(child)){
                        queue.offer(child);
                        seen.add(child);
                    }
                }
            }
            steps++;
        }
        return -1;
    }
    List<String> getChilds(String s){
        //Up
        List<String> childs = new LinkedList<>();
        for(int i=0; i<4; i++){
            StringBuilder child = new StringBuilder(s);
            int digit = s.charAt(i) - '0';
            int digitUp = ((digit+1)%10);
            int digitDown = digit == 0 ? 9 : digit-1;
            child.setCharAt(i,(char)(digitUp+'0'));
            childs.add(child.toString());
            child.setCharAt(i,(char)(digitDown+'0'));
            childs.add(child.toString());
        }
        return childs;
    }

    public static void main(String[] args) {
        String[] d = {"8888"};
        String trg=  "0009";
        OpenTheLock o = new OpenTheLock();
        int ans =o.openLock(d,trg);
        System.out.println(ans);
    }
}
