package solutions;

import java.util.Arrays;

public class ValidNumber {
    boolean blankLeft;
    public boolean isNumber(String s) {
        if(s.contains("e")){
            return splitter(s,'e');
        }else if(s.contains("E")){
            return splitter(s,'E');
        }else{
            return isDecimal(s) || isInteger(s,true,false,false);
        }
    }
    boolean splitter(String s , char c){
        int i = s.indexOf(c);
        String leftPart = s.substring(0,i);
        String rightPart = s.substring(i+1);
        boolean left = isInteger(leftPart,true,false,false)
                || isDecimal(leftPart);
        boolean right = isInteger(rightPart,true,false,false);
        return left && right;
    }
    boolean isDecimal(String s){
        if(s.contains(".")){
            int i = s.indexOf('.');
            String leftPart = s.substring(0,i);
            String rightPart = s.substring(i+1);
            boolean left = isInteger(leftPart,true,true,true);
            boolean right = isInteger(rightPart,false,true,false);
            return left && right;
        }else{
            return isInteger(s,true,false,false);
        }
    }
    boolean isInteger(String s,boolean withSign,boolean withDot,boolean acceptSignOnly){
        if(s.length() == 0) {
            if(withDot){
                if(!blankLeft){
                    blankLeft =true;
                    return true;
                }else
                    return false;
            }else{
                return false;
            }
        }
        int i=0;
        if(withSign) {
            if (s.charAt(0) == '-' || s.charAt(0) == '+') {
                i = 1;
                if(i==s.length()){
                    blankLeft = true;
                    return acceptSignOnly;
                }
            }
        }
        for(;i<s.length();i++){
            if(!Character.isDigit(s.charAt(i)))
                return false;
        }


        return true;
    }


    public static void main(String[] args) {
        String s = "2e10";
        ValidNumber v = new ValidNumber();
        String[] no = {"abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53","4e+"};
        String[] arr = {"2", "0089",".","e","+.","+E3", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"};
        System.out.println("---Valid---");
        for(String ss : arr)
            System.out.println(ss+": "+v.isNumber(ss)+", ");
        System.out.println("----Invalid");
        for(String ss : no)
            System.out.println(ss+": "+v.isNumber(ss)+", ");
    }
}
