package solutions.DesignAndDatastructuresProblems;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

class SummaryRanges {
    Map<Integer,Integer> endMap; //Key -> end of interval , Value -> start of interval
    TreeMap<Integer,Integer> startMap; //Key -> start of interval , Value -> end of interval
    public SummaryRanges() {
        endMap = new HashMap<>();
        startMap = new TreeMap<>();
    }

    public void addNum(int val) {
        //Try to get the begining of prev interval
        Integer preStart = startMap.floorKey(val);
        //If we put to existing interval, ignore it
        if(preStart != null && startMap.get(preStart) >= val)
            return;
        //If it touches ending interval and starting interval
        boolean isThereNextLeft = endMap.containsKey(val-1);
        boolean isThereNextRight = startMap.containsKey(val+1);

        if( isThereNextLeft && isThereNextRight ){
            //extend it
            int start = endMap.get(val-1);
            int end = startMap.get(val+1);
            endMap.remove(val-1);
            startMap.remove(val+1);
            endMap.put(end,start);
            startMap.put(start,end);

        }else if(isThereNextLeft){ //it touches an ending interval only
            int start = endMap.get(val-1);
            endMap.remove(val-1);
            endMap.put(val,start);
            startMap.put(start,val);
        }else if(isThereNextRight){ // it touches a start of interval only
            //extend this interval
            int end = startMap.get(val+1);
            startMap.remove(val+1);
            startMap.put(val,end);
            endMap.put(end,val);
        }else{ // It touches no intervals
            //Add it as new interval of a single value
            startMap.put(val,val);
            endMap.put(val,val);
        }
    }

    public int[][] getIntervals() {
        int n = startMap.size();
        int[][] res = new int[n][2];
        int i = 0;
        for(Map.Entry<Integer,Integer> e : startMap.entrySet()){
            res[i][0] = e.getKey();
            res[i++][1] = e.getValue();
        }
        return res;
    }
}


