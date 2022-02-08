package solutions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ExpressionAddOp {
    int target;
    public List<String> addOperators(String num, int target) {
        char[] nums = num.toCharArray();
        this.target = target;
        int acum = nums[0] - '0';
        List<String> list = new LinkedList<>();
        String s = ""+nums[0];


        helper(list,nums,1,0,acum,s,true,false);
        return list;
    }
    void helper(List<String> list,char[] num, int i ,int lastResultPrev ,int lastResult,String s ,boolean fromPlus, boolean fromMult){
        if(i==num.length){
            if(lastResult == target)
                list.add(s);
            return ;
        }
        String plus_s = s+'+'+num[i];
        int plus = lastResult + num[i] - '0';
        helper(list,num,i+1,lastResult,plus,plus_s,true,false);

        String minus_s = s+'-'+num[i];
        int minus = lastResult - num[i] - '0';
        helper(list,num,i+1,lastResult,minus,minus_s,false,false);
        String mult_s = s+'*'+num[i];
        int mult;
        if(fromMult){
            mult = (lastResult-lastResultPrev) * (num[i] - '0');
        }else if(fromPlus){
            mult = lastResultPrev + (num[i-1]-'0')*(num[i]-'0');
        }else{
            mult = lastResultPrev - (num[i-1]-'0')*(num[i]-'0');

        }
        helper(list,num,i+1,lastResultPrev,mult,mult_s,false,true);

    }

    public static void main(String[] args) {
        String s = "232";
        int target = 8;
        ExpressionAddOp e = new ExpressionAddOp();
        List<String> ans = e.addOperators(s,target);
        System.out.println(ans);
    }
}
