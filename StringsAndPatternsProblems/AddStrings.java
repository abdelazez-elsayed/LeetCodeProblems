package solutions.StringsAndPatternsProblems;

import java.util.Random;

public class AddStrings {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int remainder = 0;
        int i=num1.length()-1;
        int j=num2.length()-1;
        while(i >= 0 && j >= 0){
            int n1 = num1.charAt(i) - '0';
            int n2 = num2.charAt(j) - '0';
            int sum = n1+n2+remainder;
            remainder = (sum)/10;
            int d = sum % 10;
            --i;
            --j;
            sb.append(d);
        }
        while (i >= 0){
            int n1 = num1.charAt(i) - '0';
            n1 += remainder;
            int d = n1 %10;
            remainder = n1/10;
            sb.append(d);
            --i;
        }
        while (j >= 0){
            int n1 = num2.charAt(j) - '0';
            n1 += remainder;
            int d = n1 %10;
            remainder = n1/10;
            sb.append(d);
            --j;
        }
        if(remainder != 0)
        sb.append(remainder);

        return sb.reverse().toString();
    }


}
