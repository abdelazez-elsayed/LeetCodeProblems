package solutions.DesignAndDatastructuresProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomSet {
    class RandomizedSet {
        Map<Integer,Integer> map;
        ArrayList<Integer> list;
        Random rand;
        public RandomizedSet() {
            map = new HashMap<>();
            list = new ArrayList<>();
            rand = new Random();
        }

        public boolean insert(int val) {
            if(map.containsKey(val))
                return false;
            map.put(val,list.size());
            list.add(val);
            return true;
        }

        public boolean remove(int val) {
            if(!map.containsKey(val))
                return false;
            int idx = map.get(val);
            map.remove(val);
            int last = list.remove(list.size()-1);
            if(idx < list.size()){
                list.set(idx,last);
                map.put(last,idx);
            }
            return true;
        }

        public int getRandom() {
            int idx = rand.nextInt(list.size());
            return list.get(idx);
        }
    }
}
