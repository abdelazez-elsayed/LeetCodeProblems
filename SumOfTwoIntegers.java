package solutions;

public class SumOfTwoIntegers {
    public int getSum(int a, int b) {
        int c;
        while(b !=0 ) {
            c = (a&b);
            a = a ^ b;
            b = (c)<<1;
        }
        return a;
    }

    public static void main(String[] args) {
        SumOfTwoIntegers s = new SumOfTwoIntegers();
        int r = s.getSum(3,2);
        System.out.println("Res  = "+r);
    }
}
