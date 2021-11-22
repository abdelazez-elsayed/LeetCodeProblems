package solutions;

public class ReverseInteger {
    public int reverse(int x) {
        if(x <= 9 && x >= -9)
            return x;
        if(x == Integer.MIN_VALUE)
            return 0;
        boolean isNeg = x < 0;
        if(isNeg) x = x * -1;
        long res=x%10;
        x /= 10;
        while(x > 0){

            res = res * 10 + x%10;

            x /= 10;
        }
        if(res > Integer.MAX_VALUE)
            return 0;
        int sol = (int)res;
        return isNeg ? -1*sol :  sol;
    }
}
