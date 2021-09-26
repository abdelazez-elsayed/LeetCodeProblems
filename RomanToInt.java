package solutions;

import java.util.Hashtable;
import java.util.Map;

public class RomanToInt {
    Map<Character,Integer> look_up = new Hashtable<>();
    public int romanToInt(String s) {
        look_up.put('I',1);
        look_up.put('V',5);
        look_up.put('X',10);
        look_up.put('L',50);
        look_up.put('C',100);
        look_up.put('D',500);
        look_up.put('M',1000);
        int result = 0 ;

        int lastVal=1000000;
        int cur_val;
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            cur_val = look_up.get(aChar);
            if (lastVal < cur_val)
                result += cur_val - lastVal - lastVal;
            else
                result += cur_val;
            lastVal = cur_val;
        }
        return result;
    }
}
