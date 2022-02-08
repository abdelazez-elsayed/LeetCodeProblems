package solutions;

public class IntegerDivison {
    public int divide(int dividend, int divisor) {
        int n = dividend;
        int d = divisor;
        if(n == 1 << 31 && d == -1) return Integer.MAX_VALUE;
        int ans=0;
        boolean sign = (n >= 0) == (d >= 0);
        n = Math.abs(n);
        d = Math.abs(d);
        while (n - d >= 0){

            int cnt =0;
            int tmp = d;
            while (n - (tmp << 1 << cnt) >= 0 ){
                cnt++;
                tmp = tmp << 1;
            }
            ans += 1 <<  cnt;

            n -=  (d << cnt);

        }
        return sign ? ans : -ans;

    }
    int getBits(int n,int d){
        int n_bits=0;

        while(n > d){
            n = n >> 1;
            n_bits++;
        }
        return n_bits;
    }

    public static void main(String[] args) {
        IntegerDivison id = new IntegerDivison();
        System.out.println(id.divide(1500,3));
    }
}
