package solutions.ArraysAndNumbersProblems;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        int n = num1.length();
        int m = num2.length();
        if(num1.equals("0") || num2.equals("0"))
            return "0";
        String acc = "0";
        for(int i=n-1; i >= 0; i--){
            StringBuilder sb = new StringBuilder();
            int rem = 0;
            for(int j=m-1; j>=0 ; j--){
                int d1 = num1.charAt(i)-'0';
                int d2 = num2.charAt(j)-'0';
                int res = d1*d2 + rem;
                int d = res%10;
                rem = res/10;
                sb.append(d);
            }
            if(rem != 0)
                sb.append(rem);
            sb.reverse();
            sb.append("0".repeat(Math.max(0, n - i - 1)));
            acc = sum(sb.toString(),acc);

        }
        return acc;
    }
    String sum(String s1,String s2){
        int n1 = s1.length();
        int n2 = s2.length();
        int i= n1-1;
        int j= n2-1;
        int rem=0;
        StringBuilder ans = new StringBuilder();
        while(i >= 0 && j >= 0){
            int d1 = s1.charAt(i--) - '0';
            int d2 = s2.charAt(j--) - '0';
            int res = d1+d2+rem;
            int d = res%10;
            rem = res / 10;
            ans.append(d);
        }
        while(i >= 0){
            int d1 = s1.charAt(i--) - '0';
            int res = d1+rem;
            int d = res%10;
            rem = res / 10;
            ans.append(d);
        }
        while(j >= 0){
            int d1 = s2.charAt(j--) - '0';
            int res = d1+rem;
            int d = res%10;
            rem = res / 10;
            ans.append(d);
        }
        if(rem != 0)
            ans.append(rem);
        return ans.reverse().toString();
    }
}
