package solutions.ArraysAndNumbersProblems;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class PoisonousPlants {
    static int days=0;
    public static int poisonousPlants(List<Integer> p) {

        boolean die = true;

        int days=0;
        while (die) {
            ListIterator<Integer> iterator = p.listIterator();

            Integer left=Integer.MAX_VALUE;
            die=false;
            if (iterator.hasNext())
                left = iterator.next();
            while (iterator.hasNext()) {
                boolean kill = false;
                Integer plant = iterator.next();
                if (plant > left) {
                    iterator.remove();
                    die = true;

                }
                left = plant;


            }
            if(die)
                days++;
        }
        return days;

    }
}
