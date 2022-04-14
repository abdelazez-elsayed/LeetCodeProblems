package solutions.ArraysAndNumbersProblems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class GetBillionUser {
    int getNextGrowth(float[] growthRates,float[] last_growth){
        float total=0;
        for(float f: last_growth ){
            total += f;
        }
        if(total > 1e6)
            return 1;
        for(int i=0; i<growthRates.length; ++i){
            last_growth[i] *= growthRates[i];
        }
        return 1+getNextGrowth(growthRates,last_growth);
    }

    int getBillionUsersDay(float[] growthRates) {
        // Write your code here
        float[] init = Arrays.copyOf(growthRates,growthRates.length);
        return getNextGrowth(growthRates,init);

    }

    public static void main(String[] args) {
        GetBillionUser g = new GetBillionUser();
        float[] test_1 = {1.1f, 1.2f, 1.3f};
        System.out.println(g.getBillionUsersDay(test_1));
        PriorityQueue<Integer> q = new PriorityQueue<>();
        LinkedList<Integer> list = new LinkedList<>();
    }
}
