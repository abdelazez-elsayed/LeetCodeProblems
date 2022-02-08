package solutions;

import java.util.*;

public class RandomSetWithDublicates {
    Map<Integer,Set<Integer>> map;
    ArrayList<Integer> list;
    Random rand;
    public RandomSetWithDublicates() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        Set<Integer> set;
        if(!map.containsKey(val)){
            set = new HashSet<>();
            map.put(val,set);
        }
        set = map.get(val);
        set.add(list.size());
        list.add(val);
        return set.size()==1;
    }

    public boolean remove(int val) {
        if(!map.containsKey(val) || map.get(val).size() == 0)
            return false;
        Set<Integer> to_remove_set = map.get(val);
        int idx_to_remove = to_remove_set.iterator().next();
        to_remove_set.remove(idx_to_remove);
        int last = list.get(list.size()-1);
        list.set(idx_to_remove,last);
        map.get(last).add(idx_to_remove);
        map.get(last).remove(list.size()-1);
        list.remove(list.size()-1);
        return true;
    }

    public int getRandom() {
        int idx = rand.nextInt(list.size());
        return list.get(idx);
    }
}
