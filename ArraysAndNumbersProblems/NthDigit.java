package solutions.ArraysAndNumbersProblems;

import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.function.Function;

public class NthDigit {

    public int findNthDigit(int n) {
        long base = 1;
        long next = 10;
        long digits = 1;
        long prev = 0;
        Function<Integer,Integer> f = x -> x*x;
        StringBuilder sb;
        while (n > (next - base) * digits + prev) {
            prev += (next - base) * digits;
            base *= 10;
            next *= 10;

            digits++;
        }
        long num = (n - prev - 1)/digits + base;
        long digi = digits- 1 - (n-prev - 1 )%digits;
        long res = 0 ;
        while(digi > 0){
            num /= 10;
            digi--;
        }
        res = num%10;
        return (int) res;
    }
    public int test(int n) {
        int len = 1, i = 1;
        long range = 9;
        while(n > len * range){
            n -= len * range;
            len++;
            range *= 10;
            i *= 10;
        }

        i += (n - 1) / len;
        String s = Integer.toString(i);
        return Character.getNumericValue(s.charAt((n - 1) % len));
    }

    public static void main(String[] args) {
        // consider this TreeSet and the values we add into it
        TreeSet<int[]> ts = new TreeSet<>(Comparator.comparingInt(a -> a[0]));
        ts.add(new int[]{0,1});
        ts.add(new int[]{1,2});
        ts.add(new int[]{2,3});

// what are the results of the following commands?
        ts.add(new int[]{0,2});
        System.out.println(ts.contains(new int[]{1,100}));
        ts.remove(new int[]{1,100});
    }

}
