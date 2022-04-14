package solutions.ArraysAndNumbersProblems;

import java.math.BigInteger;

public class KaratsubaMultiplication {
    private static final int THRESHOLD = 10;

    public BigInteger mult(BigInteger X , BigInteger Y){
        int bitLength = Math.max(X.bitLength(), Y.bitLength());
        if(bitLength < THRESHOLD)
            return X.multiply(Y);
        int half_digits  = bitLength / 2 + bitLength % 2;

        // X = b * 2^half digits + a              Y = d* 2^half_digits + c
        BigInteger b = X.shiftRight(half_digits);
        BigInteger d = Y.shiftRight(half_digits);
        BigInteger a = X.subtract(b.shiftLeft(half_digits));
        BigInteger c = Y.subtract(d.shiftLeft(half_digits));

        //X*Y = bd* 2^(half_digits*2) + (a+b)(c+d) - ac - bd +ac* 2^half_digits
        BigInteger ac = mult(a,c);
        BigInteger bd = mult(b,d);
        BigInteger abcd = mult(a.add(b),c.add(d));

        return ac.add(abcd.subtract(ac).subtract(bd).shiftLeft(half_digits)).add(bd.shiftLeft(2*half_digits));
    }
    public void TestKaratsuba(BigInteger M , BigInteger N){
        long t0 = System.currentTimeMillis();
        BigInteger NM = M.multiply(N);
        System.out.println("***Naive***\nResult = "+NM.toString() + "\n Taken time : " +(System.currentTimeMillis()-t0)+"ms");
        t0 = System.currentTimeMillis();
        BigInteger kart = mult(N,M);
        System.out.println("***Karatusba***\nResult = "+kart.toString() + "\n Taken time : " +(System.currentTimeMillis()-t0) +"ms");
        if(kart.compareTo(NM) != 0)
            System.err.println("Error in result ");

    }
}
