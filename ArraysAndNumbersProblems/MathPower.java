package solutions.ArraysAndNumbersProblems;

public class MathPower {
    public static double myPow(double x, int n) {
        if(n==0)
            return 1.0;
        if(x==1.00000)
            return 1.0;
        if(x==-1.00000){
            if(n%2 ==0)
                return 1.0;
            else
                return -1.0;
        }



        boolean isNeg = n < 0;

        if(isNeg){

            if(n==Integer.MIN_VALUE)
                n=Integer.MAX_VALUE;
            else
                n= n*-1;

        }
        double res=1;
        while(n > 0){
            int r = n%2;
            n /= 2;
            if(r==1)
                res *= x;
            x=x*x;
        }
        if(isNeg)
            return 1/res;
        return res;
    }
}
