package solutions;

public class ReverseInteger {
    public int reverse(int x) {
        if(x <= 9 && x >= -9)
            return x;
        if(x == Integer.MIN_VALUE)
            return 0;
        boolean isNeg = x < 0;
        if(isNeg) x = -x;
        int res=x%10;
        x /= 10;
        while(x > 0){
            if(res <= Integer.MAX_VALUE/10)
                res = res * 10 + x%10;
            else{
                return 0;
            }
            x /= 10;
        }
        return isNeg ? -res : res;
    }
}
