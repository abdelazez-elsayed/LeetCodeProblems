package solutions.ArraysAndNumbersProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SmallestValueoftheRearrangedNumber_2165 {
    public long smallestNumber(long num) {
        StringBuilder sb = new StringBuilder();
        List<Long> list = new ArrayList<>(32);
        if(num < 0){
            num = -num;
            while(num  > 0){
                long n = num%10;
                num /= 10;
                list.add(n);
            }
            list.sort(Collections.reverseOrder());
            long res = 0;
            for(long n : list){
                res += n;
                res *= 10;
            }
            return -res/10;
        }
        while(num  > 0){
            long n = num%10;
            num /= 10;
            list.add(n);
        }
        list.sort(Long::compareTo);
        long res = 0;
        boolean startZero = true;
        int zerosCnt = 0;
        for(long n : list){
            if(n != 0)
                startZero = false;

            if(startZero)
                zerosCnt++;
            else{
                res += n;
                res *= 10;
                res = res * tenPower(zerosCnt);
                zerosCnt = 0;
            }

        }
        return res/10;

    }
    long tenPower(int c){
        long res = 1;
        while(c-- > 0)
            res *= 10;
        return res;
    }
}
