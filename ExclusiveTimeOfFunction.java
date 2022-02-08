package solutions;

import solutions.Datastructure.Point;

import java.util.*;
public class ExclusiveTimeOfFunction {
    public class Log{
        int id, time;
        String op;
        Log(String s){
            String[] ss = s.split(":");
            id = Integer.parseInt(ss[0]);
            time = Integer.parseInt(ss[2]);
            op = ss[1];
        }
    }
    public int[] exclusiveTime(int n, List<String> logs) {

        int[] ans = new int[n];
        Stack<Log> stack =new Stack<>();

        for(String s : logs){
            Log log = new Log(s);
            if(log.op.equals("start")){
                stack.push(log);
            }else {
                Log start = stack.pop();
                int takenTime = log.time - start.time + 1;
                ans[log.id] += takenTime;
                if(!stack.isEmpty())
                    ans[stack.peek().id] -= takenTime;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ExclusiveTimeOfFunction e = new ExclusiveTimeOfFunction();
        String[] s = {"0:start:0","0:start:2","0:end:5","1:start:6","1:end:6","0:end:7"};
        int n = 2;
        List<String> l = new ArrayList<String>(Arrays.asList(s));
        int [] ans  = e.exclusiveTime( n,l);
        System.out.println(Arrays.toString(ans));
    }

}
